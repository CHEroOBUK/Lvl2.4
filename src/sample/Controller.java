package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {
    MediaPlayer mediaPlayer;
    Media sound = new Media(getClass().getResource("/css/sendingSound.mp3").toString());

    Date date = new Date();
    SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy HH:mm");

    private int checkPushVolumeButton = 0;
    private int checkSendByEnter = 0;
    private int checkShowTime = 0;

    Image imageVolOn = new Image(getClass().getResourceAsStream("/css/volOn.png"));
    Image imageVolOff = new Image(getClass().getResourceAsStream("/css/volOff.png"));

    @FXML
    Button volumeButton;
    @FXML
    Button sendButton;
    @FXML
    TextField textField;
    @FXML
    VBox mainVB;
    @FXML
    HBox settingsBox;
    @FXML
    HBox downFrameBox;
    @FXML
    HBox boxWithSendButton;
    @FXML
    TextArea textArea;
    @FXML
    ToggleButton toggleSendByEnter;
    @FXML
    ToggleButton toggleShowTime;
    @FXML
    ToggleGroup groupRadioButtons;
    @FXML
    Label labelLightTheme;
    @FXML
    Label labelDarkTheme;
    @FXML
    Label sendLabel;

    public void sendMsg() {
        if (checkShowTime == 1){
            textArea.appendText(formatDate.format(date) + ": " + textField.getText() + "\n");
        } else {
            textArea.appendText(textField.getText() + "\n");
        }
        textField.clear();
        textField.requestFocus();
        if (checkPushVolumeButton == 1){
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setAutoPlay(true);
            mediaPlayer.setVolume(0.7);
        }
    }



    public void volumeOnOff() {
        if (checkPushVolumeButton == 0){
            volumeButton.graphicProperty().setValue(new ImageView(imageVolOn));
            checkPushVolumeButton = 1;

        } else {
            volumeButton.graphicProperty().setValue(new ImageView(imageVolOff));
            checkPushVolumeButton = 0;
        }
    }

    public void setDarkTheme(){
        settingsBox.getStylesheets().clear();
        settingsBox.getStylesheets().add("/css/DarkTheme.css");
        sendButton.getStylesheets().clear();
        sendButton.getStylesheets().add("/css/DarkTheme.css");
        downFrameBox.getStylesheets().clear();
        downFrameBox.getStylesheets().add("/css/DarkTheme.css");
        textField.getStylesheets().clear();
        textField.getStylesheets().add("/css/DarkTheme.css");
        textArea.getStylesheets().clear();
        textArea.getStylesheets().add("/css/DarkTheme.css");
    }

    public void setLightTheme(){
        settingsBox.getStylesheets().clear();
        settingsBox.getStylesheets().add("/css/LightTheme.css");
        sendButton.getStylesheets().clear();
        sendButton.getStylesheets().add("/css/LightTheme.css");
        downFrameBox.getStylesheets().clear();
        downFrameBox.getStylesheets().add("/css/LightTheme.css");
        textField.getStylesheets().clear();
        textField.getStylesheets().add("/css/LightTheme.css");
        textArea.getStylesheets().clear();
        textArea.getStylesheets().add("/css/LightTheme.css");
    }

    public void sendOption(){
        if (toggleSendByEnter.isSelected()){
            checkSendByEnter = 1;
        } else {
            checkSendByEnter = 0;
        }
    }

    public void timeOption(){
        if (toggleShowTime.isSelected()){
            checkShowTime = 1;
        } else {
            checkShowTime = 0;
        }
    }

    public void customSendOption(){
        if (checkSendByEnter == 1) {
            if (checkShowTime == 1){
                textArea.appendText(formatDate.format(date) + ": " + textField.getText() + "\n");
            } else {
                textArea.appendText(textField.getText() + "\n");
            }
            textField.clear();
            textField.requestFocus();
            if (checkPushVolumeButton == 1) {
                mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.setAutoPlay(true);
                mediaPlayer.setVolume(0.7);
            }
        }
    }

}
