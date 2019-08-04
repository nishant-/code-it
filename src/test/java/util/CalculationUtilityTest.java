package util;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CalculationUtilityTest {

    @Test
    void calculatingRatio_withValueOfZero_ResultsInException() {

        int rating = 0;
        int totalCost = 5;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculationUtility.ratioOf(rating, totalCost);
        });
        assertEquals("Total cost must not be negative or zero"+  ", rating =" +
                "" + rating + ", totalCost = "+totalCost, exception.getMessage());
    }

    @Test
    void calculatingRatio_withANegativeValue_ResultsInException() {

        int rating = 5;
        int totalCost = -5;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculationUtility.ratioOf(rating, totalCost);
        });
        assertEquals("Total cost must not be negative or zero"+  ", rating =" +
                "" + rating + ", totalCost = "+totalCost, exception.getMessage());
    }

    @Test
    public void generatingRandomInteger_withMinValueGreaterThanMaxValue_ResultsInException() {

        int min = 5;
        int max = 3;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculationUtility.randomIntegerBetween(min,max);
        });

        assertEquals("Max must be grater than min, " + " min = "+ min + " max = " + max,
                exception.getMessage());

    }

    @Test
    public void GeneratingRandomInteger_WithZeroMinValue_ResultsInException() {

        int min = 0;
        int max = 10;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculationUtility.randomIntegerBetween(min, max);
        });

        assertEquals("Minimum or maximum values cannot be zero or less," + " min = "+ min + " ,max = " + max,
                exception.getMessage());
    }

    @Test
    public void GeneratingRandomInteger_BetweenGivenRange_ProducesAnIntegerBetweenThatRange() {

        int min = 1;
        int max = 20;

        int result = CalculationUtility.randomIntegerBetween(min,max);
        assertTrue((min <= result) && (result <= max));

    }

    @Test
    public void CalculatingRatio_WithValidInputs_ResultsInANonZeroValue() {

        int rating = 5;
        int totalCost = 10;

        BigDecimal result = CalculationUtility.ratioOf(rating,totalCost);
        assertTrue(result.compareTo(BigDecimal.ZERO) > 0);



    }

}