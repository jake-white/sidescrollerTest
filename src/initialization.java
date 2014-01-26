import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class initialization {
	private static panel JP = new panel();
	private static inputManager iM = new inputManager();

	public static void init()
	{
		JP.itimer.start();
		for(int i = 0; i <= panel.blockamount-1; ++i)
		{
			panel.block[i] = new blockLister();
		}
		for(int i = 0; i < panel.blockamount; ++i)
		{
			characterActions.contact[i] = false;
		}
		try {
			panel.toaster = ImageIO.read(new File("resources/toaster.png"));
		} catch (IOException e) {
		}
		musicManager.maintheme();
		panel.camerapos = 500;
		panel.block[0].objectCreation(300,200, 100, 50, 0);
		panel.block[1].objectCreation(200, 250, 100, 50, 1);
		panel.block[2].objectCreation(400, 150, 50, 50, 2);
		panel.block[3].objectCreation(450, 50, 50, 50, 3);
		panel.block[4].objectCreation(500, 200, 100, 50, 4);
		panel.block[5].objectCreation(600, 250, 100, 50, 5);
	}
}
