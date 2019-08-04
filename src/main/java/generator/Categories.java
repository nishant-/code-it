package generator;

import model.Category;
import model.Item;
import util.CalculationUtility;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;


public class Categories {

    private Categories() {}

    /**
     * This method returns top item from each category.
     * The item most likely to be picked from a category, will be the item with maximum (rating/totalCost) ratio.
     *
     * Given that only one item can be picked from the basket, the strategy mentioned above provides an opportunity to
     * fill the basket optimally with maximum number of items returned by this method.
     *
     * @param categories Category array containing the category type and items.
     * @param numberOfCategories The number of items for each category.
     *
     */
    public static Item[] getTopItemFromEachCategory(Category [] categories, int numberOfCategories) {

        sort(categories,ratingCostRatioComparator());
        Item [] topItems = new Item[numberOfCategories];
        for(int i =0 ; i < topItems.length ; i++) {
            String category = categories[i].getCategoryName();
            Item topItem = categories[i].getItems()[0];
            topItem.setCategory(category);
            topItems[i] = topItem;
        }
        return topItems;
    }

    private static void sort(Category[] categories, Comparator<Item> ratingCostRatio) {

        Arrays.stream(categories).forEach(category -> {
            Item[] items = category.getItems();
            Arrays.sort(items, ratingCostRatio);
        });
    }

    private static Comparator<Item> ratingCostRatioComparator() {
        return (item1, item2) -> {
            BigDecimal item1Ratio = CalculationUtility.ratioOf(item1.getRating(), item1.getTotalCost());
            BigDecimal item2Ratio = CalculationUtility.ratioOf(item2.getRating(), item2.getTotalCost());
           return item2Ratio.compareTo(item1Ratio);
        };
    }
}
