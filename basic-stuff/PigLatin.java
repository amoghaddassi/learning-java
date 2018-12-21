import java.util.Arrays;
import java.util.List;

class PigLatin {
	public static void main(String[] args){
		for (String arg:args) {
			System.out.print(pigLatin(arg) + " ");
		}
	System.out.println("");
	}

	/**Converts input into pig latin (moving all consenants to back, and adding ay*/
	private static String pigLatin(String input) {
		List vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
		String front = "";
		String back = "";
		for (int i=0;i<input.length();i++) {
			if (vowels.contains(input.charAt(i))) {
				front = front+input.charAt(i);
			} else {
				back = back+input.charAt(i);
			}
		}
		return front+back+"ay";
	}
}
