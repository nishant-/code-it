package model;

import lombok.*;
import util.Constants;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item extends BaseModel {

    private int rating;
    private int totalCost;
    private int price;
    private int shippingCost;
    private String category;

    @Override
    public String toString() {
        return category + ":" + "Item(total cost = "+ Constants.CURRENCY_SYMBOL + totalCost + ", rating = " + rating + ", " +
                "shipping cost = "+Constants.CURRENCY_SYMBOL+ shippingCost + ", price = "+Constants.CURRENCY_SYMBOL+ price +")";
    }

}
