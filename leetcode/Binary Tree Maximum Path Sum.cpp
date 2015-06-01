#include<iostream>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
int maxx;
int maxpath(TreeNode *node)
{
    int left=0,right=0;
    if(node->left!=NULL)
    {
        left=maxpath(node->left);
    }
    if(node->right!=NULL)
    {
        right=maxpath(node->right);
    }
    if(maxx<left+node->val+right)
        maxx=left+node->val+right;
    if(maxx<left+node->val) maxx=left+node->val;
    if(maxx<right+node->val) maxx=right+node->val;
    if(maxx<node->val) maxx=node->val;
    if(left>right&&left>0) return left+node->val;
    else if(right>0) return right+node->val;
    else return node->val;
}    
int maxPathSum(TreeNode *root) {
    maxx=0;
    if(root==NULL) return maxx;
    int m=maxpath(root);
    return maxx;
}


