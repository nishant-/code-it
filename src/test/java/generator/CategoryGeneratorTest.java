package generator;

import model.Category;
import org.junit.jupiter.api.Test;
import util.Constants;

import static org.junit.jupiter.api.Assertions.*;

class CategoryGeneratorTest {

    private static CategoryGenerator categoryCategoryGenerator;

    @Test
    public void GeneratingCategories_WithAGivenNumber_ResultsInTheGivenNumberOfCategories() {

        int numberOfCategories = 5;
        categoryCategoryGenerator = CategoryGenerator.createCategoryGenerator(5, 0);
        categoryCategoryGenerator.generate();
        Category[] categories = categoryCategoryGenerator.getObjects();

        assertTrue(categories.length==numberOfCategories);

    }

    @Test
    public void GeneratingCategories_WithGivenNumberOfItems_ProducesCategoriesWithGivenNumberOfItems() {

        categoryCategoryGenerator = CategoryGenerator.createCategoryGenerator(1, 10);

        categoryCategoryGenerator.generate();
        Category[] categories = categoryCategoryGenerator.getObjects();

        int itemSize = categories[0].getItems().length;

        assertEquals(itemSize, 10);
    }

    @Test
    public void GeneratingCategories_WithSpecifiedValuesInConfig_ProducesCategoriesAndItems() {

        categoryCategoryGenerator = CategoryGenerator.createCategoryGenerator(Constants.NUMBER_OF_CATEGORIES, Constants.NUMBER_OF_ITEMS);
        categoryCategoryGenerator.generate();
        Category[] categories = categoryCategoryGenerator.getObjects();

        int categorySize = categories.length;
        int numberOfItems = categories[0].getItems().length;

        assertTrue(categorySize == Constants.NUMBER_OF_CATEGORIES && numberOfItems == Constants.NUMBER_OF_ITEMS);
    }


}