#!/bin/python

import sys
from sets import Set


q = int(raw_input().strip())
for a0 in xrange(q):
    n,m,c_lib,c_road = raw_input().strip().split(' ')
    n,m,c_lib,c_road = [int(n),int(m),int(c_lib),int(c_road)]

    map_roads ={}

    if(c_lib > c_road):
	    for i in xrange(1,n+1):
	    	map_roads[i] = Set([i])

    for a1 in xrange(m):
        city_1,city_2 = raw_input().strip().split(' ')
        city_1,city_2 = [int(city_1),int(city_2)]

        if(c_lib > c_road):
        	if(city_1  > city_2):
        		temp = city_2
        		city_2 = city_1
        		city_1 = temp

	        map_roads[city_1].add(city_2)
	        map_roads[city_2] = map_roads[city_1]

	      #   for city in map_roads[city_1]:
		    	# map_roads[city] = map_roads[city_1]

    if(c_lib < c_road):
    	print c_lib * n
    	continue        

    visited = [False for i in range(1,n+1)]
    components = []

    for key in map_roads:
    	if( not visited[key-1]):
    		components.append(map_roads[key])
    		for node in map_roads[key]:
    			visited[node-1] = True

    result = 0
    for component in components:
    	result += ((len(component) -1 )*c_road) + c_lib

    print components
    print result

