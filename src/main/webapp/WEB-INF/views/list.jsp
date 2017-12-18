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
<!-- 引入分页插件 -->
<!-- 1.引入jQuery -->
<script type="text/javascript" src="<%=basePath%>/js/jquery.min.js"></script>
<!-- 2.引入kkpager -->
<script type="text/javascript" src="<%=basePath%>/js/kkpager/jpager.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/js/kkpager/jpager.css">
<script type="text/javascript" src="<%=basePath%>/js/listpage.js"></script>


<!-- 删除操作 -->
<script type="text/javascript">
     function del(id){
    	 
    	 if(!confirm("您确定删除吗？")){
    		 window.event.returnValue = false;
    		 
    	 } else {   
    		 window.event.returnValue = true;
	    	 $.ajax({
	    		 type:"get",
	    		 url:"<%=basePath%>delById.do",
	    		 data:{id:id},
	    		 dateType:"text",
	    		 success:function(data){
	    			 if(data=="yes"){
	    				 alert("恭喜你删除成功！");
	    				 location.href="<%=basePath%>getListByPage.do";
	    			 }
	    		 }
	    	 })
	    	 }
     }


</script>

<title>清朝秀女列表展示图</title>
</head>
<body onload="load()" >

<div>秀女列表</div>
<div>
	<table border="1">
	  <tr>
	  	<th>序号</th>
	  	<th>秀女姓氏</th>
	  	<th>入宫时间</th>
	  	<th>秀女年龄</th>
	  	<th>入宫考核最高分</th>
	  	<th>入宫考核最低分</th>
	    <th>操作</th>
	  </tr>
	  <c:forEach items="${datas.content }" var="girls" varStatus="s">
	  <tr>
	  
	     <td>${girls.id }</td>
	     <td>${girls.sname }</td>
	     <td>${girls.cometime }</td>
	     <td>${girls.age }</td>
	     <td>${girls.maxscore }</td>
	     <td>${girls.minscore }</td>
	     <td><a href="<%=basePath%>findOneById.do?id=${girls.id }">更新</a>|<a onclick="del(${girls.id })">删除</a></td>
	                           
	  </tr>
	   </c:forEach>
	</table>
</div>

<div id="jpager"></div><!-- 渲染 -->
</body>
<script type="text/javascript">
   function load() {

	    arrayPage(${datas.totalPages},${datas.size});
   }

</script>
</html>