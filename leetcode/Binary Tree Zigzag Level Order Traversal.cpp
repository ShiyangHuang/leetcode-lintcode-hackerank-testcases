#include<iostream>
#include<vector>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
vector<vector<int> > ans;
vector<vector<int> > ans2;
void track(TreeNode *node,int n)
{
    if(ans.size()<n)
    {
        vector<int> temp;
        temp.push_back(node->val);
        ans.push_back(temp);
        //cout<<ans.size()<<endl;
        //cout<<node->val<<endl;
    }
    else
    {
        ans[n-1].push_back(node->val);
    }
    if(node->left!=NULL) track(node->left,n+1);
    if(node->right!=NULL) track(node->right,n+1);
}        
vector<vector<int> > zigzagLevelOrder(TreeNode *root) {
    if(root==NULL) return ans;
    track(root,1);
    int n=ans.size();
    cout<<n<<endl;
    for(int i=0;i<n;i++)
    {
        if(i%2==0)
        {
            ans2.push_back(ans[i]);
        }
        else
        {
            vector<int> temp;
            for(int j=0;j<ans[i].size();j++)
            {
                temp.push_back(ans[i][ans[i].size()-j-1]);
                //cout<<ans[i][ans[i].capacity()-j-1]<<endl;
            }
            ans2.push_back(temp);
        }
    }        
    return ans2;
}
main()
{
    TreeNode *root = new TreeNode(1);
    root->left=new TreeNode(2);
    root->right=new TreeNode(3);
    root->left->left=new TreeNode(4);
    root->right->right=new TreeNode(5);
    vector<vector<int> > test=zigzagLevelOrder(root);
    cout<<test[0][0]<<" "<<test[1][0]<<" "<<test[1][1];
    system("pause");
}    
