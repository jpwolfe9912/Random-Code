import java.util.Scanner;
class BaseCalc3 {
	static int toDecimal(String strFoo, int base){
		strFoo = strFoo.toUpperCase();
		int lengthFoo = strFoo.length(); //gives length of String
		double decFoo = 0;
		int finDecFoo = 0;
		for(int i = 0; i <= lengthFoo - 1; i++) { //runs through each character in the 
			char charFoo = strFoo.charAt(i); //takes the first character in the input string
			if((charFoo - 48 >= base) && (charFoo - 55) >= base){ //in case a value that outside the range of a base system
				System.out.println("Why would you input something out of range???");
				System.exit(0);
			}
			int difi = lengthFoo - i - 1; //makes the power equal to the place in the string minus 1.  Takes away one each iteration
			if((charFoo - 48) <= 9){
				decFoo = (charFoo - 48) * Math.pow(base, difi); //multiplies the number at a place by the base to the power of the place minus 1
			}
			else if((charFoo - 55) >= 10){
				decFoo = (charFoo - 55) * Math.pow(base, difi);
			}
			finDecFoo += decFoo; //consecutively adds the numbers from above
		}
		return finDecFoo; //returns the final decimal number
	}
	static String toBaseX(int bar, int fooBase){ //input a number and a base.  Function returns a string that is the value in that base
		char sign = ' ';
		if(bar < 0){
			sign = '-';
			bar *= -1;
		}
		String num = "";
		if(bar == 0) { //takes care of easy case where the product is 0
			num = "0";
			return num;
		}
		//now we need to convert back to input base
		double fac = 0;
		int bin = 0;
		char addNum;
		while (Math.pow(fooBase, fac) <= bar) {
			fac++;							//keeps adding to fac until a base-power exceeds the product
		}
		fac = fac - 1;						//sets fac equal to the highest base-power that fit inside bar
		while (fac >= 0) {
			addNum = (char)((bar % fooBase) + 48); //converts the int to a char using the ASCII table
			int intAddNum = addNum - '0';
			if(intAddNum >= 10){
				addNum = (char)(intAddNum + 55); //if number is 10 or larger then we have to start using the alphabet
			}
			num = "" + addNum + num; //consecutively adds each character
			bar = (int)(bar / fooBase); //resets bar at the integer quotient of bar and the base
			fac--; //subtract from fac until it goes beyond 0
		}
		return (sign + num); //returns number as a String
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //sets up Scanner
		System.out.println("Would you like to operate two numbers or convert one? Enter \"operate\" or \"convert\": ");
		String func = sc.nextLine();
		if(func.equals("operate") || func.equals("Operate")){
			System.out.println("Enter a value: ");
			String x = sc.nextLine(); //first input value
			System.out.println("What base (1-36) is your first input value? Please input a numerical representation: ");
			int input1 = sc.nextInt(); //base of the first number
			if(input1 > 36){ //makes sure the base is from 1 to 36
				System.out.println("Please input a base within the bounds");
				System.exit(0);
			}
			sc.nextLine();
			System.out.println("Enter another value: ");
			String y = sc.nextLine(); //second input value
			System.out.println("What base (1-36) is your second input value? Please input a numerical representation: ");
			int input2 = sc.nextInt(); //base of the second number
			if(input2 > 36){ //makes sure the base is from 1 to 36
				System.out.println("Please input a base within the bounds");
				System.exit(0);
			}
			System.out.println("Would you like to +, -, *, or / these numbers?");
			char oper = sc.next().charAt(0); //sets variable oper as whatever operation the user wants
			System.out.println("What base would you like your result to be in?");
			int output = sc.nextInt(); //base of result
			if(output > 36){ //makes sure the base is from 1 to 36
				System.out.println("Please input a base within the bounds");
				System.exit(0);
			}
			
			int prod = 0;
			if(oper == '+'){ //converts both numbers to decimal and adds them
				prod = toDecimal(x, input1) + toDecimal(y, input2);
			}
			else if(oper == '-'){ //converts both numbers to decimal and subtracts them
				prod = toDecimal(x, input1) - toDecimal(y, input2);
			}
			else if(oper == '*'){ //converts both numbers to decimal and multiplies them
				prod = toDecimal(x, input1) * toDecimal(y, input2);
			}
			else if(oper == '/'){ //converts both numbers to decimal and divides them
				prod = toDecimal(x, input1) / toDecimal(y, input2);
			}
			else{ //in case you input an unacceptable operation
				System.out.println("Put in a correct operation (+, -, *, /)");
			}
			System.out.println("Your decimal result is: " + prod); //prints decimal result
			System.out.println(toDecimal(x, input1) + " " + oper + " " + toDecimal(y, input2) + " = " + prod);
			System.out.println("Your base " + output + " result is: " + toBaseX(prod, output)); //gives output in whatever base they wanted
			System.out.println(x + "_" + input1 + " " + oper + " " + y + "_" + input2 + " = " + toBaseX(prod, output) + "_" + output); //displays full equation
		}
		else if(func.equals("convert") || func.equals("Convert")){
			System.out.println("Enter a value to convert: ");
			String z = sc.nextLine();
			System.out.println("What base is your input value? ");
			int input3 = sc.nextInt();
			if(input3 > 36){
				System.out.println("Please input a base within the bounds");
				System.exit(0);
			}
			System.out.println("What base do you want to convert to?");
			int output2 = sc.nextInt();
			if(output2 > 36){ //makes sure the base is from 1 to 36
				System.out.println("Please input a base within the bounds");
				System.exit(0);
			}
			int res = toDecimal(z, input3);
			System.out.println("Your decimal result is: " + res + "_10");
			System.out.println("Your base " + output2 + " result is: " + toBaseX(res, output2) + "_" + output2);
		}
	}
}