#include<iostream>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

bool ans;

void check(TreeNode *p, TreeNode *q){
     if(p->val!=q->val) 
     {
         ans=false;
         return;
     }
     if((p->left!=NULL&&q->left==NULL)||
        (p->left==NULL&&q->left!=NULL)||
        (p->right==NULL&&q->right!=NULL)||
        (p->right==NULL&&q->right!=NULL)){
        ans=false;
        return;
        }  
        
     if(p->left!=NULL&&q->left!=NULL)
         check(p->left,q->left);
     if(p->right!=NULL&&q->right!=NULL)
         check(p->right,q->right);
       
}    

bool isSameTree(TreeNode *p, TreeNode *q) {
     ans = true;
     if(p==NULL&&q==NULL) return ans;
     if(p!=NULL&&q!=NULL)
         check(p,q);
     else return false;
     return ans;
}
