//if Company
package org.softlang.company

class Company {

	String name
	static hasMany = [departments: Department]

	/**/
	double total = 0.0

	void calculateTotal(){
		this.total = 0.0
		for(department in this.departments) this.total += department.calculateTotal()

	}
	/**/


	/**/
	void cut() {
		for(department in this.departments) department.cut();
	}
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