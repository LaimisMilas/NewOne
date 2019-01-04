<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false"%>

<jsp:include page="parts/header.jsp"></jsp:include>
<div id="page-wrapper">
	<div class="container-fluid weatherInfo">
		<div class="row">
			<div class="col-lg-12">
				<h2 class="page-header">Add New Tenant</h2>
			</div>
		</div>
		<!-- Here is your code -->
		<div class="addTenantForm">
			<form:form action="addTenant" method="POST">
				<h3>Enter Tenant Information</h3>
				<div class="row">
					<p class="error">${tenantError } </p>
					<input class="form-control formInput" name="tenantName" placeholder="Tenant Unique Name" /> 
					<p class="error">${sourceError } </p>
					<input class="form-control formInput" name="source" placeholder="Source Pvz: Local" />
					<p class="error">${deviceError } </p>
					<select class="form-control" name="device">
					  <option selected>Choose Device</option>
					  <option value="1644302641">1644302641 (Pressure)</option>
					  <option value="1644302641_1">1644302641_1 (Temperature)</option>
					  <option value="1644302641_2">1644302641_2 (Humidity)</option>
					</select><br>
					<p class="error">${propertyError } </p>
					<input class="form-control formInput" name="property" placeholder="Property Pvz: Value" />
					<h3>Enter Building Information</h3>
					<p class ="error">${buildingEmpty }</p>
					<input class="form-control formInput" name="energetinisKof" placeholder="Energy Coefficient" />
					<input class="form-control formInput" name="aukstis" placeholder="Biulding high" />
					<input class="form-control formInput" name="plotas" placeholder="Building Width (m2)" />
				</div>
					<button type="submit" class="btn btn-success btn-md ">Add Tenant</button>
			</form:form>
		</div>


	</div>
</div>

<jsp:include page="parts/footer.jsp"></jsp:include>