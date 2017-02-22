
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container">
<h3>	Books in Library</h3>
<br>
<div class="tabledetails">
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
	</tr>
</c:forEach>
</tbody>
</table>
</div>
<br>
</div>
<!-- /container -->
