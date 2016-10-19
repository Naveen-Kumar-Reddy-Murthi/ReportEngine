<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="bootstrap/jquery-1.9.1.min.js"></script><!--needed  -->
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script><!-- needed  -->
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css"/><!-- needed -->
<title>ScheduleReport</title>  
</head>
<body>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
	<%@taglib uri="http://www.springframework.org/tags" prefix="tags"%>
	<%-- <%@taglib uri="http://www.java.sun.com/jsp/jstl/core" prefix="jstl" %> --%>
	<div class="panel panel-default">
		<sf:form action="scheduleReport" method="post"
			modelAttribute="reportScheuduleEntity" cssClass="form-horizontal">
			<table cellspacing="0">
					<tr>
						<th><label for="mailId">Email:</label></th>
						<td><sf:input path="mailId" id="mailId" /></td>
						<td><sf:errors path="mailId" class="control-label"/></td>
					</tr>
					<tr>
						<th><label for="name">Name:</label></th>
						<td><sf:input path="name" id="name" /></td>
						<td><sf:errors path="name" cssClass="error" /></td>
					</tr>
					<tr>
						<th><label for="department">Department:</label></th>
						<td><sf:input path="department" id="department" /></td>
						<td><sf:errors path="department" cssClass="error" /></td>
					</tr>
					<tr>
						<th><label for="email">Email:</label></th>
						<td><sf:input path="email" id="email" /></td>
						<td><sf:errors path="email" cssClass="error" /></td>
					</tr>

					<tr>
						<th><input type="Submit" value="Submit" /></th>
						<td></td>
					</tr>
				</table>
		</sf:form>
	</div>
</body>
</html>