//#if Company
package org.softlang.company

import org.springframework.aop.aspectj.RuntimeTestWalker.ThisInstanceOfResidueTestVisitor;

class Company {

	String name
	static hasMany = [departments: Department]

	//#if Total
	double total = 0.0

	void calculateTotal(){
		this.total = 0.0
		for(department in this.departments) this.total += department.calculateTotal()

	}
	//#endif Total

	//#if Cut
	void cut() {
		for(department in this.departments) department.cut();
	}
	//#endif Cut

	//#if Valitation
	static constraints = {
		// these constraints are verified in the Views and in the Controllers
		name unique: true, blank: false
	}
	//# endif Validation
	String toString() {
		return name
	}

}
//#endif Company