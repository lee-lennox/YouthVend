package za.ac.youthVend.factory;

import za.ac.youthVend.domain.Buyer;
import za.ac.youthVend.domain.User;
import za.ac.youthVend.util.Helper;

public class BuyerFactory {
    public static Buyer createBuyer(String email, Long userId, String fullName, String password) {
        if (Helper.isNullOrEmpty(email)
                || Helper.isNullOrEmpty(fullName)
                || Helper.isNullOrEmpty(password)
                || userId == null || userId <= 0
                || !Helper.isValidEmail(email)) {
            System.out.println("Invalid buyer data.");
            return null;
        }

        return new Buyer.Builder()
                .setEmail(email)
                .setUserId(userId)
                .setFullName(fullName)
                .setPassword(password)
                .build();
    }
}
