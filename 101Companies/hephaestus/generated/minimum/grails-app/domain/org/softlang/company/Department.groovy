//if Company
package org.softlang.company

class Department {

	String name
	Employee manager
	static hasMany = [employees: Employee, subDepartments: Department]
	
	/**/
	
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
