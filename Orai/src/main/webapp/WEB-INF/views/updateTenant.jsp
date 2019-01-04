<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false"%>

<jsp:include page="parts/header.jsp"></jsp:include>
<div id="page-wrapper">
	<div class="container-fluid weatherInfo">
		<div class="row">
			<div class="col-lg-12">
				<h2 class="page-header">Update Tenant</h2>
			</div>
		</div>
		<!-- Here is your code -->
		<div class="addTenantForm">
			<form:form action="updateTenant?oldTenantName=${tenant.tenant }" method="POST" modelAttribute="tenant">
				<h3>Change Tenant Information</h3>
				<div class="row">
					<div class="row"><form:errors path="tenant" class="alert alert-danger error"/></div>
					<p class="formMessage">Tenant Id </p>
					<form:input class="form-control formInput" path="tenant" placeholder="Tenant Unique Name"  />
					
					<div class="row"><form:errors path="source" class="alert alert-danger error"/></div>
					<p class="formMessage">Source</p> 
					<form:input class="form-control formInput" path="source" placeholder="Source Pvz: Local" />
					
					<div class="row"><form:errors path="property" class="alert alert-danger error"/></div> 
					<p class="formMessage">Property</p>
					<form:input class="form-control formInput" path="property" placeholder="Property Pvz: Value" />
				</div>
					<button type="submit" class="btn btn-success btn-md ">Update Tenant</button>
			</form:form>
		</div>


	</div>
</div>

<jsp:include page="parts/footer.jsp"></jsp:include>