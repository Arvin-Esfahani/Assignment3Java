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
	public double getBonus()
	{
		if(this.GPA<=5)
			return -this.getGrossSalary();
		else if(this.GPA<8)
			return 0;
		else
			return 1000;
	}
	public double getNetSalary()
	{
		return this.getGrossSalary()+this.getBonus();
	}
	public String toString()
	{
		String string="<Intern>\nID:"+this.getID()+"\nName:"+this.getName()+"\nGrossSalary:"+this.getGrossSalary();
		string+="\nGPA:"+this.GPA;
		return string;
	}
}
