#include<iostream>
using namespace std;

    double pow2(double x,int n){
        if(n==0)
           return 1;
        else
        {
            double d = pow2(x,n/2);
            if(n%2 == 0)
                return d*d;
            else
                return x*d*d;
        }         
    }    
    
    double pow1(double x, int n) {
        if(n>0)
            return pow2(x,n);
        else
            return 1.0/pow2(x,-n);
    }

main()
{
    cout<<pow1(5,3);
    system("pause");
}    
