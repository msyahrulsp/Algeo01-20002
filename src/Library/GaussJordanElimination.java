package Library;

import matriks.Matriks;

public class GaussJordanElimination {
    public static void gaussJordanElimination(Matriks m) {
        double constant = 1;
        // System.out.println("kambing");
        
        // transversal setiap baris
        for (int iBrs=0; iBrs<m.baris;iBrs++) {
            int iKol = iBrs;
            while (allElmtColUnderIs0(m,iBrs,iKol) && (iKol<m.kolom-1)) {
                iKol++;
            }
            if (m.ELMT[iBrs][iKol] == 0) {
                GaussElimination.orderRow(m, iBrs, iKol);
            }
            // && !GaussElimination.allElmtColUnderIs0(m,iBrs+1,iBrs+1)

            // if ((m.ELMT[iBrs][iKol] != 1) && !GaussElimination.allElmtRowIs0(m, iBrs)) {
            //     double leading = m.ELMT[iBrs][iKol];
            //     for (int j=iBrs;j<m.kolom;j++) {
                    
            //         m.ELMT[iBrs][j] /= leading;
            //         // m.ELMT[iBrs][j] += 100;
            //     }
            // if (GaussElimination.allElmtRowIs0(m, iBrs)) iBrs+=1;

            for(int i=0; i<m.baris; i++) {
                if (!GaussElimination.allElmtRowIs0(m, i)) {
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

            


            // untuk baris di bawah m.baris
            for (int n=1;n<m.baris;n++) {
                for (int i=iBrs+n; i<m.baris; i++) {
                    if ((iKol !=m.kolom-1) && !GaussElimination.allElmtColUnderIs0(m,iBrs,iBrs)) {
                    // if ((m.ELMT[iBrs+1][iBrs] != 0) && (iKol !=m.kolom-1)) {
                        double coeff = m.ELMT[i][iBrs] / m.ELMT[iBrs][iBrs];
                        for (int j=iKol; j<m.kolom; j++) {
                        
                            
                            m.ELMT[i][j] -= coeff * m.ELMT[iBrs][j];
                            // System.out.println(m.ELMT[i][j]);
                            // m.displayMatriks();
                            // System.out.println("----");
                        }
                        // m.displayMatriks();
                        // System.out.println("-----------");
                    }
                    
                }
            }

            // untuk baris di atas m.baris
            // for (int n=0;n<iBrs;n++) {
            //     for (int i=0+n; i<iBrs; i++) {
            //         if (m.ELMT[i][iBrs] != 0) {
            //             double coeff = m.ELMT[iBrs][iBrs] / m.ELMT[iBrs+n][iBrs];
            //             for (int j=iKol; j<m.baris; j++) {
            //                 // m.ELMT[i][j] -= coeff * m.ELMT[iBrs][j];
            //                 System.out.println(m.ELMT[i][j]);
            //             }
            //             System.out.println("-----------");
                        
            //         }
            //     }
            // }
            
            
                
                
        }
        // m.displayMatriks();

        // public static boolean nextColIs0(Matriks m, int iBrs, int iKol) {
        //     boolean nextzero = true;
        //     int i=iBrs;
        //     while (i<m.baris && is0) {
        //         is0 = m.ELMT[i][iKol] == 0;
        //         i++;
        //     }
        //     return is0;
        // }

        for (int iBrs=1; iBrs<m.baris;iBrs++) {
            int iKol = iBrs;
            // if (m.ELMT[iBrs][iKol] != 1) {
            //     m.ELMT[iBrs][iKol] /= m.ELMT[iBrs][iKol];

            // //     // if (m.ELMT[iBrs][iKol] != 1) {
            // //     //     System.out.println(m.ELMT[iBrs][iKol]);
            // //     // }
            // //     // System.out.println(m.ELMT[iBrs][iKol]);
            // }

            


            //untuk baris di atas m.baris
            // for (int n=1;n<iBrs;n++) {
            for (int i=0; i<iBrs; i++) {
                if (m.ELMT[i][iBrs] != 0) {
                    double coeff = m.ELMT[i][iBrs] / m.ELMT[iBrs][iBrs];
                    // System.out.println(m.ELMT[i][iBrs]);
                    // System.out.println(m.ELMT[iBrs][iBrs]);
                    for (int j=iKol; j<m.kolom; j++) {
                    
                        
                        m.ELMT[i][j] -= coeff * m.ELMT[iBrs][j];
                        // System.out.println(m.ELMT[i][j]);
                        // m.displayMatriks();
                        // System.out.println("----");
                        
                    }
                    // System.out.println("-----------");
                }
                
            }
            // }

            // // untuk baris di atas m.baris
            // // for (int n=0;n<iBrs;n++) { 
            // for (int i=0; i<iBrs; i++) { 
            //     if (m.ELMT[i][iBrs] != 0) {
            //         // double coeff = m.ELMT[iBrs][iBrs] / m.ELMT[iBrs+n][iBrs];
            //         for (int j=iKol; j<m.kolom; j++) {
            //             // m.ELMT[i][j] -= coeff * m.ELMT[iBrs][j];
            //             System.out.println(m.ELMT[i][j]);
            //         }
            //         System.out.println("-----------");
                    
            //     }
            // }
            // }
            
            
                
                
        }
    }

    public static boolean allElmtColUnderIs0(Matriks m, int iBrs, int iKol) {
        // mengirimkan true jika semua elemen kolom iKol pada baris [iBrs...m.baris] adalah 0
        boolean is0 = true;
        int i=iBrs;
        while (i<m.baris && is0) {
            is0 = m.ELMT[i][iKol] == 0;
            i++;
        }
        return is0;
    }

}