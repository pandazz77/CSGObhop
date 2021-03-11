
public class ActiveHolder {
	
	protected static boolean active;
	
	public static void setActive(boolean newActive){
		active = newActive;
	}
	
	public static boolean getActive() {
		return active;
	}
}
