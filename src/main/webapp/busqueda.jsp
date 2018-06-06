<html>
    <head>
        <title>AmigosSpring: búsqueda de usuarios</title>
        <link href="amigos.css" rel="stylesheet" type="text/css">

    </head>
    <body>
        <h1>Búsqueda de usuarios</h1>
        <br/>
        <form action="" method="post">
		Busco
            <select name="sexo" size="1">
                <option value="mujer">mujer</option>
                <option value="hombre">hombre</option>
                <option value="indiferente">indiferente</option>
            </select>
		entre <input type="text" name="edadMin" size="2"/>
		y <input type="text" name="edadMax" size="2"/> años
		y que viva en <input type="text" name="localidad"/> (en blanco para cualquiera)
            <input type="submit" value="buscar"/>
        </form>

    </body>
</html>