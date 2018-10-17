package mainPackage;
import companyPackage.ReusaxCorp;

public class Main {

	public static void main(String[] args)
	{
		ReusaxCorp r=new ReusaxCorp();
		r.registerEmployee("123", "ahman", 2000);
		r.registerManager("234","bla",5000.0,"BCs.");
		System.out.println(r.findEmployee("234"));
	}
}
