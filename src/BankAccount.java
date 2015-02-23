/**
 *@author Bernardo Pla
 * Panther ID: 3885008
 * COP 3337
 * Assignment 1
 */
public class BankAccount {
    
    private Customer cust ; //calls customer class for this declaration, includes name and address
    private double balance ; //balance variable
    
    public BankAccount(Customer cust, double bal)
    {
        this.cust = cust ; //establish customer variable
        balance = bal ; //establish balance variable
    }
    
    public Customer getCustomer()
    {
        return cust ; //calls customer variable
    }
    
    public double getBalance()
    {
        return balance ; //calls balance variable
    }
    
    public void deposit(double amount)
    {
        balance = balance + amount ; //formula for deposits
    }
    
    public void withdraw(double amount)
    {
        balance = balance - amount ; //formula for withdrawls
    }
    
    public boolean isSufficient(double amount)
    {
        return balance > amount ; //comparison test to see if the account has enough funds
    }
    
    public String toString()
    {
        String str = cust + "\n" + "Balance $" + Double.toString(balance) + "\n \n" ; //places information to string
        return str; //returns said string
    }
    
}//end of class declaration
