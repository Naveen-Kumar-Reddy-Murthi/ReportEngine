<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

		<form method="POST" action="login" class="form-signin">
			<h2 class="form-heading">Log in</h2>
			
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

			<div class="form-group">
				 <input name="username" type="text"
					class="form-control" placeholder="Username" /> <input
					name="password" type="password" class="form-control"
					placeholder="Password" /> <span>${error}</span>

				<button class="btn btn-lg btn-primary btn-block" type="submit">LogIn</button>
			</div>

		</form>

	</div>
	<!-- /container -->

</body>
</html>