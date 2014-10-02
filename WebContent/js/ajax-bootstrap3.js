//https://github.com/Comanche/datatables-responsive
$(document).ready(function () {
    var responsiveHelper = undefined;
    var breakpointDefinition = {
        tablet: 1024,
        phone : 480
    };
    var tableElement = $('#dttable');

    tableElement.dataTable();
    
//    tableElement.dataTable({
//        autoWidth        : false,
//        preDrawCallback: function () {
//            // Initialize the responsive datatables helper once.
//            if (!responsiveHelper) {
//                responsiveHelper = new ResponsiveDatatablesHelper(tableElement, breakpointDefinition);
//            }
//        },
//        rowCallback    : function (nRow) {
//            responsiveHelper.createExpandIcon(nRow);
//        },
//        drawCallback   : function (oSettings) {
//            responsiveHelper.respond();
//        }
//    });
});
