/**
 * @Author Jason Hao
 */

package caesarCipher;

import java.util.Scanner;

public class caesarCipher {
	
	/**
	 * Encrypts the text
	 * @param text What needs to be encrypted
	 * @param shift How many positions it needs to be shifted
	 * @return Encrypted Text
	 */
	public static String encrypt(String text, int shift) {
		
		StringBuffer encryptedText = new StringBuffer();
		
		for(int i = 0; i < text.length(); i++) {	
			/* Removes the whitespaces */
			if(text.charAt(i) == 32) {
				continue;
			}
			
			/* Utilizes ascii table to convert upper case letters */
			if(Character.isUpperCase(text.charAt(i))) {
				/* Shifts character by 65 for upper case letters */
				char ch = (char)(((int)text.charAt(i) + shift - 65) % 26 + 65);
				encryptedText.append(ch);
			} else {
				/* Shifts character by 97 for the lower case letters */
				char ch = (char)(((int)text.charAt(i) + shift - 97) % 26 + 97);
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
