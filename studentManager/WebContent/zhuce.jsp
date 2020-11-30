<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<head>
<title>教师注册页面</title>
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
	height: 490px;
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


.teacher-input {
	border: 1px solid #00A9EF;
	border-radius: 3px;
	padding-left: 2px;
}
</style>
</head>
<body>
	<div class="divcenter">
		<p>教师注册</p>
		<%--  使用<form>标签创建表单，在表单中使用<table>标签进行页面布局，使用<input>标签搜集用户输入的数据  --%>
		<form id="studentAction_zhuce_do" name="Form1"	onsubmit="return checkip()"
			action="${pageContext.request.contextPath }/ZhuceServlet" method="post">
			<input class="teacher-input" id="tno" name="tno" placeholder="教工号" /><br />
			<input class="teacher-input" id="tname" name="tname" placeholder="姓名" /><br />
			<input class="teacher-input" id="gender" name="gender" placeholder="性别" /><br /> 
			<input class="teacher-input" type="password" id="password" name="password" placeholder="密码" /><br />
			<input class="teacher-input" type="password" id="password1" name="password" placeholder="确认密码" onblur="check()"/><br />
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
<script type="text/javascript">
        //自定义通过ID获取元素的函数
          function $(id){
           		return document.getElementById(id)
         	}
        	function check(){
             	var boo=$('password').value==$('password1').value;
             	if (boo) {
                 return true;
            }else{
                 alert('两次密码不一致')
                 return false;
             }
          }
</script>
</body>
</body>
</html>