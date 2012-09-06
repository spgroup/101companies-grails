//#if Authentication
package org.softlang

class Role {
    String name

    static hasMany = [ users: User, permissions: String ]
    static belongsTo = User

    static constraints = {
        name(nullable: false, blank: false, unique: true)
    }
	
	static mapping = {
		datasource 'authentication'
	 }
}
//#endif Authentication