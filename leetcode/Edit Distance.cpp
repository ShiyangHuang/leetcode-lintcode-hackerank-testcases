#include <iostream>
#include <vector>
using namespace std;
int min(int a,int b,int c){
	return a<(b<c?b:c)?a:(b<c?b:c);
}
int minDistance(string word1, string word2) {
	int l1=word1.length()+1;
	int l2=word2.length()+1;
	
	vector<vector<int> > f(l1,vector<int>(l2));
	for(int i=0;i<l1;i++) f[i][0]=i;
	for(int i=0;i<l2;i++) f[0][i]=i;
	
	for(int i=1;i<l1;i++)
	{
		for(int j=1;j<l2;j++)
		{
			if(word1[i]==word2[j]) f[i][j]=f[i-1][j-1];
			else
				f[i][j]=f[i-1][j-1]+1;
			f[i][j]=min(f[i][j],f[i-1][j]+1,f[i][j-1]+1);
		}
	} 
	return f[l1-1][l2-1]; 
}

int main(int argc, char *argv[]) {
	string w1="asdf";
	string w2="asdfasdf";
	cout<<minDistance(w1,w2);
	//cout<<min(3,2,1);
}