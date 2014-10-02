<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%--<%@include file="header.jsp" %>--%>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript">
                function submitDetailsForm() {
                    $("#approverForm").submit();
                }
            </script>

<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/ui.multiselect.css">
<link rel="stylesheet" href="css/ui.common.css">

</head>

<body role="document">

	<jsp:include page="headermenu.jsp"></jsp:include>

	<div class="container">
		<div class="row container">
			<div class="dashboard_main">
				<div class="desh-icon-bg">
					<img src="img/i-mgmt.png">
				</div>
				<div class="page-title-text">Add Item Category</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="catagory-main-box top-radius">

					<!--<div class="cat-table-title"></div>-->
					<!-- MUNU -->
					<div id='cssmenu'>
						<ul>

							<li class='has-sub active'><a href='#'><span>ITEMS</span></a>
								<ul style='display: block;'>
									<li><a href='item.html'><span>Items</span></a></li>
									<li><a href='item_category.html'><span>Item
												Category</span></a></li>
									<li class='last'><a href='item_unit.html'><span>Item
												Units</span></a></li>
								</ul></li>
							<li class=''><a href='purchase_order.html'><span>Purchase
										Order</span></a></li>
							<li class=''><a href='purchase_requisition.html'><span>Purchase
										Requisition</span></a></li>
							<li class='last'><a href='account.html'><span><spring:message
											code="menu.account" text="Label value is missing !!!" /></span></a></li>
						</ul>
					</div>
					<!-- END MUNU -->

				</div>
			</div>
			<div class="col-md-9">
				<div class="catagory-main-box top-radius">
					<div class="cat-box-title cat-title-font top-radius">Item
						Category</div>

					<div class="row tb-margin">
						<div class="col-sm-2"></div>

						<form:form action="AddApprover.html" method="POST"
							commandName="approverForm">
							<!-- <form:errors path="*" cssClass="errorblock" element="div" /> -->

							<div class="col-sm-8 visible-xs">

								<div class="form-group">
									<div class="col-sm-8 col-xs-12">
										<select id="users" class="multiselect" name="users[]"
											multiple="multiple">
											<c:forEach var="listVar" items="${emplist}">
												<option selected="" value="<c:out value="${listVar.id}"/>"><c:out
														value="${listVar.firstName}" /></option>
											</c:forEach>
											<c:forEach var="listVar" items="${empselected}">
												<option value="<c:out value="${listVar.id}"/>"><c:out
														value="${listVar.firstName}" /></option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
						</form:form>

						<div class="col-sm-2"></div>
					</div>
					<div class="row text-pad-top visible-lg visible-md visible-sm">
						<div class="div-center">
							<button type="button" class="btn btn-orange"
								onclick="submitDetailsForm();">Save</button>
							<button type="button" class="btn btn-orange"
								onclick="javascript:history.back();">Cancel</button>
						</div>
					</div>
					<div class="row text-pad-top visible-xs ">
						<div class="div-center-xs">
							<button type="button" class="btn btn-orange"
								onclick="submitDetailsForm();">Save</button>
							<button type="button" class="btn btn-orange"
								onclick="javascript:history.back();">Cancel</button>
						</div>
					</div>


				</div>
			</div>

		</div>

		<div class=""></div>
		<div class=""></div>


	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
        ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!--<script src="js/jquery-1.9.1.min.js"></script>-->
	<script src="js/jquery-ui.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/ui.multiselect.js"></script>
	<script type="text/javascript">
            $(function(){
            // choose either the full version
//            $(".multiselect").multiselect();
            // or disable some features
            $(".multiselect").multiselect({sortable: false, searchable: false});
            });
        </script>
</body>
</html>
