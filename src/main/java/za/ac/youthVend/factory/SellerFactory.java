package za.ac.youthVend.factory;

import za.ac.youthVend.domain.Seller;
import za.ac.youthVend.domain.User;
import za.ac.youthVend.util.Helper;

public class SellerFactory {
    public static Seller createSeller(String fullName, String email, String password, String businessName, boolean verified) {
        if (Helper.isNullOrEmpty(fullName) || !Helper.isValidEmail(email) ||
                Helper.isNullOrEmpty(password) || Helper.isNullOrEmpty(businessName)) {
            System.out.println("Invalid seller input data.");
            return null;
        }

        return new Seller.Builder()
                .setFullName(fullName)
                .setEmail(email)
                .setPassword(password)
                .setBusinessName(businessName)
                .setVerified(verified)
                .build();
    }
}