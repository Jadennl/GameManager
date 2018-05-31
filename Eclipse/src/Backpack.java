import java.util.List;

public class Backpack implements Item {
	private List<Item> items;
	private int storage;
	private String name;

	public Backpack(int maxStorage) {
		storage = maxStorage;
		name = "backpack";
	}

	public void use() {
		use(0);
	}

	public Item use(int i) {
		try {
			return items.get(i);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}


	public String getName() {
		return name;
	}
	
	public int getCost() {
		return 10;
	}
}