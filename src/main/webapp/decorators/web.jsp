<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>		
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang Chủ</title>
    <script src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type='text/javascript' src='<c:url value="/template/admin/js/jquery-2.2.3.min.js" />'></script>
 <script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link href="<c:url value='/template/web/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css">


<link href="<c:url value='/template/web/css/small-business.css'/>" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- Navigation -->
	<%@ include file="/common/web/header.jsp" %>

	<dec:body/>
	
	<!-- Footer -->
	<%@ include file="/common/web/footer.jsp" %>
	

	<!-- Bootstrap core JavaScript -->
	
	
	
	<script src="<c:url value='/template/web/vendor/jquery/jquery.min.js'/>"></script>
	<script src="<c:url value='/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
	<script src="<c:url value='/template/admin/paging/jquery.twbsPagination.js' />"></script>
</body>
</html>