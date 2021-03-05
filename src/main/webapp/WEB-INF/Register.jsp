<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>


<div class="container">
    
	<div id="loginbox" style="margin-top: 50px;" class="mainbox col-md-4 col-md-offset-4 col-sm-8 col-sm-offset-2">
	<div><p><a href="/Register" class="text-primary">Not a Customer?Please create a profile</a></p></div>

			<div style="padding-top: 30px" class="panel-body">
			
			<form:form modelAttribute="user" method="post"  class="form-horizontal" >
				<div class="form-group">
                  <label for="username">User Name:</label>		
				  <form:input path="username" type="text" class="form-control" placeholder="username"/>
				  <form:errors path="username" />
				 </div>
				  
				 <div class="form-group">
                  <label for="password">Password:</label>		
				  <form:input path="password" type="password" class="form-control" placeholder="password"/>
				  <form:errors path="password" />
				 </div>
				 
				 <div class="form-group">
                  <label for="email">Email address:</label>		
				  <form:input path="email" type="email" class="form-control" placeholder="email"/>
				  <form:errors path="email" />
				 </div>
				 
				 <div class="form-group">
                  <label for="mobile">Mobile No:</label>		
				  <form:input path="mobile" type="number" class="form-control" placeholder="mobile"/>
				  <form:errors path="mobile" />
				 </div>
				 
				 <div class="form-group">
                  <label for="address"> Address:</label>		
				  <form:input path="address" type="text" class="form-control" placeholder="address"/>
				  <form:errors path="address" />
				 </div>
				

				<div style="margin-top: 10px" class="form-group" align='center'>
						<!-- Button -->

						<div class="col-sm-12 controls">
							<form:button  type='success' class="btn btn-success">Register </form:button>
						</div>
				</div>

				</form:form>
		</div>
		</div>
	</div>
</div>