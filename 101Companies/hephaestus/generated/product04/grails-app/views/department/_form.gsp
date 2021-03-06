<!-- #if Webui AND Company -->
<%@ page import="org.softlang.company.Department" %>

<div class=" 
<!-- #if Validation -->
fieldcontain ${hasErrors(bean: departmentInstance, field: 'manager', 'error')} required
<!-- #endif Validation -->
">
	<label for="manager">
		<g:message code="department.manager.label" default="Manager" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="manager" name="manager.id" from="${org.softlang.company.Employee.list()}" optionKey="id" required="" value="${departmentInstance?.manager?.id}" class="many-to-one"/>
</div>
<div class="
<!-- #if Validation -->
fieldcontain ${hasErrors(bean: departmentInstance, field: 'name', 'error')} required
<!-- #endif Validation -->
">
	<label for="name">
		<g:message code="department.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${departmentInstance?.name}"/>
</div>
<div class="
<!-- #if Validation -->
fieldcontain ${hasErrors(bean: departmentInstance, field: 'employees', 'error')} 
<!-- #endif Validation -->
">
	<label for="employees">
		<g:message code="department.employees.label" default="Employees" />
	</label>
	<g:select name="employees" from="${org.softlang.company.Employee.list()}" multiple="multiple" optionKey="id" size="5" value="${departmentInstance?.employees*.id}" class="many-to-many"/>
</div>
<div class="
<!-- #if Validation -->
fieldcontain ${hasErrors(bean: departmentInstance, field: 'subDepartments', 'error')} 
<!-- #endif Validation -->
">
	<label for="subDepartments">
		<g:message code="department.subDepartments.label" default="Sub Departments" />
	</label>
	<g:select name="subDepartments" from="${org.softlang.company.Department.list()}" multiple="multiple" optionKey="id" size="5" value="${departmentInstance?.subDepartments*.id}" class="many-to-many"/>
</div>
<!-- #endif Webui AND Company -->

