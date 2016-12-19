#!/bin/python

import sys


n = int(raw_input().strip())
p = int(raw_input().strip())
# your code goes here

result = 0
if(p > n/2):
	if(n%2 == 0):
		n+=1
	result = n-p
else:
	result = p

print result/2