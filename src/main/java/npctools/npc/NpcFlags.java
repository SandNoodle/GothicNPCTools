package npctools.npc;

public class NpcFlags {
	
	private boolean invulnerable;
	private boolean ghost;
	private boolean friend;
	
	public boolean isInvulnerable() {
		return invulnerable;
	}
	
	public void setInvulnerable(boolean invulnerable) {
		this.invulnerable = invulnerable;
	}
	
	public boolean isGhost() {
		return ghost;
	}
	
	public void setGhost(boolean ghost) {
		this.ghost = ghost;
	}
	
	public boolean isFriend() {
		return friend;
	}
	
	public void setFriend(boolean friend) {
		this.friend = friend;
	}
	
	@Override
	public String toString(){
		return new StringBuilder()
				.append("Invulnerable: ")
				.append(invulnerable)
				.append(" | Ghost: ")
				.append(ghost)
				.append(" | Friend: ")
				.append(friend)
				.toString();
	}
	
}
