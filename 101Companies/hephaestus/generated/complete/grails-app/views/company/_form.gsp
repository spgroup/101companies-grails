<!-- #if Webui AND Company -->
<%@ page import="org.softlang.company.Company" %>

<div class="fieldcontain ${hasErrors(bean: companyInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="company.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${companyInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: companyInstance, field: 'departments', 'error')} ">
	<label for="departments">
		<g:message code="company.departments.label" default="Departments" />
		
	</label>
	<g:select name="departments" from="${org.softlang.company.Department.list()}" multiple="multiple" optionKey="id" size="5" value="${companyInstance?.departments*.id}" class="many-to-many"/>
</div>
<!-- #endif Webui AND Company -->

