<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
   <title>AmigosSpring: página personal de ${amigo.login} </title>
   <link href="amigos.css" rel="stylesheet" type="text/css">
</head>
<body>   
	<jsp:include page="navegacion.jsp"/>
	<div id="principal">
	<h1>${amigo.login}</h1>
	<b>Sexo:</b> ${amigo.sexo} <br>
	<b>Edad:</b> ${amigo.edad} <br>
	<b>Localidad:</b> ${amigo.localidad} <br>	
	${amigo.descripcion} <br> <br> <br>
	</div>
</body>
</html>