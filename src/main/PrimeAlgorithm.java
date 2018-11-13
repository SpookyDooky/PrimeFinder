package main;

import io.WriteHandler;

import java.util.ArrayList;

public class PrimeAlgorithm {

    private int primesFound = 0;
    private int amountPrimes;

    private ArrayList<Integer> result;

    public PrimeAlgorithm(int amountPrimes){
        this.amountPrimes = amountPrimes;
        result = new ArrayList<>();
    }

    public void start(){

        for(int x = 2; x < 50000;x++){
            boolean isPrime = true;
            int steps = 0;

            int increase = 1;
            for(int z = 2; z < x; z += increase){
                steps++;

                if(x % z == 0){
                    isPrime = false;
                    break;
                }

                if(z == 3){
                    increase = 2;
                }

                if(z == 83){
                    increase = 3;
                }
            }

            if(isPrime){
                result.add(x);
                primesFound++;
                WriteHandler.addLog("NUMBER:" + x + ", STEPS: " + steps);
            }

            if(amountPrimes == primesFound){
                break;
            }
        }
    }
}
