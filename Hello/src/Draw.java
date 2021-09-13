import java.util.ArrayList;

public class Draw {
	public static void draw(String[][] grid) {

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				System.out.print(grid[i][j] + "\t");
			}
			System.out.println("|\n");
		}

	}

	public static void setPos(String[][] grid, ArrayList<Car> arr) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {

				grid[arr.get(i).getX() - 1][arr.get(i).getY() - 1] = arr.get(i).getCarName();
				System.out.print(grid[i][j] + "\t");
			}
			System.out.println("|\n");
		}
	}

}
