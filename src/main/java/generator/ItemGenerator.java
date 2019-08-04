package generator;

import lombok.Data;
import model.Item;

import static util.CalculationUtility.*;
import static util.Constants.*;
import static util.Constants.MAX_ITEM_PRICE;
import static util.Constants.MIN_ITEM_PRICE;

@Data
public class ItemGenerator implements Generatable<Item> {

    private Item[] items;
    private int numberOfItems;

    private ItemGenerator(int numberOfItems){
        this.items = new Item[numberOfItems];
    }

    public static ItemGenerator createItemGenerator(int numberOfItems) {
        return new ItemGenerator(numberOfItems);
    }

    @Override
    public void generate() {

        for (int i = 0; i < items.length; i++) {

            int price = randomIntegerBetween(MIN_ITEM_PRICE, MAX_ITEM_PRICE);
            int shippingCost = randomIntegerBetween(MIN_SHIPPING_COST, MAX_SHIPPING_COST);
            int rating = randomIntegerBetween(MIN_RATING, MAX_RATING);
            int totalCost = price + shippingCost;

            Item anItem = Item.builder().price(price)
                    .shippingCost(shippingCost)
                    .rating(rating)
                    .totalCost(totalCost)
                    .build();

            items[i] = anItem;
        }
    }

    @Override
    public Item[] getObjects() {
        return this.getItems();
    }


}