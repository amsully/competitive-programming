# Given an array of integers, return indices of the two numbers such that they add up to a specific target.

# You may assume that each input would have exactly one solution, and you may not use the same element twice.

class Solution(object):
    def twoSumAccepted(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        for  i in range(0, len(nums)-1):
        	for j in range(i+1, len(nums)):
        		tmp = nums[i] + nums[j]
        		if(tmp == target):
        			return [i,j]
        return None # No solution

    def twoSum(self, nums, target):
    	if(len(nums) < 1):
    		return None # No Solution

    	diff_dic = {}
    	for i in range(len(nums)):
    		if nums[i] in diff_dic :
    			return [diff_dic[nums[i]], i]
    		else:
    			diff_dic[target-nums[i]] = i

    	return None


if __name__=="__main__":

	sol = Solution()

	nums = [1,2,3,4,5]
	target = 7

	print(sol.twoSum(nums, target))