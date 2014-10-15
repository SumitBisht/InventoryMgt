<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <%--<%@include file="header.jsp" %>--%>
        <jsp:include page="header.jsp"></jsp:include>

            <script type="text/javascript">
                function submitDelete(value) {
                    $('#deleteId').val(value);
                    $('#deleteForm').submit();
                }
                $(document).ready(function() {
                	$(".bcTarget").each(function() {
                	var bcdigits = $(this).attr('rel');
                	$(this).barcode(bcdigits, "code39",{barWidth:1.5, barHeight:30});

                	});
                	});
                
                $( document ).ready(function() {
                	
/*                 	$(".bcTarget").barcode("1234567890128", "ean13");    
 */                
 
 
 
 
 
/*  $(".bcTarget").load(function(){
	 
	 
	 alert('hello');
 }
		 
 );
 $(".bcod").children('.bcTarget').barcode(this.children('.bheaden').val(),'ean13');
   */              	
                });
            </script>


        </head>

        <body role="document">
  
        <jsp:include page="headermenu.jsp"></jsp:include>
            <form action="DeleteItem.html" method="POST" id="deleteForm" name="deleteForm">
                <input type="hidden" id="deleteId" name="deleteId">
            </form>


            <div class="container">
                <div class="row container">
                    <div class="dashboard_main">
                        <div class="desh-icon-bg">
                            <img src="img/i-mgmt.png">
                        </div>
                        <div class="page-title-text">Item</div>
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
                                            <li class="active"><a href='item.html'><span>Items</span></a></li>
                                            <li><a href='item_category.html'><span>Item Category</span></a></li>
                                            <li class='last'><a href='item_unit.html'><span>Item Units</span></a></li>
                                        </ul>
                                    </li>
                                    <li class=''><a href='purchase_order.html'><span>Purchase Order</span></a></li>
                                    <li class=''><a href='purchase_requisition.html'><span>Purchase Requisition</span></a></li>
                                    <li class='last'><a href='account.html'><span><spring:message code="menu.account" text="Label value is missing !!!"/></span></a></li>
                                </ul>
                            </div>
                            <!-- END MUNU -->    

                        </div>
                    </div>
                    <div class="col-md-9">
                        <div class="catagory-main-box top-radius">
                            <div class="cat-box-title cat-title-font top-radius">Items List</div>

                            <div class="tab-content">
                                <div class="tab-pane active" id="demo">
                                    <div class="row tb-margin">
                                        <div class="col-sm-4">
                                            <a href="add-item.html" class="btn btn-info add-row addrow-btn-left">Add Item</a>
                                        </div>

                                    </div>
                                    <table id="dttable" class="table table-bordered table-striped" data-filter="#filter" data-page-size="5">
                                        <thead class="orange-bg border-t">
                                            <tr>
                                                <th data-toggle="true">
                                                    Name 
                                                </th>
                                                <th data-hide="phone">
                                                    Type 
                                                </th>
                                                <th data-hide="phone">
                                                    Currstock
                                                </th>
                                                <th data-hide="phone">
                                                    Unitid 
                                                </th>
                                                <th data-hide="phone">
                                                    Price
                                                </th>
                                                <th data-hide="phone">
                                                    BarCode
                                                </th>
                                                
                                                <th data-hide="phone">
                                                <spring:message code="itemCategory.Action" text="Label value is missing !!!"/>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="listVar" items="${itemList}">
                                            <tr>
                                                <td><a href="UpdateItem.html?updateItemId=${listVar.id}"><c:out value="${listVar.name}"/></a></td>
                                                <td><c:out value="${listVar.typeid.name}"/></td>
                                                <td><c:out value="${listVar.currstock}"/></td>
                                                <td data-value="78025368997"><c:out value="${listVar.unitid.name}"/></td>
                                                <td data-value="1"><span class="status-metro status-active" title="Active"><c:out value="${listVar.price}"/></span></td>
                                               <td class="bcod">
                                               <c:if test="${listVar.barcode!=0}">
                                               <div class="bcTarget" rel="${listVar.barcode}">
                                            
                                               
                                               </div>   </c:if></td>
                                               
                                               
                                                <td data-value="78025368997" style="text-align:center;">
                                                    <button onclick="submitDelete(<c:out value="${listVar.id}"/>);" class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-trash"></span> Delete</button>
                                                </td>

                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                    <tfoot class="hide-if-no-paging">
                                        <tr>
                                            <td colspan="6">
                                                <div class="pagination pagination-centered"></div>
                                            </td>
                                        </tr>
                                    </tfoot>
                                </table>
                            </div>
                            <div class="tab-pane" id="docs">
                                <h3>Removing A Row</h3>
                                <p>It is recommended to use the built-in <code>removeRow</code> function when deleting rows from a FooTable. The reasons are:</p>
                                <ul>
                                    <li>A detail row, that may or may not be generated when a breakpoint is fired, is also deleted</li>
                                    <li>The correct FooTable events are fired which triggers a redraw. This also forces the sorting, filtering and pagination add-ons to play nicely.</li>
                                </ul>
                                <p>Simply pass the row object into the <code>removeRow</code> function. (The row object can be a jQuery object or not)</p>
                                <pre>
