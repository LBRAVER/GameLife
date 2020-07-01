package softwareshiyan;

public class cell {
    private int maxLength;
    private int maxWidth;
    private int nowGeneration;
 private int[][] grid; //һ�����ݴ���һ��ϸ��,0��������1�����

    public cell(int maxLength, int maxWidth) {
        this.maxLength = maxLength;
        this.maxWidth = maxWidth;
    this.nowGeneration=0; 
        //��ʼ��ȫΪ��
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

    //�����ʼ��ϸ��
    public void randomCell(){
        for (int i = 0; i < maxWidth; i++) {
			for (int j = 0; j < maxLength; j++)
                grid[i][j] = Math.random()>0.5?1:0;
		}
    }

    //ϸ������
    public void deleteAllCell(){
        for (int i = 0; i <maxWidth; i++) {
			for (int j = 0; j <maxLength; j++)
                grid[i][j] = 0;
		}
    }

    //����
    public void update() {
        int[][] newGrid = new int[maxWidth ][ maxLength ];
        for (int i = 0; i < maxWidth; i++) {
			for (int j = 0; j <  maxLength; j++)
                switch (getNeighborCount(i, j)) {
                    case 2:
                        newGrid[i][j] = grid[i][j]; //ϸ��״̬���ֲ���
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
    * ��ȡָ������(x,y)��col,row�����ӵ��ھӣ�neighbor����
    * @���� y y���꣬��row  ����������
    * @���� x x���꣬��col  ���������У�
    * @����ֵ �ھ���Ŀ.
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
