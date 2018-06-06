<%@page import="org.springframework.web.context.*, org.springframework.web.context.support.*" %>
<%@page import="es.ua.jtech.amigosspring.datos.IUsuariosDAO" %>
<%@page import="es.ua.jtech.amigosspring.modelo.*" %>
<%@page contentType="text/plain" pageEncoding="iso-8859-1" %>
<%
    WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    IUsuariosDAO udao = wac.getBean(IUsuariosDAO.class);
    Usuario u = udao.getUsuario(request.getParameter("login"));
    out.println("datos del usuario " + u.getLogin());
    out.println("sexo:"+u.getSexo());
    out.println("edad:" + u.getEdad());
    out.println("localidad:"+u.getLocalidad());
    out.println("descripción: "+u.getDescripcion());
%>
