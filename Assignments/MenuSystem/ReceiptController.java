package Example;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.text.NumberFormat;
import java.util.Locale;

public class ReceiptController {

    public Label totalLabel;
    public ListView<ItemOnMenu> receiptList;
    public Button payButton;
    private static MyMenu finalOrder;
    Locale locale = new Locale("en", "GB");
    NumberFormat cf = NumberFormat.getCurrencyInstance(locale);

    public void setParent(MenuController p){
        MenuController parent = p;
    }

    public void initialize() {
        receiptList.setItems(finalOrder);
        totalLabel.setText("Total price: " + cf.format(finalOrder.getTotalPrice()));
    }

    public void pay(ActionEvent actionEvent) {
        ((Stage) payButton.getScene().getWindow()).close();
        Alert alert = new Alert(Alert.AlertType.NONE, "Thank you for your order, enjoy your meal :)", ButtonType.CLOSE);
        alert.showAndWait();
    }

    public static void updateReceipt(MyMenu storedValue) {
        ReceiptController.finalOrder = storedValue;
    }
}
