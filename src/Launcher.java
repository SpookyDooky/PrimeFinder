import io.WriteHandler;
import main.PrimeAlgorithm;

public class Launcher {

    public static void main(String[] args){

        WriteHandler.setup("Data\\Version2\\" , "ThousandPrimesTestStepInc.txt");
        PrimeAlgorithm algo = new PrimeAlgorithm(1000);
        algo.start();
        WriteHandler.writeLogs();
    }
}
