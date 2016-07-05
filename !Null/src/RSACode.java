import java.math.BigInteger;

public class RSACode {
	public static String[] encrypt(String s) {
		RSA rsa = new RSA(1024);
		String[] e = new String[] { rsa.getN(), rsa.getD(), rsa.getE(), null };
		e[e.length - 1] = (rsa.encrypt(new BigInteger(s.getBytes()))).toString();
		return e;
	}

	public static String decrypt(String[] s){
		RSA r = new RSA(s[0],s[1],s[2]);
		byte[] nibble = r.decrypt(new BigInteger(s[3])).toByteArray();
		return new String(nibble);
	}
}