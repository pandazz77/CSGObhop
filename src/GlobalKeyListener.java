import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;


public class GlobalKeyListener implements NativeKeyListener, Runnable {
    public void nativeKeyPressed(NativeKeyEvent e){
        //System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        if (e.getKeyCode() == Constants.exit_key) {
            try {
				GlobalScreen.unregisterNativeHook();
			} catch (NativeHookException e1) {
				//TODO Auto-generated catch block
				e1.printStackTrace();
			}
        } else if (e.getKeyCode() == Constants.active_key) {
        	ActiveHolder.setActive(true);
        }
    }
    
    public void nativeKeyReleased(NativeKeyEvent e) {
    	
    	if (e.getKeyCode() == Constants.active_key)
			ActiveHolder.setActive(false);;
        //System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    
    public void nativeKeyTyped(NativeKeyEvent e) {/*
    	if (e.getKeyCode() == Constants.exit_key) {
            try {
				GlobalScreen.unregisterNativeHook();
			} catch (NativeHookException e1) {
				//TODO Auto-generated catch block
				e1.printStackTrace();
			}
        } else if (e.getRawCode() == 32) {
        	ActiveHolder.setActive(true);
        }
        System.out.println("Key Typed: " + e.getRawCode());
        */
    }
    
    

	@Override
	public void run() {
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new GlobalKeyListener());
    }
}