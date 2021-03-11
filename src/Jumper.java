import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Jumper{
	public static void jump() throws AWTException, InterruptedException{
		Robot r = new Robot();
		Thread.sleep(10);
		r.keyPress(KeyEvent.VK_SPACE);
		Thread.sleep(10);
		r.keyRelease(KeyEvent.VK_SPACE);
	}
}
