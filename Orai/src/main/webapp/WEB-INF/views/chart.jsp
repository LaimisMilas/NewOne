<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<jsp:include page="parts/header.jsp"></jsp:include>

<div id="page-wrapper">
	<div class="container-fluid weatherInfo">
		<div class="row">
			<div class="col-lg-12">
				<h2 class="page-header">Energy Consumption Chart</h2>
			</div>
		</div>
		<h4>Tenant Id: ${tenantName}</h4>

		<canvas id="myChart" width="400" height="400"></canvas>

	</div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/chartJavaScript.js"></script>

<jsp:include page="parts/footer.jsp"></jsp:include>