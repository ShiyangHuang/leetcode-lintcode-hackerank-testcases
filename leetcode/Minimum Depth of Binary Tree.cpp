#include<iostream>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
int mindepth;
void check(TreeNode *node, int n)
{
    if(node->left==NULL&&node->right==NULL) 
    {
        if(n<mindepth||mindepth==-1) 
                mindepth=n;
    }
    if(node->left!=NULL) check(node->left,n+1);
    if(node->right!=NULL) check(node->right,n+1);
}
    
int minDepth(TreeNode *root) {
    if(root==NULL) return 0;
    mindepth=-1;
    check(root,1);
    return mindepth;
}
