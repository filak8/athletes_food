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
            Log.d("AAA", "Food Database; insert " + foods.get(i).getFoodName());
        }
    }

    private void creatingAListOfProducts() {
        foods = new ArrayList<>();

        createNewFood("Buckwheat", "Porridge", 137);
        createNewFood("Cornflakes", "Porridge", 372);
        createNewFood("Semolina", "Porridge", 77);
        createNewFood("Oatmeal", "Porridge", 93);
        createNewFood("Cereals", "Porridge", 358);
        createNewFood("Rice porridge", "Porridge", 79);
        createNewFood("Barley porridge", "Porridge", 102);
        createNewFood("Millet porridge", "Porridge", 92);

        createNewFood("Mutton", "Meat", 201);
        createNewFood("Beef", "Meat", 191);
        createNewFood("Horsemeat", "Meat", 149);
        createNewFood("Rabbit meat", "Meat", 197);
        createNewFood("Fat pork", "Meat", 484);
        createNewFood("Low-fat pork", "Meat", 318);
        createNewFood("Veal", "Meat", 91);
        createNewFood("Goose meat", "Meat", 359);
        createNewFood("Turkey meat", "Meat", 192);
        createNewFood("Chicken meat", "Meat", 190);
        createNewFood("Chicken breast", "Meat", 161);
        createNewFood("Duck meat", "Meat", 348);

        createNewFood("Kefir, 0%", "Milk products", 29);
        createNewFood("Kefir, 1%", "Milk products", 37);
        createNewFood("Kefir, 2,5%", "Milk products", 51);
        createNewFood("Kefir, 3,2%", "Milk products", 57);
        createNewFood("Milk, 0%", "Milk products", 34);
        createNewFood("Milk, 1%", "Milk products", 43);
        createNewFood("Milk, 2,5%", "Milk products", 53);
        createNewFood("Milk, 3,2%", "Milk products", 58);
        createNewFood("Cottage cheese, 0%", "Milk products", 89);
        createNewFood("Cottage cheese, 9%", "Milk products", 156);
        createNewFood("Cottage cheese, 18%", "Milk products", 236);

        createNewFood("Eggplant", "Vegetables", 22);
        createNewFood("Beans", "Vegetables", 59);
        createNewFood("Swede", "Vegetables", 38);
        createNewFood("Green peas", "Vegetables", 75);
        createNewFood("Zucchini", "Vegetables", 30);
        createNewFood("White cabbage", "Vegetables", 31);
        createNewFood("Cauliflower", "Vegetables", 30);
        createNewFood("Potatoes", "Vegetables", 80);
        createNewFood("Green onion", "Vegetables", 21);
        createNewFood("Onion", "Vegetables", 41);
        createNewFood("Carrot", "Vegetables", 29);
        createNewFood("Cucumber", "Vegetables", 10);
        createNewFood("Olives", "Vegetables", 111);
        createNewFood("Pepper", "Vegetables", 25);
        createNewFood("Parsley", "Vegetables", 45);
        createNewFood("Radish", "Vegetables", 22);
        createNewFood("Turnip", "Vegetables", 27);
        createNewFood("Salad", "Vegetables", 15);
        createNewFood("Beet", "Vegetables", 46);
        createNewFood("Tomato", "Vegetables", 15);
        createNewFood("Garlic", "Vegetables", 103);
        createNewFood("Spinach", "Vegetables", 22);
        createNewFood("Sorrel", "Vegetables", 29);

        createNewFood("Peanut", "Nuts", 555);
        createNewFood("Walnut", "Nuts", 662);
        createNewFood("Cashew nuts", "Nuts", 647);
        createNewFood("Almond", "Nuts", 643);
        createNewFood("Sunflower seed", "Nuts", 643);
        createNewFood("Pistachios", "Nuts", 555);
        createNewFood("Hazelnut", "Nuts", 701);

        createNewFood("Prunes", "Dried fruits", 262);
        createNewFood("Dates", "Dried fruits", 277);
        createNewFood("Dried apricots", "Dried fruits", 270);
        createNewFood("Raisins", "Dried fruits", 275);

        createNewFood("Pink salmon", "Sea foods", 151);
        createNewFood("Squid", "Sea foods", 77);
        createNewFood("Flounder", "Sea foods", 86);
        createNewFood("Crucian carp", "Sea foods", 84);
        createNewFood("Carp", "Sea foods", 95);
        createNewFood("Chum salmon", "Sea foods", 138);
        createNewFood("Sprat", "Sea foods", 142);
        createNewFood("Crab meat", "Sea foods", 67);
        createNewFood("Crab stiсks", "Sea foods", 73);
        createNewFood("Shrimp", "Sea foods", 85);
        createNewFood("Bream", "Sea foods", 109);
        createNewFood("Salmon", "Sea foods", 200);
        createNewFood("Mackerel", "Sea foods", 111);
        createNewFood("Mussels", "Sea foods", 53);
        createNewFood("Pollock", "Sea foods", 67);
        createNewFood("Burbot", "Sea foods", 85);
        createNewFood("Sea bass", "Sea foods", 123);
        createNewFood("River perch", "Sea foods", 80);
        createNewFood("Sturgeon", "Sea foods", 161);
        createNewFood("Octopus", "Sea foods", 74);
        createNewFood("Halibut", "Sea foods", 106);
        createNewFood("Roach", "Sea foods", 108);
        createNewFood("Crayfish", "Sea foods", 96);
        createNewFood("Herring", "Sea foods", 248);
        createNewFood("Zander", "Sea foods", 81);
        createNewFood("Cod", "Sea foods", 76);
        createNewFood("Tuna", "Sea foods", 95);
        createNewFood("Acne", "Sea foods", 331);
        createNewFood("Oyster", "Sea foods", 91);
        createNewFood("Trout", "Sea foods", 99);
        createNewFood("Hake", "Sea foods", 84);
        createNewFood("Pike", "Sea foods", 83);

        createNewFood("Apricots", "Fruits and berries", 44);
        createNewFood("Quince", "Fruits and berries", 37);
        createNewFood("Cherry plum", "Fruits and berries", 35);
        createNewFood("Pineapple", "Fruits and berries", 49);
        createNewFood("Oranges", "Fruits and berries", 38);
        createNewFood("Bananas", "Fruits and berries", 87);
        createNewFood("Cowberry", "Fruits and berries", 42);
        createNewFood("Grapes", "Fruits and berries", 73);
        createNewFood("Cherry", "Fruits and berries", 46);
        createNewFood("Garnet", "Fruits and berries", 53);
        createNewFood("Grapefruit", "Fruits and berries", 37);
        createNewFood("Pear", "Fruits and berries", 41);
        createNewFood("Blueberry", "Fruits and berries", 35);
        createNewFood("Melon", "Fruits and berries", 34);
        createNewFood("Blackberry", "Fruits and berries", 31);
        createNewFood("Wild strawberry", "Fruits and berries", 40);
        createNewFood("Figs", "Fruits and berries", 57);
        createNewFood("Kiwi", "Fruits and berries", 46);
        createNewFood("Strawberry", "Fruits and berries", 30);
        createNewFood("Cranberry", "Fruits and berries", 27);
        createNewFood("Gooseberry", "Fruits and berries", 43);
        createNewFood("Lemon", "Fruits and berries", 30);
        createNewFood("Raspberries", "Fruits and berries", 43);
        createNewFood("Mandarin", "Fruits and berries", 39);
        createNewFood("Mango", "Fruits and berries", 69);
        createNewFood("Sea buckthorn", "Fruits and berries", 31);
        createNewFood("Peach", "Fruits and berries", 42);
        createNewFood("Pomelo", "Fruits and berries", 29);
        createNewFood("Rowan", "Fruits and berries", 57);
        createNewFood("Plum", "Fruits and berries", 41);
        createNewFood("Currant", "Fruits and berries", 38);
        createNewFood("Persimmon", "Fruits and berries", 61);
        createNewFood("Cherries", "Fruits and berries", 54);
        createNewFood("Apple", "Fruits and berries", 48);

        createNewFood("Chicken egg", "Eggs", 153);
        createNewFood("Quail egg", "Eggs", 170);
        createNewFood("Ostrich egg", "Eggs", 118);
        createNewFood("Duck egg", "Eggs", 176);
        createNewFood("Egg powder", "Eggs", 545);

        insertFoodInDatabase(foods);
    }

    private void createNewFood(String foodName, String foodType, int kcal) {
        Food food = new Food();
        food.setFoodName(foodName);
        food.setFoodType(foodType);
        food.setKcal(kcal);
        foods.add(food);
    }
}
