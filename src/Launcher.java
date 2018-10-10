import io.WriteHandler;
import main.PrimeAlgorithm;

public class Launcher {

    public static void main(String[] args){

        WriteHandler.setup("Data\\Version5\\" , "FoulStepIncreasePrimeHigh.txt");
        double totalSeconds = 0.0;

        //Time checking

       for(int times = 1; times < 201;times++) {
            PrimeAlgorithm algo = new PrimeAlgorithm(10000*times);
            //long startTime = System.nanoTime();
            algo.start();
            //long endTime = System.nanoTime();
            //double time = (endTime - startTime)/1000000000.0;
            //System.out.println(time);
            //WriteHandler.addLog("TIME: " + time);
            //totalSeconds += time;
        }

        //long startTime = System.nanoTime();
        //PrimeAlgorithm algo = new PrimeAlgorithm(10000);
        //algo.start();
        //long endTime = System.nanoTime();
        //double time = (endTime - startTime)/1000000000.0;
        //System.out.println(time);


        //WriteHandler.addLog(" ");
        //WriteHandler.addLog("AVERAGE TIME: " + String.valueOf(totalSeconds/100.0));

        System.out.println("WRITING");
        WriteHandler.writeLogs();
    }
}
