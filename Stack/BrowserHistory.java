package Stack;

import java.util.ArrayList;
import java.util.Scanner;

public class BrowserHistory {
  private ArrayList<String> history;

  public BrowserHistory() {
    history = new ArrayList<>();
  }

  public void view() {
    System.out.println("History Browser:");
    if (history.isEmpty()) {
      System.out.println("History kosong.");
    } else {
      for (int i = history.size() - 1; i >= 0; i--) {
        System.out.println((history.size() - i) + ". " + history.get(i));
      }
    }
  }

  public void browse(String site) {
    history.add(site);
    System.out.println("Website '" + site + "' telah ditambahkan ke history.");
  }

  public void back() {
    if (history.isEmpty()) {
      System.out.println("Tidak ada history untuk kembali.");
    } else {
      String lastSite = history.remove(history.size() - 1);
      System.out.println("Kembali dari '" + lastSite + "'.");
    }
  }

  public static void main(String[] args) {
    BrowserHistory browserHistory = new BrowserHistory();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("\nPilihan:");
      System.out.println("1. View history");
      System.out.println("2. Browse website");
      System.out.println("3. Back");
      System.out.println("4. Exit");

      System.out.print("Masukkan pilihan (1-4): ");
      int choice = scanner.nextInt();
      scanner.nextLine();  // Mengonsumsi newline

      switch (choice) {
        case 1:
          browserHistory.view();
          break;
        case 2:
          System.out.print("Masukkan URL website: ");
          String site = scanner.nextLine();
          browserHistory.browse(site);
          break;
        case 3:
          browserHistory.back();
          break;
        case 4:
          System.out.println("Keluar dari program.");
          scanner.close();
          return;
        default:
          System.out.println("Pilihan tidak valid. Silakan coba lagi.");
      }
    }
  }
}
