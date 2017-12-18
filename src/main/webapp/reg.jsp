<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 1,引入bootstrap 等css -->
<link rel="stylesheet" href="<%=basePath %>js/bootstrap3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath %>js/bootstrap3.3.7/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="<%=basePath %>js/jquery-ui-1.12.1/jquery-ui.min.css">
<link rel="stylesheet" href="<%=basePath %>/css/reg.css">
<!-- 2,引入bootstrap 等js -->
<script type="text/javascript" src="<%=basePath %>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/bootstrap3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery-ui-1.12.1/jquery-ui.min.js"></script>

<title>秀女入宫等级页面</title>
<script type="text/javascript">
 $(function(){
	 $('#slider-range-max').slider({
		 range:"max",
		 min:10,
		 max:100,
		 value:19,
		 slide:function(event,ui){
			 $('#age').val(ui.value);
		 }
	 })
	 $("#age").val($("#slider-range-max").slider("value"));
	
 })

</script>
<script type="text/javascript">
   function insertg() {
	   $.ajax({
		   type:"post",
		   async:true,
		   url:"<%=basePath %>insert.do",
		   data:$('#formid').serialize(),
		   dataType:"text",
		   success:function(data){
			   if(data=="yes") {
				   alert("入册成功，恭喜您！");
				   location.href="<%=basePath %>getListByPage.do";
			   }
		   }
	   })
   }

</script>
</head>
<body>
   <ul  class="nav nav-tabs">
   	<li class="active"><a href="#">登记入册</a></li>
   </ul>
   
   <div class="div1">
       <form action="" id="formid">
	        <div>
	           <div class="glyphicon glyphicon-user" style="font-size: 26px">
	           </div>
	           <label class="text-right">秀女姓名：</label>
	           <input type="text" name="sname" id="sname">
	        </div>
	         <div>
	           <div class="glyphicon glyphicon-map-marker" style="font-size: 26px">
	           </div>
	           <label class="text-right">入宫时间：</label>
	           <input type="text" name="cometime" id="cometime">
	        </div>
	         <div>
	           <div class="glyphicon glyphicon-leaf" style="font-size: 16px">
	          
	           <label class="text-right">入册年龄：</label>
	           <input type="text" name="age" id="age" 
	           style="border: 0;color: red;font-weight: bold;">
	           <div id="slider-range-max" class="age"></div>
	            </div>
	        </div>
	         <div>
	           <div class="glyphicon glyphicon-ok" style="font-size: 26px">
	           </div>
	           <label class="text-right">最高分值：</label>
	           <input type="text" name="maxscore" id="maxscore">
	        </div>
	         <div>
	           <div class="glyphicon glyphicon-remove" style="font-size: 26px">
	           </div>
	           <label class="text-right">最低分值：</label>
	           <input type="text" name="minscore" id="minscore">
	        </div>
	        <div class="button">
	           <button type="button" class="btn btn-primary btn-lg" style="font-size: 26px" onclick="insertg()">
	           <span class="glyphicon glyphicon-user">登记入册</span>
	           </button>
	        </div>
       </form>
        
   </div>
</body>
</html>