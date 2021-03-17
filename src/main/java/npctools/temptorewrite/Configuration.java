package npctools.temptorewrite;


import npctools.utils.Logger;
import nu.studer.java.util.OrderedProperties;
import nu.studer.java.util.OrderedProperties.OrderedPropertiesBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class responsible for loading and exporting configuration. The file contains all the necessary data for correct
 * operation of the program.
 */

public class Configuration {

	// Properties
	private static String mainScreenFXML;
	private static String screenColorTheme;
	private static String screenStylesheet;

	private static String defaultLanguage;

	// Paths - TODO "Env" by OS. Currently only Windows is supported.
	private static final String mainPath = System.getenv("appdata") + "\\.gothicTools";
	private static final String userDataPath = mainPath + "\\userData";
	private static final String presetsPath = mainPath +"\\presets";
	private static final String configFilePath = mainPath + "\\config.properties";

	// Directories
	private final File mainDirectory;
	private final File userDirectory;
	private final File presetsDirectory;

	// Config files
	private final File configFile;

	// Input/Output classes
	private FileReader fileReader;
	private FileWriter fileWriter;
	private final OrderedPropertiesBuilder builder;
	private final OrderedProperties properties;


	public Configuration() throws IOException {
		configFile = new File(configFilePath);
		mainDirectory = new File(mainPath);
		userDirectory = new File(userDataPath);
		presetsDirectory = new File(presetsPath);

		// Properties
		builder = new OrderedPropertiesBuilder();
		builder.withOrdering(String.CASE_INSENSITIVE_ORDER);
		builder.withSuppressDateInComment(false); // True won't write Date and Time to file.
		properties = builder.build();
	}

	public void loadConfig() throws IOException {
		// Check if we can load anything
		if (!configExists()) {
			// Check if directory doesn't exist
			if (!mainDirectory.exists()) {
				mainDirectory.mkdir();
				userDirectory.mkdir();
				presetsDirectory.mkdir();
			}

			// Config file doesn't exist - create new one
			createDefaultConfig();
		}
		fileReader = new FileReader(configFile);
		properties.load(fileReader);

		// App specific
		defaultLanguage = properties.getProperty("DefaultLanguage");
		screenColorTheme = properties.getProperty("SceneDefaultTheme");
		screenStylesheet = properties.getProperty("SceneStylesheet");

		// Done reading the config file
		fileReader.close();
	}

	private void createDefaultConfig() throws IOException {
		fileWriter = new FileWriter(configFile);

		// App specific settings
		// 	Window
		properties.setProperty("SceneDefaultTheme", "DARK");

		// 	Json path
		properties.setProperty("JSONSavePath", "\\userData");

		// 	Language settings
		properties.setProperty("DefaultLanguage", "DEFAULT");

		// Gothic specific settings bellow
		// 	Gothic path
		properties.setProperty("GothicOnePath", "");
		properties.setProperty("GothicTwoPath", "");

		// Store all to config file
		properties.store(fileWriter, "--- Gothic Tools Configuration File ---");

		// Flush and close
		fileWriter.flush();
		fileWriter.close();
	}

	public void updateProperty(String key, String value) throws IOException {
		fileWriter = new FileWriter(configFile);

		if (properties.containsProperty(key)) {
			properties.setProperty(key, value);
			Logger.log(key + " updated successfully with value " + value);
		} else {
			Logger.logError("Could not update property. Key " + key + "doesn't exist!");
		}

		// Flush and close
		fileWriter.flush();
		fileWriter.close();
	}

	public Object getProperty(String key) {
		return properties.getProperty(key);
	}

	// TODO possible rewrite for better checks
	private boolean configExists() {
		return new File(configFilePath).isFile();
	}

	// Properties
	public String getLanguage() {
		return defaultLanguage;
	}

	public String getMainPath() { return mainPath; }
	
	public static String getPresetsPath() { return presetsPath; }

	public String getSceneColorTheme() {
		return screenColorTheme;
	}

	public String getSceneStylesheet() {
		return screenStylesheet;
	}
}
