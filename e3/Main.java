import Entity.Booking;
import Entity.Customer;
import Entity.Room;
import Entity.RoomType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
        // Creating Room objects
        Map<String, Room> rooms = new HashMap<>();
        rooms.put("RS001", new Room("RS001", "Single", 8));
        rooms.put("RD001", new Room("RD001", "Double", 12));
        rooms.put("RQ002", new Room("RQ002", "Queen", 35));
        rooms.put("RT001", new Room("RT001", RoomType.valueOf("Triple"), 12.5));
        rooms.put("RQ001", new Room("RQ001", RoomType.valueOf("Quad"), 20.5));

        // Creating Customer objects
        Map<String, Customer> customers = new HashMap<>();
        customers.put("001", new Customer("001", "Mr.Linus Tovaldo", "84125325346457"));
        customers.put("002", new Customer("002", "Mr.Bill", "91124235346467"));
        customers.put("003", new Customer("003", "Mr.Turing", "911423534646"));

        // Creating Booking objects
        List<Booking> bookings = new ArrayList<>();
        try {
            bookings.add(new Booking(1, rooms.get("RS001"), customers.get("001"), "2023-03-15 09:30:15", "2023-03-16 12:30:45"));
            bookings.add(new Booking(2, rooms.get("RS001"), customers.get("002"), "2023-06-09 19:30:25", "2023-06-10 11:25:15"));
            bookings.add(new Booking(3, rooms.get("RD001"), customers.get("002"), "2023-03-11 10:10:05", "2023-03-13 11:05:10"));
            bookings.add(new Booking(4, rooms.get("RT001"), customers.get("003"), "2023-11-11 11:11:15", "2023-11-13 11:15:15"));
            bookings.add(new Booking(5, rooms.get("RT001"), customers.get("001"), "2023-10-25 09:20:25", "2023-10-26 12:25:30"));
            bookings.add(new Booking(6, rooms.get("RQ001"), customers.get("001"), "2023-08-18 18:25:35", "2023-08-19 11:35:20"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Displaying rooms
        System.out.println("Rooms Available:");
        for (Room room : rooms.values()) {
            System.out.println(room);
        }

        // Displaying customers
        System.out.println("\nCustomers:");
        for (Customer customer : customers.values()) {
            System.out.println(customer);
        }

        // Displaying bookings
        System.out.println("\nBookings:");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }
}