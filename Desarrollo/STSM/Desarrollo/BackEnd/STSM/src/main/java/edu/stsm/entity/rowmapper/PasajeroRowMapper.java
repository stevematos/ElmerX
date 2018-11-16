package edu.stsm.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.stsm.entity.Pasajero;

public class PasajeroRowMapper implements RowMapper<Pasajero>{

	@Override
	public Pasajero mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Pasajero pasajero = new Pasajero();
		
		pasajero.setIdPasajero(rs.getInt("id_pasajero"));
		pasajero.setIdUsuario(rs.getInt("id_usuario"));
		
		return pasajero;
	}

}
