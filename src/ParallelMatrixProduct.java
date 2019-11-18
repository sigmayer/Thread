import Exceptions.*;

public class ParallelMatrixProduct {

    private UsualMatrix matrix1;
    private UsualMatrix matrix2;
    private int threads;

    public ParallelMatrixProduct(UsualMatrix m1, UsualMatrix m2, int t) {
        matrix1 = m1;
        matrix2 = m2;
        if (t > m1.getRows()) {
            threads = m1.getRows();
        }
        else {
            threads = t;
        }
    }


    public UsualMatrix multiply() {

        if (matrix1.getColumns() != matrix2.getRows()) {
            throw new MatrixesException("Error: incompatible sizes of matrices.");
        }

        Thread[] threadsArray = new Thread[threads];
        int tmp = matrix1.getRows() / threads;
        int add = matrix1.getRows() % threads;
        int start = 0;

        UsualMatrix result = new UsualMatrix(matrix1.getRows(), matrix2.getColumns());

        for (int i = 0; i < threads; i++) {
            int cnt = 0;
            if (i == 0) {
                cnt = tmp + add;
            } else {
                cnt = tmp;
            }
            threadsArray[i] = new Thread(new MultiThread(matrix1, matrix2, result, start, start + cnt));
            start += cnt;
            threadsArray[i].start();
        }
        try {
            for (Thread thread : threadsArray) {
                thread.join();
            }
        }
        catch (InterruptedException e) {

        }
        return result;
    }

}
