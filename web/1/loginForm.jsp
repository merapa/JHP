<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>



	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<meta name="viewport" content="width=device-width, initial-scale=1">
			
		<!-- Basic CSS -->
		<link rel="stylesheet" href="css/basic.css">
		
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="css/bootstrap.min.css">
		
		<!-- jQuery library -->
		<script src="js/jquery-3.3.1.min.js"></script>
		
		<!-- Latest compiled JavaScript -->
		<script src="js/bootstrap.min.js"></script>
		
		<title>로그인</title>
		
		<style type="text/css">
				a.no-uline {text-decoration:none}
				::-webkit-scrollbar {display: none;}<!-- = hide scrollbar -->


		</style>
		
		<style>
				h1 {
				color: #ffffff;
				}
				h2 {
					color: #ECF7D5;
				}
				h3 {
					color: #91AA9D;
				}
				h3.a {
					color: #ECF7D5;
				}
				h5 {
					color: #ffffff;
					height: 35px;
					/*Basically, the H-tag has a margin and padding */
					margin: 0;
					padding: 0;
					vertical-align: middle; /*middle centred*/
					display:table-cell; /*acts like a table cell*/
				}
				p {
					color: #D3E0E0;
					font-size: 18px;
				}
				p.a {
					color: #D3E0E0;
					font-size: 14px;
				}
				b {
					color: #ffffff;
				}
				
				/*------------------------------------------- */
				@media screen and (max-width: 500px) {
					span.psw {
						display: block;
						float: none;
					}
					.form {
						width: 100%;
					}
				}
				form {
					border: 10px solid #12252F;
					background-color: #12252E;
					width: 65%;
					display: block;
					margin-left: auto;
					margin-right: auto;
					padding-left: 20px;
					padding-right: 20px;
					padding-bottom: 50px;
					
				}

				input[type=text], input[type=password] {
					width: 100%;
					padding: 12px 20px;
					margin: 8px 0;
					display: inline-block;
					border: 1px solid #ccc;
					box-sizing: border-box;
				  
				  
				}

				button {
					background-color: #4CAF50;
					color: white;
					padding: 20px 20px;
					margin: 20px 0;
					border: none;
					cursor: pointer;
					width: 100%;
				}

				button:hover {
					opacity: 0.8;
				}

				.joinbtn {
					width: auto;
					padding: 10px 18px;
					background-color: #f44336;
				}

				.imgcontainer {
					text-align: center;
					margin: 24px 0 12px 0;
				}

				img.avatar {
					width: 35%;
					border-radius: 50%;
				}

				.login_container {
					padding: 20px;
					width: 100%;
				}

				span.psw {
					float: right;
					padding-top: 16px;
				}

				/* Change styles for span and join button on extra small screens */
				@media screen and (max-width: 500px) {
					span.psw {
						display: block;
						float: none;
					}
					.joinbtn {
						width: 100%;
					}
				}
				
				
				
			</style>
	</head>
	<body style="background-color:#193441; overflow: auto;"><!-- overflow: auto;= hide scrollbar -->
		<!-- container start-->
		<div class="container">
			<img src="img/logo_white.png" style="width:140px; padding:20px;" align="right">
			<a href="index.html" class="no-uline" ><h1>UHMS<small> Underwater Homeostatic Maintenance System </small></h1></a>
			<h3>수중생태 항상성 유지 시스템</h3>
			
			<!-- login form start-->
			<form action="loginProcess.jsp" class="form" method="get">
				<div class="imgcontainer">
					<img src="img/avatar.png" alt="Avatar" class="avatar">
				</div>

				<div class="login_container">
					<label for="id"><b>ID</b></label><br>
					<input type="text" placeholder="Enter ID" name="id" required><br>

					<label for="pass"><b>Password</b></label><br>
					<input type="password" placeholder="Enter Password" name="pass" required>

					<button type="submit">Login</button><br>
					<label>
					<input type="checkbox" checked="checked" name="remember"> <b>Remember</b></label><br><br><br>
				</div>

				<div class="login_container" style="background-color:#f1f1f1">
					<button type="button" class="joinbtn" onclick="location.href='JoinForm.jsp'" >Join</button>
					<script type="text/javascript">
					function popupOpen(){
					var popUrl = "ForgetCheck.html" ;
					var popOption = "width=450, height=500, resizable=no, scrollbars=no, status=no;";    //팝업창 옵션(optoin)
					window.open(popUrl,"",popOption);
				}
					</script>
				Forget <a href="javascript:popupOpen();" >password?</a>
				</div>
			</form>
			<!-- login form end-->
		</div>
		<!-- container end-->
			
		
	</body>
</html>
