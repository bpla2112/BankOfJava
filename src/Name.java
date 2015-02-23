/**
 *@author Bernardo Pla
 * Panther ID: 3885008
 * COP 3337
 * Assignment 1
 */
public class Name {
    private String name1 ; //first name
    private String name2 ; //last name
    private String fullName; //made up of first and last name
    
    public Name(String n1, String n2)
    {
        name1 = n1 ; //n1 to hold first name
        name2 = n2 ; //n2 to hold last name
    }
    
    public Name(String n)
    {
        fullName = n ; //n holds first and last name
    }
    
    public String getFirstName()
    {
        return name1 ; //returns first name
    }
    
    public String getLastName()
    {
        return name2 ; //returns last name
    }
    
    public String getFullName()
    {
        return fullName ; //returns full name
    }
    
    public String toString()
    {
        String str = name1 + name2 ; //combines first and last name variables
        return str;
    }
} //end of class declaration
