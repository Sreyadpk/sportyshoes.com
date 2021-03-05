<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>


<div class="container">
    
	<div id="loginbox" style="margin-top: 50px;" class="mainbox col-md-4 col-md-offset-4 col-sm-8 col-sm-offset-2">
	<div><p><a href="/Register" class="text-primary">Not a Customer?Please create a profile</a></p></div>
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Sign In</div>
			</div>

			<div style="padding-top: 30px" class="panel-body">
			
			<form:form modelAttribute="user" method="post"  class="form-horizontal" >
			
				<div style="margin-bottom: 25px" class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							
				  <form:input path="username" type="text" class="form-control" placeholder="username"/>
				  <form:errors path="username" />
				</div>

				<div style="margin-bottom: 25px" class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
					
				  <form:input path="password" type="password" class="form-control" placeholder="password"/>
				  <form:errors path="password" />		
				</div>
                

				<div style="margin-top: 10px" class="form-group" align='center'>
						<!-- Button -->
                        <div class="col-sm-12 controls">
							<form:button  type='success' class="btn btn-success">Login </form:button>
						</div>
				</div>
                <div class="col-sm-12 controls">
					<p class="text-danger">Please Check the user name or password entered is correct</p>
				</div>
				</form:form>
		</div>
		</div>
	</div>
</div>