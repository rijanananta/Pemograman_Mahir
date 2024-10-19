package PlaylistLagu;

public class Playlist {
  song head;

  public void addSong(String title) {
    song newSong = new song(title);
    if (head == null) {
      head = newSong;
    } else {
      song current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = newSong;
    }
  }

  public void displayPlaylist() {
    if (head == null) {
      System.out.println("Playlist kosong.");
    } else {
      song current = head;
      while (current != null) {
        System.out.println(current.title);
        current = current.next;
      }
    }
   }
}
