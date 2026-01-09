package h1;

public class Grid {
	private Cell[][] gridArray;

	public Cell[][] getGridArray() {
		return gridArray;
	}

	public void setGridArray(Cell[][] gridArray) {
		this.gridArray = gridArray;
	}

	public Grid(Cell[] cells, int gridRows, int gridCols) {
		gridArray = new Cell[gridRows][gridCols];

		for (int i = 0; i < gridRows; i++) {
			for (int j = 0; j < gridCols; j++) {
				gridArray[i][j] = new Cell(i, j);
			}
		}

		for (Cell c : cells) {
			if (c.getIndexRow() < gridRows && c.getIndexCol() < gridCols) {
				gridArray[c.getIndexRow()][c.getIndexCol()].setAlive(true);
			}
		}

		for (int i = 0; i < gridRows; i++) {
			for (int j = 0; j < gridCols; j++) {
				gridArray[i][j].countLivingNeighbors(gridArray);
			}
		}
	}

	public void computeNextGen() {
		int rows = gridArray.length;
		int cols = gridArray[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				gridArray[i][j].setAlive(gridArray[i][j].isAliveNextGen());
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				gridArray[i][j].countLivingNeighbors(gridArray);
			}
		}
	}

	public void computeGeneration(int n) {
		for (int i = 0; i < n; i++) {
			computeNextGen();
		}
	}
}
