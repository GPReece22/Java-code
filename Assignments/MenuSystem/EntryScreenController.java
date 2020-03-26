package Example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class EntryScreenController extends Application {
    public TextField tableNoTextField;
    public TextField noDiningTextField;
    public Button enterButton;
    public int tableNumber;
    public int numberDining;


    public void startMenu(ActionEvent actionEvent) throws IOException {
        if (tableNoTextField != null || noDiningTextField != null) {
            String tempTableNumber = tableNoTextField.getText();
            tableNumber = Integer.parseInt(tempTableNumber);
            MenuController.updateTableNumber(tableNumber);
            String tempNumberDining = noDiningTextField.getText();
            numberDining = Integer.parseInt(tempNumberDining);
            MenuController.updateNumberDining(numberDining);
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
        launch(args);
    }

}
