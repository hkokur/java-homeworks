/* Name Surname : Hakkı Kokur
 * Student ID : 150120033
 * Purpose : Printing diamond shape from letter that is given from user.
 */
import java.util.Scanner;

public class HW4_Q3_150120033 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a Letter: ");
		String letter = input.nextLine();
		char character;
		if(letter.length() == 1) {
			character = letter.charAt(0);
		}
		else {
			character = '*';
		}
		
			
		
		if((character >= 65)&&(character<=90) || (character>=97) && (character<= 122) ) {
			character = Character.toUpperCase(character);
			char[][] matrix = constructDiamond(character);
			printDiamond(matrix);
			
		}
		else
			System.out.print("Invalid Input !");
	}
	
	public static char[][] constructDiamond(char letter){
		int length = (letter-64)*2-1;
		char[][] matrix = new char[length][length];
		
		for(int row=0; row < matrix.length; row++) {
			for(int column = 0; column < matrix[row].length; column++) {
				matrix[row][column] = 46;
			}
		}
		

		for(int i = 0, firstColumn = matrix.length/2, secondColumn = matrix.length/2; i <= matrix.length/2; i++,firstColumn++, secondColumn--) {
				matrix[i][firstColumn] = (char)(i + 'A');
				matrix[i][secondColumn] = (char)(i + 'A');
			
		}
		
		
		for(int j= 0, i = matrix.length-1,firstColumn = matrix.length/2, secondColumn = matrix.length/2; i > matrix.length/2; i--,j++,firstColumn--, secondColumn++) {
				matrix[i][firstColumn] = (char)(j + 'A');
				matrix[i][secondColumn] = (char)(j + 'A');
			
		}
		
		return matrix;
	}
	
	public static void printDiamond(char[][] diamond) {
		
		for(int row=0; row < diamond.length; row++) {
			for(int column = 0; column < diamond[row].length; column++) {
				System.out.print(diamond[row][column]);
			}
			System.out.println();
		}
	}

}
