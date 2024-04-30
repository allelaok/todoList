<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    


<html>
<head>
<meta charset=UTF-8">
<title>Todo List</title>
</head>
<body>
<table border="1"  align="center"  width="80%">
    <tr align="center"   bgcolor="lightgreen">
      <td ><b>제목</b></td>
      <td><b>기간</b></td>
      <td><b>작성자</b></td>
      <td><b>완료여부</b></td> 
      <td><b>수정</b></td>
      <td><b>삭제</b></td>      
   </tr>
   
 <c:forEach var="todo" items="${todosList}" >     
   <tr align="center">
      <td><a  href="${contextPath}/todoDetail.do?tno=${todo.tno }">${todo.title}</td>
      <td>${todo.duedate}</td>
      <td>${todo.writer}</td>
      <td>${todo.finished}</td>
      <td><a href="${contextPath}/modTodo.do?tno=${todo.tno }">수정하기</a></td>
      <td><a href="${contextPath}/removeTodo.do?tno=${todo.tno }">삭제하기</a></td>
    </tr>
  </c:forEach>   
</table>
<a  href="${contextPath}/todoForm.do"><h1 style="text-align:center">할일 추가</h1></a>
</body>
</html>
