//#if Company
package org.softlang.company

//#if Logging
import org.softlang.Logging
//#endif Logging

import org.springframework.dao.DataIntegrityViolationException


class EmployeeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [employeeInstanceList: Employee.list(params), employeeInstanceTotal: Employee.count()]
    }

    def create() {
        [employeeInstance: new Employee(params)]
    }

    def save() {
        def employeeInstance = new Employee(params)
        if (!employeeInstance.save(flush: true)) {
            render(view: "create", model: [employeeInstance: employeeInstance])
            return
        }
		
        flash.message = message(code: 'default.created.message', args: [message(code: 'employee.label', default: 'Employee'), employeeInstance.id])
        redirect(action: "show", id: employeeInstance.id)
		
		//#if AdvancedLogging
		Logging.getInstance().writeCreation(employeeInstance)
		//#endif AdvancedLogging
		
    }

    def show(Long id) {
        def employeeInstance = Employee.get(id)
        if (!employeeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'employee.label', default: 'Employee'), id])
            redirect(action: "list")
            return
        }

        [employeeInstance: employeeInstance]
    }

    def edit(Long id) {
        def employeeInstance = Employee.get(id)
        if (!employeeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'employee.label', default: 'Employee'), id])
            redirect(action: "list")
            return
        }

        [employeeInstance: employeeInstance]
    }

    def update(Long id, Long version) {
        def employeeInstance = Employee.get(id)
		
		//#if AdvancedLogging
		String old = employeeInstance.properties.toString()
		//#endif AdvancedLogging
		
        if (!employeeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'employee.label', default: 'Employee'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (employeeInstance.version > version) {
                employeeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'employee.label', default: 'Employee')] as Object[],
                          "Another user has updated this Employee while you were editing")
                render(view: "edit", model: [employeeInstance: employeeInstance])
                return
            }
        }
		
		//#if Logging
		double oldSalary = employeeInstance.salary
		//#endif Logging
		

        employeeInstance.properties = params

        if (!employeeInstance.save(flush: true)) {
            render(view: "edit", model: [employeeInstance: employeeInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'employee.label', default: 'Employee'), employeeInstance.id])
        redirect(action: "show", id: employeeInstance.id)
		
		//#if Logging
		if(oldSalary != employeeInstance.salary){
		Logging.getInstance().write(employeeInstance, oldSalary)
		}
		
		//#if AdvancedLogging
		String updated = employeeInstance.properties.toString()
		Logging.getInstance().writeUpdate('Employee', old, updated)
		//#endif AdvancedLogging
		
		//#endif Logging 
    }

    def delete(Long id) {
        def employeeInstance = Employee.get(id)
        if (!employeeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'employee.label', default: 'Employee'), id])
            redirect(action: "list")
            return
        }

        try {
            employeeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'employee.label', default: 'Employee'), id])
            redirect(action: "list")
			//#if AdvancedLogging
			Logging.getInstance().writeDeletion(employeeInstance)
			//#endif AdvancedLogging
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'employee.label', default: 'Employee'), id])
            redirect(action: "show", id: id)
        }
    }
}
//#endif Company
