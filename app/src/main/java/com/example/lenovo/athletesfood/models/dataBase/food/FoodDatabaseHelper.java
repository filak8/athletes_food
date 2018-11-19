package com.example.lenovo.athletesfood.models.dataBase.food;

import android.util.Log;

import com.example.lenovo.athletesfood.FoodAsyncTask;
import com.example.lenovo.athletesfood.models.constant.Constants;
import com.example.lenovo.athletesfood.models.dataBase.food.Food;

import java.util.ArrayList;

public class FoodDatabaseHelper {

    private ArrayList<Food> foods;

    public FoodDatabaseHelper() {
        creatingAListOfProducts();
    }

    private void insertFoodInDatabase(ArrayList<Food> foods) {
        for (int i = 0; i < foods.size(); i++) {
            new FoodAsyncTask(Constants.TASK_INSERT).execute(foods.get(i));
        }
    }

    private void creatingAListOfProducts() {
        foods = new ArrayList<>();

        createNewFood("Buckwheat", "Porridge", 137, 4.5f, 1.6f,
                27.4f);
        createNewFood("Cornflakes", "Porridge", 372, 6.5f, 2.9f,
                83.8f);
        createNewFood("Semolina", "Porridge", 77, 2.5f, 0.3f,
                16.4f);
        createNewFood("Oatmeal", "Porridge", 93, 3.2f, 1.8f,
                15.4f);
        createNewFood("Cereals", "Porridge", 358, 11.9f, 7.5f,
                69.1f);
        createNewFood("Rice porridge", "Porridge", 79, 1.5f,
                0.2f, 17.3f);
        createNewFood("Barley porridge", "Porridge", 102, 3.2f,
                0.5f, 22.7f);
        createNewFood("Millet porridge", "Porridge", 92, 3f,
                0.8f, 17.2f);

        createNewFood("Mutton", "Meat", 201, 16.2f, 15.3f,
                0f);
        createNewFood("Beef", "Meat", 191, 18.7f, 12.6f,
                0f);
        createNewFood("Horsemeat", "Meat", 149, 20.3f, 7.1f,
                0f);
        createNewFood("Rabbit meat", "Meat", 197, 20.6f, 12.8f,
                0f);
        createNewFood("Fat pork", "Meat", 484, 11.6f, 49.1f,
                0f);
        createNewFood("Low-fat pork", "Meat", 318, 16.3f, 27.9f,
                0f);
        createNewFood("Veal", "Meat", 91, 19.9f, 1.1f,
                0f);
        createNewFood("Goose meat", "Meat", 359, 16.4f, 33.1f,
                0f);
        createNewFood("Turkey meat", "Meat", 192, 21.1f, 12.3f,
                0.6f);
        createNewFood("Chicken meat", "Meat", 190, 20.4f, 8.6f,
                0.8f);
        createNewFood("Chicken breast", "Meat", 161, 31.0f,
                3.6f, 0f);
        createNewFood("Duck meat", "Meat", 348, 16.4f, 61.3f,
                0f);

        createNewFood("Kefir, 0%", "Milk products", 29, 2.8f,
                0f, 3.8f);
        createNewFood("Kefir, 1%", "Milk products", 37, 2.8f,
                1.0f, 4.0f);
        createNewFood("Kefir, 2,5%", "Milk products", 51, 3.0f,
                2.5f, 4.0f);
        createNewFood("Kefir, 3,2%", "Milk products", 57, 3.2f,
                3.2f, 4.1f);
        createNewFood("Milk, 0%", "Milk products", 34, 2.8f,
                0f, 4.6f);
        createNewFood("Milk, 1%", "Milk products", 43, 2.8f,
                1.0f, 4.6f);
        createNewFood("Milk, 2,5%", "Milk products", 53, 2.8f,
                2.5f, 4.6f);
        createNewFood("Milk, 3,2%", "Milk products", 58, 2.8f,
                3.2f, 4.6f);
        createNewFood("Cottage cheese, 0%", "Milk products", 89,
                18.2f, 0.6f ,1.8f);
        createNewFood("Cottage cheese, 9%", "Milk products", 156,
                16.5f ,9.0f, 1.9f);
        createNewFood("Cottage cheese, 18%", "Milk products", 236,
                14.0f, 18.0f, 1.9f);
        createNewFood("Cream, 10%", "Milk products", 121, 2.8f,
                10.0f, 4.1f);
        createNewFood("Cream, 20%", "Milk products", 209, 2.8f,
                20.0f, 3.9f);
        createNewFood("Sour cream, 10%", "Milk products", 118, 3.0f,
                10.0f, 2.9f);
        createNewFood("Sour cream, 15%", "Milk products", 163, 3.0f,
                15.0f, 2.9f);
        createNewFood("Sour cream, 20%", "Milk products", 208, 3.0f,
                20.0f, 2.9f);
        createNewFood("American cheese", "Milk products", 371, 18.0f,
                32.0f, 3.7f);
        createNewFood("Gouda", "Milk products", 356, 25.0f,
                27.0f, 2.2f);
        createNewFood("Blue cheeses", "Milk products", 353, 21.0f,
                29.0f, 2.3f);
        createNewFood("Gruyere", "Milk products", 413, 30.0f,
                32.0f, 0.4f);
        createNewFood("Camembert", "Milk products", 299, 20.0f,
                24.0f, 0.5f);
        createNewFood("Parmesan", "Milk products", 431, 38.0f,
                29.0f, 4.1f);
        createNewFood("Provolone", "Milk products", 352, 26.0f,
                27.0f, 2.1f);
        createNewFood("Roquefort", "Milk products", 369, 22.0f,
                31.0f, 2.0f);
        createNewFood("Cheddar", "Milk products", 402, 25.0f,
                33.0f, 1.3f);
        createNewFood("Mozzarella", "Milk products", 280, 28.0f,
                17.0f, 3.1f);
        createNewFood("Fontina", "Milk products", 389, 26.0f,
                31.0f, 1.6f);

        createNewFood("Eggplant", "Vegetables", 22, 0.6f, 0.1f,
                7.5f);
        createNewFood("Beans", "Vegetables", 59, 6.1f, 0.1f,
                8.1f);
        createNewFood("Swede", "Vegetables", 38, 1.2f, 0.1f,
                8.4f);
        createNewFood("Green peas", "Vegetables", 75, 5.4f,
                0.2f, 13.6f);
        createNewFood("Zucchini", "Vegetables", 30, 0.8f, 0.3f,
                5.9f);
        createNewFood("White cabbage", "Vegetables", 31, 1.9f,
                0f, 5.7f);
        createNewFood("Cauliflower", "Vegetables", 30, 2.7f, 0f,
                5.2f);
        createNewFood("Potatoes", "Vegetables", 80, 2.0f, 0.3f,
                16.5f);
        createNewFood("Green onion", "Vegetables", 21, 1.4f, 0f,
                4.2f);
        createNewFood("Onion", "Vegetables", 41, 1.6f, 0f,
                9.3f);
        createNewFood("Carrot", "Vegetables", 29, 1.3f, 0.1f,
                6.3f);
        createNewFood("Cucumber", "Vegetables", 10, 0.7f, 0f,
                3.1f);
        createNewFood("Olives", "Vegetables", 111, 0.6f, 10.2f,
                6.7f);
        createNewFood("Pepper", "Vegetables", 25, 1.2f, 0f,
                5.1f);
        createNewFood("Parsley", "Vegetables", 45, 3.8f, 0f,
                8.0f);
        createNewFood("Radish", "Vegetables", 22, 1.5f, 0f,
                4.2f);
        createNewFood("Turnip", "Vegetables", 27, 1.6f, 0f,
                5.8f);
        createNewFood("Salad", "Vegetables", 15, 1.6f, 0f,
                2.1f);
        createNewFood("Beet", "Vegetables", 46, 1.7f, 0f,
                10.5f);
        createNewFood("Tomato", "Vegetables", 15, 0.7f, 0f,
                3.2f);
        createNewFood("Garlic", "Vegetables", 103, 6.6f, 0f,
                21.1f);
        createNewFood("Spinach", "Vegetables", 22, 2.5f, 0f,
                2.6f);
        createNewFood("Sorrel", "Vegetables", 29, 1.6f, 0f,
                5.5f);

        createNewFood("Peanut", "Nuts", 555, 26.2f, 45.3f,
                9.9f);
        createNewFood("Walnut", "Nuts", 662, 13.5f, 61.5f,
                10.6f);
        createNewFood("Cashew nuts", "Nuts", 647, 25.8f, 54.3f,
                13.3f);
        createNewFood("Almond", "Nuts", 643, 18.3f, 57.9f,
                13.4f);
        createNewFood("Sunflower seed", "Nuts", 582, 20.9f,
                52.5f, 5.4f);
        createNewFood("Pistachios", "Nuts", 555, 20.0f, 50.5f,
                7.3f);
        createNewFood("Hazelnut", "Nuts", 701, 16.3f, 66.7f,
                9.8f);

        createNewFood("Prunes", "Dried fruits", 262, 2.7f, 0f,
                65.3f);
        createNewFood("Dates", "Dried fruits", 277, 2.5f, 0.4f,
                69.6f);
        createNewFood("Dried apricots", "Dried fruits", 270, 5.7f,
                0f, 65.3f);
        createNewFood("Raisins", "Dried fruits", 275, 1.7f, 0f,
                70.7f);

        createNewFood("Pink salmon", "Sea foods", 151, 21.2f,
                7.1f, 0f);
        createNewFood("Squid", "Sea foods", 77, 18.2f, 0.2f,
                0f);
        createNewFood("Flounder", "Sea foods", 86, 16.0f, 2.5f,
                0f);
        createNewFood("Crucian carp", "Sea foods", 84, 17.5f,
                1.6f, 0f);
        createNewFood("Carp", "Sea foods", 95, 16.0f, 3.5f,
                0f);
        createNewFood("Chum salmon", "Sea foods", 138, 22.1f,
                5.8f, 0f);
        createNewFood("Sprat", "Sea foods", 142, 14.3f, 9.2f,
                0f);
        createNewFood("Crab meat", "Sea foods", 67, 16.0f, 0.9f,
                0f);
        createNewFood("Crab stiсks", "Sea foods", 73, 17.9f,
                2.1f, 0f);
        createNewFood("Shrimp", "Sea foods", 85, 18.0f, 0.9f,
                0f);
        createNewFood("Bream", "Sea foods", 109, 17.2f, 4.2f,
                0f);
        createNewFood("Salmon", "Sea foods", 200, 19.2f, 13.8f,
                0f);
        createNewFood("Mackerel", "Sea foods", 111, 20.2f, 3.6f,
                0f);
        createNewFood("Mussels", "Sea foods", 53, 9.7f, 1.6f,
                0f);
        createNewFood("Pollock", "Sea foods", 67, 15.7f, 0.6f,
                0f);
        createNewFood("Burbot", "Sea foods", 85, 18.6f, 0.8f,
                0f);
        createNewFood("Sea bass", "Sea foods", 123, 17.4f,
                5.5f, 0f);
        createNewFood("River perch", "Sea foods", 80, 18.3f,
                0.7f, 0f);
        createNewFood("Sturgeon", "Sea foods", 161, 16.5f,
                10.5f, 0f);
        createNewFood("Octopus", "Sea foods", 74, 18.5f, 0f,
                0f);
        createNewFood("Halibut", "Sea foods", 106, 18.5f, 3.2f,
                0f);
        createNewFood("Roach", "Sea foods", 108, 18.5f, 0.4f,
                0f);
        createNewFood("Crayfish", "Sea foods", 96, 20.3f, 1.2f,
                1.1f);
        createNewFood("Herring", "Sea foods", 248, 17.3f,
                19.9f, 0f);
        createNewFood("Zander", "Sea foods", 81, 19.0f, 0.7f,
                0f);
        createNewFood("Cod", "Sea foods", 76, 17.7f, 0.5f,
                0f);
        createNewFood("Tuna", "Sea foods", 95, 21.7f, 1.3f,
                0f);
        createNewFood("Acne", "Sea foods", 331, 14.2f, 30.7f,
                9f);
        createNewFood("Oyster", "Sea foods", 91, 14.4f, 0.3f,
                6.2f);
        createNewFood("Trout", "Sea foods", 99, 19.6f, 2.1f,
                0f);
        createNewFood("Hake", "Sea foods", 84, 16.4f, 2.3f,
                0f);
        createNewFood("Pike", "Sea foods", 83, 18.2f, 0.8f,
                0f);

        createNewFood("Apricots", "Fruits and berries", 44, 0.7f,
                0f, 10.1f);
        createNewFood("Quince", "Fruits and berries", 37, 0.6f,
                0f, 8.7f);
        createNewFood("Cherry plum", "Fruits and berries", 35, 0.3f,
                0f, 7.6f);
        createNewFood("Pineapple", "Fruits and berries", 49, 0.3f,
                0f, 11.9f);
        createNewFood("Oranges", "Fruits and berries", 38, 0.8f,
                0f, 8.6f);
        createNewFood("Bananas", "Fruits and berries", 87, 1.7f,
                0f, 22.1f);
        createNewFood("Cowberry", "Fruits and berries", 42, 0.6f,
                0f, 8.8f);
        createNewFood("Grapes", "Fruits and berries", 73, 0.5f,
                0f, 17.8f);
        createNewFood("Cherry", "Fruits and berries", 46, 0.9f,
                0f, 11.1f);
        createNewFood("Garnet", "Fruits and berries", 53, 0.9f,
                0f, 11.9f);
        createNewFood("Grapefruit", "Fruits and berries", 37, 0.8f,
                0f,7.5f);
        createNewFood("Pear", "Fruits and berries", 41, 0.5f,
                0f, 10.6f);
        createNewFood("Blueberry", "Fruits and berries", 35, 1.1f,
                0f, 7.4f);
        createNewFood("Melon", "Fruits and berries", 34, 0.8f,
                0.3f, 7.3f);
        createNewFood("Blackberry", "Fruits and berries", 31, 1.9f,
                0f, 5.1f);
        createNewFood("Wild strawberry", "Fruits and berries", 40,
                1.9f, 0f, 7.1f);
        createNewFood("Figs", "Fruits and berries", 57, 0.9f,
                0f, 13.7f);
        createNewFood("Kiwi", "Fruits and berries", 46, 1.0f,
                0.7f, 9.7f);
        createNewFood("Strawberry", "Fruits and berries", 30, 0.6f,
                0.4f, 7.0f);
        createNewFood("Cranberry", "Fruits and berries", 27, 0.7f,
                0f, 4.9f);
        createNewFood("Gooseberry", "Fruits and berries", 43, 0.8f,
                0f, 9.7f);
        createNewFood("Lemon", "Fruits and berries", 30, 0.9f,
                0f, 3.3f);
        createNewFood("Raspberries", "Fruits and berries", 43, 0.7f,
                0f, 9.2f);
        createNewFood("Mandarin", "Fruits and berries", 39, 0.9f,
                0f, 8.8f);
        createNewFood("Mango", "Fruits and berries", 69, 0.6f,
                0.4f, 11.8f);
        createNewFood("Sea buckthorn", "Fruits and berries", 31,
                0.8f, 0f, 5.6f);
        createNewFood("Peach", "Fruits and berries", 42, 0.9f,
                0f, 10.1f);
        createNewFood("Pomelo", "Fruits and berries", 29, 0.6f,
                0.1f, 6.1f);
        createNewFood("Rowan", "Fruits and berries", 57, 1.6f,
                0f, 12.2f);
        createNewFood("Plum", "Fruits and berries", 41, 0.8f,
                0f, 9.7f);
        createNewFood("Currant", "Fruits and berries", 38, 0.6f,
                0f, 8.7f);
        createNewFood("Persimmon", "Fruits and berries", 61, 0.7f,
                0f, 15.7f);
        createNewFood("Cherries", "Fruits and berries", 54, 1.3f,
                0f, 12.5f);
        createNewFood("Apple", "Fruits and berries", 48, 0.5f,
                0f, 11.4f);

        createNewFood("Chicken egg", "Eggs", 153, 12.7f, 11.1f,
                0.6f);
        createNewFood("Quail egg", "Eggs", 170, 11.9f, 13.3f,
                0.8f);
        createNewFood("Ostrich egg", "Eggs", 118, 12.4f, 11.5f,
                0.8f);
        createNewFood("Duck egg", "Eggs", 176, 13.5f, 14.1f,
                0.2f);
        createNewFood("Egg powder", "Eggs", 545, 45.3f, 37.3f,
                5.1f);

        createNewFood("Brandy", "Alcoholic beverages", 225, 0f,
                0f,1.0f);
        createNewFood("Vermouth", "Alcoholic beverages", 155, 0f,
                0f,15.9f);
        createNewFood("Dry wine", "Alcoholic beverages", 66, 0f,
                0f,0f);
        createNewFood("Semi-dry wine", "Alcoholic beverages", 78,
                0.3f, 0f,2.5f);
        createNewFood("Semi-sweet wine", "Alcoholic beverages", 88,
                0.2f, 0f,5.0f);
        createNewFood("Dessert wine", "Alcoholic beverages", 175,
                0.5f, 0f,20.0f);
        createNewFood("Whiskey", "Alcoholic beverages", 222,
                0f, 0f,0f);
        createNewFood("Vodka", "Alcoholic beverages", 234,
                0f, 0f,0.1f);
        createNewFood("Gin", "Alcoholic beverages", 223,
                0f, 0f,0f);
        createNewFood("Cognac", "Alcoholic beverages", 240,
                0f, 0f,0.1f);
        createNewFood("Liquor", "Alcoholic beverages", 344,
                0f, 0f,53.0f);
        createNewFood("Light beer", "Alcoholic beverages", 45,
                0.8f, 0f,4.5f);
        createNewFood("Dark beer", "Alcoholic beverages", 39,
                0.2f, 0f,4.0f);
        createNewFood("Port wine", "Alcoholic beverages", 167,
                0f, 0f,13.8f);
        createNewFood("Rum", "Alcoholic beverages", 217,
                0f, 0f,0f);
        createNewFood("Champagne", "Alcoholic beverages", 88,
                0.3f, 0f,5.2f);

        createNewFood("Apricot juice", "Soft drinks", 39,
                0.9f, 0.2f,9.2f);
        createNewFood("Pineapple juice", "Soft drinks", 48,
                0.2f, 0.2f,11.4f);
        createNewFood("Orange juice", "Soft drinks", 36,
                0.9f, 0.1f,8.4f);
        createNewFood("Grape juice", "Soft drinks", 56,
                0.3f, 0f,14.5f);
        createNewFood("Cherry juice", "Soft drinks", 49,
                0.5f, 0f,10.6f);
        createNewFood("Pomegranate juice", "Soft drinks", 58,
                0.2f, 0f,14.0f);
        createNewFood("Milk cocoa", "Soft drinks", 377,
                24.0f, 17.0f,33.1f);
        createNewFood("Bread kvass", "Soft drinks", 26,
                0.2f, 0f,5.0f);
        createNewFood("Coca-cola", "Soft drinks", 42,
                0f, 0f,10.6f);
        createNewFood("Coffee with milk", "Soft drinks", 56,
                0.8f, 1.0f,11.0f);
        createNewFood("Lemonade", "Soft drinks", 377,
                24.0f, 17.0f,33.1f);
        createNewFood("Lemon juice", "Soft drinks", 18,
                1.0f, 0.1f,3.2f);
        createNewFood("Carrot juice", "Soft drinks", 31,
                1.0f, 0.1f,6.5f);
        createNewFood("Peach juice", "Soft drinks", 37,
                0.8f, 0.1f,9.1f);
        createNewFood("Apple juice", "Soft drinks", 42,
                0.5f, 0.4f,9.7f);
        createNewFood("Non-alcoholic beer", "Soft drinks", 22,
                0f, 0f,4.1f);
        createNewFood("Green tea", "Soft drinks", 0,
                0f, 0f,0f);
        createNewFood("Black tea", "Soft drinks", 0,
                0f, 0f,0f);

        createNewFood("Fresh white mushrooms", "Mushrooms", 32,
                3.3f, 1.5f,2.4f);
        createNewFood("Dried white mushrooms", "Mushrooms", 277,
                23.8f, 6.8f,30.2f);
        createNewFood("Fresh oyster mushrooms", "Mushrooms", 34,
                2.5f, 0.5f,6.2f);
        createNewFood("Fresh chanterelles", "Mushrooms", 22,
                1.5f, 1.0f,2.4f);
        createNewFood("Dried chanterelles", "Mushrooms", 268,
                22.0f, 7.2f,25.4f);
        createNewFood("Buttered fresh", "Mushrooms", 12,
                2.5f, 0.7f,1.5f);
        createNewFood("Boletus fresh", "Mushrooms", 30,
                2.1f, 1.2f,3.4f);
        createNewFood("Boletus dried", "Mushrooms", 231,
                23.3f, 9.5f,14.4f);
        createNewFood("Fresh aspen mushrooms", "Mushrooms", 31,
                3.3f, 0.4f,3.5f);
        createNewFood("Dried aspen mushrooms", "Mushrooms", 325,
                35.2f, 5.4f,33.0f);
        createNewFood("Fresh champignons", "Mushrooms", 29,
                4.3f, 0.9f,1.4f);

        createNewFood("Boiled sausage", "Sausages", 243,
                11.1f, 22.5f,0f);
        createNewFood("Half-smoked sausage", "Sausages", 428,
                17.6f, 39.1f,0f);
        createNewFood("Smoked sausage", "Sausages", 476,
                24.3f, 41.6f,0f);
        createNewFood("Hunting sausages", "Sausages", 325,
                27.1f, 24.6f,0f);
        createNewFood("Salami", "Sausages", 576,
                21.3f, 53.6f,1.1f);
        createNewFood("Beef sausages", "Sausages", 215,
                11.1f, 18.2f,1.6f);
        createNewFood("Pork sausages", "Sausages", 330,
                10.1f, 31.8f,1.7f);

        createNewFood("Chicken fat", "Butter, margarine, fats", 896,
                0f, 99.7f,0f);
        createNewFood("Pork fat", "Butter, margarine, fats", 882,
                0f, 99.5f,0f);
        createNewFood("Cream margarine", "Butter, margarine, fats", 746,
                0.5f, 82.3f,0f);
        createNewFood("Milk margarine", "Butter, margarine, fats", 744,
                0.5f, 82.0f,0.9f);
        createNewFood("Mayonnaise, 67%", "Butter, margarine, fats", 624,
                3.3f, 67.0f,2.4f);
        createNewFood("Olive oil", "Butter, margarine, fats", 898,
                0f, 99.8f,0f);
        createNewFood("Linseed oil", "Butter, margarine, fats", 898,
                0f, 99.8f,0f);
        createNewFood("Sunflower oil", "Butter, margarine, fats", 899,
                0f, 99.9f,0f);
        createNewFood("Butter, 82,5%", "Butter, margarine, fats", 747,
                0.5f, 82.5f,1.0f);

        createNewFood("Jam", "Sweets", 286,
                0.4f, 0.2f,74.5f);
        createNewFood("Waffles", "Sweets", 425,
                8.2f, 19.8f,53.1f);
        createNewFood("Hematogen", "Sweets", 352,
                6.2f, 2.8f,75.5f);
        createNewFood("Marshmallow", "Sweets", 295,
                0.7f, 0f,77.3f);
        createNewFood("Iris", "Sweets", 384,
                3.1f, 7.7f,81.2f);
        createNewFood("Caramel", "Sweets", 291,
                0f, 0.2f,77.3f);
        createNewFood("Chocolate candy", "Sweets", 576,
                3.9f, 39.7f,54.6f);
        createNewFood("Marmalade", "Sweets", 289,
                0f, 0.2f,77.1f);
        createNewFood("Honey", "Sweets", 312,
                0.6f, 0f,80.5f);
        createNewFood("Ice cream", "Sweets", 223,
                3.6f, 15.1f,20.5f);
        createNewFood("Paste", "Sweets", 301,
                0.6f, 0f,80.1f);
        createNewFood("Biscuit", "Sweets", 430,
                6.5f, 14.1f,71.4f);
        createNewFood("Puff pastry", "Sweets", 543,
                5.7f, 38.3f,46.8f);
        createNewFood("Biscuit cake", "Sweets", 338,
                4.9f, 9.1f,84.1f);
        createNewFood("Gingerbread", "Sweets", 333,
                4.4f, 2.9f,77.1f);
        createNewFood("Sugar", "Sweets", 377,
                0.2f, 0f,99.6f);
        createNewFood("Sunflower halva", "Sweets", 519,
                11.4f, 29.3f,54.6f);
        createNewFood("Dark chocolate", "Sweets", 546,
                5.2f, 35.6f,52.4f);
        createNewFood("Milk chocolate", "Sweets", 552,
                6.7f, 35.6f,52.4f);

        createNewFood("Bagel", "Bakery products", 342,
                16.4f, 1.1f,69.7f);
        createNewFood("Baton", "Bakery products", 261,
                9.4f, 2.7f,50.7f);
        createNewFood("Armenian pita bread", "Bakery products", 239,
                7.7f, 1.1f,47.8f);
        createNewFood("Wheat flour extra class", "Bakery products", 324,
                10.4f, 0.8f,74.5f);
        createNewFood("Wheat flour 1 gradle", "Bakery products", 329,
                10.6f, 1.4f,73.6f);
        createNewFood("Wheat flour 2 gradle", "Bakery products", 328,
                11.6f, 1.9f,70.7f);
        createNewFood("Rye flour", "Bakery products", 321,
                6.8f, 1.2f,76.8f);
        createNewFood("Rye bread", "Bakery products", 210,
                4.7f, 0.6f,49.5f);
        createNewFood("Wheat bread", "Bakery products", 246,
                7.4f, 2.2f,53.0f);

        createNewFood("Wheat bread", "Other", 246,
                7.4f, 2.2f,53.0f);

        insertFoodInDatabase(foods);
    }

    private void createNewFood(String foodName, String foodType, int kcal, float proteins, float fats, float carbohydrates ) {
        Food food = new Food();
        food.setFoodName(foodName);
        food.setFoodType(foodType);
        food.setKcal(kcal);
        food.setProteins(proteins);
        food.setFats(fats);
        food.setCarbohydrates(carbohydrates);
        foods.add(food);
    }
}
