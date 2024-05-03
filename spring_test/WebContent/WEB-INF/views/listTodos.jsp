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
<title>Todo List</title>
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
					    
					    
					    <h5 class="card-title">Special title treatment</h5>
					    <table class="table">
					    	<thead>
					    	<tr>
					    		<th scope="col">Tno</th>
					    		<th scope="col">Title</th>
					    		<th scope="col">Writer</th>
					    		<th scope="col">Duedate</th>
					    		<th scope="col">Finished</th>
					    	</tr>
					    	</thead>
					    	<tbody>
					    	<c:forEach items="${responseDTO.dtoList}" var="todo">
					    		<tr>
					    			<th scope="row"><c:out value="${todo.tno }" /></th>
					    			<td><a href="todoDetail.do?tno=${todo.tno}&${pageRequestDTO.link}" class="text-decoration-none">
					    				<c:out value="${todo.title }" /></a></td>
					    			<td><c:out value="${todo.writer }" /></td>
					    			<td><c:out value="${todo.duedate }" /></td>
					    			<td><c:out value="${todo.finished }" /></td>
					    		</tr>
					    	</c:forEach>
					    	</tbody>
					    </table>
					    
					    <div class="float-end">
					    	<ul class="pagination flex-wrap">
					    	
					    		<c:if test="${responseDTO.prev }">
					    			<li class="page-item">
					    				<a class="page-link">Previous</a>
					    			</li>
					    		</c:if>		
					    	
					    		<c:forEach begin="${responseDTO.start}" end="${responseDTO.end }" var="num">
					    		<li class="page-item ${responseDTO.page == num? 'active':''} "><a class="page-link" data-num="${num}">${num}</a></li>
					    		</c:forEach>
					    		
					    		<c:if test="${responseDTO.next }">
					    			<li class="page-item">
					    				<a class="page-link">Next</a>
					    			</li>
					    		</c:if>
					    		
					    	</ul>
					    </div>
					    
					    
					    <script>
					    
					    	document.querySelector(".pagination").addEventListener("click", function (e) {
					    		e.preventDefault();
					    		e.stopPropagation();
					    		
					    		const target = e.target;
					    		
					    		if(target.tagName !== 'A'){
					    			return;
					    		}
					    		
					    		const num = target.getAttribute("data-num");
					    		
					    		self.location = `${contextPath}/listTodos.do?page=\${num}`;
					    		
					    	}, false);
					    
					    </script>
					    
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