package edu.stsm.dao;

import java.util.List;

import edu.stsm.entity.Usuario;

public interface IUsuarioDAO {
	
	List<Usuario> getAllUsuarios();
    Usuario getUsuarioById(Integer idUsuario);
    Usuario addUsuario(Usuario usuario);
    Usuario updateUsuario(Usuario usuario);
    void deleteUsuario(Integer idUsuario);

}

