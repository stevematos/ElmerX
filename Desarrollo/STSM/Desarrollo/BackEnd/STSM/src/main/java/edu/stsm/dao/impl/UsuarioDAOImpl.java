package edu.stsm.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.stsm.dao.IUsuarioDAO;
import edu.stsm.entity.Usuario;
import edu.stsm.entity.rowmapper.UsuarioRowMapper;

@Transactional
@Repository
public class UsuarioDAOImpl implements IUsuarioDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Usuario> getAllUsuarios() {
		// TODO Auto-generated method stub
		String sql = "SELECT id_usuario, id_facultad, nombre, apellidos, celular, cod_alumno, usuario, contrasena FROM usuario";
        //RowMapper<Usuario> rowMapper = new BeanPropertyRowMapper<Usuario>(Usuario.class);
		RowMapper<Usuario> rowMapper = new UsuarioRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Usuario getUsuarioById(Integer idUsuario) {
		// TODO Auto-generated method stub
		String sql = "SELECT id_usuario, id_facultad, nombre, apellidos, celular, cod_alumno, usuario, contrasena FROM usuario WHERE id_usuario = ?";
		RowMapper<Usuario> rowMapper = new BeanPropertyRowMapper<Usuario>(Usuario.class);
		Usuario usuario = jdbcTemplate.queryForObject(sql, rowMapper, idUsuario);
		return usuario;
	}

	@Override
	public Usuario addUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		//Add usuario
		String sql = "INSERT INTO usuario (id_usuario, id_facultad, nombre, apellidos, celular, cod_alumno, usuario, contrasena) values (?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, usuario.getIdUsuario(), usuario.getIdFacultad(), usuario.getApellidos(), usuario.getApellidos(), usuario.getCelular(), usuario.getCodAlumno(), usuario.getUsuario(), usuario.getContrasena());
				
		//Fetch usuario id
		sql = "SELECT id_usuario, id_facultad, nombre, apellidos, celular, cod_alumno, usuario, contrasena FROM usuario WHERE id_usuario = ?";
		Usuario addedUsuario = jdbcTemplate.queryForObject(sql, Usuario.class, usuario.getIdUsuario());
				
		//Set usuario id 
		return addedUsuario;
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		String sql = "UPDATE usuario SET id_facultad = ?, nombre = ?, apellidos = ?, celular = ?, cod_alumno = ?, usuario = ?, contrasena = ? WHERE id_usuario = ?";
		jdbcTemplate.update(sql, usuario.getIdFacultad(), usuario.getApellidos(), usuario.getApellidos(), usuario.getCelular(), usuario.getCodAlumno(), usuario.getUsuario(), usuario.getContrasena(), usuario.getIdUsuario());
		
		//Fetch usuario id
		sql = "SELECT id_usuario, id_facultad, nombre, apellidos, celular, cod_alumno, usuario, contrasena FROM usuario WHERE id_usuario = ?";
		Usuario updatedUsuario = jdbcTemplate.queryForObject(sql, Usuario.class, usuario.getIdUsuario());
						
		//Set usuario id 
		return updatedUsuario;
	}

	@Override
	public void deleteUsuario(Integer idUsuario) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM usuario WHERE id_usuario = ?";
		jdbcTemplate.update(sql, idUsuario);
	}

}
