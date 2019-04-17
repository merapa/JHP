    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- container start-->
		<div class="container">
			<img src="img/logo_white.png" style="width:140px; padding:20px;" align="right"><br><br>
			<a href="index_login.jsp" class="no-uline" ><h1>UHMS<small> Underwater Homeostatic Maintenance System </small></h1></a>
			<h3>수중생태 항상성 유지 시스템</h3>
			
			<!-- login form start-->
			<div class="topnav">
				<div class="login-container">
					<form action="loginForm.jsp" method="post">
						<h4 align="right"><%=id%> 님 환영합니다.</h4>
						<button type="button" class="mypagebtn" onclick="location.href='Boardinfo.jsp'" style="float: right;">MyPage</button>
						<button type="button" class="logoutbtn" onclick="location.href='loginForm.jsp'" style="float: right;">Logout</button>
						<br><br><br><br>
						
						<!--
						<% if(id.equals("jun0289jun")){
						%>
						<h4 align="right"><input type="button" onclick="location.href='member_list.jsp'" value="관리자 메뉴"></h4></a><br>
						<%}%>
						-->
						
					</form>
				</div>
			</div>
			<!-- login form end-->
			<div class="row" align="center">
				<div class="col-sm-3" style="background-color:#3E606F; margin-top:3px;"><a href="light.jsp"><h5>조명</h5></a></div>
				<div class="col-sm-3" style="background-color:#12252E; margin-top:3px;"><a href="heat.jsp"><h5>히터</h5></a></div>
				<div class="col-sm-3" style="background-color:#3E606F; margin-top:3px;"><a href="cooling.jsp"><h5>쿨러</h5></a></div>
				<div class="col-sm-3" style="background-color:#12252E; margin-top:3px;"><a href="waterlevel.jsp"><h5>수위보충</h5></a></div>
				<div class="col-sm-3" style="background-color:#3E606F; margin-top:3px;"><a href="feed.jsp"><h5>먹이자동급여</h5></a></div>
				<div class="col-sm-3" style="background-color:#12252E; margin-top:3px;"><a href="list.jsp"><h5>수조목록</h5></a></div>
				<div class="col-sm-3" style="background-color:#3E606F; margin-top:3px;"><a href="daiary.jsp"><h5>기록일지</h5></a></div>
				<div class="col-sm-3" style="background-color:#12252E; margin-top:3px;"><a href="qna.jsp"><h5>QnA</h5></a></div>
			
			</div>
		</div>
		<!-- container end-->
