import java.util.*;
public class findmedian {
	//�ֱ��s1��s2��ʼ,t1��t2ֹ(�����±�)
  static double getmedian(int x[],int s1,int t1,int y[],int s2,int t2)
  {
	int n=t1-s1+1,m=t2-s2+1 ;//���鳤��,����ʹ�������麯�������棩
	int l1=s1,l2=s2,r1=t1,r2=t2;//��ֹλ��
	int mid1=(t1+s1)/2,mid2=(t2+s2)/2;//�м�λ��
	double i,j;//��λ��
	//����ż����λ��
	if(n%2==0) {
		i=(x[n/2+s1]+x[n/2-1+s1])/2.0;
	}
	else i=x[n/2+s1];
	if(m%2==0) {
		j=(y[m/2+s2]+y[m/2-1+s2])/2.0;
	}
	else j=y[m/2+s2];
	
	while((l1<=r1)&&(l2<=r2)) {
		//y[]��Ԫ�ض����ڵ���x[]
		if(x[r1]<=y[l2]) {
			return (x[r1]+y[l2])/2.0;
		}
		//x[]��Ԫ�ض����ڵ���y[]
		if(x[l1]>=y[r2]) {
			return (x[l1]+y[r2])/2.0;
		}	
		
	if(l1+1==r1) {//ÿ������ֻ��2��Ԫ��ʱ
	int max=x[r1]>=y[r2]?x[r1]:y[r2];
	int min=x[l1]<=y[l2]?x[l1]:y[l2];
	return (x[l1]+x[r1]+y[l2]+y[r2]-max-min)/2.0;
	}		
		//��λ�����
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
			 if((t2-s2)%2==0)//ʹ�õ�����Ϊ����
				 return getmedian( x,mid1,t1,y,s2,mid2);
				 else return getmedian(x,s1,mid1,y,mid2,t2);
			 }
		 }
	return -1;
	}

	public static void main(String[] args) {
			
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("���鳤��:");
		int n=scanner.nextInt();
		int arr1[]=new int[n];
		int arr2[]=new int[n];
		System.out.println("��������һ��");
		for(int i=0;i<n;i++) {
			arr1[i]=scanner.nextInt();
		}
		System.out.println("�����������");
		for(int i=0;i<n;i++) {
			arr2[i]=scanner.nextInt();
		}
		scanner.close();
double res=getmedian(arr1,0,n-1,arr2,0,n-1);
System.out.println("��λ��:");
System.out.println(res);
	
	}
}
