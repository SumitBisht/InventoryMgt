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
                    <div class="page-title-text"><spring:message code="label.invoice.heading" text="Label value is missing !!!"/></div>
                </div>
            </div>	
            <div class="row">
                <div class="col-md-3">
                    <div class="catagory-main-box top-radius">
                        <div id='cssmenu'>
                            <ul>
                                <li class='has-sub active'><a href='invoice_entry.html'><span><spring:message code="label.invoice.operations" text="Label value is missing !!!"/></span></a>
                                <li class=''><a href='#'><span><spring:message code="label.invoice.entry" text="Label value is missing !!!"/></span></a>
                                    <ul style='display: block;'>
                                        <li><a href='invoice_entry.html'><span><spring:message code="label.invoice.heading" text="Label value is missing !!!"/></span></a></li>
                                        <li class="active"><a href='not_in_use.html'><span><spring:message code="label.invoice.box" text="Label value is missing !!!"/></span></a></li>
                                        <li class='last'><a href='not_in_use.html'><span><spring:message code="label.invoice.bank" text="Label value is missing !!!"/></span></a></li>
                                        <li class='last'><a href='not_in_use.html'><span><spring:message code="label.invoice.heading" text="Label value is missing !!!"/></span></a></li>
                                    </ul>
                                </li>
                                
                            </ul>
                            
                        </div>
                        <!-- END MUNU -->    
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title cat-title-font top-radius"><spring:message code="menu.employeereport" text="Label value is missing !!!"/></div>
                        <div class="tab-content">
                            <div class="tab-pane active" id="demo">
								<p>TODO: Display an invoice here </p>
                                
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
        </script>
    </body>
</html>