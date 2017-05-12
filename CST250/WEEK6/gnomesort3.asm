	.file	1 "gnomesort.c"
	.section .mdebug.abi32
	.previous
	.gnu_attribute 4, 1
	.abicalls
	.text
	.align	2
	.globl	Gnome_Sort
	.ent	Gnome_Sort
	.type	Gnome_Sort, @function
Gnome_Sort:
	.set	nomips16
	.frame	$fp,40,$ra		# vars= 8, regs= 2/0, args= 16, gp= 8
	.mask	0xc0000000,-4
	.fmask	0x00000000,0
	.set	noreorder
	.set	nomacro
	
	addiu	$sp,$sp,-40
	sw	$ra,36($sp)
	sw	$fp,32($sp)
	move	$fp,$sp
	lui	$gp,%hi(__gnu_local_gp)
	addiu	$gp,$gp,%lo(__gnu_local_gp)
	.cprestore	16
	sw	$a0,40($fp)
	sw	$a1,44($fp)
	sw	$0,24($fp)
	li	$v0,1			# 0x1
	sw	$v0,24($fp)
	b	$L2
	nop

$L6:
	lw	$v0,24($fp)
	nop
	sll	$v1,$v0,2
	lw	$v0,40($fp)
	nop
	addu	$v0,$v0,$v1
	lw	$a0,0($v0)
	lw	$v0,24($fp)
	nop
	addiu	$v0,$v0,-1
	sll	$v1,$v0,2
	lw	$v0,40($fp)
	nop
	addu	$v0,$v0,$v1
	lw	$v0,0($v0)
	nop
	slt	$v0,$a0,$v0
	bne	$v0,$0,$L3
	nop

	lw	$v0,24($fp)
	nop
	addiu	$v0,$v0,1
	sw	$v0,24($fp)
	b	$L4
	nop

$L3:
	lw	$v0,24($fp)
	nop
	sll	$v1,$v0,2
	lw	$v0,40($fp)
	nop
	addu	$v0,$v0,$v1
	lw	$a0,0($v0)
	lw	$v0,24($fp)
	nop
	addiu	$v0,$v0,-1
	sll	$v1,$v0,2
	lw	$v0,40($fp)
	nop
	addu	$v0,$v0,$v1
	lw	$v0,0($v0)
	nop
	move	$a1,$v0
	lw	$t9,%call16(swap)($gp)
	nop
	jalr	$t9
	nop

	lw	$gp,16($fp)
	lw	$v1,24($fp)
	li	$v0,1			# 0x1
	bne	$v1,$v0,$L5
	nop

	lw	$v0,24($fp)
	nop
	addiu	$v0,$v0,1
	sw	$v0,24($fp)
	b	$L4
	nop

$L5:
	lw	$v0,24($fp)
	nop
	addiu	$v0,$v0,-1
	sw	$v0,24($fp)
$L4:
	lw	$v0,24($fp)
	nop
	addiu	$v0,$v0,1
	sw	$v0,24($fp)
$L2:
	lw	$v0,24($fp)
	lw	$v1,44($fp)
	nop
	slt	$v0,$v0,$v1
	bne	$v0,$0,$L6
	nop

	move	$sp,$fp
	lw	$ra,36($sp)
	lw	$fp,32($sp)
	addiu	$sp,$sp,40
	j	$ra
	nop

	.set	macro
	.set	reorder
	.end	Gnome_Sort
	.align	2
	.globl	main
	.ent	main
	.type	main, @function
main:
	.set	nomips16
	.frame	$fp,64,$ra		# vars= 32, regs= 2/0, args= 16, gp= 8
	.mask	0xc0000000,-4
	.fmask	0x00000000,0
	.set	noreorder
	.set	nomacro
	
	addiu	$sp,$sp,-64
	sw	$ra,60($sp)
	sw	$fp,56($sp)
	move	$fp,$sp
	.cprestore	16
	li	$v0,6			# 0x6
	sw	$v0,24($fp)
	li	$v0,5			# 0x5
	sw	$v0,28($fp)
	li	$v0,7			# 0x7
	sw	$v0,32($fp)
	li	$v0,4			# 0x4
	sw	$v0,36($fp)
	li	$v0,10			# 0xa
	sw	$v0,40($fp)
	li	$v0,1			# 0x1
	sw	$v0,44($fp)
	li	$v0,2			# 0x2
	sw	$v0,48($fp)
	addiu	$v0,$fp,28
	move	$a0,$v0
	lw	$a1,24($fp)
	.option	pic0
	jal	Gnome_Sort
	nop

	.option	pic2
	lw	$gp,16($fp)
	move	$v0,$0
	move	$sp,$fp
	lw	$ra,60($sp)
	lw	$fp,56($sp)
	addiu	$sp,$sp,64
	j	$ra
	nop

	.set	macro
	.set	reorder
	.end	main
	.ident	"GCC: (Debian 4.3.5-4) 4.3.5"
