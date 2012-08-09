// #if treeStructure
package org.softlang.company

class Company {

	String name
	static hasMany = [departments: Department]
	
    static constraints = {
		name unique: true, blank: false
    }
	
	String toString() {
		return name
	}
}
// #endif