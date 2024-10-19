package penumpang;

public class Main {
  public static void main(String[] args) {
    Flight flight = new Flight();
    flight.addPassenger("Andi");
    flight.addPassenger("Budi");
    flight.addPassenger("Cici");

    flight.displayPassengers(); // Menampilkan: Andi, Budi, Cici

    flight.removePassenger("Cici");
    flight.displayPassengers(); // Menampilkan: Andi,Cici
  }
}
