
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="container">

    You are Logged In !!!!!

</div>
<h3>Recently added books by me</h3>

<table style="text-align: center;">
<thead>
<tr>
<th width="75px">Id</th><th width="150px">Book Author</th><th width="150px">Book Title</th><th width="200px">Book Category</th><th width="100px"></th><th width="100px"></th>
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

<h3>Recently added books in Library</h3>

<table style="text-align: center;">
<thead>
<tr>
<th width="75px">Id</th><th width="150px">Book Author</th><th width="150px">Book Title</th><th width="200px">Book Category</th><th width="100px"></th><th width="100px"></th>
</tr>
</thead>
<tbody>
<c:forEach var="book" items="${allbooks}">
	<tr>
			<td>${book.book_author}</td>
			<td>${book.book_title}</td>
			<td>${book.book_category}</td>
		
	</tr>
</c:forEach>
</tbody>
</table>