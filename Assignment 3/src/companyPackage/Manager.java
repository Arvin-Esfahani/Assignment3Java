package companyPackage;

public class Manager extends Employee {
	private String degree;
	public Manager(String ID,String name, double grossSalary,String managerDegree) 
	{
		// TODO Auto-generated constructor stub
		super(ID,name,grossSalary);
		this.degree=managerDegree;
	}
	public double getBonus()
	{
		if(degree.equals("BCs."))
		{
			return this.getGrossSalary()*0.1;
		}
		else if(degree.equals("MSc."))
		{
			return this.getGrossSalary()*0.2;
		}
		else if(degree.equals("PhD"))
		{
			return this.getGrossSalary()*0.35;
		}
		else
		{
			return -1;
		}
	}
	public double getNetSalary()
	{
		return (this.getGrossSalary()+this.getBonus())*0.9;
	}
	public String getDegree()
	{
		return this.degree;
	}
	public void setDegree(String newDegree)
	{
		this.degree=newDegree;
	}
}
