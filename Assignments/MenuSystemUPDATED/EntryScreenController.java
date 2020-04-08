package Example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class EntryScreenController extends Application {
    public TextField tableNoTextField;
    public TextField noDiningTextField;
    public Button enterButton;
    public Button updateButton;
    public Button ownerButton;
    public Label maxDinersNumberLabel;
    public Label maxTableNumberLabel;

    public int tableNumber;
    public int numberDining;
    public static int maxTableNumber = 10;
    public static int maxDinersPerTable = 5;
    private static MyMenu starters;
    private static MyMenu mains;
    private static MyMenu desserts;
    private static MyMenu drinks;
    private static MyMenu extras;


    public void initialize(){
        maxTableNumberLabel.setText("1 - " + maxTableNumber);
        maxDinersNumberLabel.setText("1 - " + maxDinersPerTable);
    }

    public void startMenu(ActionEvent actionEvent) throws IOException {
        if (tableNoTextField.getText().equals("") || noDiningTextField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter a table number and number of customers dining",
                    ButtonType.OK);
            alert.showAndWait();
        }
        else {
            try {
                String tempTableNumber = tableNoTextField.getText();
                tableNumber = Integer.parseInt(tempTableNumber);
                String tempNumberDining = noDiningTextField.getText();
                numberDining = Integer.parseInt(tempNumberDining);
                if (tableNumber <= maxTableNumber && tableNumber >= 1 && numberDining <= maxDinersPerTable && numberDining >= 1) {
                    MenuController.updateNumberDining(numberDining);
                    MenuController.updateTableNumber(tableNumber);
                    tableNoTextField.clear();
                    noDiningTextField.clear();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
                    Scene MenuScene = new Scene(loader.load());
                    MenuController controller = loader.getController();
                    controller.setParent(EntryScreenController.this);
                    Stage inputStage = new Stage();
                    inputStage.setScene(MenuScene);
                    inputStage.initModality(Modality.APPLICATION_MODAL);
                    inputStage.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter valid shit",
                            ButtonType.OK);
                    alert.showAndWait();
                }
            }
            catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter valid shit",
                        ButtonType.OK);
                alert.showAndWait();
            }
        }
    }

    @Override
    public void start(Stage menuStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("entryScreen.fxml"));
        menuStage.setTitle("Example Menu");
        menuStage.setScene(new Scene(root, 400, 200));
        menuStage.show();
    }

    public static void main(String[] args) {
        starters = new MyMenu();
        starters.addFoodItem("Smoked Salmon", 1.6, 180, "Wild alaskan smoked " +
                "salmon served on a bed of iceberg lettuce with thousand island dressing", "");
        starters.addFoodItem("Pate", 2.5, 195, "aaa", "");
        starters.addFoodItem("Melon", 1., 98, "aaa", "");
        starters.addFoodItem("Ciabatta", 1.75, 102, "aaaa", "");

        mains = new MyMenu();
        mains.addFoodItem("Steak and Ale Pie", 7.5, 870, "aaa", "");
        mains.addFoodItem("Chicken Pie", 7, 780, "aaa", "");
        mains.addFoodItem("Fish and Chips", 6.5, 880, "aaa", "");
        mains.addFoodItem("Bangers and Mash", 6.5, 690, "aaa", "");
        mains.addFoodItem("Steak", 9.5, 680, "aaa", "");
        mains.addFoodItem("Fajitas", 7.5, 640, "aaa", "");

        desserts = new MyMenu();
        desserts.addFoodItem("Chocolate Fudge Cake", 1.5, 480, "aaa", "");
        desserts.addFoodItem("Sticky toffee pudding", 1.5, 560, "aaa", "");
        desserts.addFoodItem("Mousse", 1.5, 250, "aaa", "");

        drinks = new MyMenu();
        drinks.addFoodItem("Coke", 1, 100, "aaa", "");
        drinks.addFoodItem("San Miguel", 2, 260, "aaa", "");

        extras = new MyMenu();
        extras.addFoodItem("Chips", 1.5, 200, "aaa", "");
        extras.addFoodItem("Wedges", 1.75, 230, "aaa", "");

        MealSelectionController.setMenus(starters, mains, desserts, drinks, extras);
        EditMenuController.setEditingMenus(starters, mains, desserts, drinks, extras);

        launch(args);
    }

    public void ownerOptions(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ownerOptions.fxml"));
        Scene OwnerOptionsScene = new Scene(loader.load());
        OwnerOptionsController controller = loader.getController();
        controller.setParent(EntryScreenController.this);
        Stage inputStage = new Stage();
        inputStage.setScene(OwnerOptionsScene);
        inputStage.initModality(Modality.APPLICATION_MODAL);
        inputStage.show();
        EditRestaurantController.setMaxTables(maxTableNumber);
        EditRestaurantController.setCurrentMaxDinersPerTable(maxDinersPerTable);
    }

    public static void setMaxTables(int maxTableValue) {
        maxTableNumber = maxTableValue;
    }

    public static void setCurrentMaxDinersPerTable(int maxDinersValue) {
        maxDinersPerTable = maxDinersValue;
    }

    public void updateLabels(){
        maxTableNumberLabel.setText("1 - " + maxTableNumber);
        maxDinersNumberLabel.setText("1 - " + maxDinersPerTable);
    }
}