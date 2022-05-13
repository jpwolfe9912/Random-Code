import java.util.Scanner;
class BaseCalc1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a binary number");
		int x = sc.nextInt(); //first input value
		System.out.println("Enter another binary number");
		int y = sc.nextInt(); //second input value
		String Strx = Integer.toString(x); //converts first input value to String
		String Stry = Integer.toString(y); //converts second input value to String
		int lengthx = Strx.length();
		int lengthy = Stry.length();
		double decx = 0;
		double decy = 0;
		double finDecx = 0;
		double finDecy = 0;
		for(int i = 0; i <= lengthx - 1; i++) {
			char charx = Strx.charAt(i); //
			if (charx == '0') {
				decx = 0; //if a digit is 0, it will not go into the conversion
			}
			else if (charx == '1') {
				int difi = lengthx - i - 1;
				decx = Math.pow(2, difi); //if a digit is 1, it will take 
			}								//2^(numerical placement in the overall number
			else {
				System.out.println("Input a fucking binary number you idiot");
				System.exit(0);
			}
		finDecx = finDecx + decx; //consecutively adds the numbers from above
		}
		for(int j = 0; j <= lengthy - 1; j++) {
			char chary = Stry.charAt(j); //
			if (chary == '0') {
				decy = 0;
			}
			else if (chary == '1') {
				int difj = lengthy - j - 1;
				decy = Math.pow(2, difj);
			}
			else {
				System.out.println("Input a fucking binary number you idiot");
				System.exit(0);
			}
			finDecy = finDecy + decy;
		}
		double prod = finDecx * finDecy; //multiplies the two dec numbers
		if(prod == 0) {
			System.out.println("Your binary product is 0");
			System.exit(0);
		}
		int prod2 = (int)prod;
		System.out.println("Your decimal product is " + prod2);
		//now we need to convert back to binary
		double fac = 0;
		String binNum = "";
		double bin = 0;
		while (Math.pow(2, fac) <= prod) { //while 2^fac <= 49
				fac++;						//keeps adding to fac until a 2power exceeds the product
		}
		fac = fac - 1;						//sets fac equal to the highest 2power that fit inside prod
		while (fac >= 0) {
			bin = Math.pow(2, fac); //raises 2^fac
			if(prod >= bin) {
				prod = prod - bin; //subtracts the product from the highest 2power that fits inside
				binNum = binNum + "1";
				fac--;
			}
			else {
				binNum = binNum + "0";
				fac--;
			}
		}
		System.out.println("Your binary product is " + binNum);
	}
}