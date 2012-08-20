// #if Company
package org.softlang.company

class Employee {

	String name
	Double salary
	Boolean isManager
	
	// address
	String street
	Long number
	String zipcode
	String city
	String country
	
	// #if Valitation
    static constraints = {
		name blank: false, nullable: false
		salary min: 1.0d, nullable: false
		//address
		street blank: false, nullable: false
		number min: 1L, nullable: false
		zipcode blank: false, nullable: false
		city blank: false, nullable: false
		country blank: false, nullable: false
    }
	// #endif Validation
	
	String toString() {
		return name
	}
}
// #endif Company
