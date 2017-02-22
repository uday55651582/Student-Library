
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>



<div class="container">
Add Books to Library
    <form:form action="mybooks" method="post" commandName="book">
            <table >
                <tr>
                    <td>Book Title:</td>
                    <td><form:input path="book_title" /></td>
                </tr>
                 <tr>
                    <td>Book Author:</td>
                    <td><form:input path="book_author" /></td>
                </tr>
                 <tr>
                    <td>Book Category:</td>
                     <td><form:select path="book_category" items="${categoryList}" /></td>
                </tr>
                <tr>
                    <td>Book Owner:</td>
                    <td><form:input path="book_owner" /></td>
                </tr>
               <tr>
                    <td z><input type="submit" value="Add Book" /></td>
                </tr>
            </table>
        </form:form>
</div>
<!-- /container -->
