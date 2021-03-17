package npctools.npc.routine;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Routine {

	// Usable part of the Routine's name
	// Final Routine is made as follows: Rtn_[ROUTINE_NAME]_[NPCID]
	private String routineName;

	// List of Actions making a routine
	private final JsonArray routineActions;

	//Activity consinsts of: START, END, ACTION, WAYPOINT
	private transient JsonObject routineActivity;

	public Routine() {
		routineName = "Start";
		routineActions = new JsonArray();
	}

	public Routine(String name) {
		this();
		setName(name);
	}

	/**
	 * This function adds another action to list of routines
	 *
	 * @param start    - Start time of the action. Format, ex. 8,00 ([HRS,MINS])
	 * @param end      - End time of the action. Format asme as above
	 * @param action   - What action is performed
	 * @param waypoint - Place where the action is performed
	 */
	public void addActivity(String start, String end, String action, String waypoint) {
		routineActivity = new JsonObject();
		routineActivity.addProperty("ACTIVITY_START", start);
		routineActivity.addProperty("ACTIVITY_END", end);
		routineActivity.addProperty("ACTIVITY_NAME", action);
		routineActivity.addProperty("ACTIVITY_WAYPOINT", waypoint);

		routineActions.add(routineActivity);
	}

	public void removeActivity(JsonObject activity) {
		if (routineActions.contains(activity))
			routineActions.remove(activity);
	}

	public void removeAllActivities() {
		for (int i = 0; i < routineActions.size(); i++) {
			routineActions.remove(i);
		}
	}

	/**
	 * Gets all activities contained in a routine
	 *
	 * @return all list of activites as JsonArray
	 */
	public JsonArray getActivities() {
		return routineActions;
	}

	/**
	 * Sets the name of the routine. Final name in the script file is saved as: Rtn_[NAME]_[NPC ID] For an easy access
	 * it's just the name of the routine without any suffixes and suffixes.
	 *
	 * @param name - Usable part of the routine's name
	 */

	public void setName(String name) {
		routineName = name;
	}

	/**
	 * Returns the name of the routine. It should be noted that the only thing it returns is usable part of the
	 * routine.
	 * Full routine's name is as follows: Rtn_[NAME]_[NPC ID] The only returned part is [NAME]
	 *
	 * @return Usuable part of the routine's name as String
	 */

	public String getName() {
		return routineName;
	}

}
