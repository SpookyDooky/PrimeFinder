package main;

import io.WriteHandler;

import java.util.ArrayList;
import java.util.HashSet;

public class PrimeAlgorithm {

    private int primesFound = 0;
    private int amountPrimes;

    private int[] list;

    private int foulSteps = 0;

    public PrimeAlgorithm(int amountPrimes){
        this.amountPrimes = amountPrimes;
        this.list = new int[amountPrimes];
    }

    public void start(){

        for(int x = 2; x < 250000000;x++){
            boolean isPrime = true;
            int steps = 0;

            int increase = 1;
            for(int z = 2; z < (int)(x * 0.5) + 1; z += increase){
                steps++;

                if(x % z == 0){
                    isPrime = false;
                    if(steps > foulSteps) {
                        foulSteps = steps;
                    }
                    break;
                }

                if(z == 3){
                    increase = 2;
                }

                if (z > 5) {
                    break;
                }
            }

            if(isPrime) {
                for (int y = 0; y < primesFound; y++) {
                    if (list[y] > x / 2) {
                        break;
                    }
                    steps++;
                    if (x % list[y] == 0) {
                        isPrime = false;
                        if(steps > foulSteps) {
                            foulSteps = steps;
                        }
                        break;
                    }

                    if(y > 2000){
                        break;
                    }
                }
            }

            if(isPrime){
                list[primesFound] = x;
                primesFound++;
                WriteHandler.addLog("NUMBER:" + x + ", STEPS: " + steps);
            }

            if(amountPrimes == primesFound){
                System.out.println(foulSteps);
                break;
            }
        }
    }
}
