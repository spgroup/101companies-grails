// #if treeStructure
package org.softlang.company

class Company {

	String name
	static hasMany = [departments: Department]
	
    static constraints = {
		//pode ser uma feature de validacao
		//sera que a verificacao eh feita na UI e no controlador? verificar isso
		// seria algo do tipo: // #if treeStructure and validacao
		name unique: true, blank: false
    }
	
	String toString() {
		return name
	}
}
// #endif