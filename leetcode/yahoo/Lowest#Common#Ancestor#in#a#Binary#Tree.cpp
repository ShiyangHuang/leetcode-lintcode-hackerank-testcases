#include<iostream>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

int ans;
bool find(int x,int y,TreeNode *node)
{
    if(node==NULL) return false;
    if(node->val==x||node->val==y) return true;
    bool l=find(x,y,node->left);
    bool r=find(x,y,node->right);
    if(l&&r)
    {
        ans=node->val;
    }
    return (l||r);    
}    

int LowestCommonAncient(int x,int y,TreeNode *node)
{
    ans=0;
    bool f=find(x,y,node);
    return ans;
}    
