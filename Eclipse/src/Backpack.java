import java.util.List;

public class Backpack implements Item {
	private List<Item> items;
	private int storage;
	private String name;

	public Backpack(int maxStorage) {
		storage = maxStorage;
		name = "backpack";
	}

	public int size(){
		return items.size();
	}
	public void use(){
		int x = 0;
		for(Item i: items){
			System.out.println("(" + x + ")" + i.getName());
		}
		System.out.println("\t- if there are no items, please add them in the player menu.");
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