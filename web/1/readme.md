JSP -> DAO DTO Servlet 사용 예정 ( jsp 이용만 하다가 Dao,Servlet 추가 중 )
현재 수정중 = joinProcess.jsp 






ex) INSERT INTO member VALUES (?,?,?,?) 

		위 인서트	member 의 뜻은  테이블

		name = "jdbc/jhp" 
		auth = "Container"
		type = "javax.sql.DataSource"
		username = "root"		오라클 id
		password = "01230123"			오라클 pw
		driverClassName = "org.mariadb.jdbc.Driver"
		url = "jdbc:mariadb://localhost:3306/JHP"   여기의 jhp는 데이터베이스
		maxActive = "500
