package generator;

import model.Item;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import util.Constants;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ItemGeneratorTest {

    private static ItemGenerator itemGenerator;


    @Test
    public void GeneratingItemArray_WithAnInputValueForSize_ResultsInAnArrayOfItemsOfGivenSize() {
        int numberOfItems = 20;
        itemGenerator = ItemGenerator.createItemGenerator(20);
        itemGenerator.generate();
        Item[] arr = itemGenerator.getObjects();
        assertEquals(arr.length, numberOfItems);
    }

    @Test
    @RepeatedTest(50)
    public void VerifyThat_PriceOfGeneratedItems_IsBetweenSpecifiedRange() {

        int numberOfItems = 200;
        boolean isPriceWithinRange = true;
        itemGenerator = ItemGenerator.createItemGenerator(numberOfItems);
        itemGenerator.generate();

        Item[] arr = itemGenerator.getObjects();
        for (Item item : arr) {
            isPriceWithinRange = isPriceWithinRange && (item.getPrice() >= Constants.MIN_ITEM_PRICE
                    && item.getPrice() <= Constants.MAX_ITEM_PRICE);
        }
        assertTrue(isPriceWithinRange == true);
    }

    @Test
    @RepeatedTest(10)
    public void VerifyThat_ShippingCostOfGeneratedItems_IsBetweenSpecifiedRange() {

        int numberOfItems = 50;
        itemGenerator = ItemGenerator.createItemGenerator(numberOfItems);
        itemGenerator.generate();

        Item[] arr = itemGenerator.getObjects();
        boolean isShippingCostWithinRange = true;
        for (Item item : arr) {
            isShippingCostWithinRange = isShippingCostWithinRange && (item.getShippingCost() >= Constants.MIN_SHIPPING_COST
                    && item.getShippingCost() <= Constants.MAX_SHIPPING_COST);
        }
        assertTrue(isShippingCostWithinRange == true);
    }

    @Test
    @RepeatedTest(5)
    public void VerifyThat_RatingOfGeneratedItems_IsBetweenSpecifiedRange() {
        int numberOfItems = 100;
        itemGenerator = ItemGenerator.createItemGenerator(numberOfItems);
        itemGenerator.generate();

        Item[] arr = itemGenerator.getObjects();
        boolean isItemRatingWithinRange = true;
        for (Item item : arr) {
            isItemRatingWithinRange = isItemRatingWithinRange && (item.getRating() >= Constants.MIN_RATING
                    && item.getRating() <= Constants.MAX_RATING);
        }
        assertTrue(isItemRatingWithinRange == true);
    }
}
