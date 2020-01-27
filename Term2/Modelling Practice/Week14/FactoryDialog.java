import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.*;

class FactoryDialog extends Stage {

    private HBox questionBox;
    private HBox inputBox;

    public FactoryDialog(){
        TextInputDialog fave = new TextInputDialog( "Enter text:");
    }
}
