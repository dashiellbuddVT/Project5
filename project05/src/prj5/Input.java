package prj5;

import java.io.FileNotFoundException;

import java.text.ParseException;

public class Input {

    /**
     * 
     * @param the
     *            main method for the input class
     * @throws ParseException
     * @throws FileNotFoundException
     */
    public static void main(String[] args)
        throws FileNotFoundException,
        java.io.IOException {
        Reader red;
        if (args.length == 1) {
            red = new Reader(args[0]);
        }
        else {
            red = new Reader("SampleInput1_2022.csv");
        }
        
        SingularlyLinkedList<Account> accounts = red.getAccounts();
        new Display(new Controller(accounts));
        for (Account account : accounts)
        {
            System.out.println(account.toString());
        }
        
    }

}
