<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<jsp:include page="parts/header.jsp"></jsp:include>
<div id="page-wrapper">
	<div class="container-fluid weatherInfo">
		<div class="row">
			<div class="col-lg-12">
				<h2 class="page-header">Energy Consumption</h2>
			</div>
		</div>
		<!-- Here is your code -->
		<table class="table">
			<thead>
				<tr>
					<th>id</th>
					<th>Tenant</th>
				</tr>
			</thead>
			<c:forEach items="${tenantList }" var="tenantList">
				<tr>
					<td>${tenantList.id }</td>
					<td>${tenantList.tenant }</td>				
					<td><a  class="btn btn-primary" href="showChart?tenant=${tenantList.tenant}" >Show Energy Chart</a></td>
				</tr>
			</c:forEach>
		</table>


	</div>
</div>

<jsp:include page="parts/footer.jsp"></jsp:include>