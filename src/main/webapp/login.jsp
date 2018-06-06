<html>
	<head>
	  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
	  <title>AmigosSpring: conoce gente y aprende Spring</title>
	  <link href="amigos.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<h1>AmigosSpring</h1>
		<form action="login.do" method="post">
			<table>
			<tr>
    			<td>Usuario:</td> <td><input type="text" name="login"></td>
    		</tr>
    		<tr>	
    		    <td>Contraseña:</td><td><input type="password" name="password"></td>
    		</tr>
    		<tr>    
    		    <td colspan="2"> <input type="submit" value="Entrar"></td>
    		</tr>    
    		</table>
    		<div style="color:red">${error}</div>
		</form>	
		<br>
	</body>
			
	
</html>