<html>
	<head>
		<title>Welcome!</title>
	</head>
	<body>
		<#list userList as user>
			<h1>Welcome ${user.name}!&nbsp;&nbsp;id:${user.id}</h1><br/>
		</#list>
		<p>Our latest product:
		<a href = "${lastProduct.url}">${lastProduct.name}</a>!
	</body>
</html>