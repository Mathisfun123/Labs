// Lab23ast.java
// This is the starting version of the "Perfect Number" program.
import java.util.*;

public class Lab23ast {

	private static LinkedHashMap<String, String> perfectNums;
	private static Scanner sc;

	public static void main (String args[]) {
		init();
		run();
	}

	public static void init() {
		createMap();
		initScanner();
	}

	public static void run() {
		String in = getInput().trim();
		System.out.println();
		for(String s : perfectNums.keySet()) {
			//System.out.println(s);
			if(Integer.parseInt(s) <= Integer.parseInt(in)) {
				System.out.println(perfectNums.get(s) + " = " + s);
			}
		}
	}

	public static void initScanner() {
		sc = new Scanner(System.in);
	}

	public static void createMap() {
		perfectNums = new LinkedHashMap<>();
		perfectNums.put("6", "1 + 2 + 3");
		perfectNums.put("28", "1 + 2 + 4 + 7 + 14");
		perfectNums.put("496", "1 + 2 + 4 + 8 + 16 + 31 + 62 + 124 + 248");
		perfectNums.put("8128", "1 + 2 + 4 + 8 + 16 + 32 + 64 + 127 + 254 + 508 + 1016 + 2032 + 4064");
	}

	public static String getInput() {
		boolean badInput = false;
		String input = "";
		do {
			System.out.print("Enter an integer in [2..10000] range ===>> ");
			input = sc.nextLine();
			try {
				Integer.parseInt(input);
				if(Integer.parseInt(input) > 10000 || Integer.parseInt(input) < 2) throw new ArithmeticException();
				badInput = true;
			} catch(Exception e) {
				System.out.println("Invalid input: \'" + input + "\'");
				badInput = false;
			}
		} while(!badInput);
		return input;
	}

}
