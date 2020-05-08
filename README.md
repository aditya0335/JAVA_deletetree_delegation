# JAVA_deletetree_delegation

PART 1: Define Delete in Class AbsTree
Lecture 3 presents an object-oriented definition of a binary search tree called class AbsTree, with two subclasses, Tree and DupTree. In this part of the assignment, you are to complete the definition of the delete operation in class AbsTree in such a way that it works for both trees and duptrees. The method delete(int n) should ensure that, if n is removed from a tree or duptree, the remaining values maintain the binary search tree property. For duptrees, the removal of n from the duptree takes place only when its associated count is 1.
Starter code for this part is given at Resources → Assignments → Tree_Test.java. You are to extend this code in order develop your solution.
Preliminaries: In order to facilitate a simpler solution for delete, a protected field AbsTree parent is added to class AbsTree. Revise the insert method so that the parent field is correctly set when a value is inserted into a tree or duptree.
Define three procedures, min(), max(), and find(n) which return, respectively, the AbsTree node with the minimum value, the AbsTree node with the maximum value, and the AbsTree node containing the value n. If n is not present in the tree, find(n) should return null.
Similar to insert, the code for delete is kept entirely in class AbsTree and captures what is common to trees and duptrees. The differences in delete’s behavior between Tree and DupTree are expressed in terms of two protected abstract methods, called get_count() and set_count(int n), with obvious meanings. You should implement these two methods in classes Tree and DupTree.
Defining delete: A good explanation of delete is given at: http://www.algolist.net/Data_structures/Binary_search_tree/Removal There are four main cases to delete depending upon whether the value to be deleted is at:
(i) A leaf node (but not the root); or
(ii) A non-leaf node (but not the root) with only one non-null subtree; or (iii) A root node with one non-null subtree; or
(iv) A node with both non-null subtrees.
Note that we do not allow the root node to be deleted if it has both null subtrees. Also, when a value n in a duptree has a count > 1, the method delete(n) should decrement the count field associated with n but should not delete the node. If a value n is associated with a count == 1, the method delete(n) should remove the node containing value n from the duptree.

End of Assignment 1

Assignment 1 – Part2
Part 2: Transform Inheritance in terms of Delegation
An important technique in the study of Object-Oriented Design is the use of delegation to replace class inheritance. A systematic approach for this transformation was presented in Lectures 4 and 5. ApplythisapproachtotheprogramResourcesAssignmentsDelegation.java. This program defines classes A, B, C, D, E, and F. The result of your transformation should be definition of classes called A2, B2, C2, D2, E2, and F2 which correspond to classes A, B, C, D, E, and F respectively, but do not make use of class inheritance. The original program and the transformed program, when executed, should produce the same results for the given test cases.
A systematic approach involves the following steps:
1. Define an interface hierarchy with interfaces IA, IB, IC, ID, IE, and IF based upon classes A, B, C, D, E, and F. (Optimize the interfaces to avoid redundancy.)
2. Define new classes A2, B2, C2, D2, E2, and F2 which implement IA, IB, IC, ID, IE, andIFrespectively.
3. Set up the delegation hierarchy, define delegation methods, and provide a translation for every protected abstract method.
4. Translate the pseudo-variables this and super as this2 and super2 respectively. Access superclass attributes by ‘super2-chaining’, e.g., super2.super2. ...
5. In the translated program, you will also need to define two constructors for every non-leaf non-abstract class of the original class hierarchy, i.e., for classes B2 and D2.
End of Assignment 1 Part2
