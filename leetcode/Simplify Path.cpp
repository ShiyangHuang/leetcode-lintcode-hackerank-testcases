#include<iostream>
#include<vector>
using namespace std;
struct file{
    char c[1000];
    int n;
}f[1000];    
string simplifyPath(string path) {
    
    int n = path.size();
    string ans;
    int count = 0;
    int j=0;
    int end = 0;
    int ansint[1000],ansn = 0;
    for(int i=0;i<n;i++)
    {
        if(path[i]=='/')
        {
            for(int k=j+1;k<i;k++)
            {
                f[count].c[f[count].n]=path[k];
                f[count].n++;
            }
            if(j+1<i||path[i-1]=='/') 
            {
                if(f[count].n!=0)
                  count++;
                j=i;
            }           
        }
        else if(i==n-1)
        {
            for(int k=j+1;k<n;k++)
            {
                f[count].c[f[count].n]=path[k];
                f[count].n++;
            }   
            count++;    
        }
        //if(f[count-1].n == 2 && f[count-1].c[0]=='.' && f[count-1].c[1] == '.')
        //  end = count;
    }
    //cout<<count<<endl;
    for(int i=0;i<count;i++)
    {
        if(f[i].n == 2 && f[i].c[0] == '.')
        {
            ansn--;
            if(ansn<0) ansn = 0;
        }    
        else if(f[i].n ==1 && f[i].c[0] == '.')
        ;
        else
        {
            ansint[ansn++] = i;
        }    
    }
    if(ansn == 0) return "/";
    for(int i=0;i<ansn;i++)
    {
        ans+='/';
        for(int j=0;j<f[ansint[i]].n;j++)
           ans+=f[ansint[i]].c[j];
    }        
    return ans;
}


main()
{
    cout<<simplifyPath("/home/foo/.ssh/../.ssh2/authorized_keys/");
    system("pause");
}    
