package softwareshiyan;

import static org.junit.Assert.*;

import javax.swing.JButton;
import javax.swing.JComboBox;

import org.junit.Before;
import org.junit.Test;

public class GUITest {
private static GUI frame=new GUI("≤‚ ‘");

	@Before
	public void setUp() throws Exception {
	
	}

	@Test
	public void testInitGUI() {
		frame.setMaxLength(0);
		frame.setMaxWidth(0);
		frame.initGUI();
		assertEquals(20,frame.getMaxWidth());
		assertEquals(20,frame.getMaxLength());  
		//fail("…–Œ¥ µœ÷");
	}
	
}
