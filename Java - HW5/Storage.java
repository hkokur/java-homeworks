/* Name Surname : Hakkı Kokur
 * Student ID : 150120033
 * Purpose : Creating the structure of the storage that factory has.
*/
public class Storage {
	int capacity;
	Item[] Items = new Item[0];
	
	Storage(int capacity){
		this.capacity = capacity;
	}
	
	void addItem(Item item) {
		Item[] array = new Item[Items.length+1];
		System.arraycopy(Items, 0, array, 0, Items.length);
		array[Items.length] = item;
		Items = array;
	}
}
