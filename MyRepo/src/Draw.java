import java.util.ArrayList;

public class Draw {
	public static void draw(String[][] grid) {

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				System.out.print(grid[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void setPos(String[][] grid, ArrayList<Car> arr) {
		clearGrid(grid);
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				grid[arr.get(i).getX()][arr.get(i).getY()] = arr.get(i).getCarName();
				// System.out.print(grid[i][j] + "\t");
			}
			// System.out.println();
		}

	}

	public static void clearGrid(String[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				grid[i][j] = "-----";
				// System.out.print(grid[i][j] + "\t");
			}
			// System.out.println();
		}
	}

	public static void checkWin(String[][] grid, ArrayList<Car> arr) {
		for (int i = 0; i < grid.length - 1; i++) {
			for (int j = grid[i].length - 1; j <= grid[i].length - 1; j++) {
				if (grid[i][j] != "-----") {
					System.out.println("The Winner is: " + grid[i][j] + " ! at Pos x: " + i + "& y: " + j);
					continue;
				}
			}
		}
	}

}
