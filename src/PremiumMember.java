
/**
 * Write a description of class PremiumMember here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PremiumMember extends GymMember
{
  final double premiumChange;
  String personalTrainer;
  boolean isFullPayment;
  double paidAmount;
  double discountAmount;
  
 public double getPremiumCharge()
  {
    return this.premiumCharge;
  }
 public String getPersonalTrainer()
  {
     return this.personalTrainer;
  }
 public boolean getisFullPayment()
  {
      return this.isFullPayment;
  }
 public double getpaidAmount()
  {
     return this.paidAmount;
  }
 public double getdiscountAmount()
  {
     return this.discountAmount;
  } 
  
  public PremiumMember(int id,String name,String location,String phone,
  String email,String gender,String DOB,String membershipStartDate,
  String personalTrainer)
  {
      super(id,name,location,phone,email,gender,DOB,membershipStartDate);
       
          premiumCharge=50000;
          paidAmount=0;
          isFullPayment=false;
          discountAmount=0;
          
          this.is=id;
          this.name=name;
          this.location=location;
          this.phone=phone;
          this.email=email;
          this.gender=gender;
          this.DOB=DOB;
          this.membershipStartDate=membershipStartDate;
          this.personalTrainer=personalTrainer;
   }
    public void markAttendance()
    {
      if(this.activeStatus==true)
     {
        this.attendance++;
        this.loyaltyPoints+=10;
    } 
    else
    System.out.println("Your account is deactive");
}
}
 
 public double remainingAmount;
 
 public String payDueAmount(double paidAmount)
 
 {
    if(this.isFullPayment==true)
    {
        return"Full Payment";
    }
    else if(paidAmount>premiumCharge)
   {
       return"You have paid more than the premiumCharge";
   }
    else if(paidAmount<premiumCharge)
    {
       paidAmount=this.paidAmount;
       remainingAmount=premiumCharge-this.paidAmount;
       return"You have paid amount:"+paidAmount;
    }
    else
    {
        isFullAmount=true;
        return"You have successfully paid full Amount";
    }
}
 
public void calculateDiscount()
{
  ifFullPayment==true)
  {
      discountAmount=(10.00/100)*premiumCharge;
  System.out.println("Your discount amount is"+discountAmount);
}
else
{
   System.out.println("Not eligible for discount");
}
}

public void revertPremiumMember()
{
    super.resetMember();
    personalTrainer="";
    isFullPayment=false;
    paidAmount=0;
    discountAmount=0;
}
  public void displayPremiumMember()
  {
      super.display();
   System.out.println("Personal Trainer:"+personalTrainer);
   System.out.println("PaidAmount:"+paidAmount);
   System.out.println("Full Payment:"isFullPayment);
   System.out.println("Remaining Amount:"+remainingAmount);
   
   if(isFullPayment==true)
   {
    System.out.println("Discount Amount:"+discountAmount);
}
}
}

   
   


    
 
 


       
        
          
  

    
