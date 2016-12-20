#!/bin/python

import sys
from sets import Set


n,p = raw_input().strip().split(' ')
n,p = [int(n),int(p)]
a = map(int,raw_input().strip().split(' '))
# your code goes here

a = sorted(a)

curr_min = p
curr_bttn = 1
total_buttons = 0
for a_i in a:
	while(a_i > curr_min):
		curr_min += p
		curr_bttn += 1


	total_buttons += curr_bttn
	curr_min += p
	curr_bttn += 1


# Slow
# taken = Set([])
# total_buttons = 0
# for a_i in a:
# 	min_num = a_i / p

# 	if(a_i%p != 0):
# 		min_num+=1

# 	while(min_num in taken):
# 		min_num+=1

# 	taken.add(min_num)
# 	total_buttons += min_num



print total_buttons

