package knapsack;

import lombok.AllArgsConstructor;
import lombok.Data;
import model.Item;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Basket {

    private Item[] items;
    private int maxTotalCost;

    public Result fill() {

        int numberOfItems = items.length;
        int[][] table = new int[numberOfItems + 1][maxTotalCost + 1];

        setTableFirstRowToZero(table);
        populateTable(numberOfItems, table);

        List<Item> selectedItems = getSelectedItems(numberOfItems, table);

        return new Result(selectedItems, table[numberOfItems][maxTotalCost]);

    }

    private List<Item> getSelectedItems(int numberOfItems, int[][] table) {

        int finalRating = table[numberOfItems][maxTotalCost];
        int totalCost = maxTotalCost;

        List<Item> selectedItems = new ArrayList<>();

        for (int i = numberOfItems; i > 0 && finalRating > 0; i--) {
            if (finalRating != table[i - 1][totalCost]) {
                selectedItems.add(items[i - 1]);
                finalRating = finalRating - items[i - 1].getRating();
                totalCost = totalCost - items[i - 1].getTotalCost();
            }
        }
        return selectedItems;
    }

    /**
     * Populate the result table for each item according to the relation
     *           /------ T (i - 1, j) if Cost[i-1] > total cost
     * T(i,j) = /
     *           \-------- max { T (i - 1, j) , T (i - 1, j - Cost[i]) + v[i]}
     */
    private void populateTable(int numberOfItems, int[][] table) {
        for (int i = 1; i <= numberOfItems; i++) {
            for (int j = 0; j <= maxTotalCost; j++) {
                int pick0 = table[i - 1][j];
                if (items[i - 1].getTotalCost() > j) {
                    table[i][j] = pick0;
                } else {
                    int pick1 = table[i - 1][j - items[i - 1].getTotalCost()] + items[i - 1].getRating();
                    table[i][j] = Math.max(pick0, pick1);
                }
            }
        }
    }

    private void setTableFirstRowToZero(int[][] table) {
        for (int i = 0; i <= maxTotalCost; i++) {
            table[0][i] = 0;
        }
    }
}
