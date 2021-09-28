package Library;

import java.util.Scanner;

public class InterpolasiPolinom {

//    public static Matriks readPoint()
//    {
//        int nKol = 2;
//        Scanner input = new Scanner(System.in);
//        int nBrs = input.nextInt();
//    }

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

}
