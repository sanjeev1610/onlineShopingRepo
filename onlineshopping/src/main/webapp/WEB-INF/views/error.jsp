<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="img" value="/resources/img" />


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>OnlineShop-${title}</title>

<script type="text/javascript">
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>


<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap4.min.css" rel="stylesheet">

<!-- Bootstrap spaceLab theme CSS -->
<link href="${css}/bootstrap-spacelab.min.css" rel="stylesheet">


<!-- Bootstrap datatable CSS -->
<link href="${css}/dataTables.bootstrap4.min.css" rel="stylesheet">

<!-- Font awsome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">

<!-- Custom styles for this template -->
<link href="${css}/shop-homepage.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">
		<!-- Navigation -->

		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="${contextRoot}/home">Home</a>

			</div>
		</div>
		<div class="content">
			<!-- Page Content -->
			<div class="container">

				<div class="row">


					<div class="col-xl-12">


						<div class="jumbotron">

							<h1 class="display-4"> ${errorTitle}</h1>
							<hr class="my-4">
							<blockquote>${errorDescription}</blockquote>


						</div>

					</div>

				</div>


			</div>


		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.min.js"></script>
		<script src="${js}/bootstrap4.bundle.min.js"></script>
		<!-- Datatable jquery -->
		<script src="${js}/jquery.dataTables.js"></script>
		<!-- Datatable bootstrap -->
		<script src="${js}/dataTables.bootstrap4.min.js"></script>

		<script src="${js}/myapp.js"></script>

	</div>
</body>

</html>
