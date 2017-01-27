package _01.AOP.MethodInterceptor.InvokeMethod;

public class EmployeeService {

	private String name , surname;
	private int experience;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	//--------------------------------
	public void checkNameSurname() {
		System.out.println("EmployeeService#checkNameSurname()");
		if(name.length()<2 || surname.length() < 2 ) {
			throw new IllegalArgumentException();
		}
	}
	
	public void sayHi(String message) {
		System.out.println("EmployeeService#sayHi()");
		System.out.println("MESSAGE : " + message);
	}
	
	public void getEmployeeInfo() {
		System.out.println("EmployeeService#getEmployeeInfo()");
		System.out.println("FULL NAME : " + name + " " + surname + 
				"\n" + "EXPERIENCE IS : " + experience + " YEAR." );
	}
	
}
