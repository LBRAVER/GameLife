import java.util.*;
public class findmedian {
	//分别从s1和s2开始,t1和t2止(数组下标)
  static double getmedian(int x[],int s1,int t1,int y[],int s2,int t2)
  {
	int n=t1-s1+1,m=t2-s2+1 ;//数组长度,不可使用求数组函数（后面）
	int l1=s1,l2=s2,r1=t1,r2=t2;//起止位置
	int mid1=(t1+s1)/2,mid2=(t2+s2)/2;//中间位置
	double i,j;//中位数
	//分奇偶找中位数
	if(n%2==0) {
		i=(x[n/2+s1]+x[n/2-1+s1])/2.0;
	}
	else i=x[n/2+s1];
	if(m%2==0) {
		j=(y[m/2+s2]+y[m/2-1+s2])/2.0;
	}
	else j=y[m/2+s2];
	
	while((l1<=r1)&&(l2<=r2)) {
		//y[]中元素都大于等于x[]
		if(x[r1]<=y[l2]) {
			return (x[r1]+y[l2])/2.0;
		}
		//x[]中元素都大于等于y[]
		if(x[l1]>=y[r2]) {
			return (x[l1]+y[r2])/2.0;
		}	
		
	if(l1+1==r1) {//每个数组只有2个元素时
	int max=x[r1]>=y[r2]?x[r1]:y[r2];
	int min=x[l1]<=y[l2]?x[l1]:y[l2];
	return (x[l1]+x[r1]+y[l2]+y[r2]-max-min)/2.0;
	}		
		//中位数相等
		 if(i==j) {
			 return i;
		 }
		 //
		 else if(i>j) {
			 if((t2-s2)%2!=0)
			 return getmedian( x,mid1,t1,y,s2,mid2);
			 else return getmedian(x,s1,mid1,y,mid2,t2);
		 }
		  if(i<j) {
			 if((t2-s2)%2==0)//使用的数组为奇数
				 return getmedian( x,mid1,t1,y,s2,mid2);
				 else return getmedian(x,s1,mid1,y,mid2,t2);
			 }
		 }
	return -1;
	}

	public static void main(String[] args) {
			
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("数组长度:");
		int n=scanner.nextInt();
		int arr1[]=new int[n];
		int arr2[]=new int[n];
		System.out.println("输入数组一：");
		for(int i=0;i<n;i++) {
			arr1[i]=scanner.nextInt();
		}
		System.out.println("输入数组二：");
		for(int i=0;i<n;i++) {
			arr2[i]=scanner.nextInt();
		}
		scanner.close();
double res=getmedian(arr1,0,n-1,arr2,0,n-1);
System.out.println("中位数:");
System.out.println(res);
	
	}
}
