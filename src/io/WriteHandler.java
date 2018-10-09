package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class used for logging data
 */
public class WriteHandler {

    private static BufferedWriter writer;
    private static ArrayList<String> logList;

    public static void setup(String filePath, String fileName){
        logList = new ArrayList<>();
        try {
            writer = new BufferedWriter(new FileWriter(new File(filePath + fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addLog(String log){
        logList.add(log);
    }

    public static void writeLogs(){
        for(String log : logList){
            try {
                writer.write(log);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
