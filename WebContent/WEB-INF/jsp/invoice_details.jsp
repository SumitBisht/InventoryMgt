<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
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
                    <div class="page-title-text"><spring:message code="label.invoice.heading" text="Label value is missing !!!"/></div>
                </div>
            </div>	
            <div class="row">
                <div class="col-md-3">
                    <div class="catagory-main-box top-radius">
                        <jsp:include page="cashier_menu.jsp" />
                    </div>
                </div>
                <c:if test="${ invoice.id == null}">
                  <c:set var="formAction" value="addInvoice.html" />
                </c:if>
                <c:if test="${ invoice.id != null}">
                  <c:set var="formAction" value="updateInvoice.html" />
                </c:if>
                <div class="col-md-9">
                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title cat-title-font top-radius"><spring:message code="label.invoice.heading" text="Label value is missing !!!"/></div>
                        
	                <c:if test="${ flash != null}">
	                    <div class="cat-box-title cat-title-font top-radius">${flash}</div>
	                </c:if>
                        <div class="tab-content">
                            <div class="tab-pane active" id="demo">
                            <form:form action="${formAction}" method="POST" modelAttribute="invoice">
                                <!--                                <form:errors path="*" cssClass="errorblock" element="div" /> -->
                                <form:hidden path="id" />
                                <!--div class="col-sm-8 visible-xs"-->
                                
                                    <div class="form-group">
                                        <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm"><spring:message code="label.invoice.date" text="Default Text"/></label>
                                        <div class="col-sm-8 col-xs-12">                                            
                                            <form:input type="date" class="form-control" readonly="readonly" path="date" />
                                            <form:errors path="date" cssClass="error" />
                                        </div>
                                    </div>
	                                <div class="form-group">
	                                    <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm">
	                                      <spring:message code="label.invoice.mode" text="Default Text"/>
	                                    </label>
	                                    <div class="col-sm-8 col-xs-12">
	                                        <form:select class="form-control" readonly="readonly" path="boxMode">
	                                            <form:option value="true"><spring:message code="label.invoice.boxtype" text="Default Text"/></form:option>
	                                            <form:option value="false"><spring:message code="label.invoice.banktype" text="Default Text"/></form:option>
	                                        </form:select>
	                                        <form:errors path="boxMode" cssClass="error" />
	                                    </div>
	                                </div>
                                    <div class="form-group">
	                                    <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm">
	                                      <spring:message code="label.invoice.buyername" text="Default Text"/>
	                                    </label>
                                        <div class="col-sm-8 col-xs-12">
                                            <form:input  type="text" class="form-control" readonly="readonly" path="buyerName" placeholder="Name"/>
                                            <form:errors path="buyerName" cssClass="error" />
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
	                                    <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm">
	                                      <spring:message code="label.invoice.buyeraddress" text="Default Text"/>
	                                    </label>
                                        <div class="col-sm-8 col-xs-12">
                                            <form:input  type="text" class="form-control" readonly="readonly" path="address" placeholder="Address"/>
                                            <form:errors path="address" cssClass="error" />
                                        </div>
                                    </div>
                                    <div class="form-group">
	                                    <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm">
	                                      <spring:message code="label.invoice.orderItems" text="Default Text"/>
	                                    </label>
                                        <div class="col-sm-8 col-xs-12">
                                            <form:select class="form-control" path="item_id" readonly="readonly">
                                                <c:forEach items="${items}" var="item">
                                                    <option value="${item.id}"><c:out value="${item.name}" /></option>
                                                </c:forEach>
                                            </form:select>
                                            <form:input  type="text" class="form-control" path="quantity" placeholder="Quantity"/>
                                            <form:errors path="quantity" cssClass="error" />
                                        </div>
                                    </div>
                                    <div class="form-group">
	                                    <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm">
	                                      <spring:message code="label.invoice.discountPercent" text="Default Text"/>
	                                    </label>
                                        <div class="col-sm-8 col-xs-12">
                                            <form:input  type="text" class="form-control" readonly="readonly" path="discount" placeholder="Discount Percentage"/>
                                            <form:errors path="discount" cssClass="error" />
                                        </div>
                                    </div>
                                    <div class="form-group">
	                                    <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm">
	                                      <spring:message code="label.invoice.taxPercent" text="Default Text"/>
	                                    </label>
                                        <div class="col-sm-8 col-xs-12">
                                            <form:input  type="text" class="form-control" readonly="readonly" path="tax" placeholder="Tax Percentage"/>
                                            <form:errors path="tax" cssClass="error" />
                                        </div>
                                    </div>
                                    <div class="form-group">
	                                    <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm">
	                                      <spring:message code="label.invoice.grossAmt" text="Default Text"/>
	                                    </label>
                                        <div class="col-sm-8 col-xs-12">
                                            <form:input  type="text" class="form-control" readonly="readonly" path="grossAmount" placeholder="Gross Amount"/>
                                            <form:errors path="grossAmount" cssClass="error" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                    <div class="">
                                        <div class="div-center-xs">
                                            <button type="button" class="btn btn-orange" onclick="printVoucherDetails();">Print</button>
                                            <button type="button" class="btn btn-orange" onclick="javascript:history.back();">Back</button>
                                        </div>
                                    </div>
                                    </div>
                                <!-- /div -->                                        
                               
                            </form:form>
                                
                            </div>                            
                        </div>
                    </div>
                </div>
            </div>
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
        <script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $("#fromDate").datepicker({
                    dateFormat: 'yy/mm/dd'
                });
                $("#toDate").datepicker(
                        {dateFormat: 'yy/mm/dd'});
                var table = $('#dttable').DataTable();
                $('.row-delete').click(function(eve) {
                    var row = this;
                    eve.preventDefault();
                    $.ajax({
                        url: $(row).attr('href')
                        , success: function(response) {
                            if (response === true) {
                                table.row($(row).closest('tr')).remove().draw(false);
                            }
                        }
                    });
                    return false;
                });
            });
            function printVoucherDetails() {
            	var originalPage = document.body.innerHTML;
            	var voucherDetail = document.getElementsByClassName("col-md-9")[0];
            	document.body.innerHTML = voucherDetail.innerHTML;
            	window.print();
            	document.body.innerHTML = originalPage;
            }
        </script>
    </body>
</html>