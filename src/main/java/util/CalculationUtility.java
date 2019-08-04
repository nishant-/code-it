package util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

public class CalculationUtility {


    public static BigDecimal ratioOf(int rating, int totalCost) {

        if (totalCost <= 0 || rating <= 0)
            throw new IllegalArgumentException(Constants.TOTAL_COST_OR_RATING_SHOULD_BE_GREATER_THAN_ZERO + ", rating =" +
                    "" + rating + ", totalCost = " + totalCost);

        return BigDecimal.valueOf(rating).divide(BigDecimal.valueOf(totalCost), Constants.SCALE, RoundingMode.FLOOR);
    }

    public static int randomIntegerBetween(int min, int max) {
        if (min > max)
            throw new IllegalArgumentException(Constants.MAX_MUST_BE_GRATER_THAN_MIN + " min = " + min + " max = " + max);
        if (min <= 0 || max <= 0)
            throw new IllegalArgumentException(Constants.VALUES_CANNOT_BE_ZERO_OR_LESS + " min = " + min + " ,max = " + max);

        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
