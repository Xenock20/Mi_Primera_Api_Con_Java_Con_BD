
package com.xenock.databaseapi.service;

import com.xenock.databaseapi.model.Usuario;
import com.xenock.databaseapi.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getUsuarios() {
        List<Usuario> listaUsuario = usuarioRepository.findAll();
        
        return listaUsuario;
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario findUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        
        return usuario;
    }
}
