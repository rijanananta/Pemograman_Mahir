package TextEditor;
import java.util.Stack;
import java.util.Scanner;

public class TextEditor {
  private Stack<String> undoStack = new Stack<>();
  private Stack<String> redoStack = new Stack<>();
  private String currentText = "";

  public void show() {
    System.out.println(currentText);
  }

  public void undo() {
    if (!undoStack.isEmpty()) {
      redoStack.push(currentText);
      currentText = undoStack.pop();
    } else {
      System.out.println("Tidak ada yang bisa di-undo.");
    }
  }

  public void redo() {
    if (!redoStack.isEmpty()) {
      undoStack.push(currentText);
      currentText = redoStack.pop();
    } else {
      System.out.println("Tidak ada yang bisa di-redo.");
    }
  }

  public void write(String text) {
    undoStack.push(currentText);
    currentText += text;
    redoStack.clear(); // Kosongkan redoStack saat ada perubahan baru
  }

  public static void main(String[] args) {
    TextEditor editor = new TextEditor();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.print("Masukkan perintah (show, undo, redo, write): ");
      String command = scanner.nextLine();

      switch (command) {
        case "show":
          editor.show();
          break;
        case "undo":
          editor.undo();
          break;
        case "redo":
          editor.redo();
          break;
        case "write":
          System.out.print("Masukkan teks: ");
          String text = scanner.nextLine();
          editor.write(text);
          break;
        default:
          System.out.println("Perintah tidak valid.");
      }
    }
  }
}
