
#!/bin/python

import sys
from sets import Set


set_ = Set([])
collection = []
for i in range(5,9):
	total = 0

	for v in xrange(10000,pow(10,i)):
		if( calcFives(v) and calcFours(v) and calcThrees(v) ):
			total+=1

			collection.append(total)
	print collection