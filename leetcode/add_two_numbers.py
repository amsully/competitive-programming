# You are given two non-empty linked lists representing two non-negative integers. 
# The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

# You may assume the two numbers do not contain any leading zero, except the number 0 itself.

# Definition for singly-linked list.
import math

class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if(l1 == None):
            return l2
        elif(l2 == None):
            return l1

        x, carry = self.get_x_carry(l1, l2, 0)

        answer = [x]
        # head = ListNode(x)
        # tail = head

        while(l1.next != None and l2.next != None):
            l1 = l1.next
            l2 = l2.next
            x, carry = self.get_x_carry(l1, l2, carry)
            answer.append(x)
            # tail.next = ListNode(x)
            # tail = tail.next



        # at most one of these while loops should ever iterate
        while(l1.next != None):
            l1 = l1.next
            # tail.next = l1_head
            # tail = tail.next
            answer.append(x)
        while(l2.next != None):
            l2 = l2.next
            # tail.next = l2_head
            # tail = tail.next
            answer.append(x)

        return answer

    def get_x_carry(self, l1, l2, carry):
        x = l1.val + l2.val + carry
        carry = int(math.floor(x/10)) # python 3 float
        x = x%10
        return [x, carry]



if __name__=="__main__":

    one = ListNode(1)
    two = ListNode(2)
    one.next = two # 21

    three = ListNode(3)
    four = ListNode(4)
    three.next = four # 43

    sol = Solution()

    li = sol.addTwoNumbers(one, three)
    print(li)

    #Expected output = 64

