#include<iostream>
using namespace std;

int strStr(char *haystack, char *needle) {
    int ni=strlen(haystack);
    int nj=strlen(needle);
    if(nj>ni) return -1;
    if(nj==0) return 0;
    int jump=0;
    for(int i=1;i<nj;i++)
    {
        if(needle[i]==needle[i-1])
            jump++;
        else break;
    }
    //cout<<jump<<endl;
    int t=0;
    int start=0;  
    for(int i=0;i<ni;i++)
    {
        if(t>jump)
            start=jump;
        else
            start=0;
        cout<<start<<endl;
        for(int j=start;j<nj;j++)
        {
            //cout<<i+j<<":"<<ni<<endl;
            //cout<<haystack[i+j]<<" "<<needle[j]<<endl;
            t=j;
            if(((i+nj-1)>=ni)||(haystack[i+j+start]!=needle[j]))
            {
                cout<<"break"<<endl;
                break;
            }
            else if(j==nj-1)
            {
                return i;
            }
        }
        if(i+nj-1>=ni) break;
    }                
    //cout<<ni<<" "<<nj<<endl;
    return -1;
}

main()
{
    char c1[]="bbababaaaababbaabbbabbbaaabbbaaababbabaabbaaaaabbaaabbbbaaabaabbaababbbaabaaababbaaabbbbbbaabbbbbaaabbababaaaaabaabbbababbaababaabbaa";
    char c2[]="bbabba";
    cout<<strStr(c1,c2);
    system("pause");
}    
