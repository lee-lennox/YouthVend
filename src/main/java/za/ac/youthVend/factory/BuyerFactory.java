package za.ac.youthVend.factory;

import za.ac.youthVend.domain.Buyer;
import za.ac.youthVend.domain.User;
import za.ac.youthVend.util.Helper;

public class BuyerFactory {
    public static Buyer createBuyer(String email, String fullName, String password) {
        if (Helper.isNullOrEmpty(email)
                || Helper.isNullOrEmpty(fullName)
                || Helper.isNullOrEmpty(password)
                || !Helper.isValidEmail(email)) {

        }

        return new Buyer.Builder()
                .setEmail(email)
                .setFullName(fullName)
                .setPassword(password)
                .build();
    }
}
