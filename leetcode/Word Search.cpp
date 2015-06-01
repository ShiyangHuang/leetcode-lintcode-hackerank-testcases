#include<iostream>
#include<vector>
#include<string>
using namespace std;
bool ans;
bool b[100][100];
void test(vector<vector<char> > &board, string word, int x,int y,int t)
{
    //cout<<"t="<<t<<endl;
    if(t==word.size()) {ans=true;return;}
    if(!ans&&x>0&&board[x-1][y]==word[t]&&b[x-1][y])
    {
        //cout<<"x-1,y"<<endl;
        b[x-1][y]=false;
        test(board,word,x-1,y,t+1);
        b[x-1][y]=true;
    }    
    if(!ans&&y>0&&board[x][y-1]==word[t]&&b[x][y-1]) 
    {
        //cout<<"x,y-1"<<endl;
        b[x][y-1]=false;
        test(board,word,x,y-1,t+1);
        b[x][y-1]=true;
    }    
    if(!ans&&y+1<board[0].size()&&board[x][y+1]==word[t]&&b[x][y+1])
    {
        //cout<<"x,y+1"<<endl;
        b[x][y+1]=false;
        test(board,word,x,y+1,t+1);
        b[x][y+1]=true;
    }    
  
    if(!ans&&x+1<board.size()&&board[x+1][y]==word[t]&&b[x+1][y]) 
    {
        //cout<<"x+1,y"<<endl;
        b[x+1][y]=false;
        test(board,word,x+1,y,t+1); 
        b[x+1][y]=true;
    }    
/*
    if(!ans&&x>0&&y>0&&board[x-1][y-1]==word[t]&&b[x-1][y-1])
    {
        //cout<<"x-1,y-1"<<endl;
        b[x-1][y-1]=false;
        test(board,word,x-1,y-1,t+1);
        b[x-1][y-1]=true;
    } 
    if(!ans&&x>0&&y+1<board[0].size()&&board[x-1][y+1]==word[t]&&b[x-1][y+1]) 
    {
        //cout<<"x-1,y+1"<<endl;
        b[x-1][y+1]=false;
        test(board,word,x-1,y+1,t+1);
        b[x-1][y+1]=true;
    }   
    if(!ans&&x+1<board.size()&&y>0&&board[x+1][y-1]==word[t]&&b[x+1][y-1]) 
    {
        //cout<<"x+1,y-1"<<endl;
        b[x+1][y-1]=false;
        test(board,word,x+1,y-1,t+1);   
        b[x+1][y-1]=true;
    }  
        if(!ans&&x+1<board.size()&&y+1<board[0].size()&&board[x+1][y+1]==word[t]&&b[x+1][y+1]) 
    {
        //cout<<"x+1,y+1"<<endl;
        b[x+1][y+1]=false;
        test(board,word,x+1,y+1,t+1);
        b[x+1][y+1]=true;
    }
    */
}    
bool exist(vector<vector<char> > &board, string word) {
    ans=false;
    if(board.size()==0) return ans;
    if(board[0].size()==0) return ans;
    if(board.size()*board[0].size()<word.size()) return ans;
    for(int i=0;i<board.size();i++)
    {
        for(int j=0;j<board[0].size();j++)
        {
            b[i][j]=true;
        }
    }
    for(int i=0;i<board.size();i++)
    {
        for(int j=0;j<board[0].size();j++)
        {
            //cout<<"i="<<i<<" j="<<j<<endl;
            if(board[i][j]==word[0])
            {
                b[i][j]=false;
                test(board,word,i,j,1);
                b[i][j]=true;
                if(ans) return ans;
            }    
        }
    }
    return ans;
}
main()
{
    vector<vector<char> > a;
    vector<char> t;
    for(int i=0;i<3;i++)
    {
        t.push_back('a');
    }
    for(int i=0;i<3;i++)
    {
        a.push_back(t);
    }
    a[0][0]='c';
    a[2][0]='b';
    a[2][1]='c';
    a[2][2]='d';        
    string s="aab";
    cout<<exist(a,s)<<endl;
    system("pause");
}    

     
