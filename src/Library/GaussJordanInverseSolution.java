package Library;

public class GaussJordanInverseSolution {
    public static void jordanInverseSolution(Matriks m) {
        GaussJordanInverse.makeInverse(m);
        double det = GaussDeterminant.gaussDeterminant(m);
        if (det == 0) {
            System.out.println("Matriks tidak memiliki inverse. (Determinan = 0)");
        } else {
            System.out.println("Inverse Matriks: ");
            InOut.displayMatrix(m);
        }
    }
    
}
