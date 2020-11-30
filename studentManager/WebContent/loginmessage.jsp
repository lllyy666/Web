<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<!-- 完成页面定时的跳转 -->
<meta http-equiv="refresh" content="3;url=login.jsp" charset="UTF-8">

<title>Insert title here</title>
<style>
body {
	background-image: url("images/trees.png");
}

div {
	width: 360px;
	height: 100px;
	line-height: 100px;
	border-radius: 5px;
	background-color: #8CD3EC;
	margin: 25px auto 0;
	color: white;
	text-align: center;
	font-size: 17px;
}
</style>
</head>


<body onload="run()">
  
   <div>${message}将在<span id="spanId">3</span>秒后跳转至登陆页面</div>
   
</body>

<br><script type="text/javascript">
    // 页面一加载完成，该方法就会执行
    // 读秒，一秒钟数字改变一次
    var x = 3;
    function run(){
        // 获取到的是span标签的对象
        var span = document.getElementById("spanId");
        // 获取span标签中间的文本
        span.innerHTML = x;
        x--;
        // 再让run方法执行呢，一秒钟执行一次
        window.setTimeout("run()", 1000);
    }
     
</script><br>

</html>