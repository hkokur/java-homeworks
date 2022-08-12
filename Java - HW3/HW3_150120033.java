import java.util.Scanner;

public class HW3_150120033 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Which shape would you like to draw?");
		System.out.println("1. Line");
		System.out.println("2. Triangle");
		System.out.println("3. Rectangle");
		System.out.println("4. Parabola");
		System.out.println("5. Circle");
		System.out.println("6.Exit");
		
		int choice = input.nextInt();
		
		String coordinates = ""; 
		
		if(choice == 1) {
				System.out.println("Line formula is y = ax + b");
				System.out.print("Please enter the coefficients a and b:");
				int a = input.nextInt();
				int b = input.nextInt();
				
				for(int y = 9; y >= -11; y--) {
					int x=11;
					
					if (a != 0) {
						double rawX = (y-b)/a;	
						if((int)(rawX*10)%10 == 0)
							x = (int)(rawX);
					}
					else
						x = b;
	
					if((x>=-10)&&(x<=10))
						coordinates = coordinates.concat(""+x+","+y+ " ");
				}
				
			}
		
		if(choice == 4) {
			System.out.println("Parabola formula is y = ax^2 + bx + c");
			System.out.println("Please enter the coefficients a, b and c:");
			int a = input.nextInt();
			int b = input.nextInt();
			int c = input.nextInt();
			
			for(int x = -10; x < 11;x++) {
				double y = a*Math.pow(x, 2)+b*x+c;
							
				if((int)(y*10)%10 == 0) {
					if((y>=-11)&&(y<=9))
						coordinates = coordinates.concat(""+x+","+(int)(y)+ " ");
				}		
			}	
		}
		
		if(choice  == 5) {
			System.out.println("Circle formula is (x-a)^2 + (y-b)^2 = r^2");
			System.out.println("Please enter the coordinates of the center (a,b) and the radius:");
			int a = input.nextInt();
			int b = input.nextInt();
			int r = input.nextInt();
			
			for(int x = -10; x < 11;x++) {
				double y = Math.sqrt(Math.pow(r, 2)-Math.pow(x-a, 2))+b;
				double otherY = b -Math.sqrt(Math.pow(r, 2)-Math.pow(x-a, 2));
							
				if((int)(y*10)%10 == 0) {
					if((y>=-11)&&(y<=9))
						coordinates = coordinates.concat(""+x+","+(int)(y)+ " ");
				}
				if((int)(otherY*10)%10 == 0) {
					if((otherY>=-11)&&(otherY<=9) && (otherY != y))
						coordinates = coordinates.concat(""+x+","+(int)(otherY)+ " ");
				}
			}	
			
		}
		
		if((choice == 2) || (choice == 3)) {
			System.out.print("Sorry, i couldn't write this part :/");
		}
		
		// printing y top of the y-axis
		System.out.printf("%10s","");
		System.out.print("y");
		System.out.printf("%10s","");
		System.out.println("");
		
		//printing other points
		for(int y=9 ; y>=-11; y--) {
			
			String xs = "";
			
			int num1 = 0;
			int num2 = 0;
			for(; num1 <= coordinates.length();) {
				num2 = coordinates.indexOf(" ",num1);
				if(num2 == -1)
					break;
				String dots = coordinates.substring(num1,num2);
				num1 +=dots.length()+1;
				
				int comma = dots.indexOf(",");
				int x = Integer.parseInt(dots.substring(0,comma));
				int controlY = Integer.parseInt(dots.substring(comma+1));
				
				if(controlY == y) {
					xs = xs.concat(x+",");
					}
				}
			
			int x = -10;
			for(;x<12; x++) {
				boolean printStar = false;
				
				for(int num3 = 0; num3 <= xs.length() && xs.length() != 0;) {
					int num4 = xs.indexOf(",", num3);
					if (num4 == -1)
						break;
					int x2;
					String dot = xs.substring(num3,num4);
					x2 = Integer.parseInt(dot);
					num3 =num4+1;	

					if(x == x2)
						printStar = true;

				}
				
				if(printStar) {
					System.out.print("*");
				}
				else if((x == 0 )&& (printStar==false)){
					System.out.print("|");
				}
				else if((x == 11)&&(y==0)) {
					System.out.print("x");
				}
				else if(y == 0) {
					System.out.print("-");
				}
				else
					System.out.print(" ");
			}
			System.out.println("");
			
		}	
		
	}
}
