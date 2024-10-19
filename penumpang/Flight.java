package penumpang;

public class Flight {
  Passenger head;

  public void addPassenger(String name) {
    Passenger newPassenger = new Passenger(name);
    if (head == null) {
      head = newPassenger;
    } else {
      Passenger current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = newPassenger;
    }
  }

  public void removePassenger(String name) {
    if (head == null) {
      System.out.println("Tidak ada penumpang dalam penerbangan ini.");
      return;
    }

    if (head.name.equals(name)) {
      head = head.next;
      return;
    }

    Passenger current = head;
    while (current.next != null && !current.next.name.equals(name)) {
      current = current.next;
    }

    if (current.next != null) {
      current.next = current.next.next;
    } else {
      System.out.println("Penumpang tidak ditemukan.");
    }
  }

  public void displayPassengers() {
    if (head == null) {
      System.out.println("Tidak ada penumpang dalam penerbangan ini.");
      return;
    }

    Passenger current = head;
    while (current != null) {
      System.out.println(current.name);
      current = current.next;
    }
  }
}
