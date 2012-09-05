//#if Logging
package org.softlang

import org.softlang.company.Employee

/* #if ($advancedLogging) */

import org.softlang.company.Company
import org.softlang.company.Department

/* #end */

import antlr.TreeElement;

/*singleton pattern ensures that the logging class
 has only one instance, and it provides a single global access to it*/

class Logging {
	
private static Logging uniqueInstance = new Logging()

private File f 

private String spacer = '============================\r\n'

public static enum Operation {create, update, delete}

private Logging(){
	
	f = new File("Log.txt")
	}

public static Logging getInstance(){
	return uniqueInstance
}

//registry salaries changes
void write(Employee e, double oldSalary){
	
	f <<  spacer + new Date(System.currentTimeMillis()).toString() + '\r\n'
	
	if(e == null){
		f << 'The salaries of all employees have been cut to half.\r\n'
	}else{

	    f << 'The salary of the employee ' + e.name + ' changed from ' + oldSalary + ' to ' + e.salary + '.\r\n'
	}
	
	f << spacer
}

/* #if ($advancedLogging) */

//registry when a company, department or employee is created
void writeCreation(Object treeElement){

	String treeElementName
	
	switch (treeElement) {
		
		case  Company: 
		
		Company company = treeElement
		auxiliarCreation('Company', company.name)
		
		; break
		
		case Department: 
		
		Department department = treeElement
		auxiliarCreation('Department', department.name)
		
		; break
		
		case Employee:
		
		Employee employee = treeElement
		auxiliarCreation('Employee', employee.name)
		
		; break
		
	}
	
}

private void auxiliarCreation(String treeElementType, String treeElementName){
	
	String date = new Date(System.currentTimeMillis()).toString() + '\r\n'
	
	f << spacer + date + 'A new ' + treeElementType + ' called ' + treeElementName +
	' was inserted in the system database.\r\n' + spacer
	
	}

//registry when a company, department or employee is updated
void writeUpdate(String treeElementType, String oldTreeElement, String updatedTreeElement){
	
	String date = new Date(System.currentTimeMillis()).toString() + '\r\n'
	
	f << '\r\n' + spacer + date + 'A ' + treeElementType + ' was updated in the System DataBase.\r\n Old properties:\r\n' + oldTreeElement + '\r\nNew properties:\r\n'+ updatedTreeElement + '\r\n' + spacer  
	}


//registry when a company, department or employee is deleted
void writeDeletion(Object treeElement){
	String treeElementName
	
	switch (treeElement) {
		
		case  Company:
		
		Company company = treeElement
		auxiliarDeletion('Company', company.name)
		
		; break
		
		case Department:
		
		Department department = treeElement
		auxiliarDeletion('Department', department.name)
		
		; break
		
		case Employee:
		
		Employee employee = treeElement
		auxiliarDeletion('Employee', employee.name)
		
		; break
		
	}

}

private void auxiliarDeletion(String treeElementType, String treeElementName){
	
	String date = new Date(System.currentTimeMillis()).toString() + '\r\n'
	
	f << spacer + date + 'A ' + treeElementType + ' called ' + treeElementName +
	' was deleted from the system database.\r\n' + spacer
	
	}
/* #end */
}
//#endif Logging

