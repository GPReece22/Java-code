package Example;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.collections.FXCollections;

public class MyMenu extends ObservableListWrapper<ItemOnMenu> {
    public MyMenu() {
        super(FXCollections.observableArrayList());
    }

    public void addFoodItem(String mealName, double mealCost, double calorificValue, String description, String kitchenNote) {
        super.add(new ItemOnMenu(mealName, mealCost, calorificValue, description, kitchenNote) {
        });
    }

    public double getTotalPrice(){
        double totalPrice = 0;
        for (ItemOnMenu i: MyMenu.this) {
            totalPrice += i.getMealCost();
        }
        return totalPrice;
    }
}