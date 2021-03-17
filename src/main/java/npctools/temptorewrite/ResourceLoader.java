package npctools.temptorewrite;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ResourceLoader {
	
	// Npc Tab
	private HashMap<String, String> loadedGuilds;
	private HashMap<String, String> loadedNPCTypes;
	private HashMap<String, String> loadedVoices;
	private HashMap<String, String> loadedFightTactics;
	private HashMap<String, String> loadedWalkStyles;
	private HashMap<String, String> loadedHeadMeshes;
	private HashMap<String, String> loadedFaceTextures;
	private HashMap<String, String> loadedWalkStyle;
	private HashMap<String, String> loadedBodyTextures;
	private HashMap<String, String> loadedArmors;
	private HashMap<String, String> loadedWeapons; // Melee, Ranged and Magic spells
	
	private Gson gson;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	
	private File file;
	
	public ResourceLoader() {
		gson = new GsonBuilder().setPrettyPrinting().create();
	}
	
	private void loadGuilds(){
		//loadedGuilds = loadDataByTag(getFilePath(""));
		
		if(!loadedGuilds.isEmpty()){
			// Guilds were specified using tags
		} else {
			// Use predefined Guilds.
		}
	}
	
	public Map<String, String> loadDataByTag(String fileName, String tag) throws IOException {
		Map<String, String> temp = new HashMap<String, String>();
		file = new File(fileName);
		fileReader = new FileReader(file);
		bufferedReader = new BufferedReader(fileReader);
		
		String line;
		String tagValue;
		String[] splitLine;
		
		if (!file.exists()) throw new FileNotFoundException("Could not locate specified file!");
		if (bufferedReader.readLine() == null) throw new IOException("File could not be read!");
		
		while ((line = bufferedReader.readLine()) != null) {
			if (line.contains("[" + tag + ":")) {
				line = line.replaceAll("\\s+", " ");
				splitLine = line.split(" ");
				tagValue = StringUtils.substringBetween(line, ": ", "]");
				
				temp.put(tagValue, splitLine[2]);
			}
		}
		
		bufferedReader.close();
		fileReader.close();
		
		return temp;
	}
	
	/**
	 * Searches main directory and returns absolute path for specified file
	 *
	 * @param fileName
	 * @return
	 */
	public String getFilePath(String fileName) {

		
		try (Stream<Path> walkStream = Files.walk(Paths.get("MAIN"))) {
			walkStream.filter(p -> p.toFile().isFile()).forEach(f -> {
				if (f.toString().endsWith(fileName)) {
		//			path = f.toAbsolutePath().toString();
				}
			});
		} catch (IOException e){
			e.printStackTrace();
		}
		
		return null;
	}
}
