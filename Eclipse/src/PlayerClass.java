
public abstract class PlayerClass {
	private String className;
	private int armor;
	private int mana;
	private int speed;
	private double maxHealth;

	public PlayerClass(String pclass, int armor, int mana, int speed, double maxHealth) {
		className = pclass;
		this.armor = armor;
		this.mana = mana;
		this.speed = speed;
		this.maxHealth = maxHealth;
	}

	public int[] getStats() {
		int[] stats = new int[3];
		stats[0] = armor;
		stats[1] = mana;
		stats[2] = speed;
		return stats;
	}

	public double getMax() {
		return maxHealth;
	}
	
	public String toString() {
		return className;
	}
}
