<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
   request.setCharacterEncoding("UTF-8");
%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입창</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
 integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
 crossorigin="anonymous">

</head>
<body>

<div class="container-fluid">
<!-- Header 시작 -->
	<div class="row">
		<div class="col">
			
			
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <a class="nav-link active" aria-current="page" href="#">Home</a>
        <a class="nav-link" href="#">Features</a>
        <a class="nav-link" href="#">Pricing</a>
        <a class="nav-link disabled">Disabled</a>
      </div>
    </div>
  </div>
</nav>
			
			
		</div>
	</div>
<!-- Header 끝 -->
<!-- content 시작 -->
	<div class="row content">
			<div class="col">
				<div class="card">
					<div class="card-header">
						Featured
					</div>
					<div class="card-body">
					    <form action="${contextPath}/addTodo.do" method="post">
					    	<div class="input-group mb-3">
					    		<span class="input-group-text">Title</span>
					    		<input type="text" name="title" class="form-control" placeholder="Title">
					    	</div>
					    	
					    	<div class="input-group mb-3">
					    		<span class="input-group-text">Duedate</span>
					    		<input type="date" name="duedateStr" class="form-control" placeholder="Duedate">
					    	</div>
					    	
					    	<div class="input-group mb-3">
					    		<span class="input-group-text">Writer</span>
					    		<input type="text" name="writer" class="form-control" placeholder="Writer">
					    	</div>
					    	
					    	
					    	<div class="my-4">
					    		<div class="float-end">
					    			<button type="submit" class="btn btn-primary">추가하기</button>
					    			<button type="reset" class="btn btn-seconday">다시입력</button>
					    		</div>
					    	</div>					    	
					    </form>
					    
<%-- 					    <c:forEach items="${errors}" var="error"></c:forEach> --%>

<!-- 						<script> -->
// 						    const serverValidResult = {};
// 						    <c:forEach items="${errors}" var="error">
// 						        serverValidResult['${error.getField()}'] = '${error.defaultMessage}';
// 						    </c:forEach>
// 						    console.log(serverValidResult);
<!-- 						</script> -->

					    
					</div>
				</div>
			</div>
		</div>
<!-- content 끝 -->
<!-- footer 시작 -->
	<div class="roq footer">
		
		
		<div class="row  fixed-bottom" style="z-index: -100">
			<footer class="py-1 my-1 ">
				<p class="text-center text-muted">Footer</p>
			</footer>
		</div>
		
	</div>
<!-- footer 끝 -->
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	
</body>
</html>