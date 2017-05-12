			.data
numbers: 
			.word 20, 30, 10, 40, 50, 60, 30, 25, 10, 5
length: 
			.word 10
			.text
			.globl main
main:
# Use $v0 to hold address of numbers[firstUnsortedIndex]
# Use $v1 to hold address of numbers[testIndex]
# Use $a0 to hold elementToInsert
# Use $a1 to hold value of numbers[test]
# Use $a2 to calculate the address of numbers[test] in
# Use $a3 to hold the address of numbers[length-1]
# Use $t0 to hold the base/starting address of the numbers array
# Use $t1, $t2, $t3, and $t4 for calculation
		li $t3, 0
		li $t4, 0
for_init: 
		li $v0, numbers
		addiu $v0, $v0, 4
		li $a3, length
		addiu $a3, $a3, -4
		li $t0, numbers
for_loop:
		slt $t1, $a3, $v0		# $t1 = 1 if $a3 < $v0
		bne $t1, $0, end_for	# Saying if $t1 != 0, meaning $t1 = 1, go to end_for
		
		#bgt $v0, $a3, end_for	# Saying if $v0 > $a3, go to end_for
		
		addiu $v1, $v0, -4
		lw $a0, 0($v0)
while:	li $t3, 1
		slt $t2, $v1, $t0		# $t2 = 1 if $v1 < $t0
		beq $t2, $t3, end_while	# Saying if $t2 = 1, go to end_while
		
		#blt $v1, $t0, end_while	#Saying if $v1 < $t0, go to end_while
		
		lw $a1, 0($v1)
		
		#ble $a1, $a0, end_while	# Saying if $a1 <= $a0, go to end_while
		beq $a1, $a0, end_while		# Saying if $a1 = $a0, go to end_while
		slt $t2, $a1, $a0			# $t2 = 1 if $a1 < $a0
		beq $t2, $t3, end_while		# Saying if $t2 = 1, go to end_while
		sw $a1, 4($v1)
		addiu $v1, $v1, -4
		j while
end_while:
		sw $a0, 4($v1)
		addi $v0, $v0, 4
		j for_loop
end_for:
		nop

		
#################################################################################################
#
# Control Structures
#
# Branches
#
# comparison for conditional branches is built into instruction
#		b	target		#  unconditional branch to program label target
#		beq	$t0,$t1,target	#  branch to target if  $t0 = $t1
#		blt	$t0,$t1,target	#  branch to target if  $t0 < $t1
#		ble	$t0,$t1,target	#  branch to target if  $t0 <= $t1
#		bgt	$t0,$t1,target	#  branch to target if  $t0 > $t1
#		bge	$t0,$t1,target	#  branch to target if  $t0 >= $t1
#		bne	$t0,$t1,target	#  branch to target if  $t0 <> $t1
# Jumps
#
#		j	target	#  unconditional jump to program label target
#		jr	$t3		#  jump to address contained in $t3 ("jump register")
# Subroutine Calls
#
# subroutine call: "jump and link" instruction
#
#	jal	sub_label	#  "jump and link"
# copy program counter (return address) to register $ra (return address register)
# jump to program statement at sub_label
# subroutine return: "jump register" instruction
#
#	jr	$ra	#  "jump register"
# jump to return address in $ra (stored by jal instruction)
# Note: return address stored in register $ra; if subroutine will call other subroutines, 
# or is recursive, return address should be copied from $ra onto stack to preserve it, since 
# jal always places return address in this register and hence will overwrite previous value

