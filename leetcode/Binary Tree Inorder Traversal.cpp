#inlcude<iostream>
#include<vector>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
 
vector<int> ans;
void check(TreeNode *node)
{
    if(node->left!=NULL)
    {
        check(node->left);
    }
    ans.push_back(node->val);
    if(node->right!=NULL)
    {
        check(node->right);
    }
}
            
vector<int> inorderTraversal(TreeNode *root) {
     if(root==NULL) return ans;
     check(root);
     return ans;
} 
