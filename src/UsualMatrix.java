import Exceptions.*;
import java.util.Random;

public class UsualMatrix {

    private int[][] matrica;
    private int rows;
    private int columns;

    public UsualMatrix(int rws, int clmns) {
        if ((rws <= 0) || (clmns <= 0)) {
            throw new MatrixesException("Error: invalid size index.");
        }
        matrica = new int[rws][clmns];
        rows = rws;
        columns = clmns;
    }

    public void rand() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Random random = new Random();
                matrica[i][j] = random.nextInt(10);;
            }
        }
    }

    public UsualMatrix sum(final UsualMatrix mtx) {
        if ((this.rows != mtx.rows) || (this.columns != mtx.columns)) {
            throw new MatrixesException("Error: unequal sizes of matrices.");
        }
        UsualMatrix res = new UsualMatrix( this.rows, this.columns );
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                res.setElement(i, j, this.getElement(i, j) + mtx.getElement(i, j));
            }
        }
        return res;
    }

    public UsualMatrix product(final UsualMatrix mtx) {
        if (this.columns != mtx.rows) {
            throw new MatrixesException("Error: incompatible sizes of matrices.");
        }
        UsualMatrix res = new UsualMatrix(this.rows, mtx.columns);
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < mtx.columns; j++) {
                for(int l = 0; l < this.columns; l++) {
                    res.setElement(i, j, res.getElement(i, j) + this.getElement(i, l) * mtx.getElement(l, j));
                }
            }
        }
        return res;
    }

    public void setElement(int row, int column, int value) {
        if ((row < 0) || (row > this.rows - 1)) {
            throw new MatrixesException("Error: invalid row index.");
        }
        if ((column < 0) || (column > this.columns - 1)) {
            throw new MatrixesException("Error: invalid column index.");
        }
        matrica[row][column] = value;
    }

    public int getElement(int row, int column) {
        if ((row < 0) || (row > this.rows - 1)) {
            throw new MatrixesException("Error: invalid row index.");
        }
        if ((column < 0) || (column > this.columns - 1)) {
            throw new MatrixesException("Error: invalid column index.");
        }
        return matrica[row][column];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                sb.append(this.getElement(i, j) + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof UsualMatrix) {
            UsualMatrix tmp = (UsualMatrix)obj;
            if ((this.rows != tmp.rows) || (this.columns != tmp.columns)) {
                return false;
            }
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    if (this.getElement(i, j) != tmp.getElement(i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
