import java.util.Random;
import java.util.Scanner;

public class GameLife{
    private final int HEIGHT=10;//二维游戏世界的大小。HEIGHT*WIDTH 个字符
    private final int WIDTH =10;
    private char[][] world = new char[HEIGHT][WIDTH];//二维数组表格
   
    private final char Y ='*'; //用字符*代表一个活细胞
    private final char No = ' ';
    /**
     * 构造器使用预定义的数据初始化world. 
     */
    GameLife(){
      world[3][4] = world[3][5] = world[3][6]=world[6][4] =Y;
        //glider
      world[9][4] =  world[9][5] =  world[9][6] =  world[5][6] =  world[6][5] = Y;
   }
    
    
    /**
     * 在控制台中输出world数据
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
 * Helper Method。
 * 获取指定坐标(x,y)或（col,row）格子中细胞状况值,即是否存在细胞。注意参数超出边界情况。
 * @参数 y y坐标，或row  格子所在行
 * @参数 x x坐标，或col  格子所在列，
 * @返回值 参数超出边界或者格子为空，返回0；否则返回1。
 */
private int cellState(int y,int x) {
    boolean isEmpty = (y < 0 || y >= HEIGHT || x < 0 || x >= WIDTH || world[y][x] != Y ) ;
    return isEmpty ? 0 : 1 ;
}


/**
 * 获取指定坐标(x,y)或（col,row）格子的邻居（neighbor）数
 * @参数 y y坐标，或row  格子所在行
 * @参数 x x坐标，或col  格子所在列，
 * @返回值 邻居数目.
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
 * 世代交替。
 * 生命游戏的核心是在当前world数据基础上计算出下一代的world数据，以便打印新一代的二维世界。
 * 为此，需扫描当代world的每一个格子，计算其邻居的数量，以条件语句表达生命演化规则，设定新一代world的数据。
 * 因为在所有的格子计算完之前，world的数据不得变化，
 * 因此使用了应该临时的temp，暂存二维世界的数据。
 * ★calculate()
 */
public void nextWorld() {
    char[][] temp = new char[HEIGHT][WIDTH];
    int y=0;//坐标位置(x,y)
    for (char[] rowArr : world){
        int x=0;
        for(char colData :rowArr ){
            int neighbor = getNeighbors(y, x);//习惯(y, x)
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
 * 在BlueJ中，你可以创建一个GameLife对象，交替调用其print()、nextWorld()方法。
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
