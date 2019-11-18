public class MultiThread implements Runnable {

    private UsualMatrix matrix1;
    private UsualMatrix matrix2;
    private UsualMatrix result;
    private int startRow;
    private int finishRow;

    public MultiThread(UsualMatrix m1, UsualMatrix m2, UsualMatrix r, int start, int finish) {
        matrix1 = m1;
        matrix2 = m2;
        result = r;
        startRow = start;
        finishRow = finish;
    }

    @Override
    public void run() {
        for (int i = startRow; i < finishRow; i++) {
            for (int j = 0; j < result.getColumns(); j++) {
                int tmp = 0;
                for (int l = 0; l < matrix2.getRows(); l++) {
                    tmp += matrix1.getElement(i, l) * matrix2.getElement(l, j);
                }
                result.setElement(i, j, tmp);
            }
        }
    }
}
