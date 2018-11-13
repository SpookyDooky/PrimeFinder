package main;

import java.math.BigInteger;
import java.util.Random;

public class PrimalityTester {

    private int[] checkList;
    private BigInteger k;

    public PrimalityTester(int[] checkList, BigInteger k){
        this.checkList = checkList;
        this.k = k;
    }

    public boolean probablePrime(BigInteger integer){
        BigInteger n_1 = integer.subtract(BigInteger.ONE);

        BigInteger r = findR(n_1);
        BigInteger d = findD(n_1,r);

        System.out.println("R: " + r.toString());
        System.out.println("D: " + d.toString());
        for(BigInteger x = new BigInteger("0"); x.compareTo(this.k) == -1;x = x.add(BigInteger.ONE)) {
            BigInteger random = generateRandom(integer);

            BigInteger formulaX1 = power(random, d).mod(integer);

            boolean goBoolean1 = true;
            if (formulaX1.equals(BigInteger.ONE) || formulaX1.equals(n_1)) {
                goBoolean1 = false;
            }

            boolean goBoolean2 = true;
            if (goBoolean1) {
                for (BigInteger y = new BigInteger("0"); y.compareTo(d.subtract(BigInteger.ONE)) == -1; y =y.add(BigInteger.ONE)) {
                    System.out.println(y.toString());
                    formulaX1 = (formulaX1.pow(2)).mod(integer);
                    if (formulaX1.compareTo(n_1) == 0) {
                        goBoolean2 = false;
                    }
                }

                if (goBoolean2) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Generates a random BigInteger
     * @param integer - The range
     * @return - The BigInteger
     */
    public BigInteger generateRandom(BigInteger integer){
        Random random = new Random();
        BigInteger upperLimit = integer.subtract(new BigInteger("2"));

        BigInteger result;

        do{
            result = new BigInteger(upperLimit.bitLength(), random);
        } while(result.compareTo(upperLimit) >= 0 && result.compareTo(new BigInteger("2")) == -1);
        return result;
    }

    /**
     * Repeated squaring
     * @param integer - The integer
     * @param exponent - The exponent
     * @return - Returns a BigInteger
     */
    public BigInteger power(BigInteger integer, BigInteger exponent){
        BigInteger result = BigInteger.ONE;

        while (exponent.signum() > 0) {
            if (exponent.testBit(0)) result = result.multiply(integer);
            integer = integer.multiply(integer);
            exponent = exponent.shiftRight(1);
        }
        return result;
    }

    public BigInteger findR(BigInteger integer){
        System.out.println("Integer");
        BigInteger base = new BigInteger("2");

        BigInteger exponent = new BigInteger("2");
        while(power(base,exponent).compareTo(integer) == -1){
            exponent = exponent.add(new BigInteger("1"));
        }

        exponent = exponent.subtract(new BigInteger("1"));

        while(integer.mod(power(base,exponent)).compareTo(new BigInteger("0")) != 0){
            exponent = exponent.subtract(BigInteger.ONE);
        }

        return power(base,exponent);
    }

    public BigInteger findD(BigInteger integer, BigInteger r){
        BigInteger d = integer.divide(r);

        return d;
    }
}
