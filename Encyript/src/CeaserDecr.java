import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CeaserDecr {
    int numberSteps;
    File toRead;
    File toWrite;
    public CeaserDecr(String pathRead, String pathWrite, char key){
        toRead=new File(pathRead);
        toWrite=new File(pathWrite);
        numberSteps=(key%96);
    }
    public void decriptMain() throws IOException {
        FileReader readFile=new FileReader(toRead);
        FileWriter writeFile=new FileWriter(toWrite);
        String encyriptedText=new String();
        String dencyriptedText=new String();

        int charRead;
        while ((charRead=readFile.read())!=-1){
            encyriptedText+=(char) charRead;
        }

        for (int i=0;i<encyriptedText.length();i++){
            if (!Character.isAlphabetic(encyriptedText.charAt(i))){
                dencyriptedText+=encyriptedText.charAt(i);
            }
            else{
                if(Character.isUpperCase(encyriptedText.charAt(i))){
                    char thecharToAdd=encyriptedText.charAt(i);
                    int numericValueOfChar=thecharToAdd%64;
                    int decidePlace=(numericValueOfChar-numberSteps)%26;
                    if (decidePlace==0){
                        char finalForm= (char) (90);
                        dencyriptedText+=finalForm;
                    }
                    else {
                        if (decidePlace<0){
                            dencyriptedText+=(char)(90+decidePlace);
                        }
                        else {
                            dencyriptedText+=(char)(64+decidePlace);
                        }
                    }
                }
                else {
                    char thecharToAdd=encyriptedText.charAt(i);
                    int numericValueOfChar=thecharToAdd%96;
                    int decidePlace=(numericValueOfChar-numberSteps)%26;
                    if (decidePlace==0){
                        char finalForm= (char) (122);
                        dencyriptedText+=finalForm;
                    }
                    else {
                        if (decidePlace<0){
                            dencyriptedText+=(char)(122+decidePlace);
                        }
                        else {
                            dencyriptedText+=(char)(96+decidePlace);
                        }
                    }
                }

            }
        }
        writeFile.write(dencyriptedText);
        writeFile.close();
    }
}
