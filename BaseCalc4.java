import java.util.Scanner;
class BaseCalc4 {
	static int toDecimal(String strFoo, int base){
		int lengthFoo = strFoo.length(); //gives length of String
		double decFoo = 0; //initializes variable
		int finDecFoo = 0; // initializes variable
		for(int i = 0; i <= lengthFoo - 1; i++) { //runs through each character in the input string
			char charFoo = strFoo.charAt(i); //takes the first character in the input string
			if((charFoo - 48 >= base) && (charFoo - 55) >= base){ //in case a value that is outside the range of the inputted base system
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
		if(sign == '-'){
			return (sign + num); //returns number as a String
		}
		else{
			return num;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //sets up Scanner
		System.out.println("Would you like to operate multiple numbers or convert one? Enter \"operate\" or \"convert\": ");
		String func = sc.nextLine();
		if(func.equals("operate") || func.equals("Operate")){
			System.out.println("How many numbers would you like to operate? ");
			int iter = sc.nextInt();
			sc.nextLine();
			if(iter < 2){
				System.out.println("You cannot operate on less than two numbers. ");
				System.exit(0);
			}
			String[]reps = new String[iter];
			int[]repBase = new int[iter];
			for (int j = 0; j < iter; j++){
				System.out.println("Enter a value: ");
				reps[j] = sc.nextLine(); //first input value
				reps[j] = reps[j].toUpperCase();
				System.out.println("What base (2-36) is your input value? Please input a numerical representation: ");
				repBase[j] = sc.nextInt(); //base of the first number
				sc.nextLine();
				if((repBase[j] > 36) || (repBase[j] < 1)){ //makes sure the base is from 1 to 36
					System.out.println("Please input a base within the bounds");
					System.exit(0);
				}
			}
			System.out.println("Would you like to +, -, *, or / these numbers?");
			char oper = sc.next().charAt(0); //sets variable oper as whatever operation the user wants
			System.out.println("What base would you like your result to be in?");
			int output = sc.nextInt(); //base of result
			if((output > 36) || (output < 1)){ //makes sure the base is from 1 to 36
				System.out.println("Please input a base within the bounds");
				System.exit(0);
			}
			//now we start the actual computations
			int add = 0;
			int sub = 2 * toDecimal(reps[0], repBase[0]);
			int mult = 1;
			int div = (int)Math.pow(toDecimal(reps[0], repBase[0]), 2);
			for(int k = 0; k < iter; k++){
				if(oper == '+'){ //converts both numbers to decimal and adds them
					add += toDecimal(reps[k], repBase[k]);
				}
				else if(oper == '-'){ //converts both numbers to decimal and subtracts them
					System.out.println(sub);
					sub -= toDecimal(reps[k], repBase[k]);
				}
				else if(oper == '*'){ //converts both numbers to decimal and multiplies them
					mult *= toDecimal(reps[k], repBase[k]);
				}
				else if(oper == '/'){ //converts both numbers to decimal and divides them
					div /= toDecimal(reps[k], repBase[k]);
				}
				else{ //in case you input an unacceptable operation
					System.out.println("Put in a correct operation (+, -, *, /)");
					System.exit(0);
				}
			}
			int prod;
			if(oper == '+'){
				prod = add;
			}
			else if(oper == '-'){
				prod = sub;
			}
			else if(oper == '*'){
				prod = mult;
			}
			else{
				prod = div;
			}
			System.out.println("Your decimal result is: " + prod); //prints decimal result
			System.out.print(toDecimal(reps[0], repBase[0]) + " ");
			for (int l = 1; l < iter; l++){
				System.out.print(oper + " " + toDecimal(reps[l], repBase[l]) + " ");
			}
			System.out.println("= " + prod);
			System.out.println("Your base " + output + " result is: " + toBaseX(prod, output)); //gives output in whatever base they wanted
			System.out.print(reps[0] + "_" + repBase[0] + " ");
			for(int m = 1; m < iter; m++){
				System.out.print(oper + " " + reps[m] + "_" + repBase[m] + " ");
			}
			System.out.print("= " + toBaseX(prod, output) + "_" + output);
			//System.out.println(reps[0] + "_" + input1 + " " + oper + " " + reps[1] + "_" + input2 + " = " + toBaseX(prod, output) + "_" + output); //displays full equation
		}
		else if(func.equals("convert") || func.equals("Convert")){
			System.out.println("Enter a value to convert: ");
			String z = sc.nextLine();
			z = z.toUpperCase();
			System.out.println("What base is your input value? ");
			int input3 = sc.nextInt();
			if((input3 > 36) || (input3 < 1)){
				System.out.println("Please input a base within the bounds");
				System.exit(0);
			}
			System.out.println("What base do you want to convert to?");
			int output2 = sc.nextInt();
			if((output2 > 36) || (output2 < 1)){ //makes sure the base is from 1 to 36
				System.out.println("Please input a base within the bounds");
				System.exit(0);
			}
			int res = toDecimal(z, input3);
			System.out.println("Your decimal result is: " + res + "_10");
			System.out.println("Your base " + output2 + " result is: " + toBaseX(res, output2) + "_" + output2);
		}
	}
}