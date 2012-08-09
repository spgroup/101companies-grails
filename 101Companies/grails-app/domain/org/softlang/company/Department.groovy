// #if treeStructure
package org.softlang.company

class Department {

	String name
	Employee manager
	static hasMany = [employees: Employee, subDepartments: Department]
	
    static constraints = {
		manager nullable: false
		name unique: true, blank: false
    }
	
	String toString() {
		return name
	}
}
// #endif
