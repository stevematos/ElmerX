package edu.stsm.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.stsm.dao.IAsientoDAO;
import edu.stsm.entity.Asiento;
import edu.stsm.entity.rowmapper.AsientoRowMapper;

@Transactional
@Repository
public class AsientoDAOImpl implements IAsientoDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Asiento> getAllAsientos() {
		// TODO Auto-generated method stub
		String sql = "SELECT id_viaje, id_pasajero, hora_ocupacion FROM asiento";
        //RowMapper<Asiento> rowMapper = new BeanPropertyRowMapper<Asiento>(Asiento.class);
		RowMapper<Asiento> rowMapper = new AsientoRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Asiento getAsientoById(Integer idViaje, Integer idPasajero) {
		// TODO Auto-generated method stub
		String sql = "SELECT id_viaje, id_pasajero, hora_ocupacion FROM asiento WHERE id_viaje = ? and id_pasajero = ?";
		RowMapper<Asiento> rowMapper = new BeanPropertyRowMapper<Asiento>(Asiento.class);
		Asiento asiento = jdbcTemplate.queryForObject(sql, rowMapper, idViaje, idPasajero);
		return asiento;
	}

	@Override
	public Asiento addAsiento(Asiento asiento) {
		// TODO Auto-generated method stub
		//Add asiento
		String sql = "INSERT INTO asiento (id_viaje, id_pasajero, hora_ocupacion) values (?, ?, ?)";
		jdbcTemplate.update(sql, asiento.getIdViaje(), asiento.getIdPasajero(), asiento.getHoraOcupacion());
				
		//Fetch asiento id
		sql = "SELECT id_viaje, id_pasajero, hora_ocupacion FROM asiento WHERE id_viaje = ? and id_pasajero = ?";
		RowMapper<Asiento> rowMapper = new BeanPropertyRowMapper<Asiento>(Asiento.class);
		Asiento addedAsiento = jdbcTemplate.queryForObject(sql, rowMapper, asiento.getIdViaje(), asiento.getIdPasajero());
				
		//Set asiento id 
		return addedAsiento;
	}

	@Override
	public Asiento updateAsiento(Asiento asiento) {
		// TODO Auto-generated method stub
		String sql = "UPDATE asientos SET hora_ocupacion = ? WHERE id_viaje = ? and id_pasajero = ?";
		jdbcTemplate.update(sql, asiento.getHoraOcupacion(), asiento.getIdViaje(), asiento.getIdPasajero());
		
		//Fetch asiento id
		sql = "SELECT id_viaje, id_pasajero, hora_ocupacion FROM asiento WHERE id_viaje = ? and id_pasajero = ?";
		RowMapper<Asiento> rowMapper = new BeanPropertyRowMapper<Asiento>(Asiento.class);
		Asiento updatedAsiento = jdbcTemplate.queryForObject(sql, rowMapper, asiento.getIdViaje(), asiento.getIdPasajero());
						
		//Set asiento id 
		return updatedAsiento;
	}

	@Override
	public void deleteAsiento(Integer idViaje, Integer idPasajero) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM articles WHERE id_viaje = ? and id_pasajero = ?";
		jdbcTemplate.update(sql, idViaje, idPasajero);
	}

}
