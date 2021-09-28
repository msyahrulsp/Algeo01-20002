package matriks;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Matriks {
    public int baris = 0, kolom = 0;
    public double[][] ELMT;

    // Konstruktor
    // public Matriks() {
    //     this.baris = 1;
    //     this.kolom = 1;

    //     this.ELMT = new double[1][1];
    //     this.ELMT[0][0] = 1;
    // }

    public Matriks(int baris, int kolom) {
        this.ELMT = new double[baris][kolom];
        this.baris = baris;
        this.kolom = kolom;
    }

    public void displayMatriks() {
        for (int i = 0; i < this.baris; i++) {
            for (int j = 0; j < this.kolom; j++) {
                System.out.print(this.ELMT[i][j]);
                if (j < this.kolom) System.out.print(" ");
            }
            if (i < this.baris) System.out.print("\n");
        }
    }

    public static Matriks readSquareMatriks() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan ukuran matriks: ");
        int N = input.nextInt();

        Matriks m = new Matriks(N, N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                m.ELMT[i][j] = input.nextDouble();
            }
        }
        // input.close();
        return m;
    }

    public static Matriks keyboardInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan jumlah baris: ");
        int baris = input.nextInt();
        System.out.print("Masukkan jumlah kolom: ");
        int kolom = input.nextInt();
        
        Matriks m = new Matriks(baris, kolom);
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                m.ELMT[i][j] = input.nextDouble();
            }
        }
        // input.close();
        return m;
    }

    public Matriks fileInput(String fileName) {
        try {
            String path = System.getProperty("user.dir"); // HARUSNYA sampai parent folder doang
            path = path.replace("\\src", ""); // Safecase user.dir sampe src hasilnya
            File inputFile = new File(new File(path + "/test/" + fileName).getCanonicalPath());
            Scanner scanner = new Scanner(inputFile);

            this.baris = 0;
            this.kolom = 0;
            while (scanner.hasNextLine()) {
                if (this.baris == 0) {
                    this.kolom = (scanner.nextLine().trim().split(" ")).length;
                } else {
                    scanner.nextLine();
                }
                this.baris++;
            }
            scanner.close();

            Scanner scanner2 = new Scanner(inputFile);
            this.ELMT = new double[this.baris][this.kolom];
            for (int i = 0; i < this.baris; i++) {
                for (int j = 0; j < this.kolom; j++) {
                    this.ELMT[i][j] = scanner2.nextDouble();
                }
            }
            scanner2.close();

        } catch (FileNotFoundException e) {
            System.out.print("File tidak ditemukan.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this;
    }
    
    public static void displaySPLSolution(double[] result) {
        for (int i=0; i<result.length; i++) {
            System.out.printf("x%d = %.3f\n",i+1, result[i]);
        }
    }

    public static void displaySPLSolution(String[] result) {
        for (int i=0; i<result.length; i++) {
            System.out.printf("x%d = %s\n", i+1, result[i]);
        }
    }

    public static void displayDeterminant(double det) {
        System.out.printf("Determinan = %.3f\n", det);
    }
}
