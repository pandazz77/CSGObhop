import java.awt.AWTException;

public class MainClass{
	public static void main(String[] args) throws AWTException, InterruptedException {
		Thread listener = new Thread(new GlobalKeyListener());
		listener.start();
		while(true) {
			System.out.print("");
			if (ActiveHolder.getActive()) {
				System.out.println(ActiveHolder.getActive());
				Jumper.jump();
			}
		}
	}
}