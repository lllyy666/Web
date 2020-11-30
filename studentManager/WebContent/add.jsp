<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<head>
<title>增加学生信息页面</title>
<style>
* {
	margin: 0;
	padding: 0;
	border: none;
}

body {
	background-image: url("images/trees.png");
}

.divcenter {
	height: 480px;
	font-family: "微软雅黑";
	width: 330px;
	text-align: center;
	border: 1px solid #00a9ef;
	background-color: white;
	margin: 55px auto 0;
	border-radius: 6px;
}

.divcenter>p {
	height: 50px;
	font-size: 19px;
	border-bottom: 1px solid #00a9ef;
	background-color: #e5f6fd;
	line-height: 50px;
	text-align: center;
	border-radius: 6px 6px 0 0;
}

form {
	margin-top: 15px;
}

input {
	width: 300px;
	height: 40px;
	margin-bottom: 8px;
	font-size: 16px;
}

input[type="submit"] {
	background-color: #5A98DE;
	text-decoration: none;
	color: white;
	border-radius: 3px;
	line-height: 40px;
	margin-top: 5px;
	text-align: center;
	
}

input[type="reset"] {
	background-color: #5A98DE;
	text-decoration: none;
	color: white;
	border-radius: 3px;
	line-height: 40px;
	margin-top: 5px;
	text-align: center;
	
}


.student-input {
	border: 1px solid #00A9EF;
	border-radius: 3px;
	padding-left: 2px;
}
</style>
</head>
<body>
	<div class="divcenter">
		<p>增加学生信息</p>
		<%--  使用<form>标签创建表单，在表单中使用<table>标签进行页面布局，使用<input>标签搜集用户输入的数据  --%>
		<form id="studentAction_save_do" name="Form1"
			action="${pageContext.request.contextPath }/AddServlet" method="post">
			<input class="student-input" id="sno" name="sno" placeholder="学号" /><br />
			<input class="student-input" id="sname" name="sname" placeholder="姓名" /><br />
			<input class="student-input" id="birthday" name="birthday" placeholder="生日" /><br /> 
			<input class="student-input" id="gender" name="gender" placeholder="性别" /><br /> 
			<input class="student-input" id="bj" name="bj" placeholder="班级" /><br /> 
			<input type="submit" value="确定">
			<input type="reset" value="重置">
			<input type="button" value="返回"		style="background-color: #5A98DE;
											 	text-decoration: none;
												color: white;
												border-radius: 3px;
												line-height: 40px;
												margin-top: 5px;
												text-align: center;"
			onclick="JavaScript:history.go(-1)">
		</form>
	</div>
</body>
</body>
</html>