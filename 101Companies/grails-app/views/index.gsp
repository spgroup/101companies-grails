<!-- #if Webui -->
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>101Companies in grails</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}
            
			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>
		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="status" role="complementary">
			<h1>Useful information</h1>
			<ul>
				<li>Frequently Asked Questions</li>
				<li>The features</li>
				<li>The implementations</li>
				<li>Contributors</li>
				<li>The stakeholders</li>
				<li>Some themes of contributions</li>
				<li>Some ideas for contributions</li>
				<li>The data exposed</li>
				<li>More resources</li>
				<li>The ontology</li>
			</ul>
		</div>
		<div id="page-body" role="main">
			<h1>Welcome to 101Companies in grails</h1>
			<p>101companies is a community project in computer science (or software science) with the objective of developing a free, structured, online knowledge resource including an open-source repository for different stakeholders with interests in software technologies, software languages, and technological spaces; notably: teachers and learners in software engineering or software languages as well as software developers, software technologists, and ontologists.</p>

			<div id="controller-list" role="navigation">
				<h2>Application in grails:</h2>
				<p>We present an implementation of the 101Companies implementation using powerful resources provided by grails.</p>
				<!-- #if Company -->
					<g:link controller="company" action="list">Company</g:link> |
					<g:link controller="department" action="list">Department</g:link> |
					<g:link controller="employee" action="list">Employee</g:link>
				<!-- #endif Company -->
			</div>
		</div>
	</body>
</html>
<!-- #endif -->
