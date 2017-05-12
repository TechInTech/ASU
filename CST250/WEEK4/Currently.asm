#
# Problem statement:
#
# This program is a full calculator
# that uses the UART for both input and output.
# Enter the expressions into the send buffer. The
# = character separates multiple expressions.
# The calculator should accept full mathematical expressions
# with 2 numbers (operands) and an operator (e.g. “1+2=”) and
# print the result to the UART using the provided module. It
# should handle the operators to add (+), subtract (-),
# and multiply (*), but it ignores the division (/) operator.
# It should accept multiple expressions and generate the
# appropriate outputs for each expression without manually resetting
# the simulation (e.g. the input “5-4=1*2=” should output “1” followed by “2”).
#
# Programmer: Hieu Pham
# ASURITE ID: hqpham
# ASU ID: 1207370953
# CST250
# SPRING 2016
# Strategy: Follow similar implementation from Chistopher Mar
# in Proj2 solution
#

.org 0x10000000

########## Initializations ##########
# Initializations
li $s0, 0xf0000000
li $s1, 48		# Difference between ASCII and number value
		# Use for subtracting from ASCII value to obtain decimal value
li $s2, 0b10	# UART receive mask
li $s3, 10		# Conversion constant (may not use. TBD)
li $s4, '='	# Preload with '='
li $s5, '+'	# Preload with '+'
li $s6, '-'	# Preload with '-'
li $s7, '*'	# Preload with '*'
li $v0, 0		# Result holder
li $t2, 0		# Temporary result during conversion (Summing)

# Main loop
main:
	jal get_char		# jump and link to label get_char
	nop			# jal delay slot
	bne $s4, $t1, not_equals	# check if character from get_char was '='
	nop			# while(char != '=')
	jal UART_WriteLoop2		# Write a \n out
	nop			# jal delay slot
	#move $v0, $t2		# move the sum ($t2) into final register $v0
	#move $t2, $0		# clear summing register
	j main			# looping for next round
	nop			# j delay slot
	
not_equals:	# Not equals means a digit (ignoring  invalid cases)
	jal StoreFirstNumb
	nop
	#jal string_to_value
	#nop
	jal get_char		# jump and link to label get_char (put char into $t1)
	nop
Branch0:
	bne $s5, $t1, Do_Task1	# If character from get_char was '+', do +
	nop
          #Do the addition here#
	jal get_char	# jump and link to label get_char (put char into $t1)
	nop		# This is the second operand
	subu $t1, $t1, $s1	# convert new digit from ascii to value
			# decimal digit = (decimal ASCII value) - (decimal 48)
	addiu $t4, $t1, 0	# Transfers $t1 into $t4
	addu $t2, $t3, $t4	# Perform (+) and store result into $t2
	move $a0, $t2
	#jal put_char
	#nop
	j Branch3  #Case '+' done
	nop	
Branch1:
	bne $s6, $t1, Do_Task2	# If character from get_char was '-', do -
	nop
	jal get_char	# jump and link to label get_char (put char into $t1)
	nop		# This is the second operand
	subu $t1, $t1, $s1	# convert new digit from ascii to value
			# decimal digit = (decimal ASCII value) - (decimal 48)
	addiu $t4, $t1, 0	# Transfers $t1 into $t4
	subu $t2, $t3, $t4	# Perform (-) and store result into $t2	
	move $a0, $t2
	#jal put_char
	#nop
	j Branch3  #Case '-' done
	nop
Branch2:
	bne $s7, $t1, Do_Task3	# If character from get_char was '*', do *
	nop
	jal get_char	# jump and link to label get_char (put char into $t1)
	nop		# This is the second operand
	subu $t1, $t1, $s1	# convert new digit from ascii to value
			# decimal digit = (decimal ASCII value) - (decimal 48)
	addiu $t4, $t1, 0	# Transfers $t1 into $t4
	mullo $t2, $t3, $t4	# Perform (*) and store result into $t2
	move $a0, $t2
	#jal put_char
	#nop
	j Branch3  #Case '*' done
	nop
Branch3:
	move $v0, $t2
	move $a0, $v0	
	jal UART_WriteLoop
	nop
	j main
	nop
	

