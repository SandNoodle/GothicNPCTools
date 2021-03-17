package npctools;

import npctools.ui.WindowManager;
import npctools.temptorewrite.Configuration;
import npctools.utils.Logger;

import java.io.IOException;


/**
 * Set of NPC creation and editing tools for Gothic I / Gothic II. Created for maximum efficiency and convenience for
 * people, who cannot code in Daedalus (scripting language used by Piranha Bytes for their first two games).
 *
 * @author Krzysztof Grabski
 * @version 0.1
 * @since 2020-12-10
 */

public class Main {

	/*
	static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	static NpcManager npcManager = new NpcManager();
	static String path = "test.json";
	static Writer writer;

	static Configuration cfg;
	*/

	private static Configuration config;
	private static WindowManager windowManager;

	public static void main(String[] args) {
		Logger.setVerbose(true);

		Logger.log("Starting an application!");
		Logger.log("Reading configuration file...");
		try {
			config = new Configuration();
			config.loadConfig();
			Logger.log("Configuration file was loaded successfully!");
		} catch (IOException e) {
			e.printStackTrace();
			Logger.logError("Could not read configuration file!");
		}

		Logger.log("Building window!");
		windowManager = new WindowManager();
		windowManager.launchApplication(args);
	}

	public static Configuration getConfiguration() {
		return config;
	}

}
