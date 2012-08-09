// #if treeStructure
package org.softlang.company

class Address {

	String street
	Long number
	String zipcode
	String city
	String country
	static belongsTo = Employee
	
    static constraints = {
		street blank: false, nullable: false
		number min: 1L, nullable: false
		zipcode blank: false, nullable: false
		city blank: false, nullable: false
		country blank: false, nullable: false
    }
	
	String toString() {
		return street
	}
}
// #endif
