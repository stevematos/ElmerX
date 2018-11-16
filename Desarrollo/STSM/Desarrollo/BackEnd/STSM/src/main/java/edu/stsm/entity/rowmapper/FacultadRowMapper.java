package edu.stsm.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.stsm.entity.Facultad;

public class FacultadRowMapper implements RowMapper<Facultad>{

	@Override
	public Facultad mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Facultad facultad = new Facultad();
		
		facultad.setIdFacultad(rs.getInt("id_facultad"));
		facultad.setNombre(rs.getString("nombre"));
		
		return facultad;
	}

}
