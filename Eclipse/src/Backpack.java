import java.util.List;

public class Backpack implements Item{
	private List<Item> items;
	private int storage;
	private int weight;
	private String name;
	
	public Backpack(int maxStorage) {
		storage = maxStorage;
		name = "backpack";
	}
	
	public void use() {
	
	}

	public String getName() {
		return name;
	}
	
	public int getCost() {
		return 10;
	}
}