#!/bin/python

import sys
from sets import Set


q = int(raw_input().strip())
for a0 in xrange(q):
    n,m,c_lib,c_road = raw_input().strip().split(' ')
    n,m,c_lib,c_road = [int(n),int(m),int(c_lib),int(c_road)]

    map_city ={}

    if(c_lib > c_road):
	    for i in xrange(1,n+1):
	    	map_city[i] = Set([])

    for a1 in xrange(m):
        city_1,city_2 = raw_input().strip().split(' ')
        city_1,city_2 = [int(city_1),int(city_2)]

        if(c_lib > c_road):
            map_city[city_2].add(city_1)
            map_city[city_1].add(city_2)

    if(c_lib < c_road):
    	print c_lib * n
    	continue        

    visited = [False for i in range(1,n+1)]
    components = []

    for key in map_city:
    	if( not visited[key-1]):
            stak = []
            component = []
            stak.append(key)

            while(len(stak) > 0):
                node = stak.pop()
                if(visited[node-1]):
                    continue
                else:
                    visited[node-1] = True
                    component.append(node)
                    for neighbor in map_city[node]:
                        if(not visited[neighbor-1]):
                            stak.append(neighbor)

            components.append(component)


    result = 0
    for component in components:
    	result += ((len(component) -1 )*c_road) + c_lib

    # print components
    # print map_city
    print result

