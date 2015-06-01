#include <iostream>

using namespace std;

  void rotate(int nums[], int n, int k) {
        k=n-k%n;
        if(k==0) return;
        int max=n;
        while(max)
        {
            for(int i=0;i<k;i++)
            {
				cout<<i<<endl;
                if(!max) break;
                int tmp=nums[i];
                int j=i;
                while(max&&(j+k)%n!=i)
                {
                    nums[j]=nums[(j+k)%n];
                    j+=k;
                    j%=n;
                    max--;
					cout<<max<<endl;
                }
                nums[j]=tmp;
				max--;
            }
        }
		for(int i=0;i<n;i++)
		{
			cout<<nums[i];
		}
    }
int main(int argc, char *argv[]) {
	int num[] = {1,2,3};
	rotate(num,3,1);
}