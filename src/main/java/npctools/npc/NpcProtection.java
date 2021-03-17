package npctools.npc;

public class NpcProtection {
	
	private boolean isEnabled;
	private int blunt;
	private int edge;
	private int fire;
	private int point;
	private int magic;
	private int fly;
	
	// Getters
	public boolean isEnabled() {
		return isEnabled;
	}
	
	public int getBlunt() {
		return blunt;
	}
	
	public int getEdge() {
		return edge;
	}

	public int getFire() {
		return fire;
	}

	public int getPoint() {
		return point;
	}

	public int getMagic() {
		return magic;
	}

	public int getFly() {
		return fly;
	}

	// Setters
	
	public void setEnabled(boolean enabled) {
		isEnabled = enabled;
	}
	
	public void setBlunt(int blunt) {
		this.blunt = blunt;
	}
	
	
	public void setEdge(int edge) {
		this.edge = edge;
	}
	
	public void setFire(int fire) {
		this.fire = fire;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}
	
	public void setMagic(int magic) {
		this.magic = magic;
	}
	
	public void setFly(int fly) {
		this.fly = fly;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append(" Is Enabled?: ")
				.append(isEnabled)
				.append(" | Blunt: ")
				.append(blunt)
				.append(" | Edge: ")
				.append(edge)
				.append(" | Fire: ")
				.append(fire)
				.append(" | Point: ")
				.append(point)
				.append(" | Magic: ")
				.append(magic)
				.append(" | Fly: ")
				.append(fly)
				.toString();
	}
}
