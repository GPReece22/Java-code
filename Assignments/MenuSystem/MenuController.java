package Example;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class MenuController {
    public Button doneButton;
    public Button mealButton;
    public Button extrasButton;
    public ListView<ItemOnMenu> chosenList;
    private static MyMenu order;
    private static int tableNumber;
    private static int noOfDiners;
    public Button viewOrderButton;
    public Label infoLabel;
    public Button drinksButton;
    public Button starterButton;
    public Button mainButton;
    public Button dessertButton;


    public void setParent(EntryScreenController p) {
        EntryScreenController parent = p;
    }

    public void initialize() {
        order = new MyMenu();
        chosenList.setItems(order);
        infoLabel.setText("Table Number: " + tableNumber + "   Number of diners: " + noOfDiners);
    }

    public void viewOrder(ActionEvent actionEvent) {
        chosenList.setItems(order);
    }

    public void done(ActionEvent actionEvent) throws IOException {
        if (order.getTotalPrice() != 0) {
            ReceiptController.updateReceipt(order);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("receipt.fxml"));
            Scene receiptScene = new Scene(loader.load());
            ReceiptController controller = loader.getController();
            controller.setParent(MenuController.this);

            Stage inputStage = new Stage();
            inputStage.setScene(receiptScene);
            inputStage.initModality(Modality.APPLICATION_MODAL);
            inputStage.show();
            ((Stage) extrasButton.getScene().getWindow()).close();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please order some food before checking out", ButtonType.OK);
            alert.showAndWait();
        }
    }

    public void addMeal(ActionEvent actionEvent) throws IOException {
        launchMealSelection();
        MealSelectionController.updateOption(99);
    }

    public void addStarter(ActionEvent actionEvent) throws IOException {
        MealSelectionController.updateOption(1);
        launchMealSelection();
    }

    public void addMain(ActionEvent actionEvent) throws IOException {
        MealSelectionController.updateOption(2);
        launchMealSelection();
    }

    public void addDessert(ActionEvent actionEvent) throws IOException {
        MealSelectionController.updateOption(3);
        launchMealSelection();
    }

    public void addDrink(ActionEvent actionEvent) throws IOException {
        MealSelectionController.updateOption(4);
        launchMealSelection();
    }

    public void addExtras(ActionEvent actionEvent) throws IOException {
        MealSelectionController.updateOption(5);
        launchMealSelection();
    }

    public void launchMealSelection() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mealSelection.fxml"));
        Scene mealSelectionScene = new Scene(loader.load());
        MealSelectionController controller = loader.getController();
        controller.setParent(MenuController.this);

        Stage inputStage = new Stage();
        inputStage.setScene(mealSelectionScene);
        inputStage.initModality(Modality.APPLICATION_MODAL);
        inputStage.show();
    }

    public static void updateTableNumber(int tableValue) {
        MenuController.tableNumber = tableValue;
    }

    public static void updateNumberDining(int NumberDiningValue) {
        MenuController.noOfDiners = NumberDiningValue;
    }

    public static void updateOrder(MyMenu storedValue) {
        MenuController.order.addAll(storedValue);
    }
}
