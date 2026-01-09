package h2;

public class Spielstein {

    private int currentRow;
    private int currentCol;
    private Spielbrett brett;

    public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
        this.brett = brett;
        this.currentRow = indexRow;
        this.currentCol = indexCol;
    }

    private boolean movesOut() {
  
        Feld currentField = brett.getBrett()[currentRow][currentCol];
        char dir = currentField.getDirection();
        int maxIndex = brett.getDim() - 1;

        if (dir == 'U' && currentRow == 0) {
            return true;
        } else if (dir == 'D' && currentRow == maxIndex) {
            return true;
        } else if (dir == 'L' && currentCol == 0) {
            return true;
        } else if (dir == 'R' && currentCol == maxIndex) {
            return true;
        }

        return false;
    }

    public void go(int n) {
      
        for (int i = 0; i < n; i++) {
            Feld currentField = brett.getBrett()[currentRow][currentCol];

            if (currentField.isBoese() || movesOut()) {
                continue; 
            }

            char dir = currentField.getDirection();
            switch (dir) {
                case 'U':
                    currentRow--;
                    break;
                case 'D':
                    currentRow++;
                    break;
                case 'L':
                    currentCol--;
                    break;
                case 'R':
                    currentCol++;
                    break;
            }
        }
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }

    public Spielbrett getBrett() {
        return brett;
    }

    public void setBrett(Spielbrett brett) {
        this.brett = brett;
    }
}
