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
#


# main source file
#Programmer: Hieu Pham
#ASURITE ID: hqpham
#ASU ID: 1207370953
#CST250
#SPRING 2016
#I do not know how to put byte into an array in MIPS assembly.
#My program does not convert the ASCII value into a string of base-10 number
#I do know I must subtract raw ascii to decimal 48 to convert to decimal number,
#but that's just one task. I need to traverse my array and multiply each element
#to the proper power position, but I have other classes to do, and I have exhausted
#My research to get to the desired outcome.  
#It would be nice to find examples somewhere, but I could not find one.
#Long story short, this is my best.

.org 0x10000000

j start
nop
li $t9, 0			#$t9 is the counter
li $s1, 0x00000000
start:	
	jal UART_Read
	nop
	move $a0, $v0
	li $t6, 0x3D		#Load the '=' ASCII value into $t6
	bne $v0, $t6, StoreIt 	#Store if char is not '='
	nop	
	jal UART_Write2		#Otherwise, Send out the newline
	nop
uartWrite:
	
	jal UART_Write
	nop
	
	j start
	nop
UART_Read:
	lui $t0, 0xf000		#Load immediate, the upper 2 bytes of the 
				#base address of the UART
				#Falls right through to UART_ReadLoop block
UART_ReadLoop:			#Polling for DTR bit
	lw  $t1, 4($t0)		#Get the word from UART status register
	andi $t1, $t1, 0x02		#Mask for the data ready bit (0b0010)
	beq $t1, $zero, UART_ReadLoop	#Branch to UART_ReadLoop if bit pattern in UART status 
	nop			#register is 0
	lw  $v0, 8($t0)		#Otherwise, there is a byte available in the RX buffer. Get it.
	sw  $t1, 0($t0)		#Clear the ready flag at the base address by writing 0b0010
				#to 0xF0000000
	jr $ra			#Jump to return address (from where-ever the jal call happened)
	nop			#Delay slot

UART_Write:
	lui $t0, 0xf000		#Load immediate, the upper 2 bytes of the 
				#base address of the UART
				#Falls right through to UART_WriteLoop block
UART_WriteLoop:			#Polling for CTS bit
	lw  $t1, 4($t0)		#Get the word from UART status register
	andi $t1, $t1, 0x01		#Mask for the CTS bit, bit 0 is CTS (0x0001)
				#Clear to send if $t1 = 0b0001. 0b0000 = not clear to send.
	beq $t1, $zero, UART_WriteLoop	#Branch to UART_WriteLoop when not CTS
	nop			#Delay slot
	sw  $a0, 12($t0)		#If CTS, then write the data from argument register $a0
				#to the UART send register.
	sw  $t1, 0($t0)		#Write 0b0001 to UART base address to set its bit 0 to
				#cause it to send the byte out to the world.
	jr $ra			#Jump to return address (from where-ever the jal call happened)
	nop			#Delay slot

UART_Write2:			#Write the \n char to terminate the string	
	li $s1, 0x00000000
	addiu $t8, $t9, 0		#Transfer $t9 to $t8 (Attempted to find length of string)
	li $t9, 0			#$t9 is the counter, Reset because of '='
	lui $t0, 0xf000		#Load immediate, the upper 2 bytes of the 
				#base address of the UART
				#Falls right through to UART_WriteLoop block
UART_WriteLoop2:			#Polling for CTS bit
	lw  $t1, 4($t0)		#Get the word from UART status register
	andi $t1, $t1, 0x01		#Mask for the CTS bit, bit 0 is CTS (0x0001)
				#Clear to send if $t1 = 0b0001. 0b0000 = not clear to send.
	beq $t1, $zero, UART_WriteLoop2	#Branch to UART_WriteLoop when not CTS
	nop				#Delay slot
	li $a0, 0x0A		#New line character
	sw  $a0, 12($t0)		#If CTS, then write the data from argument register $a0
				#to the UART send register.
	sw  $t1, 0($t0)		#Write 0b0001 to UART base address to set its bit 0 to
				#cause it to send the byte out to the world.
	###############################
	#Do the calculation before the#
	#jr statement                 #
	###############################	
	jr $ra			#Jump to return address (from where-ever the jal call happened)
	nop			#Delay slot
StoreIt:			#My failed attempt to put a byte into an array.
	sw $v0, 0($s1)	#Store into array
	addiu $s1, $s1, 4	#Next address location is 4 bytes away
	addiu $t9, $t9, 1	#increment the counter (Attempted to see length of string)
	
	j uartWrite	#Jump to continue on polling the TX line
	nop 

