package prj5;

import java.util.Comparator;

/**
 * this compares the comparator
 * 
 * @author Group
 * @version 4/21/2023
 */
public class CompareName implements Comparator<Account> 
{
    
    public int compare(Account o1, Account o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
