<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
        
	<title>Contract Management</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css"/>">
    
    <!-- MetisMenu CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/bower_components/metisMenu/dist/metisMenu.min.css"/>">

    <!-- Timeline CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/dist/css/timeline.css"/>">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/dist/css/sb-admin-2.css"/>">
    
    <!-- formValidation CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/bower_components/formValidation/css/formValidation.min.css"/>">
    
    <!-- Custom Fonts -->
    <link rel="stylesheet" href="<c:url value="/resources/bower_components/font-awesome/css/font-awesome.min.css"/>" type="text/css">
    
    <!-- Datetimepicker CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/bower_components/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css"/>" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div id="wrapper">
		<jsp:include page="../template/navigation.jsp"></jsp:include>
		
		<div id="page-wrapper">
			<div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Create Contract</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Input Contract Information
                        </div>
                        <div class="panel-body">
                        	<sf:form method="POST" modelAttribute="contractForm" id="contractForm">
                        		<div class="row">
		                        	<div class="col-lg-6">
		                        		<div class="form-group">
		                        			<label>Category:</label>
		                        			<i class="fa fa-asterisk text-danger"></i>
		                        			<sf:input path="category" type="text" class="form-control"/>
		                        		</div>
		                        		<div class="form-group">
		                        			<label>Brand:</label>
		                        			<i class="fa fa-asterisk text-danger"></i>
		                        			<sf:input path="brand" type="text" class="form-control"/>
		                        		</div>
		                        		<div class="form-group">
		                        			<label>Vendor:</label>
		                        			<i class="fa fa-asterisk text-danger"></i>
		                        			<sf:input path="vendor" type="text" class="form-control"/>
		                        		</div>
		                        		<div class="form-group">
		                        			<label>Contract Type:</label>
		                        			<i class="fa fa-asterisk text-danger"></i>
		                        			<sf:select path="type" class="form-control">
		                        				<option value="" disabled selected style='display:none;'>Select your option</option>
		                        				<sf:option value="New"></sf:option>
		                        				<sf:option value="Renewal"></sf:option>
		                        			</sf:select>		                        			
		                        		</div>
		                        		<div class="form-group">
		                        			<label>Description:</label>
		                        			<i class="fa fa-asterisk text-danger"></i>
		                        			<sf:input path="description" type="text" class="form-control"/>	                        			
		                        		</div>
		                        		<div class="form-group">
		                        			<label>PO Number:</label>
		                        			<i class="fa fa-asterisk text-danger"></i>		                        			
		                        			<sf:input path="po" type="text" class="form-control"/>	                        			
		                        		</div>
		                        		<div class="form-group">
		                        			<label>PO Link:</label>
		                        			<i class="fa fa-asterisk text-danger"></i>
		                        			<sf:input path="poLink" type="text" class="form-control"/>	                        			
		                        		</div>
		                        		<div class="form-group">
		                        			<label>Price:</label>
		                        			<i class="fa fa-asterisk text-danger"></i>
		                        			<sf:input path="priceRMB" type="text" class="form-control"/>	                        			
		                        		</div>
		                        		<div class="form-group">
		                        			<label>Service Start Date:</label>
		                        			<i class="fa fa-asterisk text-danger"></i>
							                <div class='input-group date' id='startDate'>
							                    <sf:input path="startDate" type='text' class="form-control" />
							                    <span class="input-group-addon">
							                        <span class="fa fa-calendar"></span>
							                    </span>
							                </div>
		                        		</div>
		                        		<div class="form-group">
		                        			<label>Service End Date:</label>
		                        			<i class="fa fa-asterisk text-danger"></i>
							                <div class='input-group date' id='endDate'>
							                    <sf:input path="endDate" type='text' class="form-control" />
							                    <span class="input-group-addon">
							                        <span class="fa fa-calendar"></span>
							                    </span>
							                </div>
		                        		</div>
									</div>
									<div class="col-lg-6">
		                        		<div class="form-group">
		                        			<label>Contract Period (By Month):</label>
		                        			<i class="fa fa-asterisk text-danger"></i>
		                        			<sf:input path="contractPeriod" type="text" class="form-control"/>	                        			
		                        		</div>		                        		
		                        		<div class="form-group">
		                        			<label>Installment Terms:</label>
		                        			<i class="fa fa-asterisk text-danger"></i>
		                        			<sf:select path="installmentPayTerms" class="form-control">
		                        				<option value="" disabled selected style='display:none;'>Select your option</option>
		                        				<sf:option value="One time"></sf:option>
		                        				<sf:option value="Installment"></sf:option>
		                        			</sf:select>	                        			
		                        		</div>
		                        		<div class="form-group" style="display: none;">
		                        			<label>Payment Cycle:</label>
		                        			<i class="fa fa-asterisk text-danger"></i>
		                        			<sf:select path="paymentCycle" class="form-control">
		                        				<option value="" disabled selected style='display:none;'>Select your option</option>
		                        				<sf:option value="Monthly"></sf:option>
		                        				<sf:option value="Quarterly"></sf:option>
		                        				<sf:option value="Yearly"></sf:option>
		                        			</sf:select>	                        			
		                        		</div>
		                        		<div class="form-group">
		                        			<label>Payment Start Date:</label>
		                        			<i class="fa fa-asterisk text-danger"></i>
							                <div class='input-group date' id='paymentStartDay'>
							                    <sf:input path="paymentStartDay" type='text' class="form-control" />
							                    <span class="input-group-addon">
							                        <span class="fa fa-calendar"></span>
							                    </span>
							                </div>
		                        		</div>
		                        		
		                        		<div class="form-group">
		                        			<label>Service Level:</label>
		                        			<i class="fa fa-asterisk text-danger"></i>
		                        			<sf:input path="serviceLevel" type="text" class="form-control"/>	                        			
		                        		</div>
		                        		<div class="form-group">
		                        			<label>Cost Center:</label>
		                        			<i class="fa fa-asterisk text-danger"></i>
		                        			<sf:input path="costCenter" type="text" class="form-control"/>	                        			
		                        		</div>
		                        		<div class="form-group">
		                        			<label>Owner Name:</label>
		                        			<i class="fa fa-asterisk text-danger"></i>
		                        			<sf:input path="ownerName" type="text" class="form-control"/>	                        			
		                        		</div>		                        		
		                        	</div>
		                        </div>
		                        
		                        <div class="row">
	                        		<div class="col-lg-12">
		                        		<button type="submit" class="btn btn-default">Submit Button</button>
		                        		<button type="reset" class="btn btn-default">Reset Button</button>
		                        	</div>
	                        	</div>
		                    </sf:form>
                        </div>
                    </div>
                    
                </div>
            </div>
		</div>
	</div>
	<!-- /#wrapper -->
	
	<!-- jQuery -->
    <script src="<c:url value="/resources/bower_components/jquery/dist/jquery.min.js"/>"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"/>"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<c:url value="/resources/bower_components/metisMenu/dist/metisMenu.min.js"/>"></script>
    
    <!-- moment JS -->
    <script src="<c:url value="/resources/bower_components/moment/moment.min.js"/>"> </script>
    
    <!-- DatetimePicker JS -->
    <script src="<c:url value="/resources/bower_components/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"/>"></script>
    
    <!-- Custom Theme JavaScript -->
    <script src="<c:url value="/resources/dist/js/sb-admin-2.js"/>"></script>
    
    <!-- formValidation JavaScript -->
    <script src="<c:url value="/resources/bower_components/formValidation/js/formValidation.min.js"/>"></script>
    <script src="<c:url value="/resources/bower_components/formValidation/js/framework/bootstrap.min.js"/>"></script>
    
    <!-- Initial Datetimepicker -->
    <script type="text/javascript">
	    jQuery(function () {
	        jQuery('#startDate,#endDate,#paymentStartDay').datetimepicker({
	        	format:'YYYY-MM-DD'	
	    	});
	    });
	</script>
</body>
</html>