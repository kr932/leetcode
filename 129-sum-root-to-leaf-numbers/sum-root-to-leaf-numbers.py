# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def sumNumbers(self, root):
        def dfs(node, current_sum):
            if not node:
                return 0

            # Update current number
            current_sum = current_sum * 10 + node.val

            # If leaf node → return the number formed
            if not node.left and not node.right:
                return current_sum

            # Recur for left and right
            return dfs(node.left, current_sum) + dfs(node.right, current_sum)

        return dfs(root, 0)



if __name__ == "__main__":

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    print(Solution().sumNumbers(root))  # Output: 25

    root = TreeNode(4)
    root.left = TreeNode(9)
    root.right = TreeNode(0)
    root.left.left = TreeNode(5)
    root.left.right = TreeNode(1)
    print(Solution().sumNumbers(root))  # Output: 1026
