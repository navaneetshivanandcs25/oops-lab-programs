
class BusReservation {
    boolean seatAvailable = true;

    // Without synchronization
    void bookSeat(String customer) {
        if (seatAvailable) {
            System.out.println(customer + " is trying to book the seat.");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            seatAvailable = false;
            System.out.println(customer + " successfully booked the seat.");
        } else {
            System.out.println(customer + " failed to book the seat.");
        }
    }

    // With synchronization
    synchronized void bookSeatSync(String customer) {
        if (seatAvailable) {
            System.out.println(customer + " is trying to book the seat.");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            seatAvailable = false;
            System.out.println(customer + " successfully booked the seat.");
        } else {
            System.out.println(customer + " failed to book the seat.");
        }
    }
}

class Customer extends Thread {
    BusReservation bus;
    String customer;
    boolean sync;

    Customer(BusReservation bus, String customer, boolean sync) {
        this.bus = bus;
        this.customer = customer;
        this.sync = sync;
    }

    public void run() {
        if (sync) {
            bus.bookSeatSync(customer);
        } else {
            bus.bookSeat(customer);
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("WITHOUT SYNCHRONIZATION");

        BusReservation bus1 = new BusReservation();

        Customer c1 = new Customer(bus1, "Customer 1", false);
        Customer c2 = new Customer(bus1, "Customer 2", false);

        c1.start();
        c2.start();

        c1.join();
        c2.join();

        System.out.println("\nWITH SYNCHRONIZATION");

        BusReservation bus2 = new BusReservation();

        Customer c3 = new Customer(bus2, "Customer 1", true);
        Customer c4 = new Customer(bus2, "Customer 2", true);

        c3.start();
        c4.start();

        c3.join();
        c4.join();
    }
}
