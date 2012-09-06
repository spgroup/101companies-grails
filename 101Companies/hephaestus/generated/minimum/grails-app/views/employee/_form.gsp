<!-- #if Webui AND Company -->
<%@ page import="org.softlang.company.Employee" %>

<div class="
<!-- #if Validation -->
fieldcontain ${hasErrors(bean: employeeInstance, field: 'name', 'error')} required
<!-- #endif Validation -->
">
	<label for="name">
		<g:message code="employee.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${employeeInstance?.name}"/>
</div>

<div class="
<!-- #if Validation -->
fieldcontain ${hasErrors(bean: employeeInstance, field: 'salary', 'error')} required
<!-- #endif Validation -->
">
	<label for="salary">
		<g:message code="employee.salary.label" default="Salary" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="salary" value="${fieldValue(bean: employeeInstance, field: 'salary')}" required=""/>
</div>

<h1>Address</h1>

<div class="
<!-- #if Validation -->
fieldcontain ${hasErrors(bean: employeeInstance, field: 'street', 'error')} required
<!-- #endif Validation -->
">
	<label for="street">
		<g:message code="employee.street.label" default="Street" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="street" required="" value="${employeeInstance?.street}"/>
</div>

<div class="
<!-- #if Validation -->
fieldcontain ${hasErrors(bean: employeeInstance, field: 'number', 'error')} required
<!-- #endif Validation -->
">
	<label for="number">
		<g:message code="employee.number.label" default="Number" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="number" type="number" min="1" value="${employeeInstance.number}" required=""/>
</div>

<div class="
<!-- #if Validation -->
fieldcontain ${hasErrors(bean: employeeInstance, field: 'zipcode', 'error')} required
<!-- #endif Validation -->
">
	<label for="zipcode">
		<g:message code="employee.zipcode.label" default="Zipcode" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="zipcode" required="" value="${employeeInstance?.zipcode}"/>
</div>

<div class="
<!-- #if Validation -->
fieldcontain ${hasErrors(bean: employeeInstance, field: 'city', 'error')} required
<!-- #endif Validation -->
">
	<label for="city">
		<g:message code="employee.city.label" default="City" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="city" required="" value="${employeeInstance?.city}"/>
</div>

<div class="
<!-- #if Validation -->
fieldcontain ${hasErrors(bean: employeeInstance, field: 'country', 'error')} required
<!-- #endif Validation -->
">
	<label for="country">
		<g:message code="employee.country.label" default="Country" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="country" required="" value="${employeeInstance?.country}"/>
</div>
<!-- #endif Webui AND Company -->
