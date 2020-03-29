package Example;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class OwnerOptionsController {

    public Button setNoOfTablesButton;
    public Button editMenuButton;
    public Button doneButton;
    public Label passwordLabel;
    public TextField passwordTF;
    public Button enterButton;
    final static String password = "password";

    public void setParent(EntryScreenController p) {
        EntryScreenController parent = p;
    }

    public void setNoOfTables(ActionEvent actionEvent) {
    }

    public void editMenu(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("editMenu.fxml"));
        Scene EditMenuScene = new Scene(loader.load());
        EditMenuController controller = loader.getController();
        controller.setParent(OwnerOptionsController.this);
        Stage inputStage = new Stage();
        inputStage.setScene(EditMenuScene);
        inputStage.initModality(Modality.APPLICATION_MODAL);
        inputStage.show();
    }

    public void done(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you would like to close?",
                ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            ((Stage)doneButton.getScene().getWindow()).close();
        }
    }

    public void enterPassword(ActionEvent actionEvent) {
        String entered = passwordTF.getText();
        if (entered.equals(password)){
            passwordTF.setDisable(true);
            passwordTF.setOpacity(0);
            enterButton.setDisable(true);
            enterButton.setOpacity(0);
            editMenuButton.setDisable(false);
            editMenuButton.setOpacity(1);
            setNoOfTablesButton.setDisable(false);
            setNoOfTablesButton.setOpacity(1);
        }
    }
}
