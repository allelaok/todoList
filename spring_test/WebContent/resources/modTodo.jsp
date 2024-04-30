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
	<form method="post"   action="${contextPath}/updateTodo.do">
	<h1  class="text_center">Todo 수정창</h1>
	<table  align="center">
		<tr>
	      <td width="200"><p align="right">제목</td>
	      <td width="400"><input type="text" name="title" value="${todo.title }"></td>
	   </tr>
	   <tr>
	      <td width="200"><p align="right">기간</td>
	      <td width="400"><input type="date" name="duedateStr" value="${todo.duedate }" required></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">작성자</td>
	       <td width="400"><p><input type="text" name="writer" value="${todo.writer }"></td>
	    </tr>
	    <tr>
	   		<td width="200"><p align="right">완료여부</td>
		   	<td width="400">
		       <input type="radio" id="finished_yes" name="finished" value="true" ${todo.finished ? "checked" : ""}>
		       <label for="completed_yes">완료</label>
		       <input type="radio" id="finished_no" name="finished" value="false" ${!todo.finished ? "checked" : ""}>
		       <label for="completed_no">미완료</label>
		   	</td>
		</tr>
		
	    <tr>
	       	<td width="200"><p>&nbsp;</p>
		       <input type="hidden" name="tno" value="${todo.tno }" >
			</td>
	       <td width="400"><input type="submit" value="수정하기"><input type="reset" value="다시입력"></td>
	    </tr>
	</table>
	</form>
</body>
</html>