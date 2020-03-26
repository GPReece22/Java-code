package Example;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.collections.FXCollections;

public class MyMenu extends ObservableListWrapper<ItemOnMenu> {
    public MyMenu() {
        super(FXCollections.observableArrayList());
    }

    public void addFoodItem(String mealName, double mealCost, double calorificValue, String description) {
        super.add(new Starter(mealName, mealCost, calorificValue, description));
    }

    public double getTotalPrice(){
        double totalPrice = 0;

        for (ItemOnMenu i: MyMenu.this) {
            totalPrice += i.getMealCost();
        }

        return totalPrice;
    }
}