   
    <h2>Find Your Book</h2><br>  
    <form action="doSearch" method="post">
     Search: <input type="text" name="searchText" />
    <br><br>
    <input type="submit"/>
    <input type="hidden"
	name="${_csrf.parameterName}"
	value="${_csrf.token}"/>
   </form>

