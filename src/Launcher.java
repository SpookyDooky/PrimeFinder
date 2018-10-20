import main.PrimalityTester;

import java.math.BigInteger;

public class Launcher {

    public static void main(String[] args){
        /**
        WriteHandler.setup("Data\\" , "FoulStepIncreasePrimeHigh.txt");
        PrimeAlgorithm algo = new PrimeAlgorithm(10000);
        algo.start();

        System.out.println("WRITING");
        WriteHandler.writeLogs();
         **/

        PrimalityTester tester = new PrimalityTester(new int[1], new BigInteger("10"));
        System.out.println(tester.probablePrime(new BigInteger("10000169")));
    }
}
