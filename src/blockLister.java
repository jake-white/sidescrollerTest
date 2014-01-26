public class blockLister {
	public static int[] x = new int[200], y = new int[200];
	public static int[] length = new int[200], height = new int[200];

	public void objectCreation(int x, int y, int length, int height, int num) {
		blockLister.x[num] = x;
		blockLister.y[num] = y;
		blockLister.length[num] = length;
		blockLister.height[num] = height;
	}

	public static int x(int num) {
		return x[num];
	}

	public static int y(int num) {
		return y[num];
	}

	public static int length(int num) {
		return length[num];
	}

	public static int height(int num) {
		return height[num];
	}

}