###################### Driving subroutines #################
# This subroutine gets a character from the UART by polling the status register
# and placing the character in register $t1.
get_char:
	lw $t0, 4($s0)		# load status register
	and $t0, $t0, $s2		# mask for ready bit
	bne $t0, $s2, get_char	# Polling
	nop			# Branch delay slot
	lw $t1, 8($s0)		# load from recieve buffer (now $t1 can be used to postprocess)
	sw $s2, 0($s0)		# command register: clear status
	jr $ra			# Return to caller
	nop			# jr delay slot
# This subroutine combines the new digit with the previous result to form the
# new result. $s3 and $t2 previously hold some values. $t2 is initialized to 0
# limitation: within 32-bit range only.
#string_to_value:
	#mullo $t2, $t2, $s3	# multiply temporary result by 10 (shifts left 1 decimal place)
			# initially, 0 * 10 = 0
	#subu $t1, $t1, $s1	# convert new digit from ascii to value
			# decimal digit = (decimal ASCII value) - (decimal 48)
	#addu $t2, $t2, $t1	# temporary result + new digit
	#jr $ra		# return to caller
	#nop		# jr delay slot

# Store the first byte
StoreFirstNumb:
	subu $t1, $t1, $s1	# convert new digit from ascii to value
			# decimal digit = (decimal ASCII value) - (decimal 48)
	addiu $t3, $t1, 0	# Transfers $t1 into $t3
	jr $ra		# return to caller
	nop		# jr delay slot

Do_Task1:			# Check for '-' operation
	j Branch1		# jump to proper place to systematically return
	nop

Do_Task2:			# Check for '*' operation		
	j Branch2		# jump to proper place to systematically return
	nop

Do_Task3:			# Check for '+' operation	
	j Branch0		# jump to proper place to systematically return
	nop

############ Attempt to reuse code from previous project #############
# What happens up to this point:
# (1) $t1 holds the character
# (2) $t2 holds the operation result
# (3) $t3 holds the first operand
# (4) $t4 holds the second operand
# (5) $s0 holds 0xf0000000 (UART address)
# (6) $s1 holds 48, Difference between ASCII and number value
# (7) $s2 holds 0b10, the UART receive mask
# (8) $s3 holds 10, Conversion constant (may not use. TBD)
# (9) $s4 holds the '=' 
# (10) $s5 holds the '+'
# (11) $s6 holds the '-' 
# (12) $s7 holds the '*'
# (13) $v0 still has 0
# (14) $t2 ditto
# (15) $t0 is used in get_char
######################################################################
				#Falls right through to UART_WriteLoop block
UART_WriteLoop:			#Polling for CTS bit
	lw  $t5, 4($s0)		#Get the word from UART status register
	andi $t5, $t5, 0b0001		#Mask for the CTS bit, bit 0 is CTS (0x0001)
				#Clear to send if $t1 = 0b0001. 0b0000 = not clear to send.
	beq $t5, $zero, UART_WriteLoop	#Branch to UART_WriteLoop when not CTS
	nop			#Delay slot
	sw  $a0, 12($s0)		#If CTS, then write the data from argument register $v0
				#to the UART send register.
	sw  $t5, 0($s0)		#Write 0b0001 to UART base address to set its bit 0 to
				#cause it to send the byte out to the world.
	jr $ra			#Jump to return address (from where-ever the jal call happened)
	nop			#Delay slot

				#Falls right through to UART_WriteLoop block
UART_WriteLoop2:			#Polling for CTS bit
	lw  $t5, 4($s0)		#Get the word from UART status register
	andi $t5, $t5, 0x01		#Mask for the CTS bit, bit 0 is CTS (0x0001)
				#Clear to send if $t1 = 0b0001. 0b0000 = not clear to send.
	beq $t5, $zero, UART_WriteLoop2	#Branch to UART_WriteLoop when not CTS
	nop				#Delay slot
	li $a0, 0x0A		#New line character
	sw  $a0, 12($s0)		#If CTS, then write the data from argument register $a0
				#to the UART send register.
	sw  $t5, 0($s0)		#Write 0b0001 to UART base address to set its bit 0 to
				#cause it to send the byte out to the world.
	jr $ra			#Jump to return address (from where-ever the jal call happened)
	nop			#Delay slot
