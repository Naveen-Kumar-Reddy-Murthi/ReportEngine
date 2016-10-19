<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="bootstrap/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css"/>
<title>ScheduleReport</title>
</head>
<body>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%-- <%@taglib uri="http://www.java.sun.com/jsp/jstl/core" prefix="jstl" %> --%>
<div class="panel panel-default">

	
	<sf:form action="schedule" class="form-control">
	<label class="col-sm-2 control-label">Email</label>
			<div class="col-sm-10">
				<sf:input path="mailId" type="text" class="form-control"
                                id="mailId" placeholder="Recepient's Email" />
				<sf:errors path="mailId" class="control-label" />
			</div>
	</sf:form>

</div>
</body>
</html>