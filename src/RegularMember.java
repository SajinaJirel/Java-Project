
/**
 * Write a description of class RegularMember here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RegularMember extends GymMember
{
   final private int attendanceLimit;
   private boolean isEligibleForUpgrade;
   private String removalReason;
   private String referralSource;
   private String plan;
   private double price;
   
   public int getAttendanceLimit()
   {
     return this.attendanceLimit;
   }   
   public boolean getisEligibleForUpgrade()
   {
      return this.isEligibleForUpgrade;
   }
   public String getremovalReason()
   {
      return this.removalReason;
   }
   public String getreferralSource()
   {
      return this.referralSource;
   }
   public String getplan()
   {
      return this.plan;
   }
   public double getPrice()
   {
      return this.price;
   }
   
   public RegularMember(int id,String name,String location,
   String phone,String email,String gender,String DOB,String membershipStartDate,
   String referralSource)
   {
       super(id,name,location,phone,email,gender,DOB,membershipStartDate);
        isEligibleForUpgrade=false;
        attendanceLimit=30;l
        plan="basic";
        price=6500;
        removalReason="";
        
        this.id=id;
        this.name=name;
        this.location=location;
        this.phone=phone;
        this.email=email;
        this.gender=gender;
        this.DOB=DOB;
        this.membershipStartDate=membershipStartDate;
        this.referralSource=referralSource;
    }
     public void markAttendance()
     {
       if(activeStatus==true)
     { attendance++;
       loyaltyPoints+=5;
       if(attendance==attendanceLimit)
       //if attendance reaches limit(30)eligibility becomes true
       {
         this.isEligibleForUpgrade=true;
       }
    }
    else
    {
      System.out.println("Your account is deactive");
    }
}

public double getPlanPrice(String plan)
{ switch(plan)
    {
       case"basic":
       return 6500;
       case"standard":
       return 12500;
       case"deluxe":
       return 18500;
       default:
    System.out.println("Invalid plan input");
      return-1;
    }
}
  public String upgradePlan(String plan)
  {
     if(isEligibleForUpgrade!=true)
     {
        return"You're not eligible to upgrade";
     }
     else
      { 
        if(getPlanPrice(plan)==price)
      {
         return"you cannot choose your current plan";
      }
      else if(getPlanPrice(plan)==12500)
       return"Your Plan has sucessfully been upgraded to standard";
     }
    else if(getPlanPrice(plan)==18500)
     {
        plan="deluxe";
        price=18500;
        return"Your plan has sucessfully been upgraded to deluxe";
    } 
    else
    {
        return"Invalid Plan";
    }
}
}
public void displayRegularMember()
{
  super.display();
  System.out.println("plan:"+plan);
  System.out.println("price:"+price);
  if(removalReason!="")
  {
  System.out.println(removalReason);
}
}
}
      
        
    


        
    
        
  
