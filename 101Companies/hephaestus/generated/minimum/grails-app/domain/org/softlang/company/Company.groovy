//if Company
package org.softlang.company

class Company {

	String name
	static hasMany = [departments: Department]

	/**/


	/**/
	

	//if Validation
	static constraints = {
		// these constraints are verified in the Views and in the Controllers
		name unique: true, blank: false
	}
	// endif Validation
	String toString() {
		return name
	}

}
//endif Company