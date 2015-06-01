#include<iostream>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
bool check(TreeNode *left, TreeNode *right)
{
    if(left==NULL&&right==NULL) return true;
    if(left->val!=right->val) return false;
    if((left->left!=NULL && right->right==NULL)||
       (left->right!=NULL && right->left==NULL)||
       (left->left==NULL && right->right!=NULL)||
       (left->right==NULL && right->left!=NULL))
       return false;
    return check(left->right,right->left)&&check(left->left,right->right);
}
        
bool isSymmetric(TreeNode *root) {
    return check(root,root);
}
