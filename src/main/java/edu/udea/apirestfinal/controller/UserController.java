package edu.udea.apirestfinal.controller;

import edu.udea.apirestfinal.model.Rol;
import edu.udea.apirestfinal.model.User;
import edu.udea.apirestfinal.service.RolService;
import edu.udea.apirestfinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller // -> indica que es un controlador
public class UserController {

    //Inyectar los srvicios
    @Autowired
    private UserService userService;
    @Autowired
    private RolService rolService;

    @Autowired
    public UserController(UserService userService, RolService rolService) {
        this.userService = userService;
        this.rolService = rolService;
    }

    @GetMapping("/users")
    public String listarUsers(Model model){
        model.addAttribute("users", userService.buscarTodos());
        return "users";
    }

    @PostMapping("/create")
    public String crearUser(Model model){

        User user = new User();
        List<Rol> roles = rolService.buscarTodos();
        model.addAttribute("Titulo", "Formulario New User");
        model.addAttribute("user",user);
        model.addAttribute("roles",roles);

        userService.guardar(user);
        return "create_user";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute User user){
        userService.guardar(user);
        System.out.println("User: " + user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idUser, Model model){

        User user = userService.buscar(idUser);
        List<Rol> roles = rolService.buscarTodos();

        model.addAttribute("Titulo", "Formulario Edit User");
        model.addAttribute("user",user);
        model.addAttribute("roles",roles);

        userService.guardar(user);
        return "edit_user";
    }

    @PostMapping("/update")
    public String actualizar(@ModelAttribute User user){
        userService.editar(user);
        System.out.println("User: " + user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long idUser){
        userService.eliminar(idUser);
        System.out.println("User eliminado");
        return "redirect:/users";
    }

}
