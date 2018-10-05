# AVL-tree-creation-and-traversal
AVL trees or Adelson-Velskii and Landis tree named after the inventors is a balanced binary search tree With a balanced condition that:
1. Pairs of sub-trees differ in height by at most 1.
2. Every subtree is an AVL tree

Search time: O(logn)
Insertion time: O(logn) 
Deletion time: O(logn) 

Insertion or Deletion may create imbalance in the tree which would require a rebalancing operation as defined below:
Rebalance: 
Suppose the node to be rebalanced is X. There are 4 cases that we might have to fix (two are the mirror images of the other two):
		Case 1. An insertion in the left subtree of the left child of X,
		Case 2. An insertion in the right subtree of the left child of X,
		Case 3. An insertion in the left subtree of the right child of X, or
		Case 4. An insertion in the right subtree of the right child of X.
			Balance is restored by tree rotations

Rotations:

		Case 1 and case 4 are symmetric and requires the same operation for balance. 
		Cases 1,4 are handled by single rotation.
		Case 2 and case 3 are symmetric and requires the same operation for balance.
		Cases 2,3 are handled by double rotation

Single Rotation:

	A single rotation switches the roles of the parent and child while maintaining the search order.
	Single rotation handles the outside cases (i.e. 1 and 4).
	We rotate between a node and its child. 
	Child becomes parent. Parent becomes right child in case 1, left child in case 4.
	The result is a binary search tree that satisfies the AVL property.

Double Rotation:

	Single rotation does not fix the inside cases (2 and 3). 
	These cases require a double rotation, involving three nodes and four subtrees
Left-Right Double Rotation:

		A left-right double rotation is equivalent to a sequence of two single rotations: 
	1st rotation on the original tree:
	  a left rotation between X’s left-child and grandchild
	 2nd rotation on the new tree: 
	  a right rotation between X and its new left child. 

Do the same process in opposite direction for Right-Lefy Double Rotation
