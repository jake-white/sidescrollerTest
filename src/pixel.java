
public class pixel {
	public static int[] pointx = new int[200], pointy = new int[200];

	public pixel(int x, int y, int num)
	{
		pointx[num] = x;
		pointy[num] = y;		
	}
	public static int pixelx(int num)
	{
		return pointx[num];
	}

	public static int pixely(int num)
	{
		return pointy[num];
	}
}
