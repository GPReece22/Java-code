package Example;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

abstract class ItemOnMenu implements Serializable {

    private String mealName;
    private double mealCost;
    private double calorificValue;
    private String description;
    private boolean vegetarian;

    Locale locale = new Locale("en", "GB");
    NumberFormat cf = NumberFormat.getCurrencyInstance(locale);

    public ItemOnMenu(){
    }

    public String getDescription() {
        return description;
    }

    public ItemOnMenu(String mName, double mCost, double cValue, String desc) {
        mealName = mName;
        mealCost = mCost;
        calorificValue = cValue;
        description = desc;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public double getMealCost() {
        return mealCost;
    }

    public void setMealCost(double mealCost) {
        this.mealCost = mealCost;
    }

    public double getCalorificValue() {
        return calorificValue;
    }

    public void setCalorificValue(double calorificValue) {
        this.calorificValue = calorificValue;
    }

    @Override
    public String toString() {
        return mealName + " - " + cf.format(mealCost) +
                "\ncalories: " + calorificValue;
    }
}
