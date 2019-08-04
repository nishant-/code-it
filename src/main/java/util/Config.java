package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

final class Config {


     static int NUMBER_OF_CATEGORIES;
     static int NUMBER_OF_ITEMS;
     static int MIN_ITEM_PRICE;
     static int MAX_ITEM_PRICE;
     static int MIN_SHIPPING_COST;
     static int MAX_SHIPPING_COST;
     static int MAX_RATING;
     static int MIN_RATING;
     static int MAX_TOTAL_COST;

    private Config() {}

    static Properties prop = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            prop.load(fis);
        } catch (FileNotFoundException e) {
            System.out.println(" Config file not found, exiting application");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("IO Exception occurred, " + e);
            System.exit(1);
        }
       getConfigValues();
    }
    public static String getProperty(String key) {
        return prop.getProperty(key);
    }


    private static void getConfigValues() {
        try {
            getIntValues();
        }
        catch (NumberFormatException nfe) {
            System.out.println("Exception occurred while reading configuration values from config.properties file.\nVerify all " +
                    "required values have been assigned correctly as described in the properties file.\n" +
                    "Exiting current application");
            System.exit(1);
        }
    }

    private static void getIntValues() {
        NUMBER_OF_CATEGORIES = Integer.parseInt(getProperty("number.of.categories"));
        NUMBER_OF_ITEMS = Integer.parseInt(getProperty("number.of.items"));
        MIN_ITEM_PRICE = Integer.parseInt(getProperty("min.item.price"));
        MAX_ITEM_PRICE = Integer.parseInt(getProperty("max.item.price"));
        MIN_SHIPPING_COST = Integer.parseInt(getProperty("min.shipping.cost"));
        MAX_SHIPPING_COST = Integer.parseInt(getProperty("max.shipping.cost"));
        MAX_RATING = Integer.parseInt(getProperty("max.rating"));
        MIN_RATING = Integer.parseInt(getProperty("min.rating"));
        MAX_TOTAL_COST = Integer.parseInt(getProperty("max.total.cost"));
    }


}