<!-- #if Webui AND Company -->
<%@ page import="org.softlang.company.Employee" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'employee.label', default: 'Employee')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-employee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-employee" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'employee.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="salary" title="${message(code: 'employee.salary.label', default: 'Salary')}" />
					
						<g:sortableColumn property="street" title="${message(code: 'employee.street.label', default: 'Street')}" />
					
						<g:sortableColumn property="number" title="${message(code: 'employee.number.label', default: 'Number')}" />
					
						<g:sortableColumn property="zipcode" title="${message(code: 'employee.zipcode.label', default: 'Zipcode')}" />
					
						<g:sortableColumn property="city" title="${message(code: 'employee.city.label', default: 'City')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${employeeInstanceList}" status="i" var="employeeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${employeeInstance.id}">${fieldValue(bean: employeeInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: employeeInstance, field: "salary")}</td>
					
						<td>${fieldValue(bean: employeeInstance, field: "street")}</td>
					
						<td>${fieldValue(bean: employeeInstance, field: "number")}</td>
					
						<td>${fieldValue(bean: employeeInstance, field: "zipcode")}</td>
					
						<td>${fieldValue(bean: employeeInstance, field: "city")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${employeeInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
<!-- #endif Webui AND Company -->