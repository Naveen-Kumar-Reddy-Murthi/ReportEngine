<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<script type="text/javascript"
	src="resources/bootstrap/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="resources/bootstrap/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css"
	href="resources/bootstrap/css/bootstrap.css" />
</head>

<body>

	<div class="container">

		<sf:form method="post" action="login" modelAttribute="loginEntity" class="form-signin">
			<h2 class="form-heading">Log in</h2>
			
			<div class="form-group row">
				<spring:bind path="userId">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-xs-2 col-form-label">User Id</label>
						<div class="col-xs-5">
							<sf:input path="userId" type="text" class="form-control"
								id="userId" placeholder="Enter User Id" />
							<sf:errors path="userId" class="control-label" />
						</div>
					</div>
				</spring:bind>
			</div>

			<div class="form-group row">
				<spring:bind path="password">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<label class="col-xs-2 col-form-label">User Id</label>
						<div class="col-xs-5">
							<sf:input path="password" type="password" class="form-control"
								id="password" placeholder="Enter Password" />
							<sf:errors path="userId" class="control-label" />
						</div>
					</div>
				</spring:bind>
			</div>
			<div class="col-sm-offset-5 col-md-14">
				<button class="btn btn-md btn-primary pull-center" type="submit">LogIn</button>
			</div>

		</sf:form>

	</div>
	<!-- /container -->

</body>
</html>