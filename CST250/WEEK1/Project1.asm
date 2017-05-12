.text
.globl main
main:
#Storing variables
li $a0, $a0, 2015
# store 2015
li $a1, $a1, 250
li $t1, 0xf0100000
lw $t0, 0($t1) # reading operation case number
jr $t0 # jump to appropriate operation
L0: add $v0, $a0, $a1 # addition
J Exit
L1: sub $v0, $a0, $a1 # subtraction
J Exit
L2: mul $v0, $a0, $a1 # multiplication
J Exit
L3: div $v0, $a0, $a1 # division
Exit: <next instruction>