$(&#39;table&#39;).footable().on(&#39;click&#39;, &#39;.row-delete&#39;, function(e) {
    e.preventDefault();
    //get the footable object
    var footable = $(&#39;table&#39;).data(&#39;footable&#39;);

    //get the row we are wanting to delete
    var row = $(this).parents(&#39;tr:first&#39;);

    //delete the row
    footable.removeRow(row);
});</pre>
                                <h3>Adding A Row</h3>
                                <p>For similar reasons as above, it is recommended to use the built-in <code>appendRow</code> function for adding rows to the FooTable:</p>
                                <pre>
$(&#39;.add-row&#39;).click(function(e) {
    e.preventDefault();

    //get the footable object
    var footable = $(&#39;table&#39;).data(&#39;footable&#39;);

    //build up the row we are wanting to add
    var newRow = &#39;&lt;tr&gt;&lt;td&gt;Isidra&lt;/td&gt;&lt;td&gt;&lt;a href=&quot;#&quot;&gt;Boudreaux&lt;/a&gt;&lt;/td&gt;&lt;td&gt;Traffic Court Referee&lt;/td&gt;&lt;td data-value=&quot;78025368997&quot;&gt;22 Jun 1972&lt;/td&gt;&lt;td data-value=&quot;1&quot;&gt;&lt;span class=&quot;status-metro status-active&quot; title=&quot;Active&quot;&gt;Active&lt;/span&gt;&lt;/td&gt;&lt;td&gt;&lt;a class=&quot;row-delete&quot; href=&quot;#&quot;&gt;&lt;span class=&quot;glyphicon glyphicon-remove&quot;&gt;&lt;/span&gt;&lt;/a&gt;&lt;/td&gt;&lt;/tr&gt;&#39;;

    //add it
    footable.appendRow(newRow);
});</pre>
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
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" language="javascript" src="js/dataTables.responsive.min.js"></script>
        <script >
            $(document).ready(function () {

                var tableElement = $('#dttable');
                tableElement.dataTable();
                
                var extensions = {
                    "sFilter": "dataTables_filter custom_filter_class",
                    "sLength": "dataTables_length custom_length_class"
                }
                // Used when bJQueryUI is false
                $.extend($.fn.dataTableExt.oStdClasses, extensions);
                // Used when bJQueryUI is true
                //$.extend($.fn.dataTableExt.oJUIClasses, extensions);
                
                //init pdf and print buttons...
                TableTools.DEFAULTS.aButtons = [  "pdf" ];
                
                tableElement.dataTable( {
                    "sDom": 'lf<"pull-right">Wrtip',
                    "bJQueryUI": false,
                    "sPaginationType": "full_numbers",
                    "bServerSide":true,
                    "bProcessing":true,
                    "sAjaxSource":"<%= request.getContextPath() %>/User/Manager/?oper=getusers",
                    "oSearch": {"bSmart": false},
                    "iDisplayLength": 10,
//                    "aLengthMenu": [[5, 10, 25, 50,100, 500], [5, 10, 25, 50,100, 500]],
                    "aoColumnDefs":[{
                            "aTargets": [ 4 ],"bSearchable":false, "bSortable": false,"sWidth":"20%",sClass:"alignleft  "
                            , "mRender": function ( data, type, full )  {
                                return  "<a class=\"btn btn-mini\" HREF=\"#\" onclick=\"onedit("+data+")\" style='margin-top: 0px;margin-left: 10px'><i class=\"icon-edit\"></i> Edit</a> \n\
                                    <a class=\"btn btn-mini\" HREF=\"#\" onclick=\"ondelete("+data+")\" style='margin-top: 0px;margin-left:10px'><i class=\"icon-trash\"></i> Delete</a> \n\
                                    <a class=\"btn btn-mini\" HREF=\"#\" onclick=\"onlogin("+data+")\" style='margin-top: 0px;margin-left:10px'><i class=\"icon-user\"></i> Login</a>";
                            }
                        },{"aTargets":[1],"sWidth":"30%"},{"aTargets":[0],"sClass":"aligrnleft"}
                        ,{"aTargets":[2],"sClass":"aligrnleft"}
                    ],
                    "oColumnFilterWidgets": {
                        "aiExclude": [ 0,1,4 ]
                        ,"iMaxSelections":1
                    },
                    "oLanguage": {
                        "sLengthMenu": " _MENU_ ",
                        "sSearch": "_INPUT_"
                    }
                } );

            }
        </script>
    </body>
</html>
