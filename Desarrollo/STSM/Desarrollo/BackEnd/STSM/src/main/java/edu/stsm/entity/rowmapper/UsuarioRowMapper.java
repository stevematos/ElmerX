package edu.stsm.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.stsm.entity.Usuario;

public class UsuarioRowMapper implements RowMapper<Usuario>{

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Usuario usuario = new Usuario();
		
		usuario.setIdUsuario(rs.getInt("id_usuario"));
		usuario.setIdFacultad(rs.getInt("id_facultad"));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setApellidos(rs.getString("apellidos"));
		usuario.setCelular(rs.getString("celular"));
		usuario.setCodAlumno(rs.getString("cod_alumno"));
		usuario.setUsuario(rs.getString("usuario"));
		usuario.setContrasena(rs.getString("contrasena"));
		
		return usuario;
	}

}
