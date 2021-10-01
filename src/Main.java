import java.util.Scanner;
import java.io.PrintStream;

import Library.*;
import matriks.Matriks;
import util.FileOut;
import util.Menu;

public class Main {
    
    public static Scanner input = new Scanner(System.in);
    public static PrintStream terminal = System.out;
    public static int opsi;
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
                System.out.println("----------------------------------------");
            }
            else {System.out.println("Operasi " + op + " tidak ditemukan");}
        } while (op != 7);

    }

    public static void getSolution() {
        Menu.SPLMenu();
        select(1, 4);
        Menu.InputMenuType();
        choose("in");

        Matriks m;
        if (inputType == 2) {
            System.out.println("\nInput matriks: ");
            m = Matriks.keyboardInput();
        } else {
            m = new Matriks(0, 0);
            System.out.print("\n> Masukkan nama file: ");
            String file = input.next();
            m.fileInput(file);
        }

        switch (opsi) {
            case 1:
                GaussElimination.gaussElimination(m);
                Menu.OutputMenu();
                choose("out");
                if (outputType == 1) FileOut.FileOutput();
                GaussSolution.gaussSolution(m);
                break;
            case 2:
                GaussJordanElimination.gaussJordanElimination(m);
                Menu.OutputMenu();
                choose("out");
                if (outputType == 1) FileOut.FileOutput();
                GaussSolution.gaussSolution(m);
                break;
            case 3:
                Matriks mInverse = AdjointInverse.getResult(Matriks.copyMatriks(m, m.baris, m.kolom - 1));
                Menu.OutputMenu();
                choose("out");
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
                choose("out");
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
        select(1, 2);  
        Menu.InputMenuType();
        choose("in");      

        Matriks m;
        if (inputType == 2) {
            System.out.println("\nInput matriks: ");
            m = Matriks.keyboardInputAug();
        } else {
            m = new Matriks(0, 0);
            System.out.print("\n> Masukkan nama file: ");
            String file = input.next();
            m.fileInput(file);
        }
        double det;

        switch (opsi){
            case 1:
                det = GaussDeterminant.gaussDeterminant(m);
                Menu.OutputMenu();
                choose("out");
                if (outputType == 1) FileOut.FileOutput();
                Matriks.displayDeterminant(det);
                break;
            case 2:
                det = CofactorDeterminant.getDeterminant(m);
                Menu.OutputMenu();
                choose("out");
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
        Menu.TransposeMenu();
        select(1, 3);
        Menu.InputMenuType();
        choose("in");

        Matriks m;
        if (inputType == 2) {
            System.out.println("\nInput matriks: ");
            m = Matriks.keyboardInputAug();
        } else {
            m = new Matriks(0, 0);
            System.out.print("\n> Masukkan nama file: ");
            String file = input.next();
            m.fileInput(file);
        }

        switch (opsi){
            case 1:
                m = Matriks.keyboardInput();
                m = TransposeCofactorAdjoint.getTranspose(m);
                Menu.OutputMenu();
                choose("out");
                if (outputType == 1) FileOut.FileOutput();
                m.displayMatriks();
                break;
            case 2:
                m = Matriks.keyboardInputSquare();
                m = TransposeCofactorAdjoint.getCofactor(m);
                Menu.OutputMenu();
                choose("out");
                if (outputType == 1) FileOut.FileOutput();
                m.displayMatriks();
                break;
            case 3:
                m = Matriks.keyboardInputSquare();
                m = TransposeCofactorAdjoint.getAdjoint(m);
                Menu.OutputMenu();
                choose("out");
                if (outputType == 1) FileOut.FileOutput();
                m.displayMatriks();
                break;
            
            default:
                System.out.println("\nOperasi " + opsi + " tidak ditemukan\n");
                break;
        }
        System.setOut(terminal);
    }

    public static void getMatrixInverse() {
        Menu.InverseMenu();
        select(1, 2);
        Menu.InputMenuType();
        choose("in");

        Matriks m;
        if (inputType == 2) {
            System.out.println("\nInput matriks: ");
            m = Matriks.keyboardInputSquare();
        } else {
            m = new Matriks(0, 0);
            System.out.print("\n> Masukkan nama file: ");
            String file = input.next();
            m.fileInput(file);
        }

        switch (opsi){
            case 1:
                Menu.OutputMenu();
                choose("out");
                if (outputType == 1) FileOut.FileOutput();
                GaussJordanInverseSolution.jordanInverseSolution(m);
                break;
            case 2:
                Menu.OutputMenu();
                choose("out");
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
        choose("in");

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
        choose("out");
        if (outputType == 1) FileOut.FileOutput();
        InterpolasiPolinom.polinomSolution(m, x);
        System.setOut(terminal);
    }

    public static void getRegression() {
        Menu.InputMenuType();
        choose("in");

        Matriks m;
        if (inputType == 2) {
            System.out.println("\nInput matriks: ");
            m = Matriks.mRegresi();
        } else {
            m = new Matriks(0, 0);
            System.out.print("\n> Masukkan nama file: ");
            String file = input.next();
            m.fileInput(file);
        }

        double[] taksiran = Reg.getTaksiran(m);
        Menu.OutputMenu();
        choose("out");
        if (outputType == 1) FileOut.FileOutput();
        Reg.getSolution(m, taksiran);
        System.setOut(terminal);
    }

    public static void choose(String type) {
        if (type == "out") {
            outputType = input.nextByte();
            while ((outputType < 1) || (outputType > 2)) {
                System.out.println("Opsi hanya 1 dan 2");
                System.out.print("Pilih: ");
                outputType = input.nextByte();
            }
        } else {
            inputType = input.nextByte();
            while ((inputType < 1) || (inputType > 2)) {
                System.out.println("Opsi hanya 1 dan 2");
                System.out.print("Pilih: ");
                inputType = input.nextByte();
            }   
        }
    }

    public static void select(int min, int max) {
        opsi = input.nextInt();
        while ((opsi < min) || (opsi > max)) {
            System.out.println("Opsi hanya " + min + " sampai " + max);
            System.out.print("Pilih metode: ");
            opsi = input.nextInt();
        }
    }
}