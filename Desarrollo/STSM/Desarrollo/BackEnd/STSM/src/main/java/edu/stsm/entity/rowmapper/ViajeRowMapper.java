package edu.stsm.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.stsm.entity.Viaje;

public class ViajeRowMapper implements RowMapper<Viaje>{

	@Override
	public Viaje mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Viaje viaje = new Viaje();
		
		viaje.setIdViaje(rs.getInt("id_viaje"));
		viaje.setInicio(rs.getString("inicio"));
		viaje.setFin(rs.getString("fin"));
		viaje.setCupos(rs.getInt("cupos"));
		viaje.setCuposDisponibles(rs.getInt("cupos_disponibles"));
		viaje.setEnCurso(rs.getBoolean("en_curso"));
		viaje.setIdConductor(rs.getInt("id_conductor"));
		viaje.setHoraPartida(rs.getTime("hora_partida"));
		
		return viaje;
	}

}
