import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {
	private BigInteger n, d, e;

	public RSA(int bitlen) {
		SecureRandom r = new SecureRandom();
		BigInteger p = new BigInteger(bitlen / 2, 100, r);
		BigInteger q = new BigInteger(bitlen / 2, 100, r);
		n = p.multiply(q);
		BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		e = new BigInteger("3");
		while (m.gcd(e).intValue() > 1)
			e = e.add(new BigInteger("2"));
		d = e.modInverse(m);
	}

	public RSA(String a, String b, String c) {
		n = new BigInteger(a);
		d = new BigInteger(b);
		e = new BigInteger(c);
	}

	public BigInteger encrypt(BigInteger message) {
		return message.modPow(e, n);
	}

	public BigInteger decrypt(BigInteger message) {
		return message.modPow(d, n);
	}

	public String getN() {
		return n.toString();
	}

	public String getD() {
		return d.toString();
	}

	public String getE() {
		return e.toString();
	}
}