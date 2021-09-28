package Library;
import static Library.GaussElimination.*;

public class GaussJordanElimination {

    public static boolean allElmtColIs0(Matriks m, int idx) {
        // mengirimkan true jika semua elemen baris idx adalah 0
        boolean is0 = true;
        int i=0;
        while (i<m.baris && is0) {
            is0 = m.ELMT[idx][i] == 0;
            i++;
        }
        return is0;
    }

    public static boolean findLeading(Matriks m, int iBrs)
    {
        int i=0;
        // int idxLead=0;
        boolean isLead=true;
        while (i<m.kolom && isLead)
        {
            if (m.ELMT[iBrs][i] == 1)
            {
                isLead = false;
                // idxLead = i;
            }
            i ++;
        }
        isLead = !isLead;
        return isLead;
    }

    public static int findLeadingIdx(Matriks m, int iBrs)
    {
        int i=0;
        int idxLead=0;
        boolean isLead=false;
        while (i<m.kolom && !(isLead))
        {
            if (m.ELMT[iBrs][i] == 1)
            {
                isLead = true;
                idxLead = i;
                break;
            }
            i ++;
        }
        return idxLead;
    }


    public static void gaussJordanElimination(Matriks m) {

        // for (int iBrs = 0; iBrs < m.baris; iBrs++) {
        //     int iKol = iBrs;
        //     // kalau 0 kolomnya naik
        //     while (allElmtColIs0(m, iBrs) && (iKol < m.kolom - 1)) {
        //         iKol++;
        //     }
        //     // tuker dgn non zero
        //     if (m.ELMT[iBrs][iKol] == 0) {
        //         orderRow(m, iKol);
        //     }
        //     // mengubah elemen baris berdasar baris-iBrs (referensi)
        //     for (int j = iBrs + 1; j < m.baris; j++) {
        //         double coeff = m.ELMT[j][iKol] / m.ELMT[iBrs][iKol];
        //         for (int k = iKol; k < m.kolom; k++) {
        //             m.ELMT[j][k] -= m.ELMT[iBrs][k] * coeff;

        //         }
        //     }
        // }

        // // Membuat leading one tiap baris (jika elemen baris tidak all 0)
        // for (int i = 0; i < m.baris; i++) {
        //     if (!allElmtRowIs0(m, i)) {
        //         int iLead = 0;
        //         while (iLead < m.kolom && m.ELMT[i][iLead] == 0) {
        //             iLead++;
        //         }
        //         double factor = m.ELMT[i][iLead];
        //         for (int j = iLead; j < m.kolom; j++) {
        //             if (m.ELMT[i][j] != 0) {
        //                 m.ELMT[i][j] /= factor;
        //             }
        //         }
        //     }
        // }

        for (int iBrs = 0; iBrs < m.baris; iBrs++) {
            int iKol = iBrs;
            while (allElmtColUnderIs0(m,iBrs,iKol) && (iKol<m.kolom-1)) {
                iKol++;
            }
            if (m.ELMT[iBrs][iKol] == 0) {
                orderRow(m, iBrs, iKol);
            }
            // mengubah elemen baris dibawah berdasar baris-iBrs (referensi)
            if (!((iKol==m.kolom-1) && allElmtColUnderIs0(m,iBrs,iKol))) {
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
            if (!allElmtRowIs0(m, i)) {
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

        for (int iBrs = 1; iBrs< m.baris; iBrs++) {
            if (findLeading(m, iBrs))
            {
                int idxLead = findLeadingIdx(m, iBrs);
                for (int BrsBefore = 1;BrsBefore<=iBrs;BrsBefore++)
                {
                    if (m.ELMT[iBrs - BrsBefore][idxLead] != 0) {
                        for (int j = 0; j < iBrs; j++) {
                            double coeff = m.ELMT[j][idxLead] / m.ELMT[iBrs][idxLead];
//                            m.ELMT[j][idxLead] -= m.ELMT[iBrs][idxLead] * coeff;
                            for (int k=0; k<m.kolom;k++)
                            {
                                m.ELMT[j][k] -= m.ELMT[iBrs][k] * coeff;
                            }

                        }
                    }
                }

            }
        }

    }
}
