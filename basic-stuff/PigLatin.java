import java.util.Arrays;
import java.util.List;

class PigLatin {
	public static void main(String[] args){
		for (String arg:args) {
			System.out.print(pigLatin(arg) + " ");
		}
	System.out.println("");
	}

	private static String pigLatin(String input) {
		int splitPoint = leadingConsenents(input);
		String front = input.substring(splitPoint, input.length());
		String back = input.substring(0, splitPoint);
		return front + back + "ay";		
	}

private static int leadingConsenents(String input) {
		int counter = 0;
		for (int i=0;i<input.length();i++) {
			if (vowel(input.charAt(i))) return counter;
			else counter = counter+1;
		} return counter;
	}

	private static boolean vowel(char x) {
		return x == 'a' || x == 'e'|| x == 'i'|| x == 'o'|| x == 'u';
	}
}
