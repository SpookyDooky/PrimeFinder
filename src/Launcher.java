import io.WriteHandler;
import main.PrimeAlgorithm;

public class Launcher {

    public static void main(String[] args){

        WriteHandler.setup("Data\\Version3\\" , "TimeCheck10ThousandPrimes.txt");
        double totalSeconds = 0.0;

        //Time checking

        for(int times = 0; times < 100;times++) {
            PrimeAlgorithm algo = new PrimeAlgorithm(10000);
            long startTime = System.nanoTime();
            algo.start();
            long endTime = System.nanoTime();
            double time = (endTime - startTime)/1000000000.0;
            System.out.println(time);
            WriteHandler.addLog("TIME: " + time);
            totalSeconds += time;
        }

        WriteHandler.addLog(" ");
        WriteHandler.addLog("AVERAGE TIME: " + String.valueOf(totalSeconds/100.0));
        WriteHandler.writeLogs();
    }
}
