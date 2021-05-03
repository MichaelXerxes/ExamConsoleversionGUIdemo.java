package Assignment2OOP;
import WorkingGUI.panels.HolidayPlanPanel;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
public class HolidayPlan {
     Scanner keyboard=new Scanner(System.in);
    private String id, name;
    private ArrayList<Calendar> dob=new ArrayList<Calendar>();//code change ,initiation
    private ArrayList<String> travellers=new ArrayList<String>();//code change  ,initiation
    private Calendar dateCreated;
    private Policy policy;
    private String insuranceStatus;
    private String destination;
    private double cost;
    


    public HolidayPlan() {
        id = " ";
        name = " ";
        //dob = null; // avoid Null Exception  code change
        //travellers = null;// avoid Null Exception  code change
        dateCreated = Calendar.getInstance();
        policy = null;
        insuranceStatus = "client has own";
        destination = "";
        cost=0;


    }

    public HolidayPlan(String id, String name, ArrayList<Calendar> dob, ArrayList<String> travellers,String destination,double cost)
    {
        this.id = id;
        this.name = name;
        this.dob = dob;
        dateCreated = Calendar.getInstance();
        policy = null;
        this.travellers=travellers;
        this.destination= destination;
        insuranceStatus = "client has own";
        this.cost = cost;
    }

    //set methods
    public void setId (String id){
        this.id = id;
    }

    public void setName (String name){
        this.name = name;
    }

    public void setDob (Calendar dob){
        this.dob.add(dob);
    }

    public void setTravellers(String traveller){
        //traveller=keyboard.nextLine();
        travellers.add(traveller);
    }

    public void setPolicy(Policy policy){
//add cost of policy to holiday cost
        this.policy = policy;
    }

