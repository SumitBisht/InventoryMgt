<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                    <div class="page-title-text"><spring:message code="bank.list" text="Label value is missing !!!"/></div>
                </div>
            </div>	
            <div class="row">
                <div class="col-md-3">
                    <div class="catagory-main-box top-radius">
                        <!--<div class="cat-table-title"></div>-->
                        <!-- MUNU -->    
                        <div id='cssmenu'>
                            <%@include  file="finance_mgt_menu.jsp" %>
                        </div>
                        <!-- END MUNU -->    
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title cat-title-font top-radius"><spring:message code="bank.list" text="Label value is missing !!!"/></div>
                        <spring:message text="Default Text" code="purorder.search.placeholder" var="search"/>
                        <div class="tab-content">
                            <div class="tab-pane active" id="demo">
                                <div class="row tb-margin">
                                    <div class="col-sm-4">
                                        <a href="add-bank.html" class="btn btn-info add-row addrow-btn-left"><spring:message code="bank.add" text="Label value is missing !!!"/></a>
                                    </div>
                                    <div class="col-sm-8">
                                        <!--<div class="form-group visible-sm visible-md visible-lg">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="purorder.search" text="Label value is missing !!!"/></label>
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
                                <table id="dttable" class="table table-bordered table-striped" data-filter="#filter" data-page-size="5">
                                    <thead class="orange-bg border-t">
                                        <tr>
                                            <th data-toggle="true">
                                                <spring:message code="label.bank.name" text="Label value is missing !!!"/>
                                            </th>
                                            <th data-hide="phone">
                                                <spring:message code="label.bank.address1" text="Label value is missing !!!"/> 
                                            </th>
                                            <th data-hide="phone">
                                                <spring:message code="label.bank.address2" text="Label value is missing !!!"/> 
                                            </th>
                                            <th data-hide="phone">
                                                <spring:message code="label.bank.city" text="Label value is missing !!!"/> 
                                            </th>
                                            <th data-hide="phone">
                                                <spring:message code="label.bank.country" text="Label value is missing !!!"/> 
                                            </th>
                                            <th data-hide="phone" data-name="Delete">
                                                <spring:message code="label.purorder.action" text="Label value is missing !!!"/> 
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="bank" items="${bankList}">
                                            <tr>
                                                <td>${bank.name}</td>
                                                <td>${bank.address1}</td>                                                
                                                <td>${bank.address2}</td>
                                                <td>${bank.city}</td>
                                                <td>${countryMap[bank.countryId]}</td>
                                                <td>
                                                    <a href="edit-bank.html?id=${bank.id}" class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-edit"></span>Edit</a>
                                                    <a href="delete-bank.html?id=${bank.id}" class="btn btn-default btn-sm row-delete" type="button"><span class="glyphicon glyphicon-trash"></span> Delete</a>
                                                </td>
                                            </tr>                                        
                                        </c:forEach>
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
            $(document).ready(function() {
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
        </script>
    </body>
</html>