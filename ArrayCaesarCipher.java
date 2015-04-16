package leo.impl;

public class ArrayCaesarCipher {

	protected char[] encoder = new char[26];
	protected char[] decoder = new char[26];
	
	public ArrayCaesarCipher(int rotation) {
		for(int i=0; i<26; i++) {
			encoder[i] = (char) ('A' + (i + rotation) % 26);
			decoder[i] = (char) ('A' + (i - rotation + 26) % 26);
		}
	}
	
	public String encrypt(String message) {
		return transform(message, encoder);
	}
	public String decrypt(String secret) {
		return transform(secret, decoder);
	}
	
	//can only recognize the characters, not the symbols
	public String transform(String original, char[] code) {
		char[] msg = original.toCharArray();
		for(int i=0; i<msg.length; i++) {
			if(Character.isUpperCase(msg[i])) {
				int j = msg[i] - 'A';
				msg[i] = code[j];
			} else if (Character.isLowerCase(msg[i])) {
				msg[i] = Character.toUpperCase(msg[i]);
				int j = msg[i] - 'A';
				msg[i] = Character.toLowerCase(code[j]);
			}
		}
		return new String(msg);
	}
	
	public static void main(String[] args) {
		ArrayCaesarCipher cipher = new ArrayCaesarCipher(5);
		System.out.println("Encryption code = " + new String(cipher.encoder));
		System.out.println("Decryption code = " + new String(cipher.decoder));
		String message = "THE EAGLE is in Play; MEET AT JOE'S";
		System.out.println("Message in char array: " + new String(message.toCharArray()));
		String coded = cipher.encrypt(message);
		System.out.println("Secret: " + coded);
		String decoded = cipher.decrypt(coded);
		System.out.println("Message: " + decoded);
	}
}
