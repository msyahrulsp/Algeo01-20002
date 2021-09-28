package Library;
import static Library.GaussElimination.*;
import static Library.InOut.*;

public class GaussSolution {
    public static void gaussSolution(Matriks m) {
        gaussElimination(m);
        displayMatrix(m);
        if (isNoSolution(m)) {
            System.out.println("Sistem persamaan linear ini tidak memiliki solusi");
        }
        else if (isInfinitySolutions(m)) {
            System.out.println("Sistem persamaan linear ini memiliki banyak solusi, dengan: ");
            String[] result = parametricSolutions(m);
            displaySPLSolution(result);
        }
        else {
            double[] result = isOneSolution(m);
            System.out.println("Sistem persamaan linear ini memiliki 1 solusi unik, yaitu:");
            displaySPLSolution(result);
        }
    }

    public static boolean isNoSolution (Matriks m) {
        boolean noSolution = false;
        boolean isPartial0 = true;
        int i = m.baris-1;
        while (i>=0 && !noSolution) {
            int j = 0;
            while (j<m.kolom-1 && isPartial0) {
                isPartial0 = (m.ELMT[i][j] == 0);
                j++;
            }
            noSolution = (isPartial0) && (m.ELMT[i][m.kolom-1] != 0);
            i--;
        }
        return noSolution;
    }

    public static boolean isInfinitySolutions(Matriks m) {
        return allElmtRowIs0(m, m.baris-1) || (m.baris<m.kolom-1);
    }

    public static double[] isOneSolution(Matriks m) {
        // back substituion
        double[] result = new double[m.kolom-1];
        for(int i=m.kolom-2; i>=0; i--) {
            result[i] = m.ELMT[i][m.kolom-1];
            for(int j=i+1; j<m.kolom-1; j++) {
                result[i] -= m.ELMT[i][j]*result[j];
            }
        }
        return result;
    }

    public static String[] parametricSolutions(Matriks m) {
        // banyak maksimal parameter = banyak variabel-1 = m.kolom-2
        String[] result = new String[m.kolom-1];
        double[][] paramMatrix = new double[m.kolom-1][m.kolom-1];
        // baris mewakili variabel, kolom mewakili parameter (kolom terakhir untuk konstanta)
        String[] paramList = new String[m.kolom-1];
        paramList[m.kolom-2] = "";

        int parCount = 0;
        int iRes = m.kolom-2;
        while (iRes>= 0) {
            boolean eResValid = false;      // true jika sudah ditemukan nilai result[iRes]
            int i=m.baris-1;
            while (i>=0 && !eResValid) {
                if (allElmtRowIs0(m, i) && (i!=0)) {
                    i--;
                }
                else {
                    if (m.ELMT[i][iRes] == 0) {
                        if (i!=0) {
                            i--;
                        }
                        else {
                            paramList[parCount] = getCharForNumber(parCount);
                            paramMatrix[iRes][parCount] = 1;
                            parCount++;
                            eResValid = true;
                            iRes--;
                        }
                    }
                    else {
                        if (isOtherLeftCol0(m,i,iRes)) {
                            if(isOtherRightCol0(m,i,iRes)) {
                                paramMatrix[iRes][m.kolom-2] = m.ELMT[i][m.kolom-1];
                            }
                            else {
                                paramMatrix[iRes][m.kolom-2] =  m.ELMT[i][m.kolom-1];
                                for (int iParam=0; iParam<m.kolom-1; iParam++) {
                                    for(int j=iRes+1; j<m.kolom-1; j++) {
                                        paramMatrix[iRes][iParam] -= paramMatrix[j][iParam]*m.ELMT[i][j];
                                    }
                                }
                            }
                        }
                        else {
                            paramMatrix[iRes][parCount] = 1;
                            paramList[parCount] = getCharForNumber(parCount);
                            parCount++;
                        }
                        eResValid = true;
                        iRes--;
                    }
                }
            }
        }

        // set result dari parametric matrix, AAAA \O/

        for (int i=0; i<m.kolom-1; i++) {
            boolean isBegin = true;
            result[i] = "";
            if ((paramMatrix[i][m.kolom-2] != 0) || (isNoParametric(paramMatrix,i, m.kolom-1))) {
                result[i] += paramMatrix[i][m.kolom-2];
                isBegin = false;
            }
            for (int j=m.kolom-3; j>=0; j--) {
                if (paramMatrix[i][j] == 0) {
                    continue;
                }
                else if (paramMatrix[i][j] > 0) {
                    if (!isBegin) {
                        result[i] += " + ";
                    }
                    if (paramMatrix[i][j] == 1) {
                        result[i] += paramList[j];
                    }
                    else {
                        result[i] += paramMatrix[i][j] + paramList[j];
                    }
                    isBegin = false;
                }
                else {
                    if (isBegin) {
                        if (paramMatrix[i][j] == -1) {
                            result[i] += "-" + paramList[j];
                        }
                        else {
                            result[i] += paramMatrix[i][j] + paramList[j];
                        }
                    }
                    else {
                        if (paramMatrix[i][j] == -1) {
                            result[i] += " - " + paramList[j];
                        }
                        else {
                            result[i] += " - " + Math.abs(paramMatrix[i][j]) + paramList[j];
                        }
                    }
                    isBegin = false;
                }
            }
        }

        return result;
    }

    //--------------------------------------------------------------------------------------
    public static boolean isNoParametric(double[][] paramMatrix, int baris, int nKolom) {
        boolean isNoP  = true;
        int j=0;
        while (j<nKolom-1 && isNoP) {
            isNoP = paramMatrix[baris][j] == 0;
            j++;
        }
        return  isNoP;
    }

    public static boolean isOtherLeftCol0(Matriks m, int baris, int kolom) {
        boolean is0 = true;
        int j = kolom-1;
        while ((j>=0) && is0) {
            is0 = m.ELMT[baris][j] == 0;
            j--;
        }
        return is0;
    }

    public static boolean isOtherRightCol0(Matriks m, int baris, int kolom) {
        boolean is0 = true;
        int j = kolom+1;
        while ((j<m.kolom-1) && is0) {
            is0 = m.ELMT[baris][j] == 0;
            j++;
        }
        return is0;
    }

    private static String getCharForNumber(int i) {
        return i >= 0 && i < 26 ? String.valueOf((char)(i + 'a')) : null;
    }

}
