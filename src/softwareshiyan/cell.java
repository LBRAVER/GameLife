package softwareshiyan;

public class cell {
    private int maxLength;
    private int maxWidth;
    private int nowGeneration;
 private int[][] grid; //一个数据代表一个细胞,0代表死，1代表活

    public cell(int maxLength, int maxWidth) {
        this.maxLength = maxLength;
        this.maxWidth = maxWidth;
    this.nowGeneration=0; 
        //初始化全为死
        grid = new int[maxWidth ][maxLength];
        for (int i = 0; i < maxWidth; i++) {
            for (int j = 0; j < maxLength; j++) {
				grid[i][j] = 0;
			}
        }
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setNowGeneration(int nowGeneration){
        this.nowGeneration = nowGeneration;
    }

    public int getNowGeneration(){
        return nowGeneration;
    }

    //随机初始化细胞
    public void randomCell(){
        for (int i = 0; i < maxWidth; i++) {
			for (int j = 0; j < maxLength; j++)
                grid[i][j] = Math.random()>0.5?1:0;
		}
    }

    //细胞清零
    public void deleteAllCell(){
        for (int i = 0; i <maxWidth; i++) {
			for (int j = 0; j <maxLength; j++)
                grid[i][j] = 0;
		}
    }

    //繁衍
    public void update() {
        int[][] newGrid = new int[maxWidth ][ maxLength ];
        for (int i = 0; i < maxWidth; i++) {
			for (int j = 0; j <  maxLength; j++)
                switch (getNeighborCount(i, j)) {
                    case 2:
                        newGrid[i][j] = grid[i][j]; //细胞状态保持不变
                        break;
                    case 3:
                        newGrid[i][j] = 1; // Cell is alive.
                        break;
                    default:
                        newGrid[i][j] = 0; // Cell is dead.
                }
		}
        for (int i = 0; i < maxWidth; i++) {
			for (int j = 0; j <  maxLength; j++)
                grid[i][j] = newGrid[i][j];
		}
        nowGeneration++;
    }

   
 public int cellState(int x,int y) {
       boolean isEmpty = (y < 0 || y >= maxLength || x < 0 || x >=maxWidth || grid[x][y] ==0) ;
       return isEmpty ? 0 : 1 ;
   }


   /**
    * 获取指定坐标(x,y)或（col,row）格子的邻居（neighbor）数
    * @参数 y y坐标，或row  格子所在行
    * @参数 x x坐标，或col  格子所在列，
    * @返回值 邻居数目.
    */
 public int getNeighborCount(int x,int y) {
	  int n = 0; //neighbor
	  if(0<=x&&x<maxWidth&&0<=y&&y<maxLength) {
       n += cellState( x- 1, y - 1);
       n += cellState( x - 1, y);
       n += cellState( x - 1, y + 1);
       n += cellState( x, y - 1);
       n += cellState( x, y + 1);
       n += cellState( x + 1, y - 1);
       n += cellState( x + 1, y);
       n += cellState( x + 1, y + 1);
       return n;
       } else {
		return 0;
	}
	 }
 
}
