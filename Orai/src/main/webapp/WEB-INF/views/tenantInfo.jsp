<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false"%>

<jsp:include page="parts/header.jsp"></jsp:include>
<div id="page-wrapper">
	<div class="container-fluid weatherInfo">
		<div class="row">
			<div class="col-lg-12">
				<h2 class="page-header">Tenant Device Data</h2>
			</div>
		</div>
		<!-- Here is your code -->
		<h3>Tenant ID: ${tenantList.get(0).tenant }</h3>
		<table id="example" class="table table-striped table-bordered" style="width:100%">
		     <thead>
		         <tr>
		            <th>Id</th>
					<th>Tenant</th>
					<th>Device Id</th>
					<th>Device Type</th>
					<th>Value</th>
					<th>Date</th>
		         </tr>
		     </thead>
		     <tbody>
		        <c:forEach items="${tenantList }" var="tenantList">
					<tr>
						<td>${tenantList.id }</td>
						<td>${tenantList.tenant }</td>
						<td>${tenantList.device }</td>
						<td>${tenantList.devicetype }</td>
						<td> <fmt:formatNumber type="number" maxFractionDigits="1" value="${tenantList.dval}"/> </td>
						<td><fmt:formatDate value="${tenantList.tstamp}" pattern="yyyy-MM-dd HH:mm" /></td>
					</tr>
				</c:forEach>
			</tbody>
		     <tfoot>
		         <tr>
		             <th>Id</th>
					<th>Tenant</th>
					<th>Device Id</th>
					<th>Device Type</th>
					<th>Value</th>
					<th>Data</th>
		         </tr>
		     </tfoot>
		 </table>
	</div>
</div>

<!-- My Script -->
<script src="${pageContext.request.contextPath}/resources/tableScript.js"></script>
 
<jsp:include page="parts/footer.jsp"></jsp:include>
