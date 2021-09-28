package Library;

import java.util.Scanner;
import static Library.GaussSolution.*;
import static Library.GaussElimination.*;
import matriks.Matriks;

public class InterpolasiPolinom {

    public static Matriks readPolinom ()

    {
        int i, j;
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan jumlah n: ");
        int n = input.nextInt();

        Matriks m = new Matriks (n, 2);
        System.out.println("Masukkan pasangan titik-titik: ");
        for (i=0;i<n;i++)
        {
            for (j=0;j<2;j++)
            {
                m.ELMT[i][j] = input.nextDouble();
            }


        }
        return m;
        // masukkan point ke sistem persamaan lanjar
        // gunakan gauss untuk mendapatkan a0, a1 ... an-1 (dlm bentuk matriks)
        // masukkan a0 .. an-1 ke sistem persamaan lanjar
        // diberikan x untuk didapatkan hasil f(x) = ... ?
    }

    public static double readX() {
        System.out.println("Masukkan nilai x yang akan ditaksir: ");
        Scanner input = new Scanner(System.in);
        double x = input.nextDouble();

        // input.close();
        return x;
    }

    public static Matriks makePolinom()
    {
        Matriks m = readPolinom();
        int i, j;
        int nBrs = m.baris;
        Matriks n = new Matriks(nBrs, nBrs+1);

        for (i=0;i<nBrs;i++)
        {
            for (j=0;j<nBrs;j++)
            {
                // operasi pangkat polinom kuadratik
                n.ELMT[i][j] = Math.pow(m.ELMT[i][0], j); 
            }
            n.ELMT[i][nBrs] = m.ELMT[i][1];
        }
        // done

        // n = 3
        // baris 3 kolom 2
        // baris 3 kolom a0, a1x, a2x^2, y => 4 kolom

        return n;
    }

    public static void polinomSolution() {
        
        double taksirResult = 0;
        Matriks o = makePolinom();
        gaussElimination(o);
        double x = readX();
        double[] result = isOneSolution(o);
        

        displaySPLSolution(result);
        
        // gaussSolution(makePolinom());
        System.out.print("Penyelesaian sistem persamaan dengan metode eliminasi Gauss menghasilkan ");
        for (int i=0;i<result.length-1;i++) {
            System.out.format("a%d = %f, ", i, result[i]);
        }
        System.out.format("a%d = %f, ", result.length-1, result[result.length-1]);
        System.out.println("");
        System.out.format("Polinom interpolasi yang melalui ketiga buah titik tersebut adalah p%d(x) =", result.length-1);
        for (int i=0;i<result.length-1;i++) {
            System.out.format(" %fx^%d +", result[i], i);
        }
        System.out.format(" %f^%d", result[result.length-1], result.length-1);
        System.out.println("");

        // menghitung nilai hasil taksiran dari polinom
        for (int i=0;i<result.length;i++) {
            taksirResult += result[i] * Math.pow(x, i);
        }

        System.out.format("Dengan menggunakan polinom ini, maka nilai fungsi pada x = %f dapat ditaksir menghasilkan p%d(%f) = %f", x, result.length-1, x, taksirResult);
        // displayMatrix(m);
    }

    public static void displaySPLSolution(double[] result) {
        for (int i=0; i<result.length; i++) {
            System.out.printf("x%d = %.4f\n",i+1, result[i]);
        }
    }

}
