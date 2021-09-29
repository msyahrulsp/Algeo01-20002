package util;

import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;

public class FileOut {
    public static void FileOutput() {
        try {
            String path = System.getProperty("user.dir"); // HARUSNYA sampai parent folder doang
            path = path.replace("\\src", ""); // Safecase user.dir sampe src hasilnya
            File folder = new File(new File(path + "/test").getCanonicalPath());

            if (!folder.exists()) folder.mkdir();

            System.out.print("> Masukkan nama file: ");
            Scanner scanner = new Scanner(System.in);
            String fileName = "output_" + scanner.nextLine();

            if (!fileName.contains(".txt")) fileName = fileName + ".txt";
            File file = new File(new File(path + "/test/" + fileName).getCanonicalPath());

            while (file.exists()) {
                System.out.println("File sudah ada. Silahkan gunakan nama lain");
                System.out.print("> Masukkan nama file: ");
                fileName = "output_" + scanner.nextLine();

                if (!fileName.contains(".txt")) fileName = fileName + ".txt";
                file = new File(new File(path + "/test/" + fileName).getCanonicalPath());
            }

            PrintStream fOut = new PrintStream(file);
            System.setOut(fOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
