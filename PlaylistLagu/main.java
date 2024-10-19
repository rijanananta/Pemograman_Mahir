package PlaylistLagu;

public class main {
  public static void main(String[] args) {
    Playlist playlist = new Playlist();
    playlist.addSong("Celengan Rindu");
    playlist.addSong("Cari Jodoh");
    playlist.addSong("Perfect");

    playlist.displayPlaylist();
  }
}
