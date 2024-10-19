package Split;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PembagiFile {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Masukkan nama file: ");
    String fileName = scanner.nextLine();

    System.out.print("Masukkan jumlah potongan: ");
    int numParts = scanner.nextInt();

    try {
      // Membaca file
      File file = new File(fileName);
      Scanner reader = new Scanner(file);

      // Membuat queue untuk menyimpan potongan file
      Queue<String> queue = new LinkedList<>();
      StringBuilder part = new StringBuilder();
      int partCount = 1;

      while (reader.hasNextLine()) {
        String line = reader.nextLine();
        part.append(line).append("\n");

        // Jika panjang bagian sudah mencapai batas atau akhir file
        if (part.length() >= (file.length() / numParts) || !reader.hasNextLine()) {
          queue.add(part.toString());
          part = new StringBuilder();
          partCount++;
        }
      }

      // Menyimpan setiap potongan ke file baru
      while (!queue.isEmpty()) {
        String content = queue.poll();
        PrintWriter writer = new PrintWriter(fileName + "_" + partCount + ".txt");
        writer.println(content);
        writer.close();
        partCount++;
      }

      System.out.println("File berhasil dipotong menjadi " + (partCount - 1) + " bagian.");
    } catch (FileNotFoundException e) {
      System.out.println("File tidak ditemukan.");
    }
  }
}
