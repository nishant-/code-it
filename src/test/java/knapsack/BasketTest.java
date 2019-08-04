package knapsack;

import model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

class BasketTest {

    @Test
    public void FillBasket_WithGivenItemsAllHavingMaxCost_ResultsInOneItemWithMaxRating() {

        Item [] items = new Item[20];
        for(int i = 0; i < items.length ; i++) {

            items[i] = Item.builder().totalCost(50)
                    .rating(((i + 1) % 5) + 1)
                    .category("Category".concat(Integer.toString(i + 1)))
                    .build();
        }

        Basket basket = new Basket(items, 50);
        Result r = basket.fill();
        List<Item> listOfItems = r.getItems();
        Item anItem = listOfItems.get(0);

        Assertions.assertTrue(listOfItems.size() == 1);
        Assertions.assertTrue((anItem.getTotalCost() == 50 && anItem.getRating() == 5));
    }

    @Test
    public void FillingBasket_WithGivenItemsAndMaxCost_GivesItemsWithSumOfTotalCostLessThnGvnCstAndSumOfRtngsMxmsd () {

        int maxTotalCost = 20;

        Item item1 = Item.builder().totalCost(7).rating(4).build();
        Item item2 = Item.builder().totalCost(6).rating(5).build();
        Item item3 = Item.builder().totalCost(12).rating(2).build();

        /**
         *  1 cost = 7, rating = 4
         *  2 cost = 6, rating = 5
         *  3 cost = 12, rating = 2
         *
         *  max cost = 20
         *
         *  optimum combination will be
         *  (1 + 2 + 3) : (tc = 25, r = 11) => no
         *  (1 + 2)     : (tc = 13, r = 9)  => yes
         *  (1 + 3)     : (tc = 19, r = 6)  => no
         *  (2 + 3)     : (tc = 18, r = 7)  => no
         *
         *  combination ( 1 + 2) is the optimum => max rating and total cost under 20
         *
         */

        Item [] items = new Item[]{item1, item2, item3};

        Basket basket = new Basket(items, maxTotalCost);

        Result result = basket.fill();

        List<Item> listOfItems = result.getItems();

        int totalCost = listOfItems.stream().collect(Collectors.summingInt(Item::getTotalCost));
        int rating = result.getOptimumRating();

        Assertions.assertTrue(totalCost == 13 && rating == 9);
    }

}