class Untitled {
	public static int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int n1 = v1.length;
		int n2 = v2.length;
		System.out.println(""+n1 + n2);
		int i=0;
		while(n1>i&&n2>i)
		{
			if(Integer.parseInt(v1[i])>Integer.parseInt(v2[i]))
				return 1;
			else if(Integer.parseInt(v1[i])<Integer.parseInt(v2[i]))
				return -1;
			i++;
		}
		if(n1>n2) 
		{
			for(int j=n2;j<n1;j++)
			{
				if(Integer.parseInt(v1[j])!=0) return 1;
			}
			return 0;
		}
		if(n1<n2) 
		{
			for(int j=n1;j<n2;j++)
			{
				if(Integer.parseInt(v2[j])!=0) return -1;
			}
			return 0;
		}
		return 0;
	}
	public static void main(String[] args) {
		String s1 = "1";
		String s2 = "1.0";
		int a = compareVersion(s1,s2);
		System.out.println(a);
	}
}