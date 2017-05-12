# Written by Christopher Mar
# CST 250 Project 2 Solution

.org 0x10000000

# Initializations
li $s0, 0xf0000000
li $s1, 48		# Difference between ASCII and number value
li $s2, 0b10	# UART receive mask
li $s3, 10		# Conversion constant
li $s4, '='	# Preload with '='
li $v0, 0		# Result
li $t2, 0		# Temporary result during conversion


# Main loop
main:
	jal get_char
	nop
	bne $s4, $t1, not_equals	# check if character from get_char was '='
		nop
		move $v0, $t2	# move number from temp
		move $t2, $0	# clear temp
		j main
		nop
	not_equals:
	jal string_to_value
	nop
	j main
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
string_to_value:
	mullo $t2, $t2, $s3	# multiply temporary result by 10 (shifts left 1 decimal place)
	subu $t1, $t1, $s1	# convert new digit from ascii to value
	addu $t2, $t2, $t1	# temporary result + new digit
	jr $ra
	nop