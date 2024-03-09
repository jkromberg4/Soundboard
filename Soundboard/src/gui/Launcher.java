package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import sound.SoundLocation;

public class Launcher extends Application {
	
	private int sceneHeight = 500;
	private int sceneWidth = 500;
	private int soundGridSpacing = 10;
	private int buttonRows = 4;
	private int buttonCols = 4;
	
	public void start(Stage mainStage) {
		try {
			
			/* -- Overall layout -- */
			
			BorderPane root = new BorderPane();
			
			
			/* -- TOP: Placeholder for future features -- */
//			Label topPHText = new Label("top bar placeholder");
//			root.setTop(topPHText);
			
			
			/* -- CENTER: Grid layout for sound buttons -- */
			
			GridPane soundGrid = new GridPane();
			soundGrid.setHgap(soundGridSpacing);
			soundGrid.setVgap(soundGridSpacing);
			soundGrid.setPadding(new Insets(soundGridSpacing));
			soundGrid.setAlignment(Pos.CENTER);
			root.setCenter(soundGrid);
			
			// Sound effect buttons
			Button[][] soundButtons = new Button[buttonRows][buttonCols];
			
			for (int i = 0; i < buttonRows; i++) {
				for (int j = 0; j < buttonCols; j++) {
					soundButtons[i][j] = new Button();
					soundButtons[i][j].setText("R" + i + " C" + j);
					soundButtons[i][j].getStyleClass().add("sound-button");
					soundGrid.add(soundButtons[i][j], j, i);
				}
			}
			
			soundButtons[0][0].setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					Media beedleMedia = new Media(SoundLocation.class.getResource("beedle-thank-you.mp3").toExternalForm());
					MediaPlayer mp3Player = new MediaPlayer(beedleMedia);
					MediaView mv = new MediaView(mp3Player);
					root.setBottom(mv);
					mp3Player.play();
				}
			});
			
			
			// First audio clip
			
//			String audioFilePath = "mario-falling.mp3";
//			Media beedleMedia = new Media(SoundLocation.class.getResource(audioFilePath).toExternalForm());
//			MediaPlayer mp3Player = new MediaPlayer(beedleMedia);
//			mp3Player.setAutoPlay(true);
//			MediaView mv = new MediaView(mp3Player);
//			root.setRight(mv);
			
			/* -- Main scene -- */
			
			Scene scene = new Scene(root,sceneHeight,sceneWidth);
			scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
			mainStage.setScene(scene);
			mainStage.setTitle("Soundboard");
			mainStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
