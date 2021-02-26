import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class HashTestOne {
    public static void main(String[] args) throws IOException {
        File exampleFile = new File("examples.txt");
        FileReader readSent = new FileReader(exampleFile.getAbsolutePath());
        BufferedReader readBuff = new BufferedReader(readSent);
        HashMap<String,String> newMap = new HashMap<String,String>();
        HashMap<String, Integer> distro = new HashMap<String, Integer>();
        HashMap <Integer,Integer> stats = new HashMap<Integer,Integer>();
        String sentance;
        while ((sentance = readBuff.readLine()) != null){
            int currentProcessed = 0;
            for (int i = 0; i<sentance.length(); i++){
                if (sentance.length() == 1){
                    String translateToString = new BigInteger(String.valueOf(sentance.charAt(0)).getBytes()).toString(2);
                    int toProses = Integer.parseInt(translateToString,2);
                    currentProcessed = toProses + toProses;
                    break;
                }else {
                    String translateToString = new BigInteger(String.valueOf(sentance.charAt(i)).getBytes()).toString(2);
                    int toProses = Integer.parseInt(translateToString,2);
                    currentProcessed += toProses;

                }
            }
            String binaryAddition = Integer.toBinaryString(currentProcessed);
            String resultReverse = Integer.toBinaryString(~currentProcessed);

            if (binaryAddition.length()<8){
                binaryAddition = String.format("%8s",Integer.toBinaryString(currentProcessed)).replace(' ','0');
            }

            String finalResult = binaryAddition.substring(binaryAddition.length()-8,binaryAddition.length()) + resultReverse.substring(resultReverse.length()-8, resultReverse.length());
            newMap.put(finalResult,sentance);
            if (distro.containsKey(finalResult)){
                distro.put(finalResult,distro.get(finalResult)+1);

            }else {distro.put(finalResult,1);}
            if (stats.containsKey(distro.get(finalResult))){
                stats.put(distro.get(finalResult),stats.get(distro.get(finalResult))+1);
            }else {
                stats.put(distro.get(finalResult),1);
            }
        }
        System.out.println(newMap);
        System.out.println("Amount of hash digests produced out of 1000 random words: "+newMap.size());
        System.out.println(distro);
        System.out.println("Amount of Values - Amount Keys that have that many values attached");
        System.out.println(stats);
        System.out.println("This means that there are: ");
        System.out.println("31 keys that corresponds to a single value");
        System.out.println("44 keys that corresponds to two values");
        System.out.println("43 keys that corresponds to three values");
        System.out.println("33 keys that corresponds to four values");
        System.out.println("38 keys that corresponds to five values");
        System.out.println("28 keys that corresponds to six values");
        System.out.println("12 keys that corresponds to seven values");
        System.out.println("12 keys that corresponds to eight values");
        System.out.println("8 keys that corresponds to nine values");
        System.out.println("1 keys that corresponds to ten values");

    }
}
