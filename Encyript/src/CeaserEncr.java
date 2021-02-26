import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CeaserEncr {
    int numberSteps;
    File toRead;
    File toWrite;
    public CeaserEncr(String pathRead, String pathWrite, char key){
        toRead=new File(pathRead);
        toWrite=new File(pathWrite);
        numberSteps=(key%96);
    }
    public void encriptMain() throws IOException {
        FileReader readFile=new FileReader(toRead);
        FileWriter writeFile=new FileWriter(toWrite);
        String toEncyript=new String();
        String encyriptedText=new String();
        int charRead;
        while ((charRead=readFile.read())!=-1){
           toEncyript+=(char) charRead;
        }
        for (int i=0;i<toEncyript.length();i++){
            if (!Character.isAlphabetic(toEncyript.charAt(i))){
                encyriptedText+=toEncyript.charAt(i);
            }
            else{
                if(Character.isUpperCase(toEncyript.charAt(i))){
                    char thecharToAdd=toEncyript.charAt(i);
                    int numericValueOfChar=thecharToAdd%64;
                    int decidePlace=(numberSteps+numericValueOfChar)%26;
                    if (decidePlace==0){
                        char finalForm= (char) (90);
                        encyriptedText+=finalForm;
                    }
                    else {
                        char toAddToText=(char) (64+decidePlace);
                        encyriptedText+=(char) (64+decidePlace);

                    }
                }
                else {
                    char thecharToAdd=toEncyript.charAt(i);
                    int numericValueOfChar=thecharToAdd%96;
                    int decidePlace=(numberSteps+numericValueOfChar)%26;
                    if (decidePlace==0){
                        char finalForm= (char) (122);
                        encyriptedText+=finalForm;
                    }
                    else {
                        encyriptedText+=(char) (96+decidePlace);

                    }

                }
            }
        }
        writeFile.write(encyriptedText);
        writeFile.close();

    }
}
