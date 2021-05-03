package Assignment2OOP;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class  Policy{
    Scanner keyboard=new Scanner(System.in);
    protected String policyNum, name,status;
    protected Calendar dob, sDate, eDate;
    protected double dailyRate, premium;
    protected String holidayPlanID;

    protected HolidayPlan  objectHPlan=new HolidayPlan(); // add line !!

    public Policy(){
        policyNum = " ";
        name = " ";
        dob = null;
        sDate = null;
        eDate = null;
        status = "pending";
        dailyRate = 0;
        premium = 0;
        holidayPlanID = "";

    }

    public Policy(String policyNum,String holidayPlanID,String name, Calendar dob, Calendar sDate, Calendar eDate ){
        this.policyNum = policyNum;
        this.name = name;
        this.dob = dob;
        this.sDate = sDate;
        this.eDate = eDate;
        status = "pending";
        dailyRate = 4;
        premium = 0;
        this.holidayPlanID = holidayPlanID;
    }
    public Policy(HolidayPlan plan){    //new constructor with HolidayPlan parameter !!!
        policyNum = " ";
        name = " ";
        dob = null;
        sDate = null;
        eDate = null;
        status = "pending";
        dailyRate = 0;
        premium = 0;
        holidayPlanID = "";
    }

    //set methods
    public void setPolicyNum (String policyNum){
        this.policyNum = policyNum;
    }

    public void setName (String name){
        this.name = name;
    }

    public void setDob (Calendar dob){
        this.dob = dob;
    }

    public void setSDate (Calendar sDate){
        this.sDate = sDate;
    }

    public void setEDate (Calendar eDate){
        this.eDate = eDate;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public void setDailyRate (double dailyRate){
        this.dailyRate = dailyRate;
    }

    public void setPremium (double premium){
        this.premium = premium;
    }

    public void setPortfolio (String holidayPlanID){
        this.holidayPlanID = holidayPlanID;
    }

    public void setObjectHPlan(HolidayPlan objectHPlan){this.objectHPlan=objectHPlan;} //line add!!

    //get methods
    public HolidayPlan getObjectHPlan(){return objectHPlan;}//line add !!

    public String getPolicyNum(){
        return policyNum;
    }

    public String getName(){
        return name;
    }

    public Calendar getDob(){
        return dob;
    }

    public Calendar getSDate(){
        return sDate;
    }

    public Calendar getEDate(){
        return eDate;
    }

    public String getStatus(){
        return status;
    }

    public double getDailyRate(){
        return dailyRate;
    }

    public double getPremium(){
        return premium;
    }

    public String getHolidayPlanID(){
        return holidayPlanID;
    }

    public void cancelPolicy(Calendar eDate,HolidayPlan plan){
        this.eDate = eDate;
        status = "CANCELLED";
        plan.setCost(0.00);//set cost to 0
        plan.setInsuranceStatus("client has own");// set String value  to insuranceStatus
    }

    public void calPremium(){
        getDailyRate();
        //work out number of days of policy and calculate premium based on a daily rate and number of people
        if(sDate!= null && eDate!= null)
        {
            long time1 = sDate.getTimeInMillis();
            long time2 = eDate.getTimeInMillis();
            long diff = time2 - time1;
            long days = diff/1000/60/60/24;
            //System.out.println(days);
            premium =days * dailyRate;
        }
        else
            premium = 0;
    }


    public String toString(){
        String str = "";
        str = str + "\nPolicy Number: " + policyNum + "\n";
        str = str + "Name: " + name + "\n";

        if (dob!= null)
        {
            str = str + "DOB: " + dob.get(Calendar.DATE) +  "/" + (dob.get(Calendar.MONTH) + 1) +  "/" + dob.get(Calendar.YEAR) + "\n";
        }
        if (sDate!= null)
        {
            str = str + "Start Date: "+ sDate.get(Calendar.DATE) +  "/" + (sDate.get(Calendar.MONTH) + 1) +  "/" + sDate.get(Calendar.YEAR) + "\n";
        }
        if (eDate!= null)
        {
            str = str + "End Date: "+ eDate.get(Calendar.DATE) +  "/" + (eDate.get(Calendar.MONTH) + 1) +  "/" + eDate.get(Calendar.YEAR) + "\n";
        }
        str = str + "Policy Type: " + this.getClass().getName() + "\n";
        str = str + "Policy Status: " + status + "\n";
        str = str + "Policy Daily Rate: " + dailyRate + "\n";
        if (holidayPlanID!= "")
        {
            str = str + "Related Portfolio Reference: " + holidayPlanID + "\n";
        }
        str = str + "Policy Premium: " + premium + "\n";
        return str;
    }//end method

    public void inputPolicy(){
        System.out.println("\nWelcome to Policy user Interface , please provide some details.\n");
        System.out.println("What`s Policy number ?");
        this.policyNum=keyboard.nextLine();
        System.out.println("What`s Policy holder name ? ");
        this.name=keyboard.nextLine();
        checkEndDate();
    }//end method

    public void checkEndDate(){
        HolidayPlan setAnyDatetest=new HolidayPlan();//creating an object
        System.out.println("Policy holder DoB (Birthday) ? ");
        setDob(setAnyDatetest.setAnYDate());//set value using reference to a method in another class
        System.out.println("When the Policy  starts ? ");
        //System.out.println("Please enter a proper (2021 or higher) year"); //not used
        setSDate(currentUserInputDate());//set value using reference to a method in another class
        System.out.println("When the Policy  ends ? Please note that the date must be higher than the start date ");
        System.out.println("Policy starts on "+sDate.get(Calendar.DAY_OF_MONTH)+"/"+(sDate.get(Calendar.MONTH)+1)+"/"+sDate.get(Calendar.YEAR));
        eDate=sDate;// avoid Null expectation and while loop to check if eDate  is appropriate
        while((eDate.get(Calendar.YEAR)<=sDate.get(Calendar.YEAR))&&(eDate.get(Calendar.MONTH)<=sDate.get(Calendar.MONTH))
               &&(eDate.get(Calendar.DAY_OF_MONTH)<=sDate.get(Calendar.DAY_OF_MONTH))) {
            setEDate(setAnyDatetest.setAnYDate());//set value using  reference to a method in another class
        } //end while loop
    }//end method

    public Calendar currentUserInputDate(){
        HolidayPlan plan=new HolidayPlan();
        Calendar mindate=Calendar.getInstance();
        Calendar date=plan.getDateCreated();
        mindate.set(Calendar.YEAR,1921);//minimum  year It can be set to 2021 for example
        mindate.set(Calendar.MONTH,1);
        mindate.set(Calendar.DATE,1);
        date=mindate;
        //while loop to check minimum date ,especially year
        while ((date.get(Calendar.YEAR)<=(mindate.get(Calendar.YEAR))))
        {

            date = plan.setAnYDate();

        }
        return date;
    }//end method
    public String DisplayTravellers(HolidayPlan plan){
        String str="";
        return str;
    }

}//end class


