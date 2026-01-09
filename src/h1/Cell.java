package h1;

public class Cell {

    private int indexRow;
    private int indexCol;
    private boolean alive;
    private int numLivingNeighbors;
    private boolean isAliveNextGen;

    public Cell(int indexRow, int indexCol, boolean alive) {
        this.indexRow = indexRow;
        this.indexCol = indexCol;
        this.alive = alive;
    }

    public Cell(int indexRow, int indexCol) {
        this.indexRow = indexRow;
        this.indexCol = indexCol;
        this.alive = false;
    }

    public int getIndexRow() {
        return indexRow;
    }

    public void setIndexRow(int indexRow) {
        this.indexRow = indexRow;
    }

    public int getIndexCol() {
        return indexCol;
    }

    public void setIndexCol(int indexCol) {
        this.indexCol = indexCol;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getNumLivingNeighbors() {
        return numLivingNeighbors;
    }

    public void setNumLivingNeighbors(int numLivingNeighbors) {
        this.numLivingNeighbors = numLivingNeighbors;
    }

    public boolean isAliveNextGen() {
        return isAliveNextGen;
    }

    public void setAliveNextGen(boolean aliveNextGen) {
        isAliveNextGen = aliveNextGen;
    }

    public void countLivingNeighbors(Cell[][] gridArray) {
        int count = 0;

        for (int i = indexRow - 1; i <= indexRow + 1; i++) {
            for (int j = indexCol - 1; j <= indexCol + 1; j++) {
                if (i == indexRow && j == indexCol) {
                    continue;
                }
                if (i >= 0 && i < gridArray.length &&
                    j >= 0 && j < gridArray[0].length &&
                    gridArray[i][j].isAlive()) {
                    count++;
                }
            }
        }

        this.numLivingNeighbors = count;
        
        decideNextStatus();
    }

    private void decideNextStatus() {
        if (this.alive) {
            
            if (this.numLivingNeighbors == 2 || this.numLivingNeighbors == 3) {
                this.isAliveNextGen = true;
            } else {
                this.isAliveNextGen = false; 
            }
        } else {
       
            if (this.numLivingNeighbors == 3) {
                this.isAliveNextGen = true;
            } else {
                this.isAliveNextGen = false;
            }
        }
    }
}