    public void setDateCreated(Calendar dateCreated) {// set method add
        this.dateCreated = dateCreated;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

    public void setInsuranceStatus(String insuranceStatus){
        this.insuranceStatus = insuranceStatus;
    }

    public void setDestination(String destination){
         this.destination=destination;
    }

    //get methods
    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Calendar> getDob(){
        return dob;
    }

    public ArrayList<String> getTravellers(){
        return travellers;
    }

    public Calendar getDateCreated(){
        return dateCreated;
    }

    public Policy getPolicy(){
        return policy;
    }

    public String getDestination(){
        return destination;
    }

    public double getCost(){
        return cost;
    }

    public String getInsuranceStatus(){
        return insuranceStatus;
    }

    public void setDob(ArrayList<Calendar> dob) {
        this.dob = dob;
    }

    public void acceptPolicy(Policy p){
        //accept a policy p and link it to this portfolio
        this.policy = p;
        policy.setPortfolio(this.id);
        policy.setStatus("active");
        this.cost = this.cost + policy.getPremium();
//add cost of policy to holiday cost
    }

    public String toString(){

        DecimalFormat df = new DecimalFormat("#.00");
        String str = " ";
        str += "\nID: " + id + "\n";
        str += "Name: " + name + "\n";
        str += "Destination:" + destination + "\n";
        str += "Travellers details " + "\n";   // string line add by me !!

        if (dob!= null && travellers!=null)
        {
            for(int i = 0;i<travellers.size();i++)

                str = str + "Name: "+ travellers.get(i) + "  DOB: " + dob.get(i).get(Calendar.DATE) +  "/"
                        + (dob.get(i).get(Calendar.MONTH) + 1) +  "/" +dob.get(i).get(Calendar.YEAR) + "\n";
        }

        if (dateCreated!= null)
        {
            str = str + "Date Created: "+  dateCreated.get(Calendar.DATE) +  "/" + (dateCreated.get(Calendar.MONTH) + 1)
                    +  "/" + dateCreated.get(Calendar.YEAR) + "\n";
        }
        if (insuranceStatus == "Company Policy") {
            str = str + "Policy ID: " + policy.getPolicyNum() + "\n";
        }else if(insuranceStatus=="client has own"){//else if statement was add by me !!
            str = str + "Policy ID: "+getInsuranceStatus()+"\n";
        }
        str = str + "Total Cost: £" + df.format(cost);

        return str;
    }
//            From this point on, my code bindings are added                  //
public void Input(){  //I -Input method
    System.out.println("Welcome to the user interface. We will create a vacation plan :)\nHoliday Plan id number ?");
    setId(keyboard.nextLine());//set any String to ID
    System.out.println("Holiday plan owner Name ?");
    setName(keyboard.nextLine());//set any String to name
    System.out.println("Where is your holiday Destination ?(something like ...Country ,county , hotel, town,other ?) Type name !");
    setDestination(keyboard.nextLine());//set any String to destination
    System.out.println("How Many Travellers  ? Give a number ...");
    addTravelers();//call method
    System.out.println("Travellers date of Birth ");
    addtravellersDoB();//call method

}
    protected void addTravelers(){//method to add Travelers name
        int number;
        RoW test=new RoW();
        System.out.println("How many Travellers will be together but no more than 8!");
        number=test.keyboardInputInteger(1,8);// you can adjust the maximum number to the required value
        for (int i=1;i<=number;i++){//for loop will go 'number' times
            System.out.println("Please enter Name traveller number "+i+" . ");
            setTravellers(keyboard.nextLine());//set method

        }
       // outputTravelelrs();//call method not used

    }
    public void outputTravelelrs(){ // method to output object from AraryList in string format not used
        for(String str:travellers){
            System.out.println(str);
        }
    }

    public void addtravellersDoB(){// method to add Travellers DoB

        for (int i=0;i<travellers.size();i++){

            System.out.println("What`s DoB traveller Name : "+travellers.get(i)+" ");

            setDob(checkuserInputDate());
        }
    }
    public Calendar setAnYDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar DOBtest = Calendar.getInstance();
        String date = "";
        int error = 0;

        do
        {	//read date from keyboard as String
            System.out.print("Enter Date : Follow instruction");
            date = makeDateLimited();//call method that return String to set proper and logic date format
            //date=keyboard.nextLine(); // change input format to any String
            // problem developed in word document
            try
            {	//apply SimpleDateFormat format to the date variable
                //and store the date in the Calendar object dob
                DOBtest.setTime(sdf.parse(date));
                error = 0;
            }
            catch(Exception e)
            {
                System.out.print("date not in correct format (dd/MM/yyyy):");
                error = 1;
            }
        }while (error == 1);
        return DOBtest;
    }//end method
    public Calendar checkuserInputDate(){//method to check minimum year input
        Calendar mindate=Calendar.getInstance();
        Calendar date;
        mindate.set(Calendar.YEAR,1921);// set value for minimum  year
        mindate.set(Calendar.MONTH,1);// set value for minimum  month
         mindate.set(Calendar.DAY_OF_MONTH,1);// set value for minimum  day
        date=mindate;
        while ((date.get(Calendar.YEAR)<=mindate.get(Calendar.YEAR)))

        {
            date=mindate;
            System.out.println("Please enter a year from 1921 .");
            date = setAnYDate();
        }
        return date;//return Calendar object
    }//end method
    public String makeDateLimited(){//method to set proper , logic date
        String str;// creating String
        int day,month,year;
        RoW row=new RoW();//creating object
        System.out.println("\nEnter day :");
        day=row.keyboardInputInteger(1,31);//assign value using method from another class
        System.out.println("Enter month :");
        month=(row.keyboardInputInteger(1,12));//assign value using method from another class
        System.out.println("Enter year :");
        year=row.keyboardInputInteger(1921,2100);//assign value using method from another class
        str=Integer.toString(day)+"/"+Integer.toString(month)+"/"+Integer.toString(year);
        return str;//return String
    }
    public void takeInputfromHPPanel(HolidayPlanPanel HPplan){// new method
        Calendar DOB=Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int error = 0;
        setId(HPplan.getId());
        setName(HPplan.getName());
        setDestination(HPplan.getDestination());
        String someDate=HPplan.getDate();
        try
        {	//apply SimpleDateFormat format to the date variable
            //and store the date in the Calendar object dob
            DOB.setTime(sdf.parse(someDate));
            error = 0;
        }
        catch(Exception e)
        {
            System.out.print("date not in correct format (dd/MM/yyyy):");
            error = 1;
        }
        setDob(DOB);

        System.out.println("ID :"+getId()+" Name : "+getName()+" Destination : "+getDestination()+" DOB : "+getDob());
    }
}//end class


