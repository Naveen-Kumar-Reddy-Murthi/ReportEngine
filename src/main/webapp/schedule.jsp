<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="bootstrap/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.css" />
<title>ScheduleReport</title>
</head>
<body>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%-- <%@taglib uri="http://www.java.sun.com/jsp/jstl/core" prefix="jstl" %> --%>
	<div class="panel panel-default">


		<sf:form action="schedule" class="form-control">

			<spring:bind path="mailId">
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<sf:input path="mailId" type="text" class="form-control"
						id="mailId" placeholder="Recepient's Email" />
					<sf:errors path="mailId" class="control-label" />
				</div>
			</spring:bind>
			<spring:bind path="frequency">
				<label class="col-sm-2 control-label">Frequency</label>
				<div class="col-sm-5">
					<sf:select path="frequency" type="text" class="form-control" id="frequency">
						<sf:option value="" label="None"/>
						<sf:option value="D" label="Daily"/>
						<sf:option value="W" label="Weekly"/>
						<sf:option value="M" label="Monthly"/>
						<sf:option value="Y" label="Yearly"/>
					</sf:select>
					<sf:errors path="frequency" class="control-label" />
				</div>
			</spring:bind>
			<spring:bind path="time">
				<label class="col-sm-2 control-label">Time</label>
				<div class="col-sm-10">
					<sf:input path="time" type="text" class="form-control"
						id="time" />
					<sf:errors path="time" class="control-label" />
				</div>
			</spring:bind>
			<spring:bind path="mailId">
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<sf:input path="mailId" type="text" class="form-control"
						id="mailId" placeholder="Recepient's Email" />
					<sf:errors path="mailId" class="control-label" />
				</div>
			</spring:bind>
		</sf:form>

	</div>
</body>
</html>