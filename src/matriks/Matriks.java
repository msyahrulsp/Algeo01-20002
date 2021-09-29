package matriks;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Matriks {
    public int baris, kolom;
    public double[][] ELMT;

    // Konstruktor
    public Matriks(int baris, int kolom) {
        this.ELMT = new double[baris][kolom];
        this.baris = baris;
        this.kolom = kolom;
    }

    public void displayMatriks() {
        for (int i = 0; i < this.baris; i++) {
            for (int j = 0; j < this.kolom; j++) {
                System.out.printf("%.2f", this.ELMT[i][j]);
                if (j < this.kolom) System.out.print(" ");
            }
            if (i < this.baris) System.out.print("\n");
        }
    }

    public static Matriks changeRow(Matriks m1, Matriks m2, int col) {
        //m2.kolomnya selalu 1
        for (int i = 0; i < m1.baris; i++) {
            m1.ELMT[i][col] = m2.ELMT[i][0];
        }
        return m1;
    }

    public static Matriks copyMatriks(Matriks m, int baris, int kolom) {
        Matriks res = new Matriks(baris, kolom);
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                res.ELMT[i][j] = m.ELMT[i][j];
            }
        }
        return res;
    }

    public static Matriks getMSolution(Matriks m) {
        Matriks res = new Matriks(m.baris, 1);
        for (int i = 0; i < m.baris; i++) {
            res.ELMT[i][0] = m.ELMT[i][m.kolom - 1];
        }
        return res;
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
                    String temp = scanner2.next();
                    String[] sNum = temp.split("/");
                    double[] num = new double[sNum.length];
                    num[0] = Double.parseDouble(sNum[0]);
                    if (sNum.length == 2) {
                        num[1] = Double.parseDouble(sNum[1]);
                        num[0] = num[0] / num[1];
                    }
                    this.ELMT[i][j] = num[0];
                }
            }
            scanner2.close();

        } catch (FileNotFoundException e) {
            System.out.print("File tidak ditemukan");
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
