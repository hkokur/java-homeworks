/* Name Surname : Hakkı Kokur
 * Student ID : 150120033
 * Purpose : Creating the structure of the item that employees produce. 
*/
public class Item {
	int id;
	static int numberOfItems;
	
	Item(int id){
		this.id = id;
		numberOfItems++;
	}
	
	Item(){
		numberOfItems++;
	}
	
}
