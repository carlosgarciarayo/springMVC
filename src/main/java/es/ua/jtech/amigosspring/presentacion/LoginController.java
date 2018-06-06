/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.ua.jtech.amigosspring.presentacion;

import es.ua.jtech.amigosspring.datos.IUsuariosDAO;
import es.ua.jtech.amigosspring.modelo.DatosLogin;
import es.ua.jtech.amigosspring.modelo.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author especialista
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    IUsuariosDAO udao;

    @RequestMapping(method=RequestMethod.GET)
    public String preparaLogin(Model modelo) {
        modelo.addAttribute(new DatosLogin());
        return "login";
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String login(DatosLogin datos, Model modelo) throws Exception {
        Usuario u = udao.getUsuario(datos.getLogin());
        if (u!=null && datos.getPassword().equals(u.getPassword())) {
            modelo.addAttribute("usuario", u);
            return "personal";
        }
        else {
            modelo.addAttribute("error", "login y/o password incorrectos");
            return "login";
        }
    }

}
