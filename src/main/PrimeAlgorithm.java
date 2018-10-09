package main;

import io.WriteHandler;

import java.util.ArrayList;
import java.util.HashSet;

public class PrimeAlgorithm {

    private int primesFound = 0;
    private int amountPrimes;

    private ArrayList<Integer> result;

    private HashSet<Integer> history;

    public PrimeAlgorithm(int amountPrimes){
        this.amountPrimes = amountPrimes;
        this.result = new ArrayList<>();
        this.history = new HashSet<>();
    }

    public void start(){

        for(int x = 2; x < 250000;x++){
            boolean isPrime = true;
            int steps = 0;

            int increase = 1;
            for(int z = 2; z < (int)x; z += increase){
                steps++;

                if(x % z == 0){
                    isPrime = false;
                    break;
                }

                if(z == 3){
                    increase = 2;
                }
            }

            if(isPrime){
                result.add(x);
                primesFound++;
                //WriteHandler.addLog("NUMBER:" + x + ", STEPS: " + steps);
            }

            if(amountPrimes == primesFound){
                break;
            }
        }
    }
}
