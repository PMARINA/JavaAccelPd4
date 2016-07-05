import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 * 
 * AES Class - using base 64 to allow more characters than would otherwise be
 * allowed
 * 
 * @author PMARINA
 * @version 6/13/2016
 */
public class AESCode {

	private static SecretKeySpec privateKey;
	private static byte[] dog;
	private static String decryptedString;
	private static String encryptedString;

	/**
	 * @param myKey - set the key
	 */
	private static void setKey(String myKey) {
		MessageDigest mdig = null;
		try {
			dog = myKey.getBytes("UTF-8"); // Dog is an array of bytes, get it?
			mdig = MessageDigest.getInstance("SHA-1");
			dog = mdig.digest(dog);
			dog = Arrays.copyOf(dog, 16);
			privateKey = new SecretKeySpec(dog, "AES");

		} catch (Exception e) {
		}

	}

	public static String getDecryptedString() {
		return decryptedString;
	}

	public static String getEncryptedString() {
		return encryptedString;
	}

	private static String encrypt(String mess) {
		Cipher aesCipher = null; // Initialize the cipher
		try {
			aesCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		} catch (Exception e) {
		}
		try {
			aesCipher.init(Cipher.ENCRYPT_MODE, privateKey); // Construct
																// cipher,
																// using key
		} catch (Exception e) {
		}
		try {
			encryptedString = (Base64.encodeBase64String(aesCipher.doFinal(mess.getBytes("UTF-8"))));
		} catch (Exception e) {
		}
		return encryptedString;
	}

	private static String decrypt(String strToDecrypt) {
		Cipher cipher = null; // Initialize cipher
		try {
			cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING"); // Construct a
																	// cipher
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			decryptedString = (new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decryptedString;
	}

	public static String encryptMessage(String mess, String pd) {
		setKey(pd);
		encrypt(mess);
		return encryptedString;
	}

	public static String decryptMessagage(String mess, String pd) {
		setKey(pd);
		decrypt(mess);
		return decryptedString;
	}

}