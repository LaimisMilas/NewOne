<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false"%>

<jsp:include page="parts/header.jsp"></jsp:include>
<div id="page-wrapper">
	<div class="container-fluid weatherInfo">
		<div class="row">
			<div class="col-lg-12">
				<h2 class="page-header">Update Record</h2>
			</div>
		</div>
		<!-- Here is your code -->
		<div class="addTenantForm">
			<form:form action="updateRecord" method="POST" modelAttribute="deviceRecord">
				<h3>Change Record Information</h3>
				<div class="row">
					<form:input class="hidden" path="id" />
					<form:input class="hidden" path="tenant" />				
					<div class="row"><form:errors path="source" class="alert alert-danger error"/></div>
					<p class="formMessage">Source</p> 
					<form:input class="form-control formInput" path="source" placeholder="Source Pvz: Local" />
					
					<div class="row"><form:errors path="property" class="alert alert-danger error"/></div> 
					<p class="formMessage">Property</p>
					<form:input class="form-control formInput" path="property" placeholder="Property Pvz: Value" />
					
					<div class="row"><form:errors path="device" class="alert alert-danger error"/></div> 
					<p class="formMessage">Device Id</p>
					<form:input class="form-control formInput" path="device" placeholder="Insert Device Id" />
					
					<div class="row"><form:errors path="devicetype" class="alert alert-danger error"/></div> 
					<p class="formMessage">Device Type</p>
					<form:input class="form-control formInput" path="devicetype" placeholder="Pvz: Temperature" />
					
					<p class="formMessage">Device Value</p>
					<form:input class="form-control formInput" path="dval" placeholder="Pvz: 20.5" />
					
				</div>
					<button type="submit" class="btn btn-success btn-md ">Update Record</button>
			</form:form>
		</div>


	</div>
</div>

<jsp:include page="parts/footer.jsp"></jsp:include>