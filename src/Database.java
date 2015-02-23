/**
 *@author Bernardo Pla
 * Panther ID: 3885008
 * COP 3337
 * Assignment 1
 */

import java.util.ArrayList;
public class Database {
    
    private BankAccount bAcc;//bank account variable
    private int index ; //index to navigate database
    private boolean found; //boolean variable to determine if account exists
    private ArrayList<BankAccount> openAccounts; //list of open accounts
    private ArrayList<BankAccount> closedAccounts ;//list of closed accounts
    
    public Database()
    {
        openAccounts = new ArrayList<BankAccount>() ; //database for open accounts
        closedAccounts = new ArrayList<BankAccount>() ; //database for closed accounts
    }
    
    public void add(BankAccount bAcc)
    {
        openAccounts.add(bAcc); //adds bank account to list of open accounts
    }
    
    public BankAccount getBankAccount()
    {
        return bAcc; //calls bank account information
    }
    
    public int getIndex()
    {
        return index ; //calls account location in list
    }
    
    public int getListSize()
    {
        return openAccounts.size(); //calls information on size of database
    }
    
    public BankAccount delete(String str)
    {
        found = false ; //set boolean variable to false
        index = 0 ; //set index to zero
        int i = openAccounts.size(); //sets i variable to size of list
        
        while(index < i && !found)
        {
            bAcc = openAccounts.get(index); //sets account to account information at that indexed location
            if(bAcc.getCustomer().getaccNo().equalsIgnoreCase(str))
                found = true; //if statement sets up whether account exists
            else
                index++; //increment by one to continue searching for deletion
        }
        return openAccounts.remove(index);
    }
    
    public boolean isInList()
    {
        return found; //boolean to determine if account is valid
    }
    
    public void search(String str)
    {
        found = false ; //set boolean variable to false
        index = 0 ; //sets index to begin at 0
        int i = openAccounts.size(); //sets i to the size of the database
        
        while(index < i && !found)
        {
            bAcc = openAccounts.get(index);
            if (bAcc.getCustomer().getaccNo().equalsIgnoreCase(str))
                found = true; //if this is true...stop
            
            else
                index++; //if false increment by one
        }
    }
    
    public String toString()
    {
        String str = openAccounts.toString() ; //get database and make it a string
        return str; //return database as string
    }
    
}//end of class declaration
