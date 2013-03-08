<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<table id="formTable">
		<tr>
			<td>Login</td>
	    	<td><input type="text" name="usuario.login" value="${usuario.login}"/></td>
	    </tr>
	    <tr>
	    	<td>E-Mail</td>
	    	<td><input type="text" name="usuario.email" value="${usuario.email}"/></td>
	    </tr>
	    <tr>
	    	<td>Nome</td>
	    	<td><input type="text" name="usuario.nome" value="${usuario.nome}"/></td>
	    </tr>
	    <tr>
	    	<td>Roles</td>
	    	<td>
	    		<div id="fullList">
		    		<select name="roles" multiple="multiple" size="8">
		    			<c:forEach items="${roles}" var="role">
		    				<option value="${role.id}">${role.name}</option>
		    			</c:forEach>
		    		</select>
	    		</div>
	    		<div id="buttons">
		    		<input type="button" value="&lt;&lt;" id="removeAll">
		    		<input type="button" value="&lt;" id="remove"/>
		    		<input type="button" value="&gt;" id="add"/>
		    		<input type="button" value="&gt;&gt;" id="addAll"/>
	    		</div>
	    		<div id="addedList">
		    		<select name="usuario.roles" multiple="multiple" size="8">
		    			<c:forEach items="${usuario.roles}" var="role">
		    				<option value="${role.id}">${role.name}</option>
		    			</c:forEach>
		    		</select>
	    		</div>
	    	</td>
	    </tr>
</table>
<input type="submit" value="Salvar"/>