package edu.stsm.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.stsm.entity.Asiento;

public class AsientoRowMapper implements RowMapper<Asiento>{

	@Override
	public Asiento mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Asiento	asiento = new Asiento();
		
		asiento.setIdViaje(rs.getInt("id_viaje"));
		asiento.setIdPasajero(rs.getInt("id_pasajero"));
		asiento.setHoraOcupacion(rs.getTime("hora_ocupacion"));
		
		return asiento;
	}

}
