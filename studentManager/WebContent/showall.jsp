<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>学生信息</title>
<style>
* {
	margin: 0;
	padding: 0;
	border: none;
}

body {
	background-image: url("images/trees.png");
}

div {
	text-align: center;
	padding: 6px;
	/*background-color: #8CD3EC;*/
}

table {
	margin-top: 15px;
	text-align: left;
	width: 100%;
	border-collapse: collapse;
	text-align: left;
}

th, td {
	border: 1px solid #ebeef5;
	padding: 7px;
}

th {
	font-size: 17px;
	text-align: left;
	background-color: #F2F2F2;
	color: #131;
}

td {
	font-size: 15px;
	background-color: white;
}

th:first-child {
	border-radius: 5px 0 0 0;
}

th:last-child {
	border-radius: 0 5px 0 0;
}

tr:last-child td:first-child {
	border-radius: 0 0 0 5px;
}

tr:last-child td:last-child {
	border-radius: 0 0 5px 0;
}

.manager a {
	text-decoration: none;
	padding: 4px;
	font-size: 13px;
	display: inline-block;
	background-color: #64D1F7;
	border-radius: 2px;
	color: white;
}

.manager a:last-child {
	background-color: #8CD3EC;
}

a:hover {
	box-shadow: 1px 1px 1px #64D1F7;
}

.manager a:last-child:hover {
	box-shadow: 1px 1px 1px #8CD3EC;
}


h1 {
    display: inline-block;
}

a {
	height: 20px;
	display: inline-block;
	padding: 6px;
	background-color: #00B4F9;
	text-decoration: none;
	color: white;
	border-radius: 3px;
	line-height: 20px;
	text-align: center;
    float: left;
}

</style>
</head>
<body>
	<div>
		<h1>学生信息</h1><a href="index.jsp">返回</a>
		<table>
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>生日</th>
				<th>班级</th>
				<th>操作</th>
			</tr>
			<c:forEach var="studentList" items="${studentLists}">
				<tr>
					<td>${studentList.sno}</td>
					<td>${studentList.sname}</td>
					<td>${studentList.gender}</td>
					<td>${studentList.birthday}</td>
					<td>${studentList.bj}</td>
					<td class="manager">
						<a href="DeleteStudent?sno=${studentList.sno}">删除</a>
						<a href="WithSnoQueryStudent?sno=${studentList.sno}">修改</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
