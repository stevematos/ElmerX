package edu.stsm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.stsm.dao.IUsuarioDAO;
import edu.stsm.entity.Usuario;
import edu.stsm.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@Override
	public List<Usuario> getAllUsuarios() {
		// TODO Auto-generated method stub
		List<Usuario> usuarioList = usuarioDAO.getAllUsuarios();
		return usuarioList;
	}

	@Override
	public Usuario getUsuarioById(Integer idUsuario) {
		// TODO Auto-generated method stub
		Usuario usuario = usuarioDAO.getUsuarioById(idUsuario);
		return usuario;
	}

	@Override
	public Usuario addUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		Usuario addedUsuario = usuarioDAO.addUsuario(usuario);
		return addedUsuario;
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		Usuario updatedUsuario = usuarioDAO.updateUsuario(usuario);
		return updatedUsuario;
	}

	@Override
	public void deleteUsuario(Integer idUsuario) {
		// TODO Auto-generated method stub
		usuarioDAO.deleteUsuario(idUsuario);
	}

}
