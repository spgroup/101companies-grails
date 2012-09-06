//if Company
package org.softlang.company

import org.springframework.dao.DataIntegrityViolationException

/* */
import org.softlang.Logging
/*  */

class CompanyController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		
        [companyInstanceList: Company.list(params), companyInstanceTotal: Company.count()]
    }

    def create() {
        [companyInstance: new Company(params)]
    }

    def save() {
        def companyInstance = new Company(params)
        if (!companyInstance.save(flush: true)) {
            render(view: "create", model: [companyInstance: companyInstance])
            return
        }
		
        flash.message = message(code: 'default.created.message', args: [message(code: 'company.label', default: 'Company'), companyInstance.id])
        redirect(action: "show", id: companyInstance.id)
		
		/*  */
		Logging.getInstance().writeCreation(companyInstance)
		/*  */
    }

    def show(Long id) {
        def companyInstance = Company.get(id)
        if (!companyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'company.label', default: 'Company'), id])
            redirect(action: "list")
            return
        }
		
		/**/
		companyInstance.calculateTotal()
		/**/
        [companyInstance: companyInstance]
    }

    def edit(Long id) {
        def companyInstance = Company.get(id)
        if (!companyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'company.label', default: 'Company'), id])
            redirect(action: "list")
            return
        }

        [companyInstance: companyInstance]
    }

    def update(Long id, Long version) {
        def companyInstance = Company.get(id)
		
		/*  */
		String old = companyInstance.properties.toString()
		/*  */
		
        if (!companyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'company.label', default: 'Company'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {

            if (companyInstance.version > version) {
                companyInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'company.label', default: 'Company')] as Object[],
                          "Another user has updated this Company while you were editing")
                render(view: "edit", model: [companyInstance: companyInstance])
                return
            }
        }
		
        companyInstance.properties = params

        if (!companyInstance.save(flush: true)) {
            render(view: "edit", model: [companyInstance: companyInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'company.label', default: 'Company'), companyInstance.id])
        redirect(action: "show", id: companyInstance.id)
		
		/*  */
		String updated = companyInstance.properties.toString()
		
		Logging.getInstance().writeUpdate('Company', old, updated)
		/*  */
    }

    def delete(Long id) {
        def companyInstance = Company.get(id)
        if (!companyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'company.label', default: 'Company'), id])
            redirect(action: "list")
            return
        }

        try {
            companyInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'company.label', default: 'Company'), id])
            redirect(action: "list")
			
			/*  */
			Logging.getInstance().writeDeletion(companyInstance)
			/*  */
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'company.label', default: 'Company'), id])
            redirect(action: "show", id: id)
        }
    }
	
	/*  */
	// verify if the cut feature is really updating the database
	def cut(Long id) {
		def companyInstance = Company.get(id)
		if (!companyInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'company.label', default: 'Company'), id])
			redirect(action: "list")
			return
		}

		try {
			companyInstance.cut()
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'company.label', default: 'Company'), id])
			redirect(action: "list")
			
			/* */
			Logging.getInstance().write(null, 0)
			/*  */
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'company.label', default: 'Company'), id])
			redirect(action: "show", id: id)
		}
	}
	/*  */
}
//endif Company