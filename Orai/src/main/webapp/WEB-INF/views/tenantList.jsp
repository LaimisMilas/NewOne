<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<jsp:include page="parts/header.jsp"></jsp:include>
<div id="page-wrapper">
	<div class="container-fluid weatherInfo">
		<div class="row">
			<div class="col-lg-12">
				<h2 class="page-header">Tenants List</h2>
			</div>
		</div>
		<!-- Here is your code -->
		<table id="example" class="table table-striped table-bordered" style="width:100%">
		     <thead>
		         <tr>
		         	<th>Id</th>
					<th>Tenant</th>
					<th></th>
					<th></th>
					<th></th>
		         </tr>
		     </thead>
		     <tbody>
		          <c:forEach items="${tenantList }" var="tenantList">
					<tr>
						<td>${tenantList.id }</td>
						<td>${tenantList.tenant }</td>
						<td><a  class="btn btn-primary" href="showMore?tenant=${tenantList.tenant}" >Show More</a></td>
						<td><a  class="btn btn-primary" href="updateTenant?tenant=${tenantList.tenant}" >Update</a></td>
						<td><a  class="btn btn-primary dltBtn" href="dltTenant?dltTenant=${tenantList.tenant }" >Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		     <tfoot>
		         <tr>
		   			<th>Id</th>
					<th>Tenant</th>
		         </tr>
		     </tfoot>
		 </table>
	</div>
</div>

<!-- My Script -->
<script src="${pageContext.request.contextPath}/resources/tableScript.js"></script>
 
<jsp:include page="parts/footer.jsp"></jsp:include>

