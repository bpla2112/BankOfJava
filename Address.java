/**
 *@author Bernardo Pla
 */

public class Address {
    private String street ; //declares street variable
    private String city ; //declares city variable
    private String state; //declares state as a variable
    private String zipcode; //declares zip code as a variable
    private String country; //declares country as a variable
    
    public Address (String street)
    {
        this.street = street ; //sets street 
    }
    
    public void nameCity (String city)
    {
        this.city = city ; //sets city 
    }
    
    public void nameState(String state)
    {
        this.state = state ; //sets state
    }
    
    public void nameZip(String zipcode)
    {
        this.zipcode = zipcode; //sets zip code
    }
    
    public void nameCountry (String country)
    {
        this.country = country ; //sets country 
    }
    
    public String getStreet()
    {
        return street ; //calls street on account
    }
    
    public String getCity()
    {
        return city ; //calls city on account 
    }
    
    public String getState()
    {
        return state; //calls state on account
    }
    
    public String getZipCode()
    {
        return zipcode ; //calls zip code on account
    }
    
    public String getCountry()
    {
        return country ; //calls country on account
    }
    
    public String toString()
    {
       String str = street + "\n" + city + "\n" + state + "\n" + zipcode + "\n" +country ;//creates string for address 
       return str ; //prints address
    }
    
    
}//end of class declaration
