package Helpers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encriptamiento {
	
	public static String HashPassword(String originalPass) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(originalPass.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return originalPass;
	}
	
/*	
	public static String getHash(byte[] inputBytes, String algorithm) {
		String hashValue = "";
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			md.update(inputBytes);
			byte[] digestedBytes = md.digest();
			hashValue = DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();
		} 
		catch (Exception e) {
		}
	return hashValue;
}
	public static void main (String[] args) {
		String someString = "this is some string";
		System.out.println(getHash(someString.getBytes(), "SHA-512"));
	}
*/
}
		