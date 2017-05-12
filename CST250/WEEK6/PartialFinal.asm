10 7 15 9 7 93 5 10 2 11 5 77 8 12 7 3;







#####################################################################################################

outterLoop:             			# Used to determine when we are done iterating over the Array
    	addu $t1, $0, $0			# $t1 holds a flag to determine when the list is sorted
    	li  $a0, Array      		# Set $a0 to the base address of the Array

innerLoop:                  		# The inner loop will iterate over the Array checking if 
									# a swap is needed
    	lw  $t2, 0($a0)         	# sets $t2 to the current element in array
    	lw  $t3, 4($a0)         	# sets $t3 to the next element in array
    	slt $t5, $t2, $t3       	# $t5 = 1 if $t2 < $t3
		beq $t5, $0, continue   	# if $t5 = 1, then swap them
		nop
    	addiu $t1, $0, 1        	# if we need to swap, we need to check the list again
    	sw  $t2, 4($a0)         	# store the greater numbers contents in the higher position 
									# in array (swap)
    	sw  $t3, 0($a0)         	# store the lesser numbers contents in the lower position 
									# in array (swap)

continue:
    	addiu $a0, $a0, 4           # advance the array to start at the next location from last time
    	bne  $a0, $t9, innerLoop    # If $a0 != the end of Array, jump back to innerLoop
		nop
		bne  $t1, $0, outterLoop    # $t1 = 1, another pass is needed, jump back to outterLoop
		nop