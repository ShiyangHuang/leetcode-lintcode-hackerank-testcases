#include<iostream>
#include<vector>

using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

bool ans;

int max(int a,int b)
{
    if(a>b) return a;
    else return b;
}
    
int check(TreeNode *root)
{
    if(root->left==NULL&&root->right==NULL)
    {
        return 1;
    }
    int left=0,right=0;    
    if(root->left!=NULL)
        left = check(root->left);
    if(root->right!=NULL)
        right = check(root->right);
    if(abs(left-right)>1) ans=false;
    return max(left,right)+1;
}        
    
bool isBalanced(TreeNode *root) {
    if(root==NULL) return true;
    ans = true;
    int depth = check(root);
    return ans;        
} 
