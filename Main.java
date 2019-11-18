public class Main {

    public static void main(String[] args) {
        UsualMatrix firstSmallMatrix = new UsualMatrix(3,3);
        firstSmallMatrix.rand();
        UsualMatrix secondSmallMatrix = new UsualMatrix(3, 3);
        secondSmallMatrix.rand();

        System.out.println(firstSmallMatrix);
        System.out.println(secondSmallMatrix);

        UsualMatrix result1 = firstSmallMatrix.product(secondSmallMatrix);
        System.out.println(result1);

        ParallelMatrixProduct pmp1 = new ParallelMatrixProduct(firstSmallMatrix, secondSmallMatrix, 100);
        UsualMatrix result2 = pmp1.multiply();
        System.out.println(result2);

        UsualMatrix firstMatrix = new UsualMatrix(2000,2000);
        firstMatrix.rand();
        UsualMatrix secondMatrix = new UsualMatrix(2000, 2000);
        secondMatrix.rand();
        ParallelMatrixProduct pmp2 = new ParallelMatrixProduct(firstMatrix, secondMatrix, 2);
        ParallelMatrixProduct pmp3 = new ParallelMatrixProduct(firstMatrix, secondMatrix, 3);
        ParallelMatrixProduct pmp4 = new ParallelMatrixProduct(firstMatrix, secondMatrix, 4);
        ParallelMatrixProduct pmp5 = new ParallelMatrixProduct(firstMatrix, secondMatrix, 5);
        ParallelMatrixProduct pmp6 = new ParallelMatrixProduct(firstMatrix, secondMatrix, 6);
        ParallelMatrixProduct pmp7 = new ParallelMatrixProduct(firstMatrix, secondMatrix, 7);
        ParallelMatrixProduct pmp8 = new ParallelMatrixProduct(firstMatrix, secondMatrix, 8);
        ParallelMatrixProduct pmp9 = new ParallelMatrixProduct(firstMatrix, secondMatrix, 9);
        ParallelMatrixProduct pmp10 = new ParallelMatrixProduct(firstMatrix, secondMatrix, 10);

        //long startTime1 = System.currentTimeMillis();
        //firstMatrix.product(secondMatrix);
        //long timeSpent1 = System.currentTimeMillis() - startTime1;


        //System.out.println("Time spent:" + timeSpent1 + "\n");

        long startTime2 = System.currentTimeMillis();
        pmp2.multiply();
        long timeSpent2 = System.currentTimeMillis() - startTime2;
        System.out.println("Time spent:" + timeSpent2);

        long startTime3 = System.currentTimeMillis();
        pmp3.multiply();
        long timeSpent3 = System.currentTimeMillis() - startTime3;
        System.out.println("Time spent:" + timeSpent3);

        long startTime4 = System.currentTimeMillis();
        pmp4.multiply();
        long timeSpent4 = System.currentTimeMillis() - startTime4;
        System.out.println("Time spent:" + timeSpent4);

        long startTime5 = System.currentTimeMillis();
        pmp5.multiply();
        long timeSpent5 = System.currentTimeMillis() - startTime5;
        System.out.println("Time spent:" + timeSpent5);

        long startTime6 = System.currentTimeMillis();
        pmp6.multiply();
        long timeSpent6 = System.currentTimeMillis() - startTime6;
        System.out.println("Time spent:" + timeSpent6);

        long startTime7 = System.currentTimeMillis();
        pmp7.multiply();
        long timeSpent7 = System.currentTimeMillis() - startTime7;
        System.out.println("Time spent:" + timeSpent7);

        long startTime8 = System.currentTimeMillis();
        pmp8.multiply();
        long timeSpent8 = System.currentTimeMillis() - startTime8;
        System.out.println("Time spent:" + timeSpent8);

        long startTime9 = System.currentTimeMillis();
        pmp9.multiply();
        long timeSpent9 = System.currentTimeMillis() - startTime9;
        System.out.println("Time spent:" + timeSpent9);

        long startTime10 = System.currentTimeMillis();
        pmp10.multiply();
        long timeSpent10 = System.currentTimeMillis() - startTime10;
        System.out.println("Time spent:" + timeSpent10);

    }
}
