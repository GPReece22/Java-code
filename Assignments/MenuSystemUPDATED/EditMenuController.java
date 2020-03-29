package Example;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class EditMenuController {
    public ListView starterList;
    public ListView mainList;
    public ListView dessertList;
    public ListView drinkList;
    public ListView ExtraList;
    public TextField itemNameTF;
    public TextField itemPriceTF;
    public TextField itemCalorieTF;
    public TextField itemDescriptionTF;
    public Button addButton;
    public Button removeButton;

    public void setParent(OwnerOptionsController p) {
        OwnerOptionsController parent = p;
    }

    public void addItem(ActionEvent actionEvent) {
    }

    public void removeItem(ActionEvent actionEvent) {
    }
}
