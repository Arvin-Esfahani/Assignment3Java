package companyPackage;

public class Employee 
{
	private String ID;//Employee ID
	private String name;
	private double grossSalary;
	public Employee(String employeeID, String employeeName,double employeeGrossSalary)
	{
		this.ID=employeeID;
		this.name=employeeName;
		this.grossSalary=employeeGrossSalary;
	}
	public double getNetSalary()
	{
		return (this.grossSalary*0.9);
	}
	public String getID()
	{
		return this.ID;
	}
	public String getName()
	{
		 
		return this.name;
	}
	public double getGrossSalary()
	{
		return this.grossSalary;
	}
	public void setID(String newID)
	{
		this.ID=newID;
	}
	public void setName(String newName)
	{
		this.name=newName;
	}
	public void setGrossSalary(double newGrossSalary)
	{
		this.grossSalary=newGrossSalary;
	}
	public String toString()
	{
		String string="<Employee>\nID:"+this.ID+"\nName:"+this.name+"\nGrossSalary:"+this.grossSalary;
		return string;
	}
}
