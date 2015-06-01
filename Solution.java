public class Solution {
    public static int removeDuplicates(int[] A) {
        if(A.length<=2)
        return A.length;
        
        int i=1,j=1;
        int count=0;
        while(j<A.length){
			//System.out.printf("%d %d%n",i,j);
            if(A[j]==A[i-1]){
                if(count==1){
                    A[i-1]=A[j];
                    j++;
                    count=0;
                }
                i++;
                j++;
                count++;
				System.out.println("if");
            }else if(A[j]>A[i]){
                A[i]=A[j];
                i++;
                j++;
				System.out.println("else");
            }
			System.out.printf("A[j]=%d j=%d A[i]=%d i=%d%n",A[j],j,A[i],i);
        }
        return i;
    }
	public static void main(String[] args){
		int[] a={1,1,1,2,2,3};
		System.out.println(removeDuplicates(a));
	}
}