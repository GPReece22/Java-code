package Example;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MealSelectionController {
    public Button submitOrderButton;
    public Label choiceLabel;
    public ListView<ItemOnMenu> foodListView;
    public Button addStarterButton;
    public TextField nameTextField;
    public TextField priceTextField;
    public TextField caloriesTextField;
    public TextField descriptionTextField;
    public Button moreInfoButton;
    public Button backButton;
    private MyMenu starters;
    private MyMenu mains;
    private MyMenu desserts;
    private MyMenu drinks;
    private MyMenu extras;
    public MyMenu chosen;
    int course = 0;
    private static int option = 0;

    public void initialize() {
        starters = new MyMenu();
        starters.addFoodItem("Smoked Salmon", 1.6, 180, "Wild alaskan smoked " +
                "salmon served on a bed of iceberg lettuce with thousand island dressing");
        starters.addFoodItem("Pate", 2.5, 195, "aaa");
        starters.addFoodItem("Melon", 1., 98, "aaa");
        starters.addFoodItem("Ciabatta", 1.75, 102, "aaaa");

        mains = new MyMenu();
        mains.addFoodItem("Steak and Ale Pie", 7.5, 870, "aaa");
        mains.addFoodItem("Chicken Pie", 7, 780, "aaa");
        mains.addFoodItem("Fish and Chips", 6.5, 880, "aaa");
        mains.addFoodItem("Bangers and Mash", 6.5, 690, "aaa");
        mains.addFoodItem("Steak", 9.5, 680, "aaa");
        mains.addFoodItem("Fajitas", 7.5, 640, "aaa");

        desserts = new MyMenu();
        desserts.addFoodItem("Chocolate Fudge Cake", 1.5, 480, "aaa");
        desserts.addFoodItem("Sticky toffee pudding", 1.5, 560, "aaa");
        desserts.addFoodItem("Mousse", 1.5, 250, "aaa");

        drinks = new MyMenu();
        drinks.addFoodItem("Coke", 1, 100, "aaa");
        drinks.addFoodItem("San Miguel", 2, 260, "aaa");

        extras = new MyMenu();
        extras.addFoodItem("Chips", 1.5, 200, "aaa");
        extras.addFoodItem("Wedges", 1.75, 230, "aaa");

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

    public void submitMeal(ActionEvent actionEvent) {
        MenuController.updateOrder(chosen);
        ((Stage) submitOrderButton.getScene().getWindow()).close();
    }

    public void addFoodItem(ActionEvent actionEvent) {
        chooseFood();
        MenuController.updateOrder(chosen);
    }

    public void showMoreInfo(ActionEvent actionEvent) {
        int selectedIndex = foodListView.getSelectionModel().getSelectedIndex();
        getDescription(foodListView.getItems().get(selectedIndex));
    }

    public void back(ActionEvent actionEvent) {
        ((Stage) submitOrderButton.getScene().getWindow()).close();
    }

    private void setAllTextFields(ItemOnMenu i) {
        nameTextField.setText(i.getMealName());
        priceTextField.setText(String.valueOf(i.getMealCost()));
        caloriesTextField.setText(String.valueOf(i.getCalorificValue()));
    }

    private void clearAllTextFields() {
        nameTextField.clear();
        priceTextField.clear();
        caloriesTextField.clear();
    }

    private void add3course(){
        foodListView.setItems(starters);
        chooseFood();
        if (course == 1) {
            foodListView.getSelectionModel().clearSelection();
            choiceLabel.setText("Please choose a main course");
            foodListView.setItems(mains);
        }

        if (course == 2) {
            foodListView.getSelectionModel().clearSelection();
            choiceLabel.setText("Please choose a dessert course");
            foodListView.setItems(desserts);
        }

        if (course == 3) {
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
                course++;
                String name = nameTextField.getText();
                String tempPrice = priceTextField.getText();
                double price = Double.parseDouble(tempPrice);
                String tempCValue = caloriesTextField.getText();
                double calorificValue = Double.parseDouble(tempCValue);
                String description = descriptionTextField.getText();
                chosen.addFoodItem(name, price, calorificValue, description);
                clearAllTextFields();
                foodListView.setDisable(true);
                foodListView.setOpacity(0);
                addStarterButton.setDisable(true);
                addStarterButton.setOpacity(0);
                submitOrderButton.setDisable(false);
                submitOrderButton.setOpacity(1);
                choiceLabel.setText("Thank you :)");
            }
        }
    }

    public static void updateOption(int optionValue) {
        option = optionValue;
    }

    public void getDescription(ItemOnMenu i){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, i.getDescription(), ButtonType.OK);
        alert.showAndWait();
    }
}
