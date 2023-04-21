package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class Input {
    
    /**
     * 
     * @param the main method for the input class
     * @throws ParseException 
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException, ParseException
    {
        if(args.length == 1)
        {
             Reader red = new Reader(args[0]);
        }
        else
        {
            Reader red = new Reader("SampleInput1_2022.csv");
        } 
    }

  
}
