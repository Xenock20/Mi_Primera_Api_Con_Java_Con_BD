package com.xenock.databaseapi.controller;

import com.xenock.databaseapi.model.Usuario;
import com.xenock.databaseapi.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {
    
    @Autowired
    private IUsuarioService usuarioService;
    
    @GetMapping("/usuario/lista")
    public List<Usuario> getUsuario() {
        return usuarioService.getUsuarios();
    }
    
    @PostMapping("/usuario/crear")
    public String createUsuario(@RequestBody Usuario usuario) {     
        usuarioService.saveUsuario(usuario);
        return "Usuario Creado";
    }
    
    @DeleteMapping("/usuario/eliminar/{id}")
    public String deleteUsuario(@PathVariable Long id){  
        usuarioService.deleteUsuario(id);
        return "Usuario Eliminado";
    }
    
    @PutMapping("/usuario/editar/{id}")
    public Usuario editUsuario(@PathVariable Long id,
                               @RequestParam ("usuario") String nuevoUsuario,
                               @RequestParam ("passwords") String nuevoPasswords){
        
        Usuario usuario = usuarioService.findUsuario(id);
        
        usuario.setUsuario(nuevoUsuario);
        usuario.setPasswords(nuevoPasswords);
        
        usuarioService.saveUsuario(usuario);
        
        return usuario;
    }
}
