package npctools.ui.controllers;

import javafx.scene.control.TextField;

public class BasicController {
	
	protected void textFieldAsVerbalOnly(TextField textField) {
		textField.textProperty().addListener((observableValue, oldValue, newValue) -> {
			if (newValue.matches("[^a-zA-Z ]*")) return;
			textField.setText(newValue.replaceAll("[\\d]", ""));
		});
	}
	
	protected void textFieldAsNumericOnly(TextField textField) {
		textField.textProperty().addListener((observableValue, oldValue, newValue) -> {
			if (newValue.matches("\\d*")) return;
			textField.setText(newValue.replaceAll("[^\\d]", ""));
		});
	}
	
}
