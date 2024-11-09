package Service;

import Entity.Booking;
import Entity.Customer;
import Entity.Room;
import Entity.RoomType;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class BookingService {
    private List<Room> rooms;
    private List<Customer> customers;
    private List<Booking> bookings;

    public BookingService(List<Room> rooms, List<Customer> customers, List<Booking> bookings) {
        this.rooms = rooms;
        this.customers = customers;
        this.bookings = bookings;
    }


    public void createBooking(int bookingId, String customerId, String roomId, LocalDateTime checkIn, LocalDateTime checkOut) {
        bookings.add(new Booking(bookingId, roomId, customerId, checkIn, checkOut));
    }


    public List<Booking> findBookingsByCustomer(String cusName, String cusPhone) {
        return bookings.stream()
                .filter(booking -> {
                    Customer customer = customers.stream()
                            .filter(c -> c.getId().equals(booking.getCustomerId()))
                            .findFirst().orElse(null);
                    return customer != null && customer.getName().equalsIgnoreCase(cusName) && customer.getPhone().equals(cusPhone);
                })
                .collect(Collectors.toList());
    }


    public Map<RoomType, Double> calculateRevenueByRoomType() {
        Map<String, Room> roomMap = rooms.stream().collect(Collectors.toMap(Room::getId, room -> room));
        return bookings.stream()
                .collect(Collectors.groupingBy(
                        booking -> roomMap.get(booking.getRoomId()).getRoomType(),
                        Collectors.summingDouble(booking -> {
                            Room room = roomMap.get(booking.getRoomId());
                            long hours = Duration.between(booking.getCheckIn(), booking.getCheckOut()).toHours();
                            return room.getPricePerHour() * hours;
                        })
                ));
    }


    public Optional<RoomType> getHighestRevenueRoomTypeIn2023() {
        Map<RoomType, Double> revenueByRoomType = calculateRevenueByRoomType();
        return revenueByRoomType.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }
}


