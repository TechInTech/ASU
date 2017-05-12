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

main:	
	li $t9, 0	#Zero out $t9
	li $t2, 0
	jal get_char
	nop
	bne $s4, $t1, not_equals	# check if character from get_char was '='
	nop
EqualSign:
	#Char is '='	
	move $t2, $0	# clear temp
	j main
	nop
not_equals:
	jal GetDigits
	nop
	j EqualSign
	nop


# This subroutine gets a character from the UART by polling the status register
# and placing the character in register $t1.
get_char:
	lw $t0, 4($s0)	# load status register
	and $t0, $t0, $s2	# mask for ready bit
	bne $t0, $s2, get_char
	nop
	lw $t1, 8($s0)	# load from recieve buffer
	sw $s2, 0($s0)	# command register: clear status
	jr $ra
	nop


# This subroutine combines the new digit with the previous result to form the
# new result.
GetDigits:			#$t1 already has an ASCII value
	mullo $t2, $t2, $s3	# multiply temporary result by 10 (shifts left 1 decimal place)
	subu $t1, $t1, $s1	# convert new digit from ascii to value
	addu $t2, $t2, $t1	# temporary result + new digit
	jal get_char	# Get next char and put in $t1
	nop		# Delay slot
	bne $t1, $s5, GetOp1	# Char is not '+', but is it '-'
	nop		# Delay slot
	# $t1 is is '+', pass sum of first operand to $t3
	addiu $t9, $t1, 0	#Put the operand in $t9
	j AllSignsChecked	#pass sum of first operand to $t3
	nop		#Delay slot
GetOp1:
	bne $t1, $s6, GetOp2	# Char is not '-', but is it '*'
	nop
	#Char is '-'
	addiu $t9, $t1, 0	#Put the operand in $t9
	j AllSignsChecked 	#pass sum of first operand to $t3
	nop		#Delay slot
GetOp2:
	bne $t1, $s7, GetDigits	# Char is not '*'
	nop
	#Char is '*'
	addiu $t9, $t1, 0	#Put the operand in $t9
	j AllSignsChecked	#pass sum of first operand to $t3
	nop		#Delay slot
AllSignsChecked:
	addiu $t3, $t2, 0	# Transfers $t2 into $t3
	move $t2, $0	#zero out summing register
	jal get_char	#Get a char passed the operator
	nop
SecondOperand:		#$t1 already had a value. $t2 is zeroed out
	mullo $t2, $t2, $s3	# multiply temporary result by 10 (shifts left 1 decimal place)
	subu $t1, $t1, $s1	# convert new digit from ascii to value
	addu $t2, $t2, $t1	# temporary result + new digit
	jal get_char	# Get next char and put in $t1
	nop		# Delay slot
	bne $t1, $s4, SecondOperand	# Char is not '=', This is the second operand
	nop		# Delay slot
	#Char is '='
	addiu $t4, $t2, 0	# Transfers $t2 into $t3
	
	#Now we have $t3 and $t4 as 2 operands. Time to perform the math
	beq $t9, $s5, Do_Plus
	nop
	beq $t9, $s6, Do_Minus
	nop
	beq $t9, $s7, Do_Time
	nop
Do_Plus:
	addu $t2, $t3, $t4	# temporary result + new digit
	j ReturnSpot
	nop
Do_Minus:
	subu $t2, $t3, $t4	# temporary result + new digit
	j ReturnSpot
	nop
Do_Time:
	mullo $t2, $t3, $t4
	j ReturnSpot
	nop
ReturnSpot:
	move $v0, $t2	# move number from temp	
	andi $t3, $t3, 0
	andi $t4, $t4, 0
	andi $t9, $t9, 0
	jr $ra
	nop
