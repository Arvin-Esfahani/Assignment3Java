package companyPackage;

public class Director extends Manager{
	private String department;
	private static double benefit=0;
	public Director(String ID,String name, double grossSalary,String managerDegree, String department) {
		// TODO Auto-generated constructor stub
		super(ID,name,grossSalary,managerDegree);
		this.department=department;
	}
	public double getNetSalary()
	{
		double total=this.getGrossSalary()+this.getBonus()+benefit;//
		if(total<30000)
			return total*0.9;
		else if(total<50000)
			return total*0.8;
		else 
			return 6000+(total-30000)*0.4;
	}
	public String getDepartment()
	{
		return this.department;
	}
	
	public static double getBenefit()
	{
		return benefit;// as it is an static variable we can not use this.
		//here as it refers to a class-related attribute which is the same for all 
		//the objects( and when changed for one object it is changed for all the objects )
	}
	public void setDepartment(String newDepartment)
	{
		this.department=newDepartment;
	}
	public void setBenefit(double newBenefit)
	{
		benefit=newBenefit;
	}
}
