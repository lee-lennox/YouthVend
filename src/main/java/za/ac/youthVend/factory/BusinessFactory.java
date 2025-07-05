package za.ac.youthVend.factory;

import za.ac.youthVend.domain.Business;
import za.ac.youthVend.domain.Seller;
import za.ac.youthVend.util.Helper;

public class BusinessFactory{
    public static Business createBusiness(String name, String description, Seller seller) {
        if (Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(description) || seller == null) {
            return null;
        }

        return new Business.Builder()
                .setBusinessName(name)
                .setDescription(description)
                .setSeller(seller)
                .build();
    }
}
