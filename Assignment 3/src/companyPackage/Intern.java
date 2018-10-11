package companyPackage;

public class Intern extends Employee{
	private double GPA;
	public Intern(String ID,String name, double grossSalary,double GPA) 
	{
		super(ID,name,grossSalary);
		this.GPA=GPA;		
	}
	public double getGPA()
	{
		return this.GPA;
	}
	public void setGPA(double newGPA)
	{
		this.GPA=newGPA;
	}
	public double getNetSalary()
	{
		if(this.GPA<=5)
			return 0;
		else if(this.GPA<8)
			return this.getGrossSalary();
		else
			return this.getGrossSalary()+1000;
	}
}
