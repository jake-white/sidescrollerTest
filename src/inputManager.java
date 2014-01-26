import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;

public class inputManager implements KeyListener {
	private final static Set<Character> pressed = new HashSet<Character>();
	private final static Set<Integer> spacebar = new HashSet<Integer>();

	public static boolean input(char key) {
		return pressed.contains(key);
	}
	public static boolean spaceHandler(int key)
	{
		return spacebar.contains(key);
		
	}

	public void keyPressed(KeyEvent arg0) {
		pressed.add(arg0.getKeyChar());
		spacebar.add(arg0.getKeyCode());
	}

	public void keyReleased(KeyEvent arg0) {
		pressed.remove(arg0.getKeyChar());
		spacebar.remove(arg0.getKeyCode());
	}

	public void keyTyped(KeyEvent arg0) {

	}
}
