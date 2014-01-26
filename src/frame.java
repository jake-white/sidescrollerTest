import java.awt.Container;

import javax.swing.JFrame;


public class frame {
	private static panel JP = new panel();
	private static inputManager iM = new inputManager();

	public static void main(String[] args)
	{
		JFrame gui = new JFrame();
		gui.setSize(1000, 400);
		gui.setTitle("Sidescroller");
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = gui.getContentPane();
		gui.addKeyListener(iM);
		pane.add(JP);
		gui.setVisible(true);
		panel.refresh = gui;
		initialization.init();
	}
	
}
