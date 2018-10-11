package comparingPackage;
import java.util.Comparator;
import companyPackage.*;
public class EmployeeComparator implements Comparator<Employee> {

	public EmployeeComparator() 
	{
		
	}

	@Override
	public int compare(Employee e1, Employee e2) 
	{
		if((e1 instanceof Director) && !(e2 instanceof Director))
			return 1;
		else if((e1 instanceof Manager) && !(e2 instanceof Director) && !(e2 instanceof Manager))
			return 1;
		else if((e1 instanceof Employee) && (e2 instanceof Intern))
			return 1;
		else if((e1 instanceof Director) && (e2 instanceof Director))
			return 0;
		else if((e1 instanceof Manager) && (e2 instanceof Manager))
			return 0;
		else if((e1 instanceof Employee) && (e2 instanceof Employee))
			return 0;
		else if((e1 instanceof Intern) && (e2 instanceof Intern))
			return 0;
		else
			return -1;
	}
	
	public int compareSalary(Employee e1, Employee e2)
	{
		if(e1.getGrossSalary()>e2.getGrossSalary())
			return 1;
		else if(e1.getGrossSalary()==e2.getGrossSalary())
			return 0;
		else
			return -1;
	}
	
	public int compareName(Employee e1, Employee e2)
	{
		String name1=e1.getName().toLowerCase();
		String name2=e2.getName().toLowerCase();
		if(name1.equals(name2))
			return 0;
		name1=name1.replace(".", "").replace(" ", "");
		name2=name2.replace(".", "").replace(" ", "");
		int length=name1.length();
		if(name2.length()<length)
			length=name2.length();
		for(int i=0;i<length;i++)
		{
			if((int)name1.charAt(i)<(int)name2.charAt(i))
				return 1;
			else if((int)name1.charAt(i)>(int)name2.charAt(i))
				return -1;
		}
		if(name1.length()<name2.length())
			return 1;
		else
			return -1;
		
	}

}
