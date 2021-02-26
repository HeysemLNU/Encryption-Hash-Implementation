import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class HashTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hashOutput ;
        System.out.println("Enter the password: ");
        String userInput = sc.nextLine();
        String padding = "X";

        // Add padding to make sure that they are even and there is at least 4 letters

        if (userInput.length()%2 != 0){

            if (userInput.length()<4){
                int toAdd = 4 - userInput.length()%4;
                for (int i =0; i<toAdd; i++){
                    userInput =  userInput + padding ;
                }

            }
            else {
                userInput =  userInput + padding ;
            }
        }
        System.out.println(userInput);

        ArrayList<String> stringsParsed = new ArrayList<>();

        int beginPars = 0;
        int endPars =0;
        int amountParsedCountdown = userInput.length();

        while(amountParsedCountdown > 0){
            endPars = endPars + 2;
            String addArray = userInput.substring(beginPars,endPars);
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

       System.out.println("Your Unique hash is: " +hashOutput);


    }
}
