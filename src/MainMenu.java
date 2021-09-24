import Library.*;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        System.out.println("-------------KALKULATOR MATRIKS-------------");
        System.out.println("""
                1. Mencari Solusi Persamaan Linier
                2. Mencari Determinan
                3. Operasi-Operasi Sederhana
                4. Matriks Balikan
                5. Interpolasi Polinom
                6. Regresi Linier Berganda
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
                getDeterminan();
                break;
            case 3:
                getOperation();
                break;
            case 4:
                getMatrixInverse();
                break;
            case 5:
                getInterpolation();
                break;
            case 6:
                getRegex();
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
        
        // input matriks m
        /*
        Scanner input = new Scanner(System.in);
        System.out.print("Pilih metode: ");
        int opsi = input.nextInt();
        switch (opsi){
            case 1:
                GaussSolution();
                break;
            case 2:
                GaussJordanSolution();
                break;
            case 3:
                InverseSolution();
                break;
            case 4:
                CrammerSolution();
                break;
            default:
                System.out.println("\nOperasi " + opsi + " tidak ditemukan\n");
                break;
       }
       */
    }

    public static void getDeterminan() {
        System.out.println("""

                1. Metode eliminasi Gauss
                2. Metode eliminasi Gauss-Jordan
                3. Metode matriks balikan
                4. Kaidah Crammer
                """);

        // input matriks m
        /*
        Scanner input = new Scanner(System.in);
        System.out.print("Pilih metode: ");
        int opsi = input.nextInt();
        switch (opsi){
            case 1:
                GaussDeterminant();
                break;
            case 2:
                GaussJordanDeterminant();
                break;
            case 3:
                InverseDeterminant();
                break;
            case 4:
                CrammerDeterminant());
                break;
            default:
                System.out.println("\nOperasi " + opsi + " tidak ditemukan\n");
                break;
        }
        */
    }

    public static void getOperation() {
        System.out.println("""

                1. Penjumlahan Matriks
                2. Pengurangan Matriks
                3. Perkalian Matriks
                4. Mencari Transpose
                5. Mencari Adjoin
                6. Mencari Kofaktor
                """);

        // input matriks m
        /*
        Scanner input = new Scanner(System.in);
        System.out.print("Pilih metode: ");
        int opsi = input.nextInt();
        switch (opsi){
            case 1:
                PlusMatrix();
                break;
            case 2:
                MinusMatrix();
                break;
            case 3:
                MultiplyMatrix();
                break;
            case 4:
                getTranspose();
                break;
            case 5:
                getAdjoint();
                break;
            case 6:
                getCofactor();
                break;
            default:
                System.out.println("\nOperasi " + opsi + " tidak ditemukan\n");
                break;
        }
        */
    }

    public static void getMatrixInverse(){
        System.out.println("""
        
                1. Metode Gauss-Jordan
                2. Metode Adjoin
                """);

        // input matriks m

        /*
        Scanner input = new Scanner(System.in);
        System.out.print("Pilih metode: ");
        int opsi = input.nextInt();
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
        */
    }

    public static void getInterpolation() {
        //langsung manggil fungsi ??
    }

    public static void getRegex() {
        //langsung manggil fungsi ??
    }


}
