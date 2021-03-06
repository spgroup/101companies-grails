/* */
import org.apache.shiro.crypto.hash.Sha256Hash
import org.softlang.User
/*  */
import org.softlang.company.Company
import org.softlang.company.Department
import org.softlang.company.Employee

class BootStrap {

    def init = { servletContext ->
		
		/*  */
		def user = new User(username: "user123", passwordHash: new Sha256Hash("password").toHex())
		user.addToPermissions("*:*")
		user.save()
		/*  */
		
		//company
		def employeeRodrigo = new Employee(name: "Rodrigo Andrade", salary: 1000d, street: "Rua Faustino Porto", number: 289l, zipcode: "51020-270", city: "Recife", country: "Brasil").save(failOnError: true)
		def employeePaola = new Employee(name: "Paola Rodrigues", salary: 1000d, street: "Rua boa viagem", number: 389l, zipcode: "51020-100", city: "Recife", country: "Brasil").save(failOnError: true)
		def employeePaulo = new Employee(name: "Paulo Borba", salary: 500d, street: "Rua 17 de Agosto", number: 259l, zipcode: "51020-500", city: "Recife", country: "Brasil").save(failOnError: true)
		def employeeCico = new Employee(name: "Cico doido", salary: 500d, street: "Rua 18 de Agosto", number: 2539l, zipcode: "51020-800", city: "Recife", country: "Brasil").save(failOnError: true)
		
		def departmentCin = new Department(name: "Cin")
		def departmentCCEN = new Department(name: "CCEN")
		
		departmentCin.addToEmployees(employeeRodrigo)
		departmentCin.addToEmployees(employeePaola)
		//departmentCin.addToEmployees(employeePaulo)
		departmentCin.setManager(employeePaulo)
		departmentCin.save(failOnError: true)
		departmentCCEN.addToSubDepartments(departmentCin)
		//departmentCCEN.addToEmployees(employeeCico)
		departmentCCEN.setManager(employeeCico)
		departmentCCEN.save(failOnError: true)
		
		def companyUFPE = new Company(name: "UFPE")
		companyUFPE.addToDepartments(departmentCCEN)
		companyUFPE.save(failOnError: true)
    }
    def destroy = {
    }
}