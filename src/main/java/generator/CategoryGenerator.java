package generator;

import lombok.Data;
import model.Category;
import model.Item;

import java.util.Arrays;

import static util.Constants.CATEGORY;

@Data
public class CategoryGenerator implements Generatable<Category> {

    private Category[] categories;
    private int numberOfCategories;
    private int numberOfItemsForEachCategory;

    private CategoryGenerator(int numberOfCategories, int numberOfItemsForEachCategory){
        this.numberOfCategories=numberOfCategories;
        this.numberOfItemsForEachCategory=numberOfItemsForEachCategory;
        this.categories = new Category[numberOfCategories];

    }

    public static CategoryGenerator createCategoryGenerator(int numberOfCategories, int numberOfItemsForEachCategory) {
        return new CategoryGenerator(numberOfCategories, numberOfItemsForEachCategory);
    }

    public void generate() {

        for (int i = 0; i < categories.length; i++) {
            Generatable<Item> itemObjectGenerator = ItemGenerator.createItemGenerator(numberOfItemsForEachCategory);
            String categoryName = CATEGORY.concat(Integer.toString(i + 1));
            itemObjectGenerator.generate();
            Item[] items = itemObjectGenerator.getObjects();
            Arrays.stream(items).forEach(item -> item.setCategory(categoryName));
            Category category = Category.builder().categoryName(categoryName)
                    .items(items).build();
            categories[i] = category;
        }
    }

    @Override
    public Category[] getObjects() {
       return this.getCategories();
    }
}
