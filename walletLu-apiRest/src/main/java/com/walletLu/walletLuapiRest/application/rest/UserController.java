package com.walletLu.walletLuapiRest.application.rest;

import com.walletLu.walletLuapiRest.domain.entities.UserEntity;
import com.walletLu.walletLuapiRest.domain.services.interfaces.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/users")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/getListAllUsers")
    @Operation(
            summary = "Ver todos los Usuarios",
            description = "Método que muestra todos los usuarios de la aplicación.",
            tags = { "Usuarios" }
    )
    public List<UserEntity> getListAllUsers() {
        return userService.getAll();
    }

    @PostMapping("/createUser")
    @Operation(
            summary = "Crear Usuario",
            description = "Método que crea un Usuario, dándole un Nombre, Apellido y Password. El UsuarioId se deja a 0.",
            tags = { "Usuarios" }
    )
    public UserEntity createUser(@RequestBody UserEntity usuario) {
        return userService.createUser(usuario);
    }
}
