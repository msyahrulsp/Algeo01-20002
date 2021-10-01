package util;

public class Menu {
    public static void MainMenu() {
        System.out.println("\n-------------KALKULATOR MATRIKS-------------");
        System.out.print("""
                1. Menentukan Solusi Persamaan Linier
                2. Determinan
                3. Transpose, Kofaktor, Adjoin 
                4. Matriks Balikan
                5. Interpolasi Polinom
                6. Regresi Linier Berganda
                7. Keluar
                """);
        System.out.print("Pilih operasi: ");
    }

    public static void SPLMenu() {
        System.out.print("""
                \n1. Metode eliminasi Gauss
                2. Metode eliminasi Gauss-Jordan
                3. Metode matriks balikan
                4. Kaidah Crammer
                """);
        System.out.print("Pilih metode: ");
    }

    public static void DeterminantMenu() {
        System.out.print("""

                \n1. Metode Reduksi Baris
                2. Metode Ekspansi Kofaktor
                """);
        System.out.print("Pilih metode: ");
    }

    public static void TransposeMenu() {
        System.out.print("""

                \n1. Transpose Matriks
                2. Matriks Kofaktor
                3. Adjoint Matriks
                """);
        System.out.print("Pilih metode: ");
    }

    public static void InverseMenu() {
        System.out.print("""
                \n1. Metode Gauss-Jordan
                2. Metode Adjoin
                """);
        System.out.print("Pilih metode: ");
    }

    public static void InputMenuType() {
        System.out.print("""
        \nMasukkan Input via File?
        1. Ya
        2. Tidak
                """);
        System.out.print("Pilih: ");
    }

    public static void OutputMenu() {
        System.out.print("""
        \nMasukkan Output ke File?
        1. Ya
        2. Tidak
                """);
        System.out.print("Pilih: ");
    }
}
