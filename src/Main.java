import java.util.Scanner;

import Library.*;
import matriks.Matriks;

public class Main {
    
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        byte op;
        do {
            System.out.println("\n-------------KALKULATOR MATRIKS-------------");
            System.out.println("""
                    1. Menentukan Solusi Persamaan Linier
                    2. Determinan
                    3. Transpose, Kofaktor, Adjoin 
                    4. Matriks Balikan
                    5. Interpolasi Polinom
                    6. Regresi Linier Berganda
                    7. Keluar
                    """);
            System.out.print("Pilih operasi: ");
            op = input.nextByte();

            if (op == 1) {getSolution();}
            else if (op == 2) {getDeterminant();}
            else if (op == 3) {getTransposeCofactorAdjoint();}
            else if (op == 4) {getMatrixInverse();}
            else if (op == 5) {getInterpolation();}
            else if (op == 6) {getRegression();}
            else if (op == 7) {
                System.out.println("\n----------------------------------------");
            }
            else {System.out.println("\nOperasi " + op + " tidak ditemukan\n");}
        } while (op != 7);

    }

    public static void getSolution(){
        System.out.println("""
                1. Metode eliminasi Gauss
                2. Metode eliminasi Gauss-Jordan
                3. Metode matriks balikan
                4. Kaidah Crammer
                """);
        
        System.out.print("Pilih metode: ");
        byte opsi = input.nextByte();
        System.out.println("Input matriks: ");
        Matriks m = Matriks.keyboardInput();

        switch (opsi){
            case 1:
                GaussElimination.gaussElimination(m);
                GaussSolution.gaussSolution(m);
                break;
            case 2:
                GaussJordanElimination.gaussJordanElimination(m);
                GaussJordanSolution.gaussSolution(m);
                break;
            case 3:
                Matriks mInverse = AdjointInverse.getResult(Matriks.copyMatriks(m, m.baris, m.kolom - 1));
                if (mInverse.baris == 0) {
                    System.out.println("Matriks tidak memiliki inverse");
                } else {
                    Matriks mB = Matriks.getMSolution(m);
                    InverseSolution.getISolution(mInverse, mB);
                }
                break;
            case 4:
                Crammer.getSolution(m);
                break;
            default:
                System.out.println("\nMetode " + opsi + " tidak ditemukan\n");
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

        
        System.out.print("Pilih metode: ");
        byte opsi = input.nextByte();        

        System.out.println("Input matriks: ");
        Matriks m = Matriks.readSquareMatriks();
        double det;

        switch (opsi){
            case 1:
                det = GaussDeterminant.gaussDeterminant(m);
                Matriks.displayDeterminant(det);
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
                det = CofactorDeterminant.getDeterminant(m);
                Matriks.displayDeterminant(det);
                break;
            default:
                System.out.println("\nMetode " + opsi + " tidak ditemukan\n");
                break;
        }

    }

    public static void getTransposeCofactorAdjoint() {
        System.out.println("""

                1. Transpose Matriks
                2. Matriks Kofaktor
                3. Adjoint Matriks
                """);

        System.out.print("Pilih metode: ");
        byte opsi = input.nextByte();
        System.out.println("Input matriks: ");
        Matriks m;

        switch (opsi){
            case 1:
                m = Matriks.keyboardInput();
                m = TransposeCofactorAdjoint.getTranspose(m);
                m.displayMatriks();
                break;
            case 2:
                m = Matriks.readSquareMatriks();
                m = TransposeCofactorAdjoint.getCofactor(m);
                m.displayMatriks();
                break;
            case 3:
                m = Matriks.readSquareMatriks();
                m = TransposeCofactorAdjoint.getAdjoint(m);
                m.displayMatriks();
                break;
            
            default:
                System.out.println("\nOperasi " + opsi + " tidak ditemukan\n");
                break;
        }
    }

    public static void getMatrixInverse(){
        System.out.println("""
        
                1. Metode Gauss-Jordan
                2. Metode Adjoin
                """);

        System.out.print("Pilih metode: ");
        byte opsi = input.nextByte();
        System.out.println("Input matriks: ");
        Matriks m = Matriks.readSquareMatriks();

        switch (opsi){
            case 1:
                GaussJordanInverseSolution.jordanInverseSolution(m);
                break;
            case 2:
                AdjointInverse.getInverse(m);
                break;
            default:
                System.out.println("\nMetode " + opsi + " tidak ditemukan\n");
                break;
        }

    }

    public static void getInterpolation() {
        InterpolasiPolinom.polinomSolution();
    }

    public static void getRegression() {
        // langsung manggil fungsi ??
    }
}