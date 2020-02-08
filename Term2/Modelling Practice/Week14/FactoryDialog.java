package sample;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.*;

class FactoryDialog extends Stage {

    private HBox questionBox;
    private HBox inputBox;
    private TextField input;
    private Label fruit;
    private Button enter;
    public String fave = "";

    public FactoryDialog(){
        questionBox = new HBox();
        questionBox.setSpacing(25);
        questionBox.setPadding(new Insets(10));
        questionBox.setAlignment(Pos.CENTER);

        inputBox = new HBox();
        inputBox.setSpacing(25);
        inputBox.setPadding(new Insets(15));

        input  = new TextField();
        fruit = new Label("What is your favourite fruit?");
        enter = new Button("Enter");

        enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //get text from text box
                fave = input.getText();
                System.out.println("Your Favourite fruit is: " + fave);
            }
        });
        VBox dialogBox = new VBox(questionBox, inputBox);

        Scene dialogScene = new Scene(dialogBox, 375, 150);

        questionBox.getChildren().addAll(fruit);
        inputBox.getChildren().addAll(input, enter);


        this.setScene(dialogScene);
    }
}