import java.util.Scanner;
import java.io.PrintStream;

import Library.*;
import matriks.Matriks;
import util.FileOut;
import util.Menu;

public class Main {
    
    public static Scanner input = new Scanner(System.in);
    public static PrintStream terminal = System.out;
    public static byte inputType = 2;
    public static byte outputType = 2;

    public static void main(String[] args) {
        byte op;
        do {
            Menu.MainMenu();
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

    public static void getSolution() {
        Menu.SPLMenu();
        byte opsi = input.nextByte();
        Menu.InputMenuType();
        inputType = input.nextByte();

        Matriks m;
        if (inputType == 2) {
            System.out.println("\nInput matriks: ");
            m = Matriks.keyboardInput();
        } else {
            m = new Matriks(0, 0);
            System.out.print("\nMasukkan nama file: ");
            String file = input.next();
            m.fileInput(file);
        }

        switch (opsi) {
            case 1:
                GaussElimination.gaussElimination(m);
                Menu.OutputMenu();
                outputType = input.nextByte();
                if (outputType == 1) FileOut.FileOutput();
                GaussSolution.gaussSolution(m);
                break;
            case 2:
                GaussJordanElimination.gaussJordanElimination(m);
                Menu.OutputMenu();
                outputType = input.nextByte();
                if (outputType == 1) FileOut.FileOutput();
                GaussSolution.gaussSolution(m);
                break;
            case 3:
                Matriks mInverse = AdjointInverse.getResult(Matriks.copyMatriks(m, m.baris, m.kolom - 1));
                Menu.OutputMenu();
                outputType = input.nextByte();
                if (outputType == 1) FileOut.FileOutput();
                if (mInverse.baris == 0) {
                    System.out.println("Matriks tidak memiliki inverse. Silahkan gunakan metode Gauss/Gauss-Jordan");
                } else {
                    Matriks mB = Matriks.getMSolution(m);
                    InverseSolution.getISolution(mInverse, mB);
                }
                break;
            case 4:
                Menu.OutputMenu();
                outputType = input.nextByte();
                if (outputType == 1) FileOut.FileOutput();
                Crammer.getSolution(m);
                break;
            default:
                System.out.println("\nMetode " + opsi + " tidak ditemukan\n");
                break;
       }
       System.setOut(terminal);
    }

    public static void getDeterminant() {
        Menu.DeterminantMenu();
        byte opsi = input.nextByte();  
        Menu.InputMenuType();
        inputType = input.nextByte();      

        Matriks m;
        if (inputType == 2) {
            System.out.println("\nInput matriks: ");
            m = Matriks.keyboardInputAug();
        } else {
            m = new Matriks(0, 0);
            System.out.print("\nMasukkan nama file: ");
            String file = input.next();
            m.fileInput(file);
        }
        double det;

        switch (opsi){
            case 1:
                det = GaussDeterminant.gaussDeterminant(m);
                Menu.OutputMenu();
                outputType = input.nextByte();
                if (outputType == 1) FileOut.FileOutput();
                Matriks.displayDeterminant(det);
                break;
            case 2:
                det = CofactorDeterminant.getDeterminant(m);
                Menu.OutputMenu();
                outputType = input.nextByte();
                if (outputType == 1) FileOut.FileOutput();
                Matriks.displayDeterminant(det);
                break;
            default:
                System.out.println("\nMetode " + opsi + " tidak ditemukan\n");
                break;
        }
        System.setOut(terminal);
    }

    public static void getTransposeCofactorAdjoint() {
    //     Menu.TransposeMenu();
    //     byte opsi = input.nextByte();
    //     Menu.InputMenuType();
    //     inputType = input.nextByte();

    //     Matriks m;
    //     if (inputType == 2) {
    //         System.out.println("\nInput matriks: ");
    //         m = Matriks.keyboardInputAug();
    //     } else {
    //         m = new Matriks(0, 0);
    //         System.out.print("\nMasukkan nama file: ");
    //         String file = input.next();
    //         m.fileInput(file);
    //     }

    //     switch (opsi){
    //         case 1:
    //             m = Matriks.keyboardInput();
    //             m = TransposeCofactorAdjoint.getTranspose(m);
    //             Menu.OutputMenu();
    //             outputType = input.nextByte();
    //             if (outputType == 1) FileOut.FileOutput();
    //             m.displayMatriks();
    //             break;
    //         case 2:
    //             m = Matriks.readSquareMatriks();
    //             m = TransposeCofactorAdjoint.getCofactor(m);
    //             Menu.OutputMenu();
    //             outputType = input.nextByte();
    //             if (outputType == 1) FileOut.FileOutput();
    //             m.displayMatriks();
    //             break;
    //         case 3:
    //             m = Matriks.readSquareMatriks();
    //             m = TransposeCofactorAdjoint.getAdjoint(m);
    //             Menu.OutputMenu();
    //             outputType = input.nextByte();
    //             if (outputType == 1) FileOut.FileOutput();
    //             m.displayMatriks();
    //             break;
            
    //         default:
    //             System.out.println("\nOperasi " + opsi + " tidak ditemukan\n");
    //             break;
    //     }
    //     System.setOut(terminal);
        System.out.println("Test12345");
    }

    public static void getMatrixInverse() {
        Menu.InverseMenu();
        byte opsi = input.nextByte();
        Menu.InputMenuType();
        inputType = input.nextByte();

        Matriks m;
        if (inputType == 2) {
            System.out.println("\nInput matriks: ");
            m = Matriks.readSquareMatriks();
        } else {
            m = new Matriks(0, 0);
            System.out.print("\nMasukkan nama file: ");
            String file = input.next();
            m.fileInput(file);
        }

        switch (opsi){
            case 1:
                Menu.OutputMenu();
                outputType = input.nextByte();
                if (outputType == 1) FileOut.FileOutput();
                GaussJordanInverseSolution.jordanInverseSolution(m);
                break;
            case 2:
                Menu.OutputMenu();
                outputType = input.nextByte();
                if (outputType == 1) FileOut.FileOutput();
                AdjointInverse.getInverse(m);
                break;
            default:
                System.out.println("\nMetode " + opsi + " tidak ditemukan\n");
                break;
        }
        System.setOut(terminal);
    }

    public static void getInterpolation() {
        Menu.InputMenuType();
        inputType = input.nextByte();

        Matriks m;
        double x;
        if (inputType == 2) {
            System.out.println("\nInput matriks: ");
            m = InterpolasiPolinom.readPolinom();
            m = InterpolasiPolinom.makePolinom(m);
        } else {
            m = new Matriks(0, 0);
            System.out.print("\n> Masukkan nama file: ");
            String file = input.next();
            m.fileInput(file);
        }
        x = InterpolasiPolinom.readX();

        Menu.OutputMenu();
        outputType = input.nextByte();
        if (outputType == 1) FileOut.FileOutput();
        InterpolasiPolinom.polinomSolution(m, x);
        System.setOut(terminal);
    }

    public static void getRegression() {
        Menu.InputMenuType();
        inputType = input.nextByte();

        Matriks m;
        if (inputType == 2) {
            System.out.println("\nInput matriks: ");
            m = Matriks.mRegresi();
        } else {
            m = new Matriks(0, 0);
            System.out.print("\nMasukkan nama file: ");
            String file = input.next();
            m.fileInput(file);
        }

        double[] taksiran = Reg.getTaksiran(m);
        Menu.OutputMenu();
        outputType = input.nextByte();
        if (outputType == 1) FileOut.FileOutput();
        Reg.getSolution(m, taksiran);
        System.setOut(terminal);
    }
}