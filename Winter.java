package Assignment2OOP;
import java.util.ArrayList;
import java.util.Calendar;
public class Winter extends Hazard{
    protected ArrayList<String>  Levels=new ArrayList<String>();
    protected ArrayList<String>  TravellerLevel=new ArrayList<String>();
    protected final double EquipmnetCover=40;
    protected double highestRate;

    public Winter(){
        super();
        addLevels();
    }
    public Winter(HolidayPlan plan){
        super(plan);
        addLevels();
    }
    public double getHighestRate() {
        return highestRate;
    }

    public void setHighestRate(double highestRate) {
        this.highestRate = highestRate;
    }

    public ArrayList<String> getTravellerLevel() {
        return TravellerLevel;
    }

    public void setTravellerLevel(String travellerLevel) {
        TravellerLevel.add(travellerLevel);
    }

    public void addLevels(){//add object to ArrayList
        Levels.add(0,"Beginner");
        Levels.add(1,"Intermediate");
        Levels.add(2,"Advanced");
        Levels.add(3,"Master");
    }//end method

    public void chooseLevel(){/// method that adds the selected user object (String) to the ArrayList TravellerLevel
        System.out.println("Type -1- for Beginner\nType -2- for Intermediate \nType -3- for Advanced \nType -4- for Master ");
        int number; //crating int variable
        String newlevel;// creating String variable
        number=keyboardInputInteger(1,4);//assign user input value using method with parameters
        newlevel=Levels.get(number-1);//assign String value from ArrayList Levels using index and 'number' value
        setTravellerLevel(newlevel);
    }//end method

    public void userchooseLevel(HolidayPlan plan){//method to add Level for each Traveller
        int number;
        number=plan.getTravellers().size();
        for(int i=0;i<number;i++){//loop that repeated as many times as necessary
            System.out.println("Choose Level for traveller name : " + plan.getTravellers().get(i));
            chooseLevel();
        }
    }//end method

    public void chooseActivity(HolidayPlan object){
        System.out.println("Price List:\nSnowboard 12£   Skis      13£\nSkates     5£   Hiking    10£ \nClimbing  20£");
        super.chooseActivity(object);
    }//end method

    public double setproperDailyRate(HolidayPlan plan) {
        //method checking for String data in ArrayLIst TravellerLevel. The highest value is then taken as highestRate
        double number1=-1,number2=0;
        getTravellerActivity();
        for (int i = 0; i < plan.getTravellers().size(); i++) {
               // for loop checking each ArrayList object
            if (TravellerActivity.get(i).contains("Snowboard")) {
                number1=12;
            } else if (TravellerActivity.get(i).contains("Skis")) {
                number1=13;
            } else if (TravellerActivity.get(i).contains("Skates")) {
                number1=5;
            } else if (TravellerActivity.get(i).contains("Hiking")) {
                number1=10;
            } else if (TravellerActivity.get(i).contains("Climbing")) {
                number1=20;
            }
            if(number2<=number1){
                setHighestRate(number1);
                number2=number1;
            }
        }
        return highestRate;
    }//end method

    public void calPremium(){
        super.calPremium();
    }

    public void calPremium(HolidayPlan plan){
        calPremium();//call method
        double testnumber,totalCover;
        testnumber=getPremium();//assign value using get method
        //System.out.println(testnumber);
        testnumber=testnumber*plan.getTravellers().size();//calculate cost for all travellers without extras
        //System.out.println(testnumber);
        totalCover=(EquipmnetCover*plan.getTravellers().size());//Extra cost
        //System.out.println(totalCover);
        setPremium(totalCover+testnumber);//total cost
    }//end method

    public String toString(){//override toString method
        String str=super.toString();
        str+="\nOne-time equipment fee :"+EquipmnetCover+"£ each. Total : "+(EquipmnetCover*TravellerActivity.size()+"£");
        return str;
    }//end method

    public String DisplayTravellers(HolidayPlan plan){ //method to add Activity for each Traveller details
        int number;
        String str="";
        str+="Travellers information : \n";
        for(int i=0;i<plan.getTravellers().size();i++){
            str+="Name :"+plan.getTravellers().get(i)+" DoB :"+ plan.getDob().get(i).get(Calendar.DATE)
                    +  "/" + ((plan.getDob().get(i).get(Calendar.MONTH))+1) +  "/" + plan.getDob().get(i).get(Calendar.YEAR)+
                    ". Activity : "+TravellerActivity.get(i)+". Level : "+TravellerLevel.get(i)+"\n";
        }
        return str;
    }//end method
}//end class

