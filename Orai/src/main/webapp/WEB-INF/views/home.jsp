<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<jsp:include page="parts/header.jsp"></jsp:include>
<div id="page-wrapper">
  <div class="container-fluid weatherInfo">
      <div class="row">
          <div class="col-lg-12">
              <h2 class="page-header">Welcome Back To Iamus Monitoring System</h2>
          </div>
      </div>
      <!-- Cia atvaizdavimo kodas -->
      <img src="${pageContext.request.contextPath}/resources/img1.jpg">
	</div>
</div>

<jsp:include page="parts/footer.jsp"></jsp:include>

