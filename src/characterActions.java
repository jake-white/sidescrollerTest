public class characterActions {
	public static int y = 260;
	public static boolean ascending;
	static double velocity = 0, speed = 0;
	static boolean collision, botcollide;
	static boolean[] contact = new boolean[panel.blockamount + 1];
	static boolean[] bottom_collide = new boolean[panel.blockamount + 1];

	public static int character_y() {
		if (panel.jumping) {
			if (panel.jumping && velocity > 0 && ascending)
				velocity -= 1;
			else if (panel.jumping && !ascending)
				velocity += 1;
			if (velocity == 0)
				ascending = !ascending;
				if (ascending && !botcollide)
					y -= velocity;
				else if (botcollide)
				{
					panel.jumping = false;
				panel.fall = true;
				}
				else if (!ascending)
					y += velocity;
				if (y >= panel.original_y) {
					panel.jumping = false;
					y = panel.original_y;
					velocity = 15;
				}
		} else
			velocity = 15;
		if (panel.fall) {
			if (panel.fall) {
				speed += 1;
				y += speed;
				if (y >= panel.original_y || collision) {
					panel.fall = false;
					y = panel.original_y;
					speed = 0;
				}

			}
		}
		if (collision)
			speed = 0;
		return y;

	}

	public static void collisionChecker(blockLister[] block, int num) {
		if (panel.camerapos + blockLister.x(num) + blockLister.length(num) > 480
				&& panel.camerapos + blockLister.x(num) < 520
				&& ((y + 40 >= blockLister.y(num) && y + 40 <= (blockLister
						.y(num) + blockLister.height(num))) || y + 41 == blockLister
						.y(num) + 1)) {
			System.out.println(y + 41 + ", " + blockLister.y(num) + 1);
			System.out.println(" y = " + y + "blockLister.y = "
					+ blockLister.y(num));
			contact[num] = true;
			if (contact[num])
				collision = true;
			y = (blockLister.y(num) - 40);
			panel.original_y = blockLister.y(num) - 40;
		} else if (panel.camerapos + blockLister.x(num)
				+ blockLister.length(num) > 480
				&& panel.camerapos + blockLister.x(num) < 510
				&& ((y + 40 >= blockLister.y(num) && y <= (blockLister.y(num) + blockLister
						.height(num))) || y == blockLister.y(num)
						+ blockLister.height(num) + 1)) {
			bottom_collide[num] = true;
			if (bottom_collide[num])
				botcollide = true;
		}
		if ((panel.camerapos + blockLister.x(num) + blockLister.length(num) > 479 && panel.camerapos
				+ blockLister.x(num) < 525)
				&& (y > blockLister.y(num)
						&& (y < blockLister.y(num) + blockLister.height(num)) || (y + 40 > blockLister
						.y(num) && (y + 40 < (blockLister.y(num) + blockLister
						.height(num)))))) {
			System.out.println(blockLister.x(num));

			if (panel.camerapos + blockLister.x(num) + blockLister.length(num) > 380
					&& panel.camerapos + blockLister.x(num)
							+ blockLister.length(num) > 479) {
				panel.sidecollide_l[num] = true;
				panel.sidecollide_r[num] = false;
			}
			if (panel.camerapos + blockLister.x(num) > 479) {
				panel.sidecollide_r[num] = true;
				panel.sidecollide_l[num] = false;
			}
			if (panel.sidecollide_l[num])
				panel.sidecollide_left = true;
			else
				panel.sidecollide_left = false;
			if (panel.sidecollide_r[num])
				panel.sidecollide_right = true;
			else
				panel.sidecollide_right = false;
		}
		if (!collision && !panel.jumping && y < 260) {
			panel.fall = true;
			panel.original_y = 260;
		} else
			panel.fall = false;

	}
}
