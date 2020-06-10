import java.math.BigInteger;
import java.util.Scanner;

public class Operations {

    public BigInteger input() {
        Scanner s = new Scanner(System.in);
        return s.nextBigInteger();
    }

    public BigInteger addition(BigInteger x, BigInteger y) {
        return x.add(y);
    }

    public BigInteger difference(BigInteger x, BigInteger y) {
        return x.subtract(y);
    }

    public BigInteger multiplication(BigInteger x, BigInteger y) {
        return x.multiply(y);
    }

    public BigInteger division(BigInteger x, BigInteger y){
        return x.divide(y);
    }
}
