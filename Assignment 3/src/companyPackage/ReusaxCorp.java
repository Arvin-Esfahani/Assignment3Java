package companyPackage;

import java.util.ArrayList;

public class ReusaxCorp 
{
	private double expenses=0;
	private ArrayList<Employee> employeeList=new ArrayList<Employee>();
	
	public ReusaxCorp()
	{
		
	}
	
	public double getExpenses()
	{
		return this.expenses;
	}
	
	public Employee findEmployee(String ID)
	{
		for(Employee e : employeeList) 
	        if(e.getID().equals(ID)) 
	            return e;
		return null;
	}
	
	public Manager findManager(String ID)
	{
		for(Employee e : employeeList) 
	        if(e.getID().equals(ID)&& isManager(e)) 
	            return (Manager) e;
		return null;
	}
	
	public Director findDirector(String ID)
	{
		for(Employee e : employeeList) 
	        if(e.getID().equals(ID)&& isDirector(e)) 
	            return (Director) e;
		return null;
	}
	
	public Intern findIntern(String ID)
	{
		for(Employee e : employeeList) 
	        if(e.getID().equals(ID)&& isIntern(e)) 
	            return (Intern) e;
		return null;
	}
	
	public void registerEmployee(String ID,String name,double grossSalary)
	{
		Employee newEmployee=new Employee(ID,name,grossSalary);
		this.employeeList.add(newEmployee);
	}
	
	public void registerManager(String ID,String name, double grossSalary,String managerDegree)
	{
		Manager newManager=new Manager(ID,name,grossSalary, managerDegree);
		employeeList.add(newManager);
	}
	
	public void registerDirector(String ID,String name, double grossSalary,String managerDegree, String department)
	{
		Manager newDirector=new Director(ID,name,grossSalary, managerDegree, department);
		employeeList.add(newDirector);
	}
	
	public void registerIntern(String ID,String name, double grossSalary,double GPA)
	{
		Intern newIntern=new Intern(ID,name,grossSalary,GPA);
		employeeList.add(newIntern);
	}
	
	public void removeEmployee(String ID)
	{
		Employee desiredEmployee=findEmployee(ID);
		if(desiredEmployee!=null)
			employeeList.remove(desiredEmployee);
	}
	
	public void updateName(String ID, String newName)
	{
		Employee desiredEmployee=findEmployee(ID);
		if(desiredEmployee!=null)
			desiredEmployee.setName(newName);
	}
	
	public void updateGrossSalary(String ID, double newSalary)
	{
		Employee desiredEmployee=findEmployee(ID);
		if(desiredEmployee!=null)
			desiredEmployee.setGrossSalary(newSalary);
	}
	
	public void updateDegree(String ID, String newDegree)
	{
		Manager desiredManager=findManager(ID);
		if(desiredManager!=null)
			desiredManager.setDegree(newDegree);	
	}
	
	public void updateDepartment(String ID, String newDepartment)
	{
		Director desiredDirector=findDirector(ID);
		if(desiredDirector!=null)
			desiredDirector.setDepartment(newDepartment);
	}
	
	public void updateBenefit(double newBenefit)
	{
		Director.setBenefit(newBenefit);
	}
	
	public void updateGPA(String ID, double newGPA)
	{
		Intern desiredIntern=findIntern(ID);
		if(desiredIntern!=null)
			desiredIntern.setGPA(newGPA);
	}
	
	public void payEmployees()
	{
		for(Employee e : employeeList) 
			if(isDirector(e))
				this.expenses+=e.getGrossSalary()+((Director) e).getBonus()+Director.getBenefit();
			else if(isManager(e))
				this.expenses+=e.getGrossSalary()+((Manager) e).getBonus();
			else if(isIntern(e))
				this.expenses+=e.getGrossSalary()+((Intern) e).getBonus();
			else
				this.expenses+=e.getGrossSalary();
	}
	
	private boolean isManager(Employee e)
	{
		return e instanceof Manager;
	}
	
	private boolean isDirector(Employee e)
	{
		return e instanceof Director;
	}
	
	private boolean isIntern(Employee e)
	{
		return e instanceof Intern;
	}
	
	@SuppressWarnings("unused")
	private boolean isEmployee(Object o)
	{
		return o instanceof Employee;
	}
	
	private boolean isJustEmployee(Employee e)//just employee and nothing else
	{
		return !(isIntern(e)||isManager(e)||isDirector(e));
	}
	
	public void promoteToManager(String ID, String degree)
	{
		Employee desiredEmployee=findEmployee(ID);
		if(desiredEmployee!=null && isJustEmployee(desiredEmployee))
		{
			Manager newManager=new Manager(desiredEmployee.getID(),desiredEmployee.getName(),desiredEmployee.getGrossSalary(),degree);
			this.employeeList.remove(desiredEmployee);
			this.employeeList.add(newManager);
		}
	}
	
	public void promoteToDirector(String ID, String department)
	{
		Manager desiredManager=findManager(ID);
		if(desiredManager!=null && !isDirector(desiredManager))
		{
			Director newDirector=new Director(desiredManager.getID(),desiredManager.getName(),desiredManager.getGrossSalary(),desiredManager.getDegree(),department);
			this.employeeList.remove(desiredManager);
			this.employeeList.add(newDirector);
		}
	}
	
	public void promoteToEmployee(String ID)
	{
		Intern desiredIntern=findIntern(ID);
		if(desiredIntern!=null)
		{
			Employee newEmployee=new Employee(desiredIntern.getID(),desiredIntern.getName(),desiredIntern.getGrossSalary());
			this.employeeList.remove(desiredIntern);
			this.employeeList.add(newEmployee);
		}
	}
	
	public void demoteToManager(String ID)
	{
		Director desiredDirector=findDirector(ID);
		if(desiredDirector!=null)
		{
			Manager newManager=new Manager(desiredDirector.getID(),desiredDirector.getName(),desiredDirector.getGrossSalary(),desiredDirector.getDegree());
			this.employeeList.remove(desiredDirector);
			this.employeeList.add(newManager);
		}
	}
	
	public void demoteToEmployee(String ID)
	{
		Manager desiredManager=findDirector(ID);
		if(desiredManager!=null && !isDirector(desiredManager))
		{
			Employee newEmployee=new Employee(desiredManager.getID(),desiredManager.getName(),desiredManager.getGrossSalary());
			this.employeeList.remove(desiredManager);
			this.employeeList.add(newEmployee);
		}
	}
	
	public void demoteToIntern(String ID, double GPA)//?
	{
		Employee desiredEmployee=findEmployee(ID);
		if(desiredEmployee!=null && isJustEmployee(desiredEmployee))
		{
			Intern newIntern=new Intern(desiredEmployee.getID(),desiredEmployee.getName(),desiredEmployee.getGrossSalary(),GPA);
			this.employeeList.remove(desiredEmployee);
			this.employeeList.add(newIntern);
		}
	}
	
	
	public int numberOfEmployees()
	{
		return this.employeeList.size();
	}
	
	
	
}

