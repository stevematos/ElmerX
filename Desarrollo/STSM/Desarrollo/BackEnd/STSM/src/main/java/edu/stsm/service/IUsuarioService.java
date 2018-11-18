package edu.stsm.service;

import java.util.List;

import edu.stsm.entity.Usuario;

public interface IUsuarioService {
	
	List<Usuario> getAllUsuarios();
    Usuario getUsuarioById(Integer idUsuario);
    Usuario addUsuario(Usuario usuario);
    Usuario updateUsuario(Usuario usuario);
    void deleteUsuario(Integer idUsuario);

}

