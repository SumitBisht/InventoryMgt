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
                    <div class="page-title-text"><spring:message code="label.meal.heading" text="Label value is missing !!!"/></div>
                </div>
            </div>	
            <div class="row">
                <div class="col-md-3">
                    <div class="catagory-main-box top-radius">
                        <jsp:include page="cashier_menu.jsp" />
                    </div>
                </div>
                
                <div class="col-md-9">
                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title cat-title-font top-radius">Add invoices for meals</div>
                        
	                <c:if test="${ flash != null}">
	                    <div class="cat-box-title cat-title-font top-radius">${flash}</div>
	                </c:if>
                        <div class="tab-content">
                            <div class="tab-pane active" id="demo">
                            <form:form action="addMealVoucher.html" method="POST" modelAttribute="invoice">
                                <!-- <form:errors path="*" cssClass="errorblock" element="div" /> -->
                                <form:hidden path="id" />
                                <!--div class="col-sm-8 visible-xs"-->
                                
                                    <div class="form-group">
                                        <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm"><spring:message code="label.meal.date" text="Default Text"/></label>
                                        <div class="col-sm-8 col-xs-12">                                            
                                            <form:input type="date" id="mealFormDate" class="form-control" path="date" />
                                        </div>
                                    </div>
	                                <div class="form-group">
	                                    <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm">
	                                      <spring:message code="label.invoice.mode" text="Default Text"/>
	                                    </label>
	                                    <div class="col-sm-8 col-xs-12">
	                                        <form:select class="form-control" path="boxMode">
	                                            <form:option value="true"><spring:message code="label.invoice.boxtype" text="Default Text"/></form:option>
	                                            <form:option value="false"><spring:message code="label.invoice.banktype" text="Default Text"/></form:option>
	                                        </form:select>
	                                        <form:errors path="boxMode" cssClass="error" />
	                                    </div>
	                                </div>
                                    <div class="form-group">
	                                    <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm">
	                                      <spring:message code="label.meal.employeename" text="Default Text"/>
	                                    </label>
                                        <div class="col-sm-8 col-xs-12">
                                            <form:input  type="text" class="form-control" path="buyerName" placeholder="Admin"/>
                                            <form:errors path="buyerName" cssClass="error" />
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
	                                    <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm">
	                                      <spring:message code="label.meal.extra" text="Default Text"/>
	                                    </label>
                                        <div class="col-sm-8 col-xs-12">
                                            <form:input  type="text" class="form-control" path="address" placeholder="Additional information"/>
                                            <form:errors path="address" cssClass="error" />
                                        </div>
                                    </div>
                                    <form:hidden path="item_id" value="0" />
                                    <form:hidden path="quantity" value="1" />
                                    <div class="form-group">
	                                    <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm">
	                                      Meal Type
	                                    </label>
                                        <div class="col-sm-8 col-xs-12">
                                            <form:select class="form-control" path="mealType">
                                                <c:forEach items="${meals}" var="meal">
									                <c:if test="${meal == mealtype}">
                                                        <option value="${meal}" selected="selected"><c:out value="${meal}" /></option>
									                </c:if>
									                <c:if test="${meal != mealtype}">
                                                        <option value="${meal}"><c:out value="${meal}" /></option>
									                </c:if>
                                                </c:forEach>
                                            </form:select>
                                        </div>
                                    </div>
                                    <div class="form-group">
	                                    <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm">
	                                      <spring:message code="label.invoice.discountPercent" text="Default Text"/>
	                                    </label>
                                        <div class="col-sm-8 col-xs-12">
                                            <form:input  type="text" class="form-control" path="discount" placeholder="Discount Percentage"/>
                                            <form:errors path="discount" cssClass="error" />
                                        </div>
                                    </div>
                                    <div class="form-group">
	                                    <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm">
	                                      <spring:message code="label.invoice.taxPercent" text="Default Text"/>
	                                    </label>
                                        <div class="col-sm-8 col-xs-12">
                                            <form:input  type="text" class="form-control" path="tax" placeholder="Tax Percentage"/>
                                            <form:errors path="tax" cssClass="error" />
                                        </div>
                                    </div>
                                    <div class="form-group">
	                                    <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm">
	                                      <spring:message code="label.invoice.grossAmt" text="Default Text"/>
	                                    </label>
                                        <div class="col-sm-8 col-xs-12">
                                            <form:input  type="text" class="form-control" path="grossAmount" placeholder="Gross Amount"/>
                                            <form:errors path="grossAmount" cssClass="error" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                    <div class="">
                                        <div class="div-center-xs">
                                            <input type="submit" class="btn btn-orange"  onclick="return submitDetailsForm();" value="Save" />
                                            <button type="button" class="btn btn-orange" onclick="javascript:history.back();">Cancel</button>
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
                $("#mealFormDate").val(new Date().getFullYear()
                        + "-"
                        + ("0" + (new Date().getMonth() + 1)).slice(-2)
                        + "-"
                        + ("0" + new Date().getDate()).slice(-2));
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
            function submitDetailsForm() {
                return true;
            }
        </script>
    </body>
</html>