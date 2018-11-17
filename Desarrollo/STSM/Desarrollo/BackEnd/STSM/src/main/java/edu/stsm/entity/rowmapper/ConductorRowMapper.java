package edu.stsm.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.stsm.entity.Conductor;

public class ConductorRowMapper implements RowMapper<Conductor>{

	@Override
	public Conductor mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Conductor conductor = new Conductor();
		
		conductor.setIdConductor(rs.getInt("id_conductor"));
		conductor.setIdUsuario(rs.getInt("id_usuario"));
		conductor.setIdAutomovil(rs.getInt("id_automovil"));
		conductor.setLicencia(rs.getString("licencia"));
			
		return conductor;
	}

}
