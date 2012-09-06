//if Company
package org.softlang.company

class Department {

	String name
	Employee manager
	static hasMany = [employees: Employee, subDepartments: Department]
	
	/**/
	double calculateTotal(){
		
		def total = 0.0
		
		total += this.manager.salary

		for(employee in this.employees) {
			
			if(employee != manager){
			total += employee.salary
			}
			
			}
		
		for (department in this.subDepartments) total += department.calculateTotal()
		
		return total
		}
	/**/
	
	/**/
	void cut() {
		this.manager.cut();
		for(department in this.subDepartments) department.cut();
		for(employee in this.employees) employee.cut();
	}
	/**/
	
	//if Validation
    static constraints = {
		manager nullable: false
		name unique: true, blank: false
    }
	//endif Validation
	
	String toString() {
		return name
	}
}
//endif Company
