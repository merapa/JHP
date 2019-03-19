ex) INSERT INTO member VALUES (?,?,?,?) 

		member 안에 들어갈건 테이블

		name = "jdbc/jhp" jhp 아이디
		auth = "Container"
		type = "javax.sql.DataSource"
		username = "zerock"		오라클 id
		password = "1234"			오라클 pw
		driverClassName = "org.mariadb.jdbc.Driver"
		url = "jdbc:mariadb://127.0.0.1:3307/jhp"   여기의 jhp는 데이터베이스
		maxActive = "500
