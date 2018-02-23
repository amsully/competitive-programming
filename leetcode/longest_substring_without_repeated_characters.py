class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """

        result = 0

        curr_pos = 0
        min_char_in_map = 0
        i = 0
        char_location = {}

        for char in s:
            if(char in char_location and char_location[char] >= curr_pos):
                size = i - curr_pos
                if(size > result):
                    result = size

                curr_pos = char_location[char] + 1

            char_location[char] = i

            i = i + 1

        size = i - curr_pos
        if(size > result):
            result = size

        return result


if __name__=='__main__':
	sol = Solution()
	print(sol.lengthOfLongestSubstring("pwwkew"))
