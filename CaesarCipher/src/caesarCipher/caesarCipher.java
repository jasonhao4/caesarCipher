package caesarCipher;

import java.util.InputMismatchException;
import java.util.Scanner;

public class caesarCipher {
	
	public static String encrypt(String text, int num) {
		StringBuffer encryptedText = new StringBuffer();
		text.toLowerCase();
		for(int i = 0; i < text.length(); i++) {
			if(text.charAt(i) == 32) {
				continue;
			}
			if(Character.isUpperCase(text.charAt(i))) {
				char ch = (char)(((int)text.charAt(i) + num - 65) % 26 + 65);
				encryptedText.append(ch);
			} else {
				char ch = (char)(((int)text.charAt(i) + num - 97) % 26 + 97);
				encryptedText.append(ch);
			}
		}
		return encryptedText.toString();
	}
	
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		String text;
		int shift;
		while (true) {
			System.out.print("Enter the text: ");
			text = scan.nextLine();
			if(!text.equals("")) {
				break;
			} else {
				System.out.println("Please enter text");
			}
		}
		while (true) {
			System.out.print("Enter shift: ");
			try {
				shift = scan.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Please enter correct shift value");
			}
		}
		System.out.println("\nEncrypted text: " + encrypt(text, shift));
		scan.close();
	}
}
