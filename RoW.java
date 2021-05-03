package Assignment2OOP;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.Scanner;

public class RoW extends Policy{
    Scanner keyboard=new Scanner(System.in);
    protected ArrayList<String> Destinations =new ArrayList<String>();
    protected String userDestination;

    public RoW(){
        super();//call to constructor in supercalss using 'super'
        addDestinations();//call method
    }
    public RoW(HolidayPlan plan){//constructor with HolidayPlan parameter
        super(plan);//call to constructor with HolidayPlan parameter in supercalss using 'super'
        addDestinations();//call method
    }
    public void setDestinations(String newdestination){
        Destinations.add(newdestination);
    }
    public ArrayList<String> getDestinations(){return Destinations;}
    public String getUserDestination() {
        return userDestination;
    }
    public void setUserDestination(String userDestination) {
        this.userDestination = userDestination;
    }

    public String toString(){// to String override method
        String str=super.toString();//call to method in supercalss using 'super'
        str+="User destinations  is : "+getUserDestination();
        return str;
    }//end method

    public String DisplayTravellers(HolidayPlan plan){//String method to Display Traveller details
        String str="";
        str+="Travellers information : \n";
        for(int i=0;i<plan.getTravellers().size();i++){
            str+="Name :"+plan.getTravellers().get(i)+" DoB :"+ plan.getDob().get(i).get(Calendar.DATE)
                    +  "/" + ((plan.getDob().get(i).get(Calendar.MONTH))+1) +  "/"
                    + plan.getDob().get(i).get(Calendar.YEAR)+"\n";
        }
        return  str;
    }//end method

    public void calPremium(){
        getDailyRate();//call method get daily Rate
        getSDate();//call method get start date
        getEDate();//call method get end date
        super.calPremium();//call to method in supercalss using 'super'
    }//end method

    protected void addDestinations(){//method that add value to destinations
        Destinations.add("North America");//add object String to ArrayList
        Destinations.add("South America");
        Destinations.add("Asia");
        Destinations.add("Rest World");
    }//end method

    public void DispalyDestinations(){// Method that display list of destinations not used
        for(String list: Destinations) {
            System.out.println(list);
        }
    }//end method

    public void chooseDestinations(){//method to allow user choose destinations
        System.out.println("Choose destinations from list ");
        System.out.println("Select on the keyboard 1 2 3 or 4");
        System.out.println("North America -1-  7£  per day South America -2- 8£  per day\nAsia         " +
                " -3-  9£  per day Rest World   -4- 10£  per day");
        chooseAndsetDailyRate();
    }//end method

    public double chooseAndsetDailyRate(){//method that return double value
        int number;
        number= keyboardInputInteger(1,4);//call method for user to choose number from 1 to 4
        if(number==1){
            setDailyRate(7);//use set method
        }else if (number==2){
            setDailyRate(8);
        }else if ((number==3)){
            setDailyRate(9);
        }else if ((number==4)){
            setDailyRate(10);
        }
        setUserDestination(Destinations.get(number-1));//it set String value from ArrayList.'-1' because index start from 0
        return getDailyRate();
    }//end method

    public  int keyboardInputInteger(int min,int max) {//method that allow user only choose integer number from min value
                                                      // to max value. It was designed so as not to cause errors in
                                                     // the program and to force the user to make the right choice .
        boolean isCorrect;
        int number=0;

        while (true) {
            System.out.println("Please enter number from " +min+ " to "+max);
            isCorrect = false;
            try {
                number = keyboard.nextInt();//user input Integer
                isCorrect = true;
            } catch (Exception e) {// if user put wrong value like String or out of range Integer
                System.out.println("Please enter Integer number from "+min+" to "+max);
                keyboard.nextLine();
            }
            while ((number > max) || (number < min)) {//while loop to set range for Integer numbers
                System.out.println("Please enter number Integer from "+min+" to "+max);
                try {
                    number = keyboard.nextInt();
                    isCorrect = true;
                } catch (Exception e) {
                    keyboard.nextLine();
                }
            }//end inner while loop
            if (isCorrect) {
                break;//exit and return number
            }
        }//end while loop
        return number;
    }//end method
}//end class


