// #if Company
package org.softlang.company

class Department {

	String name
	Employee manager
	static hasMany = [employees: Employee, subDepartments: Department]
	
	//#if Total
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
	//#endif Total
	
	// #if Valitation
    static constraints = {
		manager nullable: false
		name unique: true, blank: false
    }
	// #endif Validation
	
	String toString() {
		return name
	}
}
// #endif Company
