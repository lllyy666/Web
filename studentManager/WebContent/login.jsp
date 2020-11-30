<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎来到学生管理系统</title>
    <style>
    
<style>
* {
	margin: 0;
	padding: 0;
	border: none;
}

body {
	background-image: url("images/trees.png");
}

.sign-div{
    width: 300px;
    padding: 20px;
    text-align: center;
    position:absolute;
    top: 30%;
    left: 50%;
    transform: translate(-50%,-50%);
    overflow: hidden;
}


.sign-div h1{
    margin-top: 100px;
    color: black;
    font-size: 40px;
}
.sign-div input{
    display: block;
    width: 100%;
    padding: 0 16px;
    height: 44px;
    text-align: center;
    box-sizing: border-box;
    outline: none;
    border: none;
    font-family: "montserrat",sans-serif;
}
.sign-text{
    margin: 15px 4px;
    background: rgba(255,255,255,5);
    border-radius: 6px;
}
.sign-btn{
    margin-top: 50px;
    margin-bottom: 20px;
    background: #487eb0;
    color: #fff;
    border-radius: 44px;
    cursor: pointer;
    transition: 0.8s;
}

<!-- 进行缩放 -->
.sign-btn:hover{
    transform:scale(0.8);
}

.sign-div a{
    text-decoration: none;
    color: black;
    font-family: "montserrat", sans-serif;
    font-size: 14px;
    padding: 10px;
    transition: 0.8s;
    display: block;
}

.sign-div a:hover{
    background: rgba(0,0,0,.3);
}

</style>  
</head>
<body>
<div class="sign-div">
    <form id="studentAction_login_do" name="Form1"
			action="${pageContext.request.contextPath }/LoginServlet" method="post">
        <h1>登陆</h1>
        <input class="sign-text" type="text" id="tno" name="tno" placeholder="教工号" 
        onkeyup="cc(this.value)" onkeydown = "cc(this.value)" onblur="cc(this.value)" onfocus = "cc(this.value)">
        
        <input class="sign-text" type="password" id="password" name="password" placeholder="密码">
        <input class="sign-btn" type="submit" id="submit" name="submit"  value="登陆">
    </form>
 		<a href="zhuce.jsp">注册新用户</a>
</div>
 
<script> 
function cc(val) 
{ 
   if(val.length>=1) 
   { 
      document.all.submit.disabled=false; 
   }else{
     document.all.submit.disabled=true; 
   }
} 
cc(document.all.tno.value);//画面onload时调用
</script> 
 
</body>
</html>