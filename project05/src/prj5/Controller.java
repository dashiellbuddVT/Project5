package prj5;

import java.util.NoSuchElementException;

/**
 * Class that takes list of accounts and sorts them
 * @author henryauvil
 * @version 2023.04.26
 */
public class Controller 
{
    private SingularlyLinkedList<Account> accounts;
    private Account currAcc;
    
    /**
     * Constructor to initialize fields and set current account
     * @param accountList is the list being used and sorted
     */
    public Controller(SingularlyLinkedList<Account> accountList)
    {
        if (accountList == null)
        {
            throw new IllegalArgumentException("List is null");
        }
        
        accounts = accountList;
        currAcc = accounts.get(0);
    }
    
    
    /**
     * Method to get the account list
     * @return the list of accounts
     */
    public SingularlyLinkedList<Account> getAccountList()
    {
        return accounts;
    }

    /**
     * Method to sort the list by traditional rate
     * @param list is the list being sorted
     */
    public void sortByTrad(SingularlyLinkedList<Account> list)
    {
        SingularlyLinkedList.sort(list, Account.tradCompare());
        
    }
    
    /**
     * Method to sort the list by reach rate
     * @param list is the list being sorted
     */
    public void sortByReach(SingularlyLinkedList<Account> list)
    {
        SingularlyLinkedList.sort(list, Account.reachCompare());
        
    }
    
    /**
     * Method to sort the list by name
     * @param list is the list being sorted
     */
    public void sortByName(SingularlyLinkedList<Account> list)
    {
        SingularlyLinkedList.sort(list, Account.nameCompare());
        
    }
    
    /**
     * Method to get the name of the current account
     * @return the current account's name
     */
    public String getCurrAcc() 
    {
        if (currAcc == null) 
        {
            return null;
        }
        return currAcc.getName();
    }
    
    /**
     * Method to get the month array for the current account
     * @return the month array of the current account
     */
    public Month[] getMonths() {
        if (currAcc == null) 
        {
            throw new IllegalArgumentException("No current account");
        }
        return currAcc.getMonths();
    }
    
    /**
     * Method to check that the current account is not null
     * @return if the current account is not null
     */
    public boolean ready() 
    {
        return currAcc != null;
    }
    
    
}
