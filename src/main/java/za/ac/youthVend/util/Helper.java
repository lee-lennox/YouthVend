package za.ac.youthVend.util;

import za.ac.youthVend.domain.Seller;

import java.time.LocalDate;

public class Helper {

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isNullOrZero(Integer value) {
        return value == null || value == 0;
    }

    public static boolean isNullOrZero(Long value) {
        return value == null || value == 0L;
    }

    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public static boolean isValidPostalCode(String postalCode) {
        return !isNullOrEmpty(postalCode);
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return !isNullOrEmpty(phoneNumber);
    }

    public static boolean isValidDate(LocalDate date) {
        return date != null && !date.isAfter(LocalDate.now());
    }

    public static boolean isDate(LocalDate orderDate) {
        return orderDate != null;
    }

    public static boolean isValidRating(int rating) {
        return rating >= 1 && rating <= 5;
    }
}