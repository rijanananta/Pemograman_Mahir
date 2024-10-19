package PlaylistLagu;

public class song {
  String title;
  song next;

  public song(String title) {
    this.title = title;
    this.next = null;
  }
}
