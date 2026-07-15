
/**
 * Write a description of class GymMember here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
 public abstract class GymMember
{
  protected int id;
  protected String Name;
  protected String location;
  protected String Phone;
  protected String Email;
  protected String Gender;
  protected String DOB;
  protected String MembershipStartDate;
  protected int Attendance;
  protected double LoyalPoints;
  protected boolean ActiveStatus;
  
  public GymMember(int id1,String Name1,String location1,String Phone1,String 
  Email1,String Gender1,String DOB1,String MembershipStartDate1){
      this.Attendance=0;
      this.LoyalPoints=0;
      this.ActiveStatus=false;
      this.id=id1;
      this.Name=Name1;
      this.location=location1;
      this.Phone=Phone1;
      this.Email=Email1;
      this.Gender=Gender1;
      this.DOB=DOB1;
      this.MembershipStartDate=MembershipStartDate1;
    }
    
    public int get_id()
     {
     return this.id;
     }  
     public String get_Name()
     {
      return this.Name;
    }
    public String get_location()
    {
     return this.location;
    }
    public String get_Phone()
    {
      return this.Phone;
    }
    public String get_Email()
    {
     return this.Email;
    }
    public String get_Gender()
    {
      return this.Gender;
    }
    public String get_DOB()
    {
      return this.DOB;
    }
    public String get_MembershipStartDate()
    {
     return this.MembershipStartDate;
    }
    public int get_Attendence()
    {
     return this.Attendance;
    }
    public double get_LoyalPoint()
    {
     return this.LoyalPoints;
    }
    public boolean get_ActiveStatus()
    {
     return this.ActiveStatus;
    }
    
    public abstract int markAttendance();
    public void activeMembership(){
    if(this.ActiveStatus==false){
      this.ActiveStatus=true;
      System.out.println("the membership"+this.id+"is sucessfully activeted");
    }
    else
    {
        System.out.println("the membership"+this.id+"is already activeted");
    }
}
public void deactivateMembership(){
    if(this.ActiveStatus==true){
    this.ActiveStatus=false;
    System.out.println("The membership"+this.id+"is sucessfully deactiveted");
}
else
{
    System.out.println("the membership"+this.id+"is already deactiveted");
}
}
 public void resetMember()
{
    this.ActiveStatus=false;
    this.Attendance=0;
    this.LoyalPoints=0.0;
    System.out.println("Membership"+this.id+"is reset sucessfully");
}
 public void display(){
   System.out.println(get_id());
   System.out.println(get_Name());
   System.out.println(get_location());
   System.out.println(get_Phone());
   System.out.println(get_Email());
   System.out.println(get_Gender());
   System.out.println(get_DOB());
   System.out.println(get_MembershipStartDate());
   System.out.println(get_Attendence());
   System.out.println (get_LoyalPoint());
   System.out.println(get_ActiveStatus());
}
}
    
     
     
     
     
      
     
      
  
    

