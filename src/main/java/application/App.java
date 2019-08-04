package application;

import generator.Categories;
import generator.CategoryGenerator;
import generator.Generatable;
import knapsack.Basket;
import knapsack.Result;
import model.Category;
import model.Item;
import util.Constants;

public class App {

    private App() {}

    public static void run() {

        Generatable<Category> categoryObjectGenerator = CategoryGenerator.createCategoryGenerator(Constants.NUMBER_OF_CATEGORIES
                ,Constants.NUMBER_OF_ITEMS);

        categoryObjectGenerator.generate();
        Category [] categories = categoryObjectGenerator.getObjects();
        Item[] items = Categories.getTopItemFromEachCategory(categories, Constants.NUMBER_OF_CATEGORIES);
        Basket basket = new Basket(items, Constants.MAX_TOTAL_COST);
        Result result = basket.fill();
        result.show();
    }
}
