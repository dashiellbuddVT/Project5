package prj5;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

import list.AList;

/**
 * Class to read files
 * @author group
 * @version 2023/04/26
 */
public class Reader {

    private SingularlyLinkedList<Account> accountList;

    /**
     * Constructor
     * @param fileName is the name of the file
     * @throws FileNotFoundException
     * @throws java.io.IOException
     */
    public Reader(String fileName)
        throws FileNotFoundException,
        java.io.IOException {
        accountList = readFile(fileName);
        //displayAccounts(accountList);
    }


    /**
     * Method to read a file and get data from it
     * @param fileName is the name of the file
     * @return a list of accounts from the file
     * @throws FileNotFoundException
     * @throws java.io.IOException
     */
    public SingularlyLinkedList<Account> readFile(String fileName)
        throws FileNotFoundException,
        java.io.IOException {
        SingularlyLinkedList<Account> accountList =
            new SingularlyLinkedList<Account>();

        File f = new File(fileName);
        Scanner file = new Scanner(f);
        String thisLine = file.nextLine();
        while (file.hasNextLine()) {
            thisLine = file.nextLine();
            Scanner line = new Scanner(thisLine).useDelimiter(",");

            AList<String> tokens = new AList<String>();
            while (line.hasNext()) {
                tokens.add(line.next());
            }
            // throws a parse exception if its there are not 8 values
            if (tokens.getLength() != 10) {
                line.close();
                throw new java.io.IOException(
                    "not the right number of tokens");
            }

            String month = tokens.getEntry(0);
            String channelName = tokens.getEntry(2);
            String country = tokens.getEntry(3);
            String mainTopic = tokens.getEntry(4);
            int likes = Integer.parseInt(tokens.getEntry(5));
            int posts = Integer.parseInt(tokens.getEntry(6));
            int followers = Integer.parseInt(tokens.getEntry(7));
            int comments = Integer.parseInt(tokens.getEntry(8));
            int views = Integer.parseInt(tokens.getEntry(9));
            int monthIndex = 0;

            for (int i = 0; i < 13; i++) {
                if (month.equals(Month.MONTHS[i])) {
                    monthIndex = i;
                }
            }

            Month newMonth = new Month(monthIndex, likes, posts, followers,
                comments, views);

            boolean found = false;
            for (Account s : accountList) {
                if (channelName.equals(s.getName())) {
                    s.setMonth(newMonth);
                    found = true;
                }
            }
            if (!found) {
                Account newAccount = new Account(channelName, country,
                    mainTopic);
                newAccount.setMonth(newMonth);
                accountList.add(newAccount);

            }

            line.close();
        }
        file.close();
        return accountList;
    }
    
    /**
     * Method to get the list of accounts
     * @return the account list
     */
    public SingularlyLinkedList<Account> getAccounts()
    {
        return accountList;
    }


    /**
     * Method to display the account list
     * @param accountList is a list of the accounts being displayed
     */
    public void displayAccounts(SingularlyLinkedList<Account> accountList) {

        DecimalFormat df = new DecimalFormat("#.#");
        //CompareName comp = new CompareName();
        //accountList.sort(comp,13);

        for (Account a : accountList) {
            System.out.println(a.getName());
            System.out.print("traditional: ");
            System.out.println(df.format(a.getMonth(13).getTradRate()));
            System.out.println("==========");
        }
        CompareReach comp2 = new CompareReach(13);
        accountList.sort(comp2);
        System.out.println("**********");
        System.out.println("**********");
        for (Account a : accountList) {
            System.out.println(a.getName());
            System.out.print("reach: ");
            System.out.println(df.format(a.getMonth(13).getReachRate()));
            System.out.println("==========");
        }
    }
}
