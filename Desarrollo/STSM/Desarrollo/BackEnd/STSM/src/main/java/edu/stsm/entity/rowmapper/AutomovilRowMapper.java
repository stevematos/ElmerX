package edu.stsm.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.stsm.entity.Automovil;

public class AutomovilRowMapper implements RowMapper<Automovil>{

	@Override
	public Automovil mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Automovil automovil = new Automovil();
		
		automovil.setIdAutomovil(rs.getInt("id_automovil"));
		automovil.setModelo(rs.getString("modelo"));
		automovil.setAsientos(rs.getInt("asientos"));
		automovil.setSoat(rs.getString("soat"));
		
		return automovil;
	}

}
