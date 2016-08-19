<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="includes/header.jsp"%>

<div class="panel panel-primary">

	<div class="panel-heading">
		<h3 class="panel-title">Please sign in</h3>
	</div>
	
	<div class="panel-body">
	
	    <c:if test="${param.logout != null}">
	        <div class="alert alert-success">
	             You have been logged out
	        </div>
	    </c:if>

	    <c:if test="${param.error != null}">
			<div class="alert alert-danger">
		        Failed to login.
		        <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
		          Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
		        </c:if>
		 	</div>
	    </c:if>

		<form:form role="form">
		
			<div class="form-group">
				<label for="username">Email address</label>
				<input id="username" name="username"
					type="email" class="form-control"
					placeholder="Enter email" />
				<p class="help-block">Enter your email address.</p>
			</div>
			
			<div class="form-group">
				<label for="password">Password</label>
				<input id="password" name="password"
					type="password" class="form-control"
					placeholder="Password" />
			</div>
			
		    <div class="form-group">
                <div class="checkbox">
                    <label>
                        <input name="remember-me" type="checkbox">
                        Remember me
                    </label>
                </div>
            </div>

			<button type="submit" class="btn btn-primary">
				Sign In
			</button>
			
			<a class="btn btn-default" href="/forgot-password">
				Forgot Password
			</a>
			
		</form:form>
	</div>
</div>

<%@include file="includes/footer.jsp"%>
