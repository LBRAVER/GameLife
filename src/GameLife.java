import java.util.Random;
import java.util.Scanner;

public class GameLife{
    private final int HEIGHT=10;//��ά��Ϸ����Ĵ�С��HEIGHT*WIDTH ���ַ�
    private final int WIDTH =10;
    private char[][] world = new char[HEIGHT][WIDTH];//��ά������
   
    private final char Y ='*'; //���ַ�*����һ����ϸ��
    private final char No = ' ';
    /**
     * ������ʹ��Ԥ��������ݳ�ʼ��world. 
     */
    GameLife(){
      world[3][4] = world[3][5] = world[3][6]=world[6][4] =Y;
        //glider
      world[9][4] =  world[9][5] =  world[9][6] =  world[5][6] =  world[6][5] = Y;
   }
    
    
    /**
     * �ڿ���̨�����world����
     */
    private void print(){
        for (int height = 0; height < HEIGHT; height++) {
            for (int width = 0;width < WIDTH; width++) {
              char c = ( world[height][width] == Y) ? Y: No ;
                System.out.print(c);
            	
            }
            System.out.println("");
        }
        System.out.println("");
    }   

/**
 * Helper Method��
 * ��ȡָ������(x,y)��col,row��������ϸ��״��ֵ,���Ƿ����ϸ����ע����������߽������
 * @���� y y���꣬��row  ����������
 * @���� x x���꣬��col  ���������У�
 * @����ֵ ���������߽���߸���Ϊ�գ�����0�����򷵻�1��
 */
private int cellState(int y,int x) {
    boolean isEmpty = (y < 0 || y >= HEIGHT || x < 0 || x >= WIDTH || world[y][x] != Y ) ;
    return isEmpty ? 0 : 1 ;
}


/**
 * ��ȡָ������(x,y)��col,row�����ӵ��ھӣ�neighbor����
 * @���� y y���꣬��row  ����������
 * @���� x x���꣬��col  ���������У�
 * @����ֵ �ھ���Ŀ.
 */
private int getNeighbors(int y,int x) {
    int n = 0; //neighbor
    n += cellState( y - 1, x - 1);
    n += cellState( y - 1, x);
    n += cellState( y - 1, x + 1);
    n += cellState( y, x - 1);
    n += cellState( y, x + 1);
    n += cellState( y + 1, x - 1);
    n += cellState( y + 1, x);
    n += cellState( y + 1, x + 1);
    return n;


}
/**
 * �������档
 * ������Ϸ�ĺ������ڵ�ǰworld���ݻ����ϼ������һ����world���ݣ��Ա��ӡ��һ���Ķ�ά���硣
 * Ϊ�ˣ���ɨ�赱��world��ÿһ�����ӣ��������ھӵ�����������������������ݻ������趨��һ��world�����ݡ�
 * ��Ϊ�����еĸ��Ӽ�����֮ǰ��world�����ݲ��ñ仯��
 * ���ʹ����Ӧ����ʱ��temp���ݴ��ά��������ݡ�
 * ��calculate()
 */
public void nextWorld() {
    char[][] temp = new char[HEIGHT][WIDTH];
    int y=0;//����λ��(x,y)
    for (char[] rowArr : world){
        int x=0;
        for(char colData :rowArr ){
            int neighbor = getNeighbors(y, x);//ϰ��(y, x)
            if (neighbor==3) {
                temp[y][x] = Y;
            }else if (neighbor == 2 && colData == Y){
                temp[y][x] = Y;
            }else{
                temp[y][x] = No; 
            }
            x++;
        }
        y++;
    }
    /*
    for (int height = 0; height < HEIGHT; height++) {
    for (int width = 0; width < WIDTH; width++) {
    int neighbor = getNeighbors(height, width);
    if (neighbor==3) {
    temp[height][width] = Y;
    }else if (neighbor == 2 && world[height][width] == Y){
    temp[height][width] = Y;
    }else{
    temp[height][width] = No; 
    }
    }
    }*/
    world = temp;
}

/**
 * ��BlueJ�У�����Դ���һ��GameLife���󣬽��������print()��nextWorld()������
 */
public static void main(String[] a){
    GameLife gol = new GameLife();     
    int end;
    int generation = 0;
   // gol.print();
    Scanner in=new Scanner(System.in);
    do{
        System.out.println("Generation"+("  ")+(generation++));
        gol.nextWorld();
        gol.print();           
        System.out.println("Press 1 to quit or other key to continue: ");
        end = in.nextInt();
    }while(!"1".equals(end));       
}
}
