import java.util.Scanner;
class BaseCalc2 {
	static int toDecimal(int foo){
		String strFoo = Integer.toString(foo); //converts first input value to String
		int lengthFoo = strFoo.length();
		double decFoo = 0;
		double finDecFoo = 0;
		for(int i = 0; i <= lengthFoo - 1; i++) {
			char charFoo = strFoo.charAt(i); //
			if (charFoo == '0') {
				decFoo = 0; //if a digit is 0, it will not go into the conversion
			}
			else if (charFoo == '1') {
				int difi = lengthFoo - i - 1;
				decFoo = Math.pow(2, difi); //if a digit is 1, it will take 
			}								//2^(numerical placement in the overall number)
			else {
				System.out.println("Input a fucking binary number you idiot");
				System.exit(0);
			}
			finDecFoo += decFoo; //consecutively adds the numbers from above
		}
		return (int)finDecFoo;
	}
	static String toBinary(double bar){
		if(bar == 0) {
			System.out.println("Your binary product is 0");
			System.exit(0);
		}
		//now we need to convert back to binary
		double fac = 0;
		String binNum = "";
		double bin = 0;
		while (Math.pow(2, fac) <= bar) { //while 2^fac <= 49
				fac++;						//keeps adding to fac until a 2power exceeds the product
		}
		fac = fac - 1;						//sets fac equal to the highest 2power that fit inside bar
		while (fac >= 0) {
			bin = Math.pow(2, fac); //raises 2^fac
			if(bar >= bin) {
				bar -= bin; //subtracts the product from the highest 2power that fits inside
				binNum = binNum + "1";
				fac--;
			}
			else {
				binNum = binNum + "0";
				fac--;
			}
		}
		return binNum;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a binary number");
		int x = sc.nextInt(); //first input value
		System.out.println("Enter another binary number");
		int y = sc.nextInt(); //second input value
		double prod = toDecimal(x) * toDecimal(y); //multiplies the two decimal outputs
		System.out.println("Your decimal product is: " + (int)prod);
		System.out.println("Your binary product is " + toBinary(prod));
	}
}