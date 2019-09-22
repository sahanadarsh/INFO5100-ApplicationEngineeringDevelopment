package Assignment2;

/**
 * Submit it on or before 22nd September 2019 , 12:00 pm
 */
public class Assignment2 {
    /*
        This method should return the sum of salaries of employees having salary greater than 5000
        Note: Employee array is passed, not employee
     */
    public static double salaryGreaterThanFiveThousand(Employee[] employees) {
    	double sum = 0.0;
    	for(int i = 0; i < employees.length; i ++) {
    	   if(employees[i].getSalary()> 5000) {
    		sum = sum + employees[i].getSalary();
    	   }
    	}
    	System.out.println("Sum of the salaries of employees having salary greater than 5000 is " + sum);
    	return sum;
    		
    }

    
    /*
        This method should print either "Fizz", "Buzz" or "FizzBuzz"
        "Fizz" - if id of employee is divisible by 3
        "Buzz" - if id of employee is divisible by 5
        "FizzBuzz" - if id of employee is divisible by both 3 and 5
     */
    public static void fizzBuzz(Employee employee) {
        if(employee.getId() % 3 == 0 && employee.getId() % 5 == 0) {
        	System.out.println("FizzBuzz");
        }else if(employee.getId() % 3 == 0) {
        	System.out.println("Fizz");
        }else if(employee.getId() % 5 == 0) {
        	System.out.println("Buzz");
        }
    }

    
    /*
        This method should calculate tax for an employee in dollars
        If salary of employee is less than or equal to 2500, tax should be 10%
        If salary of employee is greater than 2500 but less than or equal to 5000, tax should be 25%
        If salary of employee is greater than 5000, tax should be 35%
    */
    public static double calculateTax(Employee employee) {
    	double tax = 0.0;
        if(employee.getSalary()<=2500) {
        	tax = (10.0/100.0)*(employee.getSalary());
        }else if(employee.getSalary()>2500 && employee.getSalary()<=5000) {
        	tax = (25.0/100.0)*(employee.getSalary());
        }else {
          tax = (35.0/100.0)*(employee.getSalary());
        }
        System.out.println("tax of an employee is " + tax);
        return tax;
    }
    
    
    /*
        We are given two employee objects.
        Implement this method to swap salaries of employees
    */
    public static void swap(Employee firstEmployee, Employee secondEmployee) {
    	double first,second,temp;
        first = firstEmployee.getSalary();
        second = secondEmployee.getSalary();
        System.out.println("Before swap : " + "first employee salary is " + first + " and " + "second employee salary is " + second );
    	temp = first;
    	first = second ;
    	second = temp ;
    	System.out.println("After swap : " + "first employee salary is " + first + " and " + "second employee salary is " + second );
    }

    
    /*
        Return number of employees whose age is greater than 50
        Note: Employee array is passed, not employee
     */
    public static int employeesAgeGreaterThan50(Employee[] employees) {
        int count = 0;
        for(int i = 0; i < employees.length; i++) {
        	if(employees[i].getAge()>50) {
        		count++;
        	}
        }
        System.out.println("Number of employess whose age is greater than 50 is " + count);
        return count;
    }

    
    /*
        Implement this method to reverse firstName of employee.
        Ex. Before: employee.getFirstName() -> "John"
        After : employee.getFirstName() -> "nhoJ"
     */
    public static void reverseFirstName(Employee employee) {
    	String name = employee.getFirstName();
        String reverse = "";
    	System.out.println("Name of an employee before reverse is " + name);
    	for(int i = name.length()-1 ; i >= 0; i--) {
    		reverse = reverse + name.charAt(i);
    	}
    	employee.setFirstName(reverse);
    	System.out.println("Name of an employee after reverse is " + employee.getFirstName());
    	
    			
    }

    
    /*
        Print "true" if employee's first name contain one or more digits
        Print "false" if employee's first name doesn't contain any digit
        Ex: employee.getFirstName() -> "ha8l" == true
        employee.getFirstName() -> "hail" == false
     */
    public static void isContainDigit(Employee employee) {
        String name = employee.getFirstName();
        String regex = ".*\\d.*";
        if(name.matches(regex)) {
        	System.out.println("true");
        }else {
        	System.out.println("false");
        }
    }

    
     /*
        Write a method to raise an employee's salary to three times of his/her original salary.
        Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
        DO NOT change the input in this method.
        Try to add a new method in Employee class: public void raiseSalary(double byPercent) 
        Call this new method.
     */
    public static void tripleSalary(Employee employee) {
    	// raise an employee's salary to three times of his/her original salary means increasing salary by 300%
        employee.raiseSalary(300/100);
    }
    
    
    //Additional question for extra credit
    /*
        Implement this method to convert String[] to employees array.
        Ex: String[] employees = new String[]{"1,John,24,7500", "2,Hail,28,7899.90"};
        This String array of length 2 contains 2 employees in form of string, where
        id = 1
        firstName=John
        age=24
        salary=7500
        convert each string to employee object.
        Hint: Use String methods. Refer : https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
     */
    public static Employee[] createEmployees(String[] employeesStr) {
        Employee[] employees = new Employee[employeesStr.length];
       
        for(int i = 0; i < employeesStr.length; i++) {
        	String[] empstr = employeesStr[i].split(",");
        	employees[i] = new Employee(Integer.parseInt(empstr[0]), empstr[1], Integer.parseInt(empstr[2]), Double.parseDouble(empstr[3]));
        }
        for(Employee e : employees) {
    		System.out.println(e.getId() + ", " + e.getFirstName() + ", " + e.getAge() + ", " + e.getSalary());
    	}
        return employees;
    }
    
    public static void main(String[] args) {

    	Employee employee1 = new Employee(1, "SahanaKS07", 25, 10000);
    	Employee employee2 = new Employee(2, "AdarshKR", 31, 20000);
    	Employee employee3 = new Employee(3, "Sahanadi", 36, 6000);
    	Employee[] employeearr = {employee1, employee2, employee3};
    	salaryGreaterThanFiveThousand(employeearr);
    	fizzBuzz(employee3);
    	calculateTax(employee3);
    	swap(employee1, employee2);
    	employeesAgeGreaterThan50(employeearr);
    	reverseFirstName(employee2);
    	isContainDigit(employee1);
    	tripleSalary(employee2);
    	String[] employees = new String[]{"1,John,24,7500", "2,Hail,28,7899.90", "3,Rosy,35,10000"};
    	createEmployees(employees);
    	
    	
    }
}