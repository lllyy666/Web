<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<head>
<title>查询学生信息</title>
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
	height: 250px;
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
	margin-top: 15px;
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
		<p>查询学生信息</p>
		<%--  使用<form>标签创建表单，在表单中使用<table>标签进行页面布局，使用<input>标签搜集用户输入的数据  --%>
		<form action="${pageContext.request.contextPath }/QueryStudent"
			method="post">
			<input class="student-input" id="sno" name="sno" placeholder="学号" /><br />
			<input type="submit" value="查询">
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