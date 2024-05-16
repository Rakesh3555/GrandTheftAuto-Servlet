<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<style>
body {
	background-image: url(GtaImages/regbg.jpg);
	background-size: cover;
}

.box {
	text-align: center;
	margin-top: 10%;
}

.log {
	border: 1px solid rgb(26, 68, 206);
	padding: 20px;
	width: 300px;
	background-color: rgb(248, 248, 248);
	box-shadow: 5px 5px 7px 10px rgba(219, 103, 7, 0.185);
	text-align: justify;
	margin: 0 auto;
}

.b1 {
	border: 1px solid rgb(5, 1, 15);
	color: rgb(250, 250, 252);
	background-color: rgb(248, 248, 250);
	width: 100px;
	border-radius: 15px;
	text-decoration: none;
}

.btn {
	margin-left: 30%;
}
</style>
<body>
	<div class="box">
		<div class="log">
			<h2
				style="font-family: Arial, Helvetica, sans-serif; text-align: center;">Pre-Order</h2>
			<form action="<%= request.getContextPath()%>/register" method="post">
				<label for="Username">Username: </label> <input type="text" name="username" placeholder="username" required><br>
				<br> <label for="Date of Birth">Date Of Birth: </label> <input type="date" name="Date_of_birth" placeholder="Date_of_birth" required><br>
				<br> <label for="Email ID">E-Mail: </label> <input type="email"
name="mail" placeholder="mail" required><br>
				<br> <label>
					<div class="btn">
						<button class="b1" type="submit">
							Confirm Order
						</button>
						<br>
						<br>
					</div>
			</form>
		</div>
	</div>
</body>
</html>