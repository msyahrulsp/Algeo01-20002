package Library;

// Prekondisi : Matriks m dengan m.baris <= m.kolom
// OUTPUT : Matriks Eselon Baris
public class GaussElimination {
    
    public static int swapCount;            // banyak swap baris yang terjadi
    public static double constant;          // hasil kali konstanta perkalian baris yang terjadi

    public static void gaussElimination(Matriks m) {
        swapCount = 0;
        constant = 1;

        for (int iBrs = 0; iBrs < m.baris; iBrs++) {
            int iKol = iBrs;
            while (allElmtKolIs0(m,iBrs,iKol) && (iKol<m.kolom-1)) {
                iKol++;
            }
            if (m.ELMT[iBrs][iKol] == 0) {
                orderRow(m, iKol);
            }
            // mengubah elemen baris dibawah berdasar baris-iBrs (referensi)
            if (!((iKol==m.kolom-1) && allElmtKolIs0(m,iBrs,iKol))) {
                // jika sudah di kolom terakhir dan elemen kolomnya kebawah adalah 0
                // maka tidak perlu dievaluasi lagi ntuk menghindari NaN
                for (int j = iBrs+1; j<m.baris; j++) {
                    double coeff = m.ELMT[j][iKol]/m.ELMT[iBrs][iKol];
                    for (int k=iKol; k<m.kolom; k++) {
                        m.ELMT[j][k] -= m.ELMT[iBrs][k] * coeff;
                    }
                }
            }
        }

        // Membuat leading one tiap baris (jika elemen baris tidak all 0)
        for(int i=0; i<m.baris; i++) {
            if (!allElmtBrsIs0(m, i)) {
                int iLead=0;
                while (iLead<m.kolom && m.ELMT[i][iLead]==0) {
                    iLead++;
                }
                double factor = m.ELMT[i][iLead];
                constant /= factor;
                for (int j=iLead; j<m.kolom; j++) {
                    if (m.ELMT[i][j] != 0) {
                        m.ELMT[i][j] /= factor;
                    }
                }
            }
        }
        //displayMatrix(m);
    }

    public static void swapRow(Matriks m, int brs1, int brs2) {
        for (int j = 0; j<m.kolom; j++) {
            double temp = m.ELMT[brs1][j];
            m.ELMT[brs1][j] = m.ELMT[brs2][j];
            m.ELMT[brs2][j] = temp;
        }
        swapCount++;
    }

    public static boolean allElmtKolIs0(Matriks m, int iBrs, int iKol) {
        // mengirimkan true jika semua elemen kolom iKol pada baris [iBrs...m.baris] adalah 0
        boolean is0 = true;
        int i=iBrs;
        while (i<m.baris && is0) {
            is0 = m.ELMT[i][iKol] == 0;
            i++;
        }
        return is0;
    }

    public static boolean allElmtBrsIs0(Matriks m, int idx) {
        // mengirimkan true jika semua elemen baris idx adalah 0
        boolean is0 = true;
        int i=idx;
        while (i<m.kolom && is0) {
            is0 = m.ELMT[idx][i] == 0;
            i++;
        }
        return is0;
    }

    public static void orderRow(Matriks m, int idx) {
        // menukar baris idx jika m[idx][idx]=0 dengan baris lain dibawahnya yang elemennya tidak 0
        int i=idx+1;
        while (i<m.baris) {
            if (m.ELMT[i][idx]!=0) {
                swapRow(m, i, idx);
                break;
            }
            i++;
        }
    }

//     public static void displayMatrix(Matriks m) {
//         int i, j;
//         for (i=0; i<m.baris; i++) {
//             for (j=0; j<m.kolom; j++)
//             {
//                 System.out.print(m.ELMT[i][j] + " ");
//             }
//             System.out.print("\n");
//         }
//     }
}
