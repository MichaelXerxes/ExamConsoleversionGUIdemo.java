package Assignment2OOP;

import java.util.Calendar;
import java.util.Scanner;
import java.util.ArrayList;//import class

public class Environment {
    protected ArrayList<Policy> userPolicy = new ArrayList<Policy>();//ArrayLists of Objects
    protected Policy policy;
    protected HolidayPlan plan=new HolidayPlan();
    protected  Calendar endPolicydate;
    public Environment(){
        plan.Input();
        Action();
        Cancel();
    }
    public Environment(ConsoleToGUI gui){
        plan.Input();
        Action();
        Cancel();
        //DisplayInGUI();

    }
    // gets sets and methods
    public Policy getPolicy() {
        return policy;
    }
    public void setPolicy(Policy policy) {
        this.policy = policy;
    }
    public ArrayList<Policy> getUserPolicy() {
        return userPolicy;
    }
    public Policy setUserPolicy(Policy policy) {
       userPolicy.add(policy);
        return policy;
    }
    public HolidayPlan getPlan() {
        return plan;
    }
    public void setPlan(HolidayPlan plan) {
        this.plan = plan;
    }
    public Calendar getEndPolicydate() {
        return endPolicydate;
    }
    public void setEndPolicydate(Calendar endPolicydate) {
        this.endPolicydate = endPolicydate;
    }
    // for RoW
    public RoW getRoW(){//planned sequence of tasks for the row object
        RoW row= (RoW) userPolicy.get(0);//crating and assigning an object from an arraylist using casting
        row.inputPolicy();//call method
        row.chooseDestinations();//call method
        row.calPremium();//call method
        System.out.println(row.DisplayTravellers(plan));//call method to display travellers details in String format
        return row;//return object
    }//end method
     // for Hazard
    public Hazard getHazard(){//planned sequence of tasks for the hazard object
        Hazard hazard;
        hazard= (Hazard) userPolicy.get(1);//assigning an object from an arraylist using casting
        hazard.inputPolicy();//call method
        hazard.userDestinations();//call method
        hazard.chooseActivity(plan);//call method
        hazard.setDailyRate(hazard.flatRate);//assign double value referring to variable 'flatRate' in object
        hazard.calPremium();//call method
        System.out.println(hazard.DisplayTravellers(plan));//call method to display travellers details in String format
        return hazard;//return object
    }//end method
    // for Winter
    public Winter getWinter(){//planned sequence of tasks for the winter object
        Winter winter;//creating object winter
        double number;
        winter= (Winter) userPolicy.get(2);//assigning an object from an arraylist using casting
        winter.inputPolicy();//call method
        winter.userDestinations();//call method
        winter.chooseActivity(plan);//call method
        winter.userchooseLevel(plan);//call method
        number=winter.setproperDailyRate(plan);//assign double value using method with parameter
        winter.setDailyRate(number);//set number value to dailyRate
        winter.calPremium(plan);//call method
        System.out.println(winter.DisplayTravellers(plan));//call method to display travellers details in String format
        return winter;//return object
    }//end method

    public void addingObjects(){//method to add objects to arraylist
        RoW row=new RoW(plan);
        Hazard hazard=new Hazard(plan);
        Winter winter=new Winter(plan);
        userPolicy.add(row);
        userPolicy.add(hazard);
        userPolicy.add(winter);
    }//end method

    public int choosePolicy(){// method to choose Policy
        RoW row=new RoW();//creating object row
        int number;
        addingObjects();//call method
        System.out.println("Choose your Policy. Type on keyboard!!\n-1- for Rest of World \n-2- for Hazard \n-3- for Winter");
        number=(row.keyboardInputInteger(1,3)-1);//-1 must be subtracted because the index of the object in arraylist starts at 0
        return number;
    }//end method

    public Policy userPolicy(){//the method by which the appropriate other method is selected
        int number=choosePolicy();// 0 ,1,2 are only availbe option for user
        if(number==0){
            setPolicy(getRoW());
        }else if(number==1){
            setPolicy(getHazard());
        }else if(number==2){
            setPolicy(getWinter());
        }
        return getPolicy();
    }//end method

    public void Action(){//method where the program obtains and displays information about the selected policy
        policy=userPolicy();
        plan.acceptPolicy(policy);
        plan.setInsuranceStatus("Company Policy");
        System.out.println(policy.toString());
        System.out.println(plan.toString());

    }//end method
    public void Cancel(){
        Scanner keyboard=new Scanner(System.in);
        String random;
        char x;
        System.out.println("If you want to Cancel! this policy, select ...(Yes,No)... " +
                "\nChoose 'Y' for (Yes)!! to CANCEL       or 'N' for (No)!! to ACCEPT");
        random=keyboard.nextLine();
        x=random.charAt(0);
        if((x=='y')||(x=='Y')){

             endPolicydate=policy.getSDate();
            //this while loop is not checking  a proper year
            System.out.println("Please enter Ends date !");
            System.out.println("Policy start date was : "+policy.getSDate().get(Calendar.DATE)+"/"+(policy.getSDate().get(Calendar.MONTH)+1)
                    +"/"+policy.getSDate().get(Calendar.YEAR));
            //while loop to check end date after user choose Canceled
            while((endPolicydate.get(Calendar.YEAR)<=policy.getSDate().get(Calendar.YEAR))&&
                    (endPolicydate.get(Calendar.MONTH)<=policy.getSDate().get(Calendar.MONTH))&&
                    (endPolicydate.get(Calendar.DAY_OF_MONTH)<=policy.getSDate().get(Calendar.DAY_OF_MONTH))) {
                setEndPolicydate(plan.setAnYDate());//a reference to a method in another class
                System.out.println("End date must be entered correctly");
            }//end while loop
            getPolicy().cancelPolicy(getEndPolicydate(),plan);//call method
            Display();//call method
            ConsoleToGUI gui=new ConsoleToGUI();//start GUI
            Display();//call method
        }else if((x=='n')||(x=='N')){
            System.out.println("Good man !!! Good Job!!!!!!");
            Display();
            ConsoleToGUI gui=new ConsoleToGUI();//Start GUI
            Display();//call method
        }// end else if
    }//end method
    public void Display(){
        System.out.println(policy.toString());
        System.out.println(plan.toString());
        System.out.println(policy.DisplayTravellers(plan));
    }
}//end class

