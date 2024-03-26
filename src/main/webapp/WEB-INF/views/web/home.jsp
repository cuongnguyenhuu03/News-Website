<%@include file="/common/taglib.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Trang Chủ</title>

</head>

<body>

	<div class="container">

		<!-- Heading Row -->
		<div class="row align-items-center my-5">
			<div class="col-lg-7">
				<img class="img-fluid rounded mb-4 mb-lg-0"
					src="http://placehold.it/900x400" alt="">
			</div>
			<!-- /.col-lg-8 -->
			<div class="col-lg-5">
				<h1 class="font-weight-light">Business Name or Tagline</h1>
				<p>This is a template that is great for small businesses. It
					doesn't have too much fancy flare to it, but it makes a great use
					of the standard Bootstrap core components. Feel free to use this
					template for any project you want!</p>
				<a class="btn btn-primary" href="#">Call to Action!</a>
			</div>
			<!-- /.col-md-4 -->
		</div>
		<!-- /.row -->

		<!-- Call to Action Well -->
		<div class="card text-white bg-secondary my-5 py-4 text-center">
			<div class="card-body">
				<p class="text-white m-0">This call to action card is a great
					place to showcase some important information or display a clever
					tagline!</p>
			</div>
		</div>

		<!-- Content Row -->
		
		<form action="<c:url value='/trang-chu'/>" id="formSubmit" method="get">
			<div class="row">
				<c:forEach var="item" items="${model.listResult}">
					<div class="col-md-4 mb-5">
						<div class="card h-100">
							<div class="card-body">
								<h5 class="card-title">${item.title}</h2>
								<p class="card-text">${item.shortDescription}</p>
							</div>
							<div class="card-footer">
								<a href="#" class="btn btn-primary btn-sm">More Info</a>
							</div>
						</div>
					</div>
				</c:forEach>
					
			</div>
			<ul class="pagination" id="pagination"></ul>						
			<input type="hidden" value="" id="page" name="page"/>
			<input type="hidden" value="" id="limit" name="limit"/>	
		</form>

	</div>
	
	<script>
		
	var totalPage = ${model.totalPage}
	var currentPage  = ${model.page};
	
	$(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPage,
            visiblePages: 10,
            startPage: currentPage,
            onPageClick: function (event, page) {
            	if (currentPage != page) {
            		$('#limit').val(6);
					$('#page').val(page);
					$('#formSubmit').submit();
				}
            }
        });
    });
	</script>

</body>


</html>