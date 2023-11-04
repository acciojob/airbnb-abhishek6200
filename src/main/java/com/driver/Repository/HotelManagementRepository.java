package com.driver.Repository;

import com.driver.model.Booking;
import com.driver.model.Hotel;
import com.driver.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class HotelManagementRepository {
    private HashMap<String, Hotel> hotelDB = new HashMap<>();
    private HashMap<String, User> userDB = new HashMap<>();
    private HashMap<String, Booking> bookingDB = new HashMap<>();
    private HashMap<Integer,Integer> noOfBookingByUser = new HashMap<>();

    public HashMap<String, Hotel> getHotelDB() {
        return hotelDB;
    }

    public void setHotelDB(HashMap<String, Hotel> hotelDB) {
        this.hotelDB = hotelDB;
    }

    public HashMap<String, User> getUserDB() {
        return userDB;
    }

    public void setUserDB(HashMap<String, User> userDB) {
        this.userDB = userDB;
    }

    public HashMap<String, Booking> getBookingDB() {
        return bookingDB;
    }

    public void setBookingDB(HashMap<String, Booking> bookingDB) {
        this.bookingDB = bookingDB;
    }

    public HashMap<Integer, Integer> getNoOfBookingByUser() {
        return noOfBookingByUser;
    }

    public void setNoOfBookingByUser(HashMap<Integer, Integer> noOfBookingByUser) {
        this.noOfBookingByUser = noOfBookingByUser;
    }
    public void addHotel(Hotel hotel){
        hotelDB.put(hotel.getHotelName(),hotel);
    }
    public void addUser(User user){
        userDB.put(user.getName(),user);
    }
    private String generateBookingId(){
        return UUID.randomUUID().toString();
    }
    public void addBooking(Booking booking){
        String bookingId = generateBookingId();
        booking.setBookingId(bookingId);
        bookingDB.put(bookingId,booking);
    }
    public void addBookingCountByUser(Integer aadharCardNo){
        noOfBookingByUser.put(aadharCardNo,noOfBookingByUser.getOrDefault(aadharCardNo,0) + 1);
    }
}
