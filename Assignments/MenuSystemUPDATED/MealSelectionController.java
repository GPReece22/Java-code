package Example;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MealSelectionController {
    public TextField nameTextField;
    public TextField priceTextField;
    public TextField caloriesTextField;
    public TextField descriptionTextField;
    public TextField kitchenNoteTextField;
    public Button addStarterButton;
    public Button moreInfoButton;
    public Button backButton;
    public Label choiceLabel;
    public ListView<ItemOnMenu> foodListView;

    private static MyMenu starters;
    private static MyMenu mains;
    private static MyMenu desserts;
    private static MyMenu drinks;
    private static MyMenu extras;
    private MyMenu chosen;
    private int course = 3;
    private static int option = 0;
    private boolean priceReduce = false;
    private double discountAmount = 1 - DISCOUNT;
    static final double DISCOUNT = 0.1;

    public void initialize() {
        chosen = new MyMenu();

        if (option == 1){
            foodListView.setItems(starters);
            choiceLabel.setText("Please choose a starter");
        }
        else if (option == 2){
            foodListView.setItems(mains);
            choiceLabel.setText("Please choose a main");
        }
        else if (option == 3){
            foodListView.setItems(desserts);
            choiceLabel.setText("Please choose a dessert");
        }
        else if (option == 4){
            foodListView.setItems(drinks);
            choiceLabel.setText("Please choose a drink");
        }
        else if (option == 5){
            foodListView.setItems(extras);
            choiceLabel.setText("Please choose an extra");
        }
        else if (option ==6){
            foodListView.setItems(starters);
            choiceLabel.setText("Please choose a starter");
            course = 0;
        }
    }

    void setParent(MenuController p) {
        MenuController parent = p;
    }

    public void selectItem(MouseEvent actionEvent) {
        ItemOnMenu selectedItem = foodListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            setAllTextFields(selectedItem);
        }
    }

    public void addFoodItem(ActionEvent actionEvent) {
        if (option == 6){
            course++;
            add3course();
        }
        else {
            chooseFood();
        }
    }

    public void showMoreInfo(ActionEvent actionEvent) {
        int selectedIndex = foodListView.getSelectionModel().getSelectedIndex();
        getDescription(foodListView.getItems().get(selectedIndex));
    }

    public void back(ActionEvent actionEvent) {
        ((Stage) backButton.getScene().getWindow()).close();
    }

    private void setAllTextFields(ItemOnMenu i) {
        nameTextField.setText(i.getMealName());
        priceTextField.setText(String.valueOf(i.getMealCost()));
        caloriesTextField.setText(String.valueOf(i.getCalorificValue()));
        descriptionTextField.setText(i.getDescription());
        kitchenNoteTextField.setText(i.getKitchenNote());
    }

    private void add3course(){
        priceReduce = true;
        if (course == 1) {
            chooseFood();
            foodListView.getSelectionModel().clearSelection();
            choiceLabel.setText("Please choose a main course");
            foodListView.setItems(mains);
        }

        if (course == 2) {
            chooseFood();
            foodListView.getSelectionModel().clearSelection();
            choiceLabel.setText("Please choose a dessert course");
            foodListView.setItems(desserts);
        }

        if (course == 3) {
            chooseFood();
            foodListView.getSelectionModel().clearSelection();
        }
    }

    private void chooseFood(){
        int selectedIndex = foodListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex == -1) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select an item", ButtonType.OK);
            alert.showAndWait();
        } else {
            ItemOnMenu toGo = foodListView.getItems().get(selectedIndex);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Would you like to add: \n" + toGo + " ?",
                    ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                String name = nameTextField.getText();
                String tempPrice = priceTextField.getText();
                double price = Double.parseDouble(tempPrice);
                String tempCValue = caloriesTextField.getText();
                double calorificValue = Double.parseDouble(tempCValue);
                String description = descriptionTextField.getText();
                String kitchenNote = kitchenNoteTextField.getText();
                if (priceReduce){
                    price = price * discountAmount;
                    kitchenNote = "Discount Applied";
                }
                chosen.addFoodItem(name, price, calorificValue, description, kitchenNote);
                if (course == 3) {
                    ((Stage) backButton.getScene().getWindow()).close();
                    MenuController.updateOrder(chosen);
                }
            }
        }
    }

    public static void updateOption(int optionValue) {
        option = optionValue;
    }

    public static void getDescription(ItemOnMenu i){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Label description = new Label(i.getDescription());
        alert.getDialogPane().setContent(description);
        alert.showAndWait();
    }

    public static void updateMenus(MyMenu updatedStarters, MyMenu updatedMains, MyMenu updatedDesserts, MyMenu updatedDrinks, MyMenu updatedExtras){
        starters = updatedStarters;
        mains = updatedMains;
        desserts = updatedDesserts;
        drinks = updatedDrinks;
        extras = updatedExtras;
    }

    public static void setMenus(MyMenu Starters, MyMenu Mains, MyMenu Desserts, MyMenu Drinks, MyMenu Extras){
        starters = Starters;
        mains = Mains;
        desserts = Desserts;
        drinks = Drinks;
        extras = Extras;
    }

    public static void addStarter(String name, double price, double calories, String description, String kitchenNote){
        starters.addFoodItem(name, price, calories, description, kitchenNote);
    }
}
