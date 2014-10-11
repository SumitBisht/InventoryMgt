<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <%--<%@include file="header.jsp" %>--%>
        <jsp:include page="header.jsp" />
        <script type="text/javascript">
            function submitDetailsForm() {
                return true;
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
    </head>
    <body role="document">
        <c:if test="${purrequisition.id == null}">
            <c:set var="formaction" value="add-purchase_requisition.html" />
            <spring:message code="label.purrequisition" text="Default Text" var="pagetitletext" />
            <spring:message code="label.add.purchaserequisition" text="Default Text" var="catboxtitle" />
            <spring:message code="label.purrequisition.save" text="Default Text" var="savebutton" />
        </c:if>
        <c:if test="${purrequisition.id != null}">
            <c:set var="formaction" value="edit-purchase_requisition.html?id=${purrequisition.id}" />
            <spring:message code="label.account" text="Default Text" var="pagetitletext" />
            <spring:message code="label.updatepurrequisition" text="Default Text" var="catboxtitle" />
            <spring:message code="label.purrequisition.update" text="Default Text" var="savebutton" />
        </c:if>
        <jsp:include page="headermenu.jsp" />
        <div class="container">
            <div class="row container">
                <div class="dashboard_main">
                    <div class="desh-icon-bg">
                        <img src="img/i-mgmt.png">
                    </div>
                    <div class="page-title-text">${pagetitletext}</div>
                </div>
            </div>	
            <div class="row">
                <div class="col-md-3">
                    <div class="catagory-main-box top-radius">

                        <!--<div class="cat-table-title"></div>-->
                        <!-- MUNU -->    
                        <div id='cssmenu'>
                            <ul>

                                <li class='has-sub active'><a href='#'><span><spring:message code="menu.ITEMS" text="Label value is missing !!!"/></span></a>
                                    <ul style='display: block;'>
                                        <li><a href='item.html'><span><spring:message code="menu.Items" text="Label value is missing !!!"/></span></a></li>
                                        <li class="active"><a href='item_category.html'><span><spring:message code="menu.ItemCategory" text="Label value is missing !!!"/></span></a></li>
                                        <li class='last'><a href='item_unit.html'><span><spring:message code="menu.ItemUnits" text="Label value is missing !!!"/></span></a></li>
                                    </ul>
                                </li>
                                <li class=''><a href='purchase_order.html'><span><spring:message code="menu.PurchaseOrder" text="Label value is missing !!!"/></span></a></li>
                                <li class=''><a href='purchase_requisition.html'><span><spring:message code="menu.PurchaseRequisition" text="Label value is missing !!!"/></span></a></li>
                                <li class='last'><a href='account.html'><span><spring:message code="menu.account" text="Label value is missing !!!"/></span></a></li>
                            </ul>
                        </div>
                        <!-- END MUNU -->    

                    </div>
                </div>
                <spring:message code="label.purrequisition.prno.placeholder" var="prnoplaceholder" text="Default Text" />
                <spring:message code="label.purrequisition.price.placeholder" var="priceplaceholder" text="Default Text" />
                <spring:message code="label.purrequisition.createdat.placeholder" var="createdatplaceholder" text="Default Text" />                

                <div class="col-md-9">
                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title cat-title-font top-radius">${catboxtitle}</div>
                        <form:form action="${formaction}" method="post" modelAttribute="purrequisition">
                            <form:hidden path="id" />
                            <div class="row tb-margin">
                                <div class="col-sm-2"></div>
                                <div class="col-sm-8">
                                        <c:if test="${not empty error}">  
                                            <div class="row text-pad-top"><div class="errorblock">${error}</div></div>
                                        </c:if>
                                        <c:if test="${not empty success}">  
                                            <div class="row text-pad-top"><div class="successblock">${success}</div></div>
                                        </c:if>
                                    <!--<div class="form-group">
                                        <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm"><spring:message code="label.purrequisition.prno" text="Default Text"/></label>
                                        <div class="col-sm-8 col-xs-12">                                            
                                            <form:input type="text" class="form-control" path="prno" placeholder="${prnoplaceholder}" />
                                            <form:errors path="prno" cssClass="error" />
                                        </div>
                                    </div>-->
                                            <form:hidden path="prno" />
                                    <div class="form-group">
                                        <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm"><spring:message code="label.purrequisition.supplier" text="Default Text"/></label>
                                        <div class="col-sm-8 col-xs-12">
                                            <form:select class="form-control" path="suplierid">
                                                <form:option value=""><spring:message code="label.purrequisition.supplier.placeholder" text="Default Text"/></form:option>
                                                <form:options items="${supplierList}" itemLabel="name" itemValue="id" />
                                            </form:select>
                                            <form:errors path="suplierid" cssClass="error" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm"><spring:message code="label.purrequisition.status" text="Default Text"/></label>
                                        <div class="col-sm-8 col-xs-12">
                                            <form:select class="form-control" path="status">
                                                <form:option value=""><spring:message code="label.purrequisition.status.placeholder" text="Default Text"/></form:option>
                                                <form:options items="${statusList}" />
                                            </form:select>
                                            <form:errors path="status" cssClass="error" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.purrequisition.isbilled" text="Default Text"/></label>
                                        <div class="col-sm-8 col-xs-12">
                                            <div class="form-control">
                                                <form:radiobutton path="isbilled" value="true" /><spring:message code="label.purrequisition.status.yes" text="Default Text"/>
                                                <form:radiobutton path="isbilled" value="false" /><spring:message code="label.purrequisition.status.no" text="Default Text"/>
                                            </div>
                                            <form:errors path="isbilled" cssClass="error" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm"><spring:message code="label.purrequisition.price" text="Default Text"/></label>
                                        <div class="col-sm-8 col-xs-12">                                            
                                            <form:input type="text" class="form-control" path="price" placeholder="${priceplaceholder}" />
                                            <form:errors path="price" cssClass="error" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm"><spring:message code="label.purrequisition.createdat" text="Default Text"/></label>
                                        <div class="col-sm-8 col-xs-12">                                            
                                            <form:input type="date" class="form-control" path="createdat" placeholder="${createdatplaceholder}" />
                                            <form:errors path="createdat" cssClass="error" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm"><spring:message code="label.purrequisition.item" text="Default Text"/></label>
                                        <div class="col-sm-8 col-xs-12">                                            
                                            <form:select class="form-control" path="items" multiple="true" items="${itemList}" itemLabel="name" itemValue="id" />
                                            <form:errors path="items" cssClass="error" />
                                        </div>
                                    </div>
                                    <div class="col-sm-2"></div>
                                </div>
                                <div class="div-center">
                                    <button type="submit" class="btn btn-orange" onclick="return submitDetailsForm();"><spring:message code="label.purrequisition.save" text="Default Text"/></button>
                                    <button type="button" class="btn btn-orange" onclick="javascript:history.back();"><spring:message code="label.purrequisition.cancel" text="Default Text"/></button>
                                </div>
                            </form:form>
                        </div>                        
                    </div>
                </div>
                <div class=""></div>
                <div class=""></div>
            </div>
        </div>
        <!-- /container -->
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/bootstrap.min.js"></script>
        <!-- Jquery UI Javascript -->
        <script src="js/jquery-ui.js"></script>
        <script type="text/javascript">
           // $('input[type=date]').datepicker({dateFormat: 'dd/mm/yy'});
        </script>
    </body>
</html>