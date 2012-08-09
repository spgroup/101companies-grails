// #if treeStructure
package org.softlang.company

class Employee {

	String name
	Double salary
	Address address
	
    static constraints = {
		name blank: false, nullable: false
		address nullable: false
		salary min: 1.0d, nullable: false
    }
	
	String toString() {
		return name
	}
}
// #endif
