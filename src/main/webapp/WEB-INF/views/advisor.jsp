<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style type="text/css">
	div.advisor {
		position: fixed;
		top: 0;
		right: 0;
	}
	
	div.advisor > a {
		color: darkblue;
	}
</style>

<div class="advisor">
	<h4>Bonjour, <%= request.getUserPrincipal().getName() %></h4>
	<c:url var="logoutUrl" value="/logout" />
	<a href="${logoutUrl}">Se déconnecter</a>
</div>