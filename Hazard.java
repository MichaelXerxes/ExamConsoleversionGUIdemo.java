package Assignment2OOP;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;

public class Hazard extends RoW{
    protected ArrayList<String> Activity=new ArrayList<String>();
    protected ArrayList<String> TravellerActivity=new ArrayList<String>();
    protected final double flatRate=14;

    public  Hazard(){
        super();//call to constructor  in supercalss using 'super'
        addActivity();

    }
    public Hazard(HolidayPlan plan){//constructor with HolidayPlan parameter
        super(plan);//call to constructor with HolidayPlan parameter in super class using 'super'
        addActivity();//call method
    }
    //sets and gets
    public void setActivity(String newActivity){
        Activity.add(newActivity);
    }
    public void setTravellerActivity(String travellerActivity){
        TravellerActivity.add(travellerActivity);
    }
    public ArrayList<String> getActivity(){return Activity;}
    public ArrayList<String> getTravellerActivity(){return TravellerActivity;}

    public void userDestinations(){
        System.out.println("\nChoose the part of the World you are going to !");
        System.out.println("Select on the keyboard 1 2 3 or 4 .");
        System.out.println("North America -1-    South America -2-   \nAsia         " +
                " -3-    Rest World    -4-   ");
        int number;
        number= keyboardInputInteger(1,4);
        setUserDestination(Destinations.get(number-1));
    }//end method

    public void addActivity(){// add objects to Arraylist
        Activity.add(0,"Snowboard");
        Activity.add(1,"Skis");
        Activity.add(2,"Skates");
        Activity.add(3,"Hiking");
        Activity.add(4,"Climbing");
    }//end method

    public void makeChoose(){// method that adds the selected user String to the ArrayList TravellerActivity
        int number =(keyboardInputInteger(1,5)-1);
        String nameAciv=Activity.get(number);
        setTravellerActivity(nameAciv);
    }//end method

    public void chooseActivity(HolidayPlan object){//method to add Activity for each Traveller details
        int number;
        number=object.getTravellers().size();// get size of Travellers
        //System.out.println(number);

        for(int i=0;i<number;i++) {
            System.out.println("Choose Activity for traveller name : " + object.getTravellers().get(i));
            System.out.println("Snowboard - Type -1- Skis      - Type -2-\nSkates    - Type -3- Hiking    - Type -4-\n" +
                    "Climbing  - Type -5-");
            makeChoose();
        }
    }//end method

    public void calPremium(){ //overridden method
        super.calPremium();
    }//end method
    public String toString(){//overridden method
        String str=super.toString();
        return str;
    }//end method
    public String DisplayTravellers(HolidayPlan plan){//String method to Display Traveller details
        String str="";
        str+="Travellers information : \n";
        for(int i=0;i<plan.getTravellers().size();i++){
            str+="Name :"+plan.getTravellers().get(i)+" DoB :"+ plan.getDob().get(i).get(Calendar.DATE)
                    +  "/" + ((plan.getDob().get(i).get(Calendar.MONTH))+1) +  "/" + plan.getDob().get(i).get(Calendar.YEAR)+
            " Activity : "+TravellerActivity.get(i)+"\n";
        }
        return str;
    }//end method
}//end class

