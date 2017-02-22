
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>



<div class="container">
<h3>My Books in Library</h3>
<br>
<table style="text-align: center;">
<thead>
<tr>
<th width="150px">Book Author</th><th width="150px">Book Title</th><th width="200px">Book Category</th><th width="100px"></th><th width="100px"></th>
</tr>
</thead>
<tbody>
<c:forEach var="book" items="${mybooks}">
	<tr>
			<td>${book.book_author}</td>
			<td>${book.book_title}</td>
			<td>${book.book_category}</td>
		<td>
			<a href="${pageContext.request.contextPath}/editbook/">Edit</a><br/></td>
		<td>	<a href="${pageContext.request.contextPath}/delete/">Delete</a><br/></td>
		
	</tr>
</c:forEach>
</tbody>
</table>
<br>
</div>
<div align="left"> To display all books  
<a href="${pageContext.request.contextPath}/allbooks/"> Click here</a>
</div>
<!-- /container -->
