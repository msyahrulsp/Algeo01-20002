import Library.*;
import java.util.Scanner;
// import jdk.javadoc.internal.tool.resources.javadoc;

public class MainMenu {
    
    public static void main(String[] args) {
        System.out.println("-------------KALKULATOR MATRIKS-------------");
        System.out.println("""
                1. Menentukan Solusi Persamaan Linier
                2. Determinan
                3. Transpose, Kofaktor, Adjoin 
                4. Matriks Balikan
                5. Interpolasi Polinom
                6. Regresi Linier Berganda
                7. Keluar
                """);

        Scanner input = new Scanner(System.in);    
        System.out.print("Pilih operasi: ");
        byte op = input.nextByte();
        input.close();

        switch (op) {
            case 1:
                getSolution();
                break;
            case 2:
                getDeterminant();
                break;
            case 3:
                getTransposeCofactorAdjoint();
                break;
            case 4:
                getMatrixInverse();
                break;
            case 5:
                getInterpolation();
                break;
            case 6:
                getRegression();
                break;
            default:
                System.out.println("\nOperasi " + op + " tidak ditemukan\n");
                break;

        }

    }

    public static void getSolution(){
        System.out.println("""
                1. Metode eliminasi Gauss
                2. Metode eliminasi Gauss-Jordan
                3. Metode matriks balikan
                4. Kaidah Crammer
                """);
        
        Scanner inputSPL = new Scanner(System.in);
        System.out.print("Pilih metode: ");
        int opsi = inputSPL.nextInt();
        inputSPL.close();
        System.out.println("Input matriks: ");
        Matriks m = InOut.readMatrix();

        switch (opsi){
            case 1:
                GaussSolution.gaussSolution(m);
                break;
            // case 2:
            //     gaussJordanSolution(m);
            //     break;
            // case 3:
            //     inverseSolution(m);
            //     break;
            // case 4:
            //     crammerSolution(m);
            //     break;
            default:
                System.out.println("\nOperasi " + opsi + " tidak ditemukan\n");
                break;
       }
    }

    public static void getDeterminant() {
        System.out.println("""

                1. Metode Eliminasi Gauss
                2. Metode Eliminasi Gauss-Jordan
                3. Metode Matriks balikan
                4. Kaidah Crammer
                5. Metode Kofaktor
                """);

        
        Scanner inputDet = new Scanner(System.in);
        System.out.print("Pilih metode: ");
        int opsi = inputDet.nextInt();
        inputDet.close();
        System.out.println("Input matriks: ");
        Matriks m = InOut.readSquareMatrix();

        switch (opsi){
            case 1:
                GaussDeterminant.gaussDeterminant(m);
                break;
            // case 2:
            //     GaussJordanDeterminant();
            //     break;
            // case 3:
            //     InverseDeterminant();
            //     break;
            // case 4:
            //     CrammerDeterminant());
            //     break;
            case 5:
                CofactorDeterminant.getDeterminant(m);
            default:
                System.out.println("\nOperasi " + opsi + " tidak ditemukan\n");
                break;
        }

    }

    public static void getTransposeCofactorAdjoint() {
        System.out.println("""

                1. Transpose Matriks
                2. Matriks Kofaktor
                3. Adjoint Matriks
                """);

        Scanner inputTCA = new Scanner(System.in);
        System.out.print("Pilih metode: ");
        byte opsi = inputTCA.nextByte();
        inputTCA.close();
        System.out.println("Input matriks: ");
        Matriks m = InOut.readSquareMatrix();

        switch (opsi){
            case 1:
                TransposeCofactorAdjoint.getTranspose(m);
                break;
            case 2:
                TransposeCofactorAdjoint.getCofactor(m);
                break;
            case 3:
                TransposeCofactorAdjoint.getAdjoint(m);
                break;
            
            default:
                System.out.println("\nOperasi " + opsi + " tidak ditemukan\n");
                break;
        }
        InOut.displayMatrix(m);
    }

    public static void getMatrixInverse(){
        System.out.println("""
        
                1. Metode Gauss-Jordan
                2. Metode Adjoin
                """);


        /*
        Scanner input = new Scanner(System.in);
        System.out.print("Pilih metode: ");
        int opsi = input.nextInt();
        System.out.println("Input matriks: ");
        Matriks m = InOut.readSquareMatrix();
        
        input.close();

        switch (opsi){
            case 1:
                GaussJordanInverse(m);
                break;
            case 2:
                AdjoinInverse(m);
                break;
            default:
                System.out.println("\nOperasi " + opsi + " tidak ditemukan\n");
                break;
        }

        InOut.displayMatrix(m);
        */
    }

    public static void getInterpolation() {
        //langsung manggil fungsi ??
    }

    public static void getRegression() {
        //langsung manggil fungsi ??
    }


}
