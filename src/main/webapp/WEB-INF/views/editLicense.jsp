<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
        
	<title>Sparepart Management</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css"/>">
    
    <!-- MetisMenu CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/bower_components/metisMenu/dist/metisMenu.min.css"/>">

    <!-- DataTables CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css"/>" >

	<!-- DataTables Responsive CSS -->
    <link rel="stylesheet" href="<c:url value="resources/bower_components/datatables-responsive/css/dataTables.responsive.css"/>">
        
    <!-- Custom CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/dist/css/sb-admin-2.css"/>">
    
    <!-- Custom Fonts -->
    <link rel="stylesheet" href="<c:url value="/resources/bower_components/font-awesome/css/font-awesome.min.css"/>" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div id="wrapper">
		<jsp:include page="./template/navigation.jsp"></jsp:include>
		
		<div id="page-wrapper">
			<div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Edit License</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
            	<div class="col-lg-12">
            		<div class="panel panel-default">
                        <div class="panel-heading">
                            Choose 1 entry to edit or delete
                        </div>
                        <div class="panel-body">
                        	<div class="dataTable_wrapper">
                        		<table class="table table-striped table-bordered table-hover" id="dataTables">
                        			<thead>
                        				<tr>
                        					<th>Inventory ID</th>
                        					<th>License Name</th>
                        					<th>License Key</th>
                        					<th>License Type</th>
                        					<th>Total Quantity</th>
                        					<th>Spare Quantity</th>
                        				</tr>
                        			</thead>
                        		</table>                        		
                        	</div>
                        	<!-- /.table-responsive -->
                        	
                        	<div>
                        		<a href="#" class="btn btn-primary" data-toggle="modal" id="edit">Edit</a>
                        		<a href="#" class="btn btn-danger" data-toggle="modal" data-target="#confirm" id="delete">Delete</a>
                        		<!-- 2 buttons here -->
                        		
                        		<div class="modal fade" id="confirm" tabindex="-1" role="dialog">
                            		<div class="modal-dialog">
                            			<div class="modal-content">
	                            			<div class="modal-header">
	                            				<button type="button" class="close" data-dismiss="modal">&times;</button>
	                            				<h3 class="modal-title" id="myModalLabel" style="color:#428bca">Confirmation!</h3>
	                            			</div>
	                            			<div class="modal-body">
	                            				<h4>Are you sure to delete?</h4>
	                            			</div>
	                            			<div class="modal-footer">
		                            			<button class="btn btn-default" data-dismiss="modal">Close</button>
		                            			<button class="btn btn-primary" id="deleteConfirmed" data-dismiss="modal">Yes!</button>
	                            			</div>
                            			</div>
	                            	</div>	                            	
                            	</div>
                            	<!-- modal-dialog for delete confirm -->
                            	
                            	<div class="modal fade" id="noSelected" tabindex="-1" role="dialog">
	                            	<div class="modal-dialog">
	                            		<div class="modal-content">
	                            			<div class="modal-header">
	                            				<button type="button" class="close" data-dismiss="modal">&times;</button>
	                            				<h3 class="modal-title" id="myModalLabel" style="color:#d9534f">Warning!</h3>
	                            			</div>
	                            			<div class="modal-body">
	                            				<h4>Please select at least one row!</h4>
	                            			</div>
	                            			<div class="modal-footer">
	                            				<button class="btn btn-primary" data-dismiss="modal">OK!</button>
	                            			</div>
	                            		</div>
                            		</div>
                            	</div>
                        	</div>
                        	<!-- /Buttons -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
            	</div>
            	<!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
		</div>
	</div>
	<!-- /#wrapper -->
	
	<!-- jQuery -->
    <script src="<c:url value="/resources/bower_components/jquery/dist/jquery.min.js"/>"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"/>"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<c:url value="/resources/bower_components/metisMenu/dist/metisMenu.min.js"/>"></script>
    
    <!-- DataTables JavaScript -->
    <script src="<c:url value="/resources/bower_components/DataTables/media/js/jquery.dataTables.min.js"/>"></script>
    <script src="<c:url value="/resources/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"/>"></script>
    
    <!-- Custom Theme JavaScript -->
    <script src="<c:url value="/resources/dist/js/sb-admin-2.js"/>"></script>
    
    <!-- Initial datatable -->
    <script>
    $(document).ready(function() {
        $('#dataTables').DataTable({
                responsive: true
        });
    });
    </script>
    
</body>
</html>