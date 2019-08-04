package generator;

import model.Category;
import model.Item;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CategoriesTest {

    @Test
    public void Verify_ItemWithMaxRatingCostRatio_IsObtainedFromEachCategory() {

        Category category1 = new Category();
        Category category2 = new Category();

        Item item1 = new Item();
        item1.setTotalCost(10);
        item1.setRating(5); //ratio = 5/10 = 0.50

        Item item2 = new Item();
        item2.setTotalCost(20);
        item2.setRating(4); //ratio = 4/20 = 0.20

        Item item3 = new Item();
        item3.setTotalCost(15);
        item3.setRating(5); //ratio = 5/15 = 0.33

        category1.setItems(new Item[] {item2, item1}); // item1
        category2.setItems(new Item[] {item3, item2}); // item3

        Category [] arr = new Category[] {category1, category2};

        Item [] topItems = Categories.getTopItemFromEachCategory(arr, 2);

        assertTrue(topItems[0].getTotalCost() == 10 && topItems[1].getTotalCost() == 15);

    }

    @Test
    public void VerifyOnlyOneItemIsPickedFromEachCategory() {

     Item item1 = Item.builder().rating(5).totalCost(10).category("Category1").build();
     Item item2 = Item.builder().rating(3).totalCost(15).category("Category1").build();
     Item item3 = Item.builder().rating(4).totalCost(12).category("Category1").build();

     Item item4 = Item.builder().rating(5).totalCost(8).category("Category2").build();
     Item item5 = Item.builder().rating(1).totalCost(6).category("Category2").build();
     Item item6 = Item.builder().rating(4).totalCost(17).category("Category2").build();

     Category c1 = Category.builder().categoryName("Category1").items(new Item[]{item1,  item2, item3}).build();
     Category c2 = Category.builder().categoryName("Category2").items(new Item[]{item4,  item5, item6}).build();

     Category[] catArr = new Category[]{c1, c2};

     Item[] items = Categories.getTopItemFromEachCategory(catArr, 2);

     Item i1 = items[0];
     Item i2 = items[1];

     assertTrue(!i1.getCategory().equals(i2.getCategory()) && items.length == 2);


    }
}