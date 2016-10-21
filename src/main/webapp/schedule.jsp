<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
	src="resources/bootstrap/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="resources/bootstrap/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css"
	href="resources/bootstrap/css/bootstrap.css" />
<script type="text/javascript">
	$(document).ready(function() {
		toggleFields();
		$("#frequency").change(function() {
			toggleFields();
		});

	});

	function toggleFields() {
		if ($("#frequency").val() === "") {
			/* $("#day-div").show();
			$("#time-div").show(); */
			$("#dateTime-div").show();
		} else if ($("#frequency").val() === "D") {
			/* $("#day-div").hide(); */
			$("#dateTime-div").show();
			$("#time-div").hide();
		} else if ($("#frequency").val() === "W") {
			$("#dateTime-div").show();
			/* $("#day-div").hide(); */
			$("#time-div").hide();
		}
		else if ($("#frequency").val() === "M") {
			$("#time-div").hide();
			/* $("#day-div").hide(); */
			$("#dateTime-div").show();
		}
		else if ($("#frequency").val() === "Y") {
			$("#time-div").hide();
			/* $("#day-div").hide(); */
			$("#dateTime-div").show();
		}
	}
</script>
<title>ScheduleReport</title>
</head>
<body>

	<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

	<div class="container">


		<sf:form action="save" modelAttribute="reportScheuduleEntity"
			class="form-horizontal" method="post">

			<jstl:set var="message"
				value="<%=request.getAttribute(\"message\")%>" />
			<jstl:if test="${not empty message}">
		<div class="form-group row">
					<div class="alert alert-success">
						<strong>Data saved successfully!</strong>
					</div>
				</div>
			</jstl:if>
			<div class="form-group row">
				<div class="page-header">
					<h1>Report Scheduler</h1>
				</div>
			</div>

			<div class="form-group row">
				<spring:bind path="mailId">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-xs-2 col-form-label">Email</label>
						<div class="col-xs-5">
							<sf:input path="mailId" type="text" class="form-control"
								id="mailId" placeholder="Recepient's Email" />
							<sf:errors path="mailId" class="control-label" />
						</div>
					</div>
				</spring:bind>
			</div>

			<div class="form-group row">
				<spring:bind path="frequency">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-xs-2 col-form-label">Frequency</label>
						<div class="col-xs-5">
							<sf:select path="frequency" type="text" class="form-control"
								id="frequency">
								<sf:option value="" selected="selected" label="select" />
								<sf:option value="D" label="Daily" />
								<sf:option value="W" label="Weekly" />
								<sf:option value="M" label="Monthly" />
								<sf:option value="Y" label="Yearly" />
							</sf:select>
							<sf:errors path="frequency" class="control-label" />
						</div>
					</div>
				</spring:bind>
			</div>

			<%-- <div class="form-group row" id="day-div">
				<spring:bind path="day">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-xs-2 col-form-label">Day</label>
						<div class="col-xs-5">
							<sf:select path="day" type="text" class="form-control" id="day">
								<sf:option value="" selected="selected" label="select" />
								<sf:option value="Monday" label="Monday" />
								<sf:option value="Tuesday" label="Tuesday" />
								<sf:option value="Wednessday" label="Wednessday" />
								<sf:option value="Thurseday" label="Thurseday" />
								<sf:option value="Friday" label="Friday" />
								<sf:option value="Saturday" label="Saturday" />
								<sf:option value="Sunday" label="Sunday" />
							</sf:select>
							<sf:errors path="day" class="control-label" />
						</div>
					</div>
				</spring:bind>
			</div> --%>

			<div class="form-group row" id="time-div" style="display: none">
				<spring:bind path="time">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-xs-2 col-form-label">Time</label>
						<div class="col-xs-5">
							<sf:input path="time" type="time" class="form-control" id="time" />
							<sf:errors path="time" class="control-label" />
						</div>
					</div>
				</spring:bind>
			</div>



			<div class="form-group row" id="dateTime-div">
				<spring:bind path="dateTime">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-xs-2 col-form-label">Date Time</label>
						<div class="col-xs-5">
							<sf:input path="dateTime" type="datetime-local"
								class="form-control" id="dateTime" data-date-format="dd-mm-yyyy hh:ii"  />
							<sf:errors path="dateTime" class="control-label" />
						</div>
					</div>
				</spring:bind>
			</div>

			<div class="form-group row">
				<spring:bind path="query">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-xs-2 col-form-label">Query</label>
						<div class="col-xs-5">
							<sf:input path="query" type="textArea" class="form-control"
								id="query" placeholder="Enter valid SQL query" />
							<sf:errors path="query" class="control-label" />
						</div>
					</div>
				</spring:bind>
			</div>

			<div class="form-group row">
				<div class="col-sm-offset-2 col-md-5">
					<button type="submit" class="btn-sm btn-primary pull-right">Save
					</button>
				</div>
			</div>
		</sf:form>
	</div>
</body>
</html>