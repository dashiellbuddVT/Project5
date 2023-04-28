package prj5;

import java.util.Comparator;

/**
 * this compares the comparator
 * 
 * @author Group
 * @version 4/21/2023
 */
public class CompareTraditional implements Comparator<Account> 
{
    private int month;
    
    public CompareTraditional(int u)
    {
        month = u;
    }


    public int compare(Account o1, Account o2) 
    {
        return (int)(o2.getMonth(month).getTradRate() 
            - o1.getMonth(month).getTradRate());
    }

}
