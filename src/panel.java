import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;

import java.util.*;

public class panel extends JPanel {
	static JFrame refresh;
	Random generator = new Random();
	private static int pixel_amount = 10;
	public static int camerapos;
	public static int original_y;
	public static boolean jumping = false, fall = false, sidecollide_left,
			sidecollide_right;
	public Timer atimer = new Timer(300, new amountTimer());
	public Timer itimer = new Timer(30, new inputTimer());
	public static int blockamount = 6;
	public static boolean sidecollide_r[] = new boolean[blockamount];
	public static boolean sidecollide_l[] = new boolean[blockamount];
	public static blockLister[] block = new blockLister[blockamount];
	public static BufferedImage toaster;

	public void paintComponent(Graphics g) {
		g.drawImage(toaster, 480, characterActions.character_y(), null);
		g.drawLine(0, 300, 1000, 300);
		g.drawString("camerapos = " + camerapos, 800, 200);
		g.drawString("ascending = " + characterActions.ascending, 800, 100);
		g.drawString("sidecollide = " + sidecollide_left + " "
				+ sidecollide_right, 800, 50);
		g.drawString("velocity = " + characterActions.velocity, 800, 300);
		g.drawString("speed = " + characterActions.speed, 300, 100);
		g.drawString("collision detected = " + characterActions.collision, 100,
				300);
		g.drawString("contact detected = " + characterActions.contact[0], 100,
				200);
		g.setColor(Color.BLUE);
		for (int count = 0; count <= blockamount; ++count) {
			g.fillRect(camerapos + blockLister.x(count), blockLister.y(count),
					blockLister.length(count), blockLister.height(count));
		}
		characterActions.collision = false;
		sidecollide_left = false;
		sidecollide_right = false;
		characterActions.botcollide = false;
		for (int i = 0; i <= blockamount - 1; ++i) {
			sidecollide_r[i] = false;
			sidecollide_l[i] = false;
			characterActions.bottom_collide[i] = false;
		}
		for (int i = 0; i <= blockamount; ++i) {
			characterActions.collisionChecker(block, i);
		}
	}

	private class amountTimer implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			if (pixel_amount <= 199)
				++pixel_amount;
		}
	}

	private class inputTimer implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (inputManager.input('a')) {
				try {
					toaster = ImageIO.read(new File("resources/toaster.png"));
				} catch (IOException e) {
				}
				if (!sidecollide_left)
				{

					if (inputManager.spaceHandler(16))
						camerapos += 10;
					else
						camerapos += 5;
				}
			} else if (inputManager.input('d')) {
				try {
					toaster = ImageIO.read(new File(
							"resources/toaster_right.png"));
				} catch (IOException e) {
				}
				if (!sidecollide_right) {
					if (inputManager.spaceHandler(16))
						camerapos -= 10;
					else
						camerapos -= 5;
				}
			}
			if (inputManager.input('q')) {

			}

			if (inputManager.spaceHandler(32) && !jumping && !fall) {
				System.out.println("You pressed space!");
				jumping = true;
				if (!characterActions.collision)
					original_y = characterActions.y;
				else
					original_y = 260;
				characterActions.ascending = true;
			}

			refresh.repaint();
		}
	}
}
