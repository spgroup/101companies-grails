//#if Logging
package org.softlang

import org.softlang.company.Employee

/*singleton pattern ensures that the logging class
 has only one instance, and it provides a single global access to it*/

class Logging {
	
private static Logging uniqueInstance = new Logging()

private File f 

private Logging(){
	
	f = new File("Log.txt")
	}

public static Logging getInstance(){
	return uniqueInstance
}
	
void write(Employee e, double oldSalary){
	
	f << '==============\r\n' + new Date(System.currentTimeMillis()).toString() + '\r\n'
	
	if(e == null){
		f << 'The salaries of all employees have been cut to half.\r\n'
	}else{

	    f << 'The salary of the employee ' + e.name + ' changed from ' + oldSalary + ' to ' + e.salary + '.\r\n'
	}
	
	f << '==============\r\n'
}

}
//#endif Logging

