package npctools.ui;

import npctools.temptorewrite.Configuration;
import npctools.utils.Logger;

import java.util.ArrayList;
import java.util.Locale;

public class LocalizationManager {

	// Supported Languages
	public static final Locale ENGLISH = new Locale("en");
	public static final Locale POLISH = new Locale("pl", "PL");

	private Locale currentLanguage;
	private ArrayList<Locale> supportedLanguages;

	private final Configuration config;

	public LocalizationManager(Configuration config) {
		this.config = config;
		initSupportedLanguages();

		//setCurrentLanguage(ENGLISH);
		loadLanguageFromConfig();
	}

	public Locale getCurrentLanguage() {
		return currentLanguage;
	}

	public void setCurrentLanguage(Locale locale) {
		currentLanguage = getSupportedList().contains(locale) ? locale : ENGLISH;
	}

	public Locale getSystemDefault() {
		Locale systemDefault = Locale.getDefault();
		return getSupportedList().contains(systemDefault) ? systemDefault : ENGLISH;
	}

	public ArrayList<Locale> getSupportedList() {
		return supportedLanguages;
	}

	private void initSupportedLanguages() {
		supportedLanguages = new ArrayList<Locale>();
		supportedLanguages.add(ENGLISH);
		supportedLanguages.add(POLISH);
	}

	private void loadLanguageFromConfig() {
		switch (config.getLanguage()) {
			case "ENGLISH":
				currentLanguage = ENGLISH;
				break;
			case "POLISH":
				currentLanguage = POLISH;
				break;
			case "DEFAULT":
				currentLanguage = getSystemDefault();
				break;
			default:
				Logger.logError(config.getLanguage().toUpperCase() + " not supported! Using ENGLISH as default.");
				setCurrentLanguage(ENGLISH);
				break;
		}

		Logger.log("Using language: " + getCurrentLanguage().getLanguage().toUpperCase());
	}
}
