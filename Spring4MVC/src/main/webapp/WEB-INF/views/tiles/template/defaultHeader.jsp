<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize var="loggedIn" access="isAuthenticated()" />
<c:choose>
    <c:when test="${loggedIn}">
    
       <nav class="navbar navbar-inverse" style="background-color:black; font-weight: bold;">
  <div class="container-fluid">
    <div class="navbar-header">
    <img src="resources/images/p2.png" style="float:left;width:62px;height:52px;" >
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#" style="font-family:Times New Roman; font-style:italic;font-color:white;">
       <marquee direction="right" width="200">Student Library </marquee></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar" style="background-color:black; font-weight: bold;">
      <ul class="nav navbar-nav navbar-right">     
      <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
      <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
      <li> <h3 style="font-family:Times New Roman; font-style:italic;font-color:white;"> ${pageContext.request.userPrincipal.name} </h3> </li>
              <li><a href="${pageContext.request.contextPath}/welcome"><span class="glyphicon"></span> My Profile</a></li>
              <li><a href="${pageContext.request.contextPath}/addbooks"><span class="glyphicon"></span> Add Books</a></li>
              <li><a href="${pageContext.request.contextPath}/mybooks"><span class="glyphicon"></span> My Books</a></li>  
              <li><a href="${pageContext.request.contextPath}/allbooks"><span class="glyphicon"></span>Library Books</a></li>  
      <li class="active">   <a onclick="document.forms['logoutForm'].submit()">Logout</a></li>

    </c:if> 
       
      </ul>   
    </div>
  </div>
</nav>
    </c:when>
    <c:otherwise>
       <nav class="navbar navbar-inverse" style="background-color:black; font-weight: bold;">
  <div class="container-fluid">
    <div class="navbar-header">
    <img src="resources/images/p2.png" style="float:left;width:62px;height:52px;" >
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#" style="font-family:Times New Roman; font-style:italic;font-color:white;">
       <marquee direction="right" width="200">Student Library </marquee></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar" style="background-color:black; font-weight: bold;">
      <ul class="nav navbar-nav navbar-right">
        <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                      <li><a href="${pageContext.request.contextPath}/allbooks"><span class="glyphicon"></span> Library Books</a></li>  
        <li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        <li><a href="${pageContext.request.contextPath}/registration"><span class="glyphicon glyphicon-user"></span> Sign UP</a></li>
      </ul>   
    </div>
  </div>
</nav>
    </c:otherwise>
</c:choose>