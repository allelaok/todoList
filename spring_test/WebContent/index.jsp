<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
    // PageRequestDTO 클래스의 인스턴스 생성
    com.nsr.spring.vo.PageRequestDTO pageRequestDTO = new com.nsr.spring.vo.PageRequestDTO();
    
    // 이동할 페이지의 URL에 쿼리 매개변수로 객체의 내용을 포함하여 redirection
    String redirectURL = "${contextPath}/listTodos.do?" + pageRequestDTO.getLink();
    response.sendRedirect(redirectURL);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>
