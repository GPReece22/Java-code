package Example;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EditMenuController {
    public TextField itemNameTF;
    public TextField itemPriceTF;
    public TextField itemCalorieTF;
    public TextField itemDescriptionTF;
    public Button addButton;
    public Button removeButton;
    public Button starterButton;
    public Button mainButton;
    public Button dessertButton;
    public Button drinkButton;
    public Button extraButton;
    public Button submitChangesButton;
    public ListView<ItemOnMenu> menuItemList;

    public static MyMenu newStarters;
    public static MyMenu newMains;
    public static MyMenu newDesserts;
    public static MyMenu newDrinks;
    public static MyMenu newExtras;
    public int menu = 0;

    public void setParent(OwnerOptionsController p) {
        OwnerOptionsController parent = p;
    }

    public void addItem(ActionEvent actionEvent) {
        String name = itemNameTF.getText();
        String tempPrice = itemPriceTF.getText();
        double price = Double.parseDouble(tempPrice);
        String tempCValue = itemCalorieTF.getText();
        double calorificValue = Double.parseDouble(tempCValue);
        String description = itemDescriptionTF.getText();
        if (name.equals("") | price == 0 | calorificValue == 0 | description.equals("") ) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter a value for all fields", ButtonType.OK);
            alert.showAndWait();
        }
        else{
            if (menu == 1) {
                MealSelectionController.addStarter(name, price, calorificValue, description, "");
            }
            if (menu == 2) {
                newMains.addFoodItem(name, price, calorificValue, description, "");
            }
            if (menu == 3) {
                newDesserts.addFoodItem(name, price, calorificValue, description, "");
            }
            if (menu == 4) {
                newDrinks.addFoodItem(name, price, calorificValue, description, "");
            }
            if (menu == 5) {
                newExtras.addFoodItem(name, price, calorificValue, description, "");
            }
        }
    }

    public void removeItem(ActionEvent actionEvent) {
        int selectedIndex = menuItemList.getSelectionModel().getSelectedIndex();
        if (selectedIndex == -1) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Select a food item", ButtonType.OK);
            alert.showAndWait();
        }
        else {
            ItemOnMenu toGo = menuItemList.getItems().get(selectedIndex);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to remove:\n" + toGo + " ?",
                    ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                if (menu == 1) {
                    newStarters.removeItem(toGo.getMealName());
                }
                if (menu == 2) {
                    newMains.removeItem(toGo.getMealName());
                }
                if (menu == 3) {
                    newDesserts.removeItem(toGo.getMealName());
                }
                if (menu == 4) {
                    newDrinks.removeItem(toGo.getMealName());
                }
                if (menu == 5) {
                    newExtras.removeItem(toGo.getMealName());
                }
                clearAllTextFields();
                menuItemList.getSelectionModel().clearSelection();
            }
        }
    }

    public void showStarters(ActionEvent actionEvent) {
        menu = 1;
        menuItemList.setItems(newStarters);
    }

    public void showMains(ActionEvent actionEvent) {
        menu = 2;
        menuItemList.setItems(newMains);
    }

    public void showDesserts(ActionEvent actionEvent) {
        menu = 3;
        menuItemList.setItems(newDesserts);
    }

    public void showDrinks(ActionEvent actionEvent) {
        menu = 4;
        menuItemList.setItems(newDrinks);
    }

    public void showExtras(ActionEvent actionEvent) {
        menu = 5;
        menuItemList.setItems(newExtras);
    }

    public static void setEditingMenus(MyMenu Starters, MyMenu Mains, MyMenu Desserts, MyMenu Drinks, MyMenu Extras){
        newStarters = Starters;
        newMains = Mains;
        newDesserts = Desserts;
        newDrinks = Drinks;
        newExtras = Extras;
    }

    public void selectItem(MouseEvent mouseEvent) {
        ItemOnMenu selectedItem = menuItemList.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            setAllTextFields(selectedItem);
        }
    }

    private void setAllTextFields(ItemOnMenu i) {
        itemNameTF.setText(i.getMealName());
        itemPriceTF.setText(String.valueOf(i.getMealCost()));
        itemCalorieTF.setText(String.valueOf(i.getCalorificValue()));
        itemDescriptionTF.setText(i.getDescription());
    }

    private void clearAllTextFields(){
        itemNameTF.setText("");
        itemPriceTF.setText("");
        itemCalorieTF.setText("");
        itemDescriptionTF.setText("");
    }

    public void submitChanges(ActionEvent actionEvent) {
        MealSelectionController.updateMenus(newStarters, newMains, newDesserts, newDrinks, newExtras);
        ((Stage) submitChangesButton.getScene().getWindow()).close();
    }
}
