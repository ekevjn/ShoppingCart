<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="register" method="post" class="pure-form">
		<fieldset>
			<legend>Sign up form</legend>
			<table>
				<tr>
					<td>User name</td>
					<td><input type="text" name="userName"
						placeholder="Enter your usename"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" placeholder="password" name="password"
						id="password" required></td>
				</tr>
				<tr>
					<td>Re-Enter password</td>
					<td><input type="password" placeholder="Confirm Password"
						id="confirm_password" required></td>
				</tr>
				<tr>
					<td>Full name</td>
					<td><input type="text" name="fullname"
						placeholder="Enter your name"></td>
				</tr>
				<tr>
					<td>Roll number</td>
					<td><input type="text" name="rollnumber"
						placeholder="Enter your roll number"></td>
				</tr>
				<tr>
					<td></td>
					<td><button type="submit" class="pure-button pure-button-primary">Resgister</button></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>

<script type="text/javascript">
	var password = document.getElementById("password");
	var confirm_password = document.getElementById("confirm_password");

	function validatePassword() {
		if (password.value != confirm_password.value) {
			confirm_password.setCustomValidity("Passwords Don't Match");
		} else {
			confirm_password.setCustomValidity('');
		}
	}

	password.onchange = validatePassword;
	confirm_password.onkeyup = validatePassword;
</script>
</html>