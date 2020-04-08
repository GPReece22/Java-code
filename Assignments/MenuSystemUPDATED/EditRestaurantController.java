package Example;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class EditRestaurantController {
    public Button editDinersButton;
    public Button editTablesButton;
    public Button submitButton;
    public Button doneButton;
    public Label currentValueLabel;
    public TextField newValueTF;

    public static int maxDinersPerTable;
    public static int maxTables;
    public int option = 0;

    public void setParent(OwnerOptionsController p) {
        OwnerOptionsController parent = p;
    }

    public void editDiners(ActionEvent actionEvent) {
        option = 1;
        goToInput();
        currentValueLabel.setText("Current value: " + maxDinersPerTable);
    }

    public void editTables(ActionEvent actionEvent) {
        option = 2;
        goToInput();
        currentValueLabel.setText("Current value: " + maxTables);
    }

    public void submitChanges(ActionEvent actionEvent) {
        if (newValueTF.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter a table number and number of customers dining",
                    ButtonType.OK);
            alert.showAndWait();
        }
        else {
            try {
                String tempString = newValueTF.getText();
                int newValue = Integer.parseInt(tempString);
                if (option == 1) {
                    maxDinersPerTable = newValue;
                    EntryScreenController.setCurrentMaxDinersPerTable(newValue);
                } else if (option == 2) {
                    maxTables = newValue;
                    EntryScreenController.setMaxTables(newValue);
                }
                newValueTF.setText("");
                goToOptions();
            }
            catch(NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter valid shit",
                        ButtonType.OK);
                alert.showAndWait();
            }
        }
    }

    public void done(ActionEvent actionEvent) {
        ((Stage)doneButton.getScene().getWindow()).close();
    }

    public void goToInput(){
        currentValueLabel.setDisable(false);
        currentValueLabel.setOpacity(1);
        editDinersButton.setDisable(true);
        editDinersButton.setOpacity(0);
        editTablesButton.setDisable(true);
        editTablesButton.setOpacity(0);
        doneButton.setDisable(true);
        doneButton.setOpacity(0);
        newValueTF.setDisable(false);
        newValueTF.setOpacity(1);
        newValueTF.setDisable(false);
        newValueTF.setOpacity(1);
        submitButton.setDisable(false);
        submitButton.setOpacity(1);
    }

    public void goToOptions(){
        currentValueLabel.setDisable(true);
        currentValueLabel.setOpacity(0);
        editDinersButton.setDisable(false);
        editDinersButton.setOpacity(1);
        editTablesButton.setDisable(false);
        editTablesButton.setOpacity(1);
        doneButton.setDisable(false);
        doneButton.setOpacity(1);
        newValueTF.setDisable(true);
        newValueTF.setOpacity(0);
        newValueTF.setDisable(true);
        newValueTF.setOpacity(0);
        submitButton.setDisable(true);
        submitButton.setOpacity(0);
    }

    public static void setMaxTables(int maxTableValue) {
        maxTables = maxTableValue;
    }

    public static void setCurrentMaxDinersPerTable(int maxDinersValue) {
        maxDinersPerTable = maxDinersValue;
    }
}
