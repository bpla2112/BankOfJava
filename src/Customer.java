/**
 *@author Bernardo Pla
 * Panther ID: 3885008
 * COP 3337
 * Assignment 1
 */
public class Customer {
    
    private Name name; //calls Name class for name variable
    private Address address ; //calls Address class for address variable
    private String accNo ; //creates string variable for account number
    
    public Customer (Name nom, Address add, String num)
    {
        name = nom ;//stores nom in name
        address = add; //stores add in address
        accNo = num ; //stores accno in accNo
    }
    
    public Name getName()
    {
        return name ; // returns name
    }
    
    public Address getAddress()
    {
        return address ;//returns address
    }
    
    public String getaccNo()
    {
        return accNo ; // returns account number
    }
    
    public void changeAccountNo (String newNum)
    {
        accNo = newNum ; //stores new account number
    }
    
    public String toString()
    {
        String str = "Account Number" + accNo + ", " + name.getFullName() + "\n" + address.getStreet() + 
                "\n" + address.getState()+ "\n" + address.getZipCode() + "\n" + address.getCountry();                
        return str ;
    }
    
}//end of class declaration
