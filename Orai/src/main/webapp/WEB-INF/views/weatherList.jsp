<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false"%>

<jsp:include page="parts/header.jsp"></jsp:include>
<div id="page-wrapper">
	<div class="container-fluid weatherInfo">
		<div class="row">
			<div class="col-lg-12">
				<h2 class="page-header">Weather History</h2>
			</div>
		</div>
		<!-- Here is your code -->
			<table id="example" class="table table-striped table-bordered" style="width:100%">
		     <thead>
		         <tr>
		            <th>Temp</th>
					<th>Pressure</th>
					<th>Himidity</th>
					<th>City</th>
					<th>Data</th>
		         </tr>
		     </thead>
		     <tbody>
		       <c:forEach items="${weatherList }" var="weatherList">
				<tr>
					<td>${weatherList.temp }</td>
					<td>${weatherList.pressure }</td>
					<td>${weatherList.humidity }</td>
					<td>${weatherList.city }</td>
					<fmt:parseDate value="${weatherList.tstamp}" type="date" pattern="yyyy-MM-dd HH:mm:ss" var="formatedDate"/>
					<td><fmt:formatDate value="${formatedDate}"  type="date" pattern="yyyy-MM-dd HH:mm"/></td>			
				</tr>
				</c:forEach>
			</tbody>
		     <tfoot>
		         <tr>
		            <th>Temp</th>
					<th>Pressure</th>
					<th>Himidity</th>
					<th>City</th>
					<th>Data</th>
		         </tr>
		     </tfoot>
		 </table>
	</div>
</div>

<!-- My Script -->
<script src="${pageContext.request.contextPath}/resources/tableScript.js"></script>
 
<jsp:include page="parts/footer.jsp"></jsp:include>
