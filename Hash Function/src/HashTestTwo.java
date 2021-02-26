import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class HashTestTwo {
    public static void main(String[] args) throws IOException {
        File exampleFile = new File("examples.txt");
        FileReader readSent = new FileReader(exampleFile.getAbsolutePath());
        BufferedReader readBuff = new BufferedReader(readSent);
        HashMap<String,String> newMap = new HashMap<String,String>();
        HashMap<String, Integer> distro = new HashMap<String, Integer>();
        HashMap <Integer,Integer> stats = new HashMap<Integer,Integer>();
        String sentance;
        while ((sentance = readBuff.readLine()) != null){

            String hashOutput ;
            String padding = "X";

            // Add padding to make sure that they are even and there is at least 4 letters

            if (sentance.length()%2 != 0){

                if (sentance.length()<4){
                    int toAdd = 4 - sentance.length()%4;
                    for (int i =0; i<toAdd; i++){
                        sentance =  sentance + padding ;
                    }

                }
                else {
                    sentance =  sentance + padding ;
                }
            }

            ArrayList<String> stringsParsed = new ArrayList<>();

            int beginPars = 0;
            int endPars =0;
            int amountParsedCountdown = sentance.length();

            while(amountParsedCountdown > 0){
                endPars = endPars + 2;
                String addArray = sentance.substring(beginPars,endPars);
                stringsParsed.add(addArray);
                amountParsedCountdown -=2;
                beginPars = beginPars +2;
            }

            int currentProcessed = 0;

            for (int i = 0; i<stringsParsed.size(); i++){
                if (i == 0){
                    String translateToString = new BigInteger(stringsParsed.get(i).getBytes()).toString(2);
                    currentProcessed = Integer.parseInt(translateToString,2);
                }else {
                    String translateToString = new BigInteger(stringsParsed.get(i).getBytes()).toString(2);
                    currentProcessed = currentProcessed ^ Integer.parseInt(translateToString,2);
                }
            }

            hashOutput = String.format("%16s",Integer.toBinaryString(currentProcessed)).replace(' ','0');

            newMap.put(hashOutput,sentance);
            if (distro.containsKey(hashOutput)){
                distro.put(hashOutput,distro.get(hashOutput)+1);

            }else {distro.put(hashOutput,1);}
            if (stats.containsKey(distro.get(hashOutput))){
                stats.put(distro.get(hashOutput),stats.get(distro.get(hashOutput))+1);
            }else {
                stats.put(distro.get(hashOutput),1);
            }
        }
        System.out.println(newMap);
        System.out.println("Amount of hash digests prodused out of 1000 random words: "+newMap.size());
        System.out.println(distro);
        System.out.println("Amount Values - Amount Keys that have that many values attached");
        System.out.println(stats);
        System.out.println("This means that there are: ");
        System.out.println("730 keys that corresponds to a single value");
        System.out.println("108 keys that corresponds to two values");
        System.out.println("14 keys that corresponds to three values");
        System.out.println("3 keys that corresponds to four values");

    }
}
