package penumpang;

public class Passenger {
  String name;
  Passenger next;

  public Passenger(String name) {
    this.name = name;
    this.next = null;
  }
}
