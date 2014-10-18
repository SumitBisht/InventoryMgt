<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<jsp:include page="header.jsp" />
</head>
<body role="document">
	<jsp:include page="headermenu.jsp" />
	<div class="container">
		<div class="row container">
			<div class="dashboard_main">
				<div class="desh-icon-bg">
					<img src="img/i-mgmt.png">
				</div>
				<div class="page-title-text">
					<spring:message code="label.invoice.heading"
						text="Label value is missing !!!" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="catagory-main-box top-radius">
					<div id='cssmenu'>
						<c:if test="${ useFinanceMenus == null}">
							<ul>
								<li class='has-sub active'><a href='invoice_entry.html'><span><spring:message
												code="label.invoice.operations"
												text="Label value is missing !!!" /></span></a>
								<li class=''><a href='#'><span><spring:message
												code="label.invoice.entry" text="Label value is missing !!!" /></span></a>
									<ul style='display: block;'>
										<li><a href='invoice_entry.html'><span><spring:message
														code="label.invoice.heading"
														text="Label value is missing !!!" /></span></a></li>
										<li class="active"><a href='cash_collections.html'><span><spring:message
														code="label.invoice.box" text="Label value is missing !!!" /></span></a></li>
										<li class='last'><a href='bank_collections.html'><span><spring:message
														code="label.invoice.bank"
														text="Label value is missing !!!" /></span></a></li>
									</ul></li>

							</ul>
						</c:if>
						<c:if test="${ useFinanceMenus != null}">
							<jsp:include page="finance_mgt_menu.jsp" />
						</c:if>
					</div>
					<!-- END MUNU -->
				</div>
			</div>
			<div class="col-md-3">
				<div class="catagory-main-box top-radius">
					<div class="cat-box-title cat-title-font top-radius">
						Credit</div>
					<div class="tab-content">
						<div class="tab-pane active" id="demo">

							<table id="dttable" class="table table-bordered table-striped"
								data-filter="#filter" data-page-size="5">
								<thead class="orange-bg border-t">
									<tr>
										<th data-toggle="true"><spring:message
												code="label.invoice.list.bill_date"
												text="Label value is missing !!!" /></th>
										<th data-hide="phone"><spring:message
												code="label.invoice.list.buyername"
												text="Label value is missing !!!" /></th>

										<th data-hide="phone"><spring:message
												code="label.invoice.list.amount"
												text="Label value is missing !!!" /></th>

									</tr>
								</thead>
								<tbody>
									<c:forEach var="invoice" items="${invoices}">
										<tr>
											<td>${invoice.date}</td>
											<td>${invoice.buyerName}</td>

											<td>${invoice.grossAmount}</td>


										</tr>
									</c:forEach>
									<tr>

										<td colspan="">Total</td>
										<td colspan=""></td>
										<td>${totali}</td>


									</tr>

								</tbody>



								<!--<tfoot class="hide-if-no-paging">
                                        <tr>
                                            <td colspan="8">
                                                <div class="pagination pagination-centered"></div>
                                            </td>
                                        </tr>
                                    </tfoot>-->
							</table>
						</div>
					</div>
				</div>
			</div>









			<div class="col-md-3">
				<div class="catagory-main-box top-radius">
					<div class="cat-box-title cat-title-font top-radius">Debit</div>
					<spring:message text="Default Text"
						code="purrequisition.search.placeholder" var="search" />
					<div class="tab-content">
						<div class="tab-pane active" id="demo">
							<div class="row tb-margin">

								<div class="col-sm-4"></div>
								<div class="col-sm-8">
									<!--<div class="form-group visible-sm visible-md visible-lg">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="purrequisition.search" text="Label value is missing !!!"/></label>
                                            <div class="col-sm-8 col-xs-12">
                                                <input id="filter" class="form-control" type="text"/>
                                            </div>                                            
                                        </div>
                                        <div class="form-group visible-xs">
                                            <div class="col-xs-12">
                                                <input id="filter" placeholder="${search}" class="form-control" type="text"/>
                                            </div>
                                        </div>-->
								</div>
							</div>
							<table id="dttable" class="table table-bordered table-striped"
								data-page-size="5">
								<thead class="orange-bg border-t">
									<tr>

										<th data-hide="phone"><spring:message
												code="label.purrequisition.supplier"
												text="Label value is missing !!!" /></th>

										<th data-hide="phone"><spring:message
												code="label.purrequisition.createdat"
												text="Label value is missing !!!" /></th>
										<th data-hide="phone"><spring:message
												code="label.purrequisition.price"
												text="Label value is missing !!!" /></th>


									</tr>
								</thead>
								<tbody>
									<c:forEach var="purrequisition" items="${purrequisitionList}">
										<tr>
											<td>${accountMap[purrequisition.suplierid]}</td>
											<td>${purrequisition.createdat}</td>
											<td>${purrequisition.price}</td>


										</tr>
									</c:forEach>

									<tr>
										<td colspan="">Total</td>
										<td colspan=""></td>


										<td>${totalo}</td>


									</tr>

								</tbody>
								<!--<tfoot class="hide-if-no-paging">
                                        <tr>
                                            <td colspan="8">
                                                <div class="pagination pagination-centered"></div>
                                            </td>
                                        </tr>
                                    </tfoot>-->
							</table>
						</div>
					</div>
				</div>
			</div>

















			






















		</div>
		<div class=""></div>
		<div class=""></div>
	</div>
	<!-- /container -->
	<!--Responsive Table-->
	<!-- Bootstrap core JavaScript
        ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.dataTables.min.js"></script>
	<script src="js/dataTables.responsive.min.js"></script>
	<script src="js/ajax-bootstrap3.js"></script>
	<script type="text/javascript">
		$(document).ready(
				function() {
					var table = $('#dttable').DataTable();
					$('.row-delete').click(
							function(eve) {
								var row = this;
								eve.preventDefault();
								$.ajax({
									url : $(row).attr('href'),
									success : function(response) {
										if (response === true) {
											table.row($(row).closest('tr'))
													.remove().draw(false);
										}
									}
								});
								return false;
							});
				});
	</script>
</body>
</html>