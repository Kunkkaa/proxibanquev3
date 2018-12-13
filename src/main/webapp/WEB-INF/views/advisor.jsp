<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style type="text/css">
div.advisor {
	position: fixed;
	top: 0;
	right: 0;
}

div.advisor>a {
	color: darkblue;
}
</style>

<div class="advisor">
	<!-- Utilisation de HttpSession ou l'attribut "advisor"
		a été rempli depuis IndexServlet -->
	<h4>Bonjour, ${sessionScope.advisor}</h4>
	<c:url var="logoutUrl" value="/logout" />
	<a href="${logoutUrl}">Se déconnecter</a>
</div>