package Library;

public class GaussJordanInverse {
    public static void displayMatrix(Matriks m) {
        int i, j;
        for (i=0; i<m.baris; i++) {
            for (j=0; j<m.kolom; j++)
            {
                System.out.print(m.ELMT[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void swapRow(Matriks m, int brs1, int brs2) {
        for (int j = 0; j<m.kolom; j++) {
            double temp = m.ELMT[brs1][j];
            m.ELMT[brs1][j] = m.ELMT[brs2][j];
            m.ELMT[brs2][j] = temp;
        }
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

    public static boolean findLeading(Matriks m, int iBrs)
    {
        int i=0;
        int idxLead=0;
        boolean isLead=true;
        while (i<m.kolom && isLead)
        {
            if (m.ELMT[iBrs][i] == 1)
            {
                isLead = false;
                idxLead = i;
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

        for (int iBrs = 0; iBrs < m.baris; iBrs++) {
            int iKol = iBrs;
            // kalau 0 kolomnya naik
            while (allElmtKolIs0(m, iBrs, iKol) && (iKol < m.kolom - 1)) {
                iKol++;
            }
            // tuker dgn non zero
            if (m.ELMT[iBrs][iKol] == 0) {
                orderRow(m, iKol);
            }
            // mengubah elemen baris berdasar baris-iBrs (referensi)
            for (int j = iBrs + 1; j < m.baris; j++) {
                double coeff = m.ELMT[j][iKol] / m.ELMT[iBrs][iKol];
                for (int k = iKol; k < m.kolom; k++) {
                    m.ELMT[j][k] -= m.ELMT[iBrs][k] * coeff;

                }
            }
        }

        // Membuat leading one tiap baris (jika elemen baris tidak all 0)
        for (int i = 0; i < m.baris; i++) {
            if (!allElmtBrsIs0(m, i)) {
                int iLead = 0;
                while (iLead < m.kolom && m.ELMT[i][iLead] == 0) {
                    iLead++;
                }
                double factor = m.ELMT[i][iLead];
                for (int j = iLead; j < m.kolom; j++) {
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

    public static Matriks makeInverse(Matriks m)
    {
//        m.baris = 2 * m.baris;
//        m.kolom = 2 * m.kolom;
        Matriks n = new Matriks(new double[m.baris][m.kolom], m.baris, 2 * m.kolom);

        for (int rows = 0; rows < m.baris; rows++)
        {
            for (int cols = 0; cols < m.kolom;cols++)
            {
                n.ELMT[rows][cols] = m.ELMT[rows][cols];
            }
        }
        for (int rows=0; rows < n.baris; rows++)
        {
//            for (int cols=0;cols<n.kolom;cols++)
//            {
//
//            }
            n.ELMT[rows][n.baris+rows] = 1;
        }
        displayMatrix(n);
        gaussJordanElimination(n);
        Matriks o = new Matriks(new double[m.baris][m.kolom], m.baris, 2 * m.kolom);

        for (int rows = 0; rows < m.baris; rows++)
        {
            for (int cols = 0; cols < m.kolom;cols++)
            {
                o.ELMT[rows][cols] = n.ELMT[rows][cols+m.kolom];
            }
        }


//                n.ELMT[1][3]
        return o;
    }
}
