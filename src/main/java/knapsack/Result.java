package knapsack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Item;
import util.Constants;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private List<Item> items;
    private int optimumRating;

    public void show(){
        this.getItems().forEach(System.out::println);
        System.out.println();
        int totalCost = getItems().stream().collect(Collectors.summingInt(Item::getTotalCost));
        System.out.println("Total cost of items picked = " + Constants.CURRENCY_SYMBOL + totalCost);
        System.out.println("Sum of ratings of items picked = "+ Constants.CURRENCY_SYMBOL +getOptimumRating());
    }
}
