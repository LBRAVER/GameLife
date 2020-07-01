/*�Ƚ�ǰp�����ݵ���
 * �ٰѺ�n-p�����ݵ���
 * Ȼ���n�����ݵ���
T(n)=O(n)
S(n)=O(1)
*/
public class zuoyi {
static void reserve(int arr[],int start,int end) {//��������
	for( int i=0;i<(end-start+1)/2;i++) {
		int temp=arr[end-i];
		arr[end-i]=arr[start+i];
		arr[start+i]=temp;
	}
}

static void result(int arr[],int n,int p) {//�ָ�����˳��
	reserve(arr,0,p-1);
	reserve(arr,p,n-1);
	reserve(arr,0,n-1);
}

static void display(int arr[]) {//�������
	for(int i=0;i<=arr.length-1 ;i++) {
		System.out.print(arr[i]);
		System.out.print(" ");	
	}
}
	public static void main(String[] args) {
		int a[]= {1,2,3,5,6,7,9};
		int p=3;
		display(a);
		System.out.println("");
		System.out.println("p="+p);
		result(a,7,3);	
		display(a);
	}
}
