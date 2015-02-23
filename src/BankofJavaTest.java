/**
 *@author Bernardo Pla
 * Panther ID: 3885008
 * COP 3337
 * Assignment 1
 */
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.util.GregorianCalendar;
import javax.swing.JScrollPane;

public class BankofJavaTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean complete = false; //variable to show whether program is complete
        int number = 0; //number initialized to 0
        String str, str2, str3, str4, str5; //string variables
        String key; //string variable
        String acct; //string variable
        
        //calendar display
        GregorianCalendar date = new GregorianCalendar(); //calendar object
        int day = date.get(Calendar.DATE); //calls date and stores it
        int month = date.get(Calendar.MONTH); //calls month and stores it
        int year = date.get(Calendar.YEAR); //calls year         
        
        Database Open = new Database(); //establishes database for open accounts
        Database Closed = new Database(); //establishes database for closed accounts            
        
        while(!complete)
        {
            String pick = JOptionPane.showInputDialog("Welcome to the Bank of Java\n1. "
             + "Create New Account \n2. Update Account\n3. Close Account \n4. " + 
                    "Print\n5. Quit");
            
            if(pick.equals(" ") || pick.equals(null))
            
                complete = true; //if user fills in blank space or cancels action terminates
            
            else
            {
                int i = Integer.parseInt(pick); //else perform program
                
                switch(i)
                {
                    case 1: //create new accounts
                    {
                        //Create Name and store it
                        str = JOptionPane.showInputDialog("Please type your name.");
                        Name name = new Name(str); //stores name variable in str
                        
                        //Address object and store it
                        str = JOptionPane.showInputDialog("Please type your address."); //street component
                        str2 = JOptionPane.showInputDialog("City?"); //city component
                        str3 = JOptionPane.showInputDialog("State?"); //state component
                        str4 = JOptionPane.showInputDialog("Zip Code?"); //zip code component
                        str5 = JOptionPane.showInputDialog("Country?"); //country component
                        
                        Address address = new Address(str); //creates address object
                        address.nameCity(str2); //adds city from str2
                        address.nameState(str3); //adds state
                        address.nameZip(str4); //adds zip code
                        address.nameCountry(str5); //adds country
                        
                        //The following lines will assign the new object an account number
                        JOptionPane.showMessageDialog(null, "Your account number is " + ++number);//shows user account number
                        
                        acct = Integer.toString(number); //sets integer into string to be printed
                        
                        //the following will create the customer
                        Customer cust = new Customer(name, address, acct); 
                        
                        //balance at creation of customer
                        str = JOptionPane.showInputDialog("Please input your initial balance."); //takes initial balance from user
                        
                        double amount = Double.parseDouble(str); //turns balance from string to double
                        
                        //create bank account
                        BankAccount money = new BankAccount(cust, amount); //creates bank account object using given parameters
                        
                        Open.add(money); //adds account to database
                        
                        
                    } //end new account creation
                    break;
                        
                    case 2: //update account
                    {
                        double balupdater; //variable to update balance
                        key = JOptionPane.showInputDialog("Please input your account number."); //user input
                        
                        Open.search(key);
                        
                        if(!Open.isInList())
                            JOptionPane.showMessageDialog(null, "Sorry. Account number is invalid"); //return if number is invalid
                        else
                        {
                            BankAccount bank = Open.getBankAccount();
                            str = JOptionPane.showInputDialog("1. Deposit " + "\n2. Withdrawl "
                            + "\n3. Back");//options for user
                            
                            int y = Integer.parseInt(str); //prepare for new switch statements
                            switch(y) //embedded into case 2
                            {
                                case 1: //deposit
                                {
                                    str = JOptionPane.showInputDialog("Please type your deposit amount.");//user input
                                    balupdater = Double.parseDouble(str);//converts input to double
                                    bank.deposit(balupdater); //updates balance
                                }//end deposit activity
                                break;
                                    
                                case 2: //withdrawl
                                {
                                    str = JOptionPane.showInputDialog("Please enter your withdrawl amount.");//user input
                                    balupdater = Double.parseDouble(str);
                                    bank.withdraw(balupdater);
                                }//end withdrawl activity
                                break;
                                    
                                case 3: //previous prompt already ended
                                    break;
                            }//switch y end
                        }//else end
                    }//case 2 end
                    break ;
                        
                    case 3: //close accounts and add to Closed database
                    {
                        key = JOptionPane.showInputDialog("Please enter your account number"); //user input
                        Open.search(key); //searches database for account number
                        
                        if(!Open.isInList())
                            JOptionPane.showMessageDialog(null, "Account number is invalid"); //return if error
                        else
                            Closed.add(Open.delete(key)); //takes deleted account and adds it to Closed database
                        
                    }//ends closing account activity
                    break; 
                        
                    case 4: //print out the lists of open or closed accounts
                    {
                        String uInput; //creates user input variable
                        uInput = JOptionPane.showInputDialog("Select the database you with to view" +
                                "\n" + "1. Open Accounts" + "\n" + "2. Closed Accounts"); //user input
                        
                        int choice = Integer.parseInt(uInput);
                        
                        switch(choice) //for printing
                        {
                            case 1: //printing information
                            {
                                JTextArea text = new JTextArea("Today is: " + (month + 1)
                                + "/" + day + "/" + year + "\n" + Open.toString(), 20, 40);
                                
                                JScrollPane scroll = new JScrollPane(text);//creates scrollable pane
                                
                                JOptionPane.showMessageDialog(null, scroll, "Open Accounts" ,
                                        JOptionPane.INFORMATION_MESSAGE); //details for scrollable pane
                                
                                
                            }//end of Open database printing
                            break;
                                
                            case 2: //For closed accounts
                            {
                                JTextArea text = new JTextArea("Today is: " + (month + 1)
                                + "/" + day + "/" + year + "\n" + Closed.toString(), 20, 40);
                                
                                JScrollPane scroll = new JScrollPane(text);//pane object
                                JOptionPane.showMessageDialog(null, scroll, "Closed Accounts", JOptionPane.INFORMATION_MESSAGE);//pane details
                                
                            }//end closed account printing
                            break;
                        }//end of switch for printing for case 4
                        break;                       
                        
                    }//end of case 4
                    default:
                        complete = true;
                    
                }//end of switch
            }//end of else
        
        }//end of while loop
        
        
    }//end of class declaration
    
}
