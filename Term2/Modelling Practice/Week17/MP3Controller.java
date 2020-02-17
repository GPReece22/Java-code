package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class MP3Controller {
    public Button playButton;
    public Button stopButton;
    public ComboBox songsCombobox;
    public Button randomButton;
    public Label nowPlayingLabel;

    ObservableList<String> listOfSongs = FXCollections.observableArrayList ("Cheese", "Cheese Salad", "Cheese and Tomato", "Cheese and Pickle", "Ploughman's");
    songList.setItems(listofSongs);
    
    public void playSong(ActionEvent actionEvent) {
    }

    public void stopSong(ActionEvent actionEvent) {
    }

    public void randomSong(ActionEvent actionEvent) {
    }

    public void getSong(ActionEvent actionEvent) {
        int selectedIndex = listOfSongs.getSelectionModel().getSelectedIndex();
        if (selectedIndex == -1) {
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "Select a Tasty Treat", ButtonType.OK);
            alert.showAndWait();
        }
        else {
            String selectedSarnie = listOfSongs.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.INFORMATION,
                    "You chose a " + selectedSarnie, ButtonType.OK);
            alert.showAndWait();
        }
    }
}
