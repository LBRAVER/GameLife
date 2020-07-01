package softwareshiyan;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class cellTest {
    
   private int nowGeneration;
  
   private static cell cell0=new cell(10,10);
	@Before
	public void setUp() throws Exception {
		cell0.deleteAllCell();
	}
	@Test
	public void testGetNowGeneration() {
		assertEquals(0,nowGeneration);
	
	}
	@Test
	public void testUpdate() {
		int grid[][]=new int[10][10];
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				grid[i][j]=1;
			}
		}
	grid[1][0]=0;//00Îª2¸öÁÚ¾Ó
		
		cell0.setGrid(grid);
		cell0.update();
	assertEquals(1,grid[0][0]);
		assertEquals(1,grid[0][9]);//3¸öÁÚ¾Ó
		assertEquals(0,grid[1][0]);
		//assertEquals(1,grid[5][5]);
		assertEquals(0,grid[5][5]);
	assertEquals(1,cell0.getNowGeneration());
	}
	@Test
	public void testgetNeighborCount() {
		
		int grid[][]=new int[10][10];
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				grid[i][j]=1;
			}
		}
		
		cell0.setGrid(grid);
		assertEquals(3,cell0.getNeighborCount(0,0));
		assertEquals(8,cell0.getNeighborCount(5,5));
	     assertEquals(0,cell0.getNeighborCount(0,-1));
		assertEquals(0,cell0.getNeighborCount(-1,0));
		assertEquals(0,cell0.getNeighborCount(10,0));
		assertEquals(0,cell0.getNeighborCount(0,10));
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				grid[i][j]=0;
			}
		}
		cell0.setGrid(grid);
		assertEquals(0,cell0.getNeighborCount(0,0));
		
	}
}
