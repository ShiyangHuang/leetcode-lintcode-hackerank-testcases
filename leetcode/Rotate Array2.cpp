#include <iostream>

using namespace std;

    
    void rotateb(int nums[], int start, int end)
    {
        while(start<end)
		{
            int tmp = nums[start];
            nums[start]=nums[end];
            nums[end]=tmp;
			start++;end--;
        }
    }

void rotate(int nums[], int n, int k) {
        k%=n;
        rotateb(nums,0,k-1);
        rotateb(nums,k,n-1);
        rotateb(nums,0,n-1);
    }
int main(int argc, char *argv[]) {
	int num[] = {1,2,3};
	int n=3;
	rotate(num,3,1);
	for(int i=0;i<n;i++)
	{
		cout<<num[i];
	}
}