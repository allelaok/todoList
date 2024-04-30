<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할일 수정창</title>
<style>
   .text_center{
     text-align:center;
   }
</style>
</head>
<body>
	<h1  class="text_center">${todo.title }</h1>
	<table  border="1" align="center">
		<tr>
	      <td width="200"><p align="right" class="text_center">제목</td>
	      <td width="400">${todo.title }</td>
	   </tr>
	   <tr>
	      <td width="200"><p align="right" class="text_center">기간</td>
	      <td width="400">${todo.duedate }"</td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right" class="text_center">작성자</td>
	       <td width="400"><p>${todo.writer }</td>
	    </tr>
	    <tr>
	   		<td width="200"><p align="right" class="text_center">완료여부</td>
		   	<td width="400">
		        ${todo.finished ? "완료" : "미완료"}
		   	</td>
		</tr>
		
	    <tr >
	       <td colspan="2" width="400" class="text_center"><a  href="${contextPath}/listTodos.do">확인</td>
	    </tr>
	</table>
</body>
</html>