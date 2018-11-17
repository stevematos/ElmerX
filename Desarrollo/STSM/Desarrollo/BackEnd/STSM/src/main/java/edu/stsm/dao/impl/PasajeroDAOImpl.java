package edu.stsm.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.stsm.dao.IPasajeroDAO;
import edu.stsm.entity.Pasajero;
import edu.stsm.entity.rowmapper.PasajeroRowMapper;

@Transactional
@Repository
public class PasajeroDAOImpl implements IPasajeroDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Pasajero> getAllPasajeros() {
		// TODO Auto-generated method stub
		String sql = "SELECT id_pasajero, id_usuario FROM pasajero";
        //RowMapper<Pasajero> rowMapper = new BeanPropertyRowMapper<Pasajero>(Pasajero.class);
		RowMapper<Pasajero> rowMapper = new PasajeroRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Pasajero getPasajeroById(Integer idPasajero) {
		// TODO Auto-generated method stub
		String sql = "SELECT id_pasajero, id_usuario FROM pasajero WHERE id_pasajero = ?";
		RowMapper<Pasajero> rowMapper = new BeanPropertyRowMapper<Pasajero>(Pasajero.class);
		Pasajero pasajero = jdbcTemplate.queryForObject(sql, rowMapper, idPasajero);
		return pasajero;
	}

	@Override
	public Pasajero addPasajero(Pasajero pasajero) {
		// TODO Auto-generated method stub
		//Add pasajero
		String sql = "INSERT INTO pasajero (id_pasajero, id_usuario) values (?, ?)";
		jdbcTemplate.update(sql, pasajero.getIdPasajero(), pasajero.getIdUsuario());
				
		//Fetch pasajero id
		sql = "SELECT id_pasajero, modelo, asientos, soat FROM pasajero WHERE id_pasajero = ?";
		Pasajero addedPasajero = jdbcTemplate.queryForObject(sql, Pasajero.class, pasajero.getIdPasajero());
				
		//Set pasajero id 
		return addedPasajero;
	}

	@Override
	public Pasajero updatePasajero(Pasajero pasajero) {
		// TODO Auto-generated method stub
		String sql = "UPDATE pasajero SET id_usuario = ? WHERE id_pasajero = ?";
		jdbcTemplate.update(sql, pasajero.getIdUsuario(), pasajero.getIdPasajero());
		
		//Fetch pasajero id
		sql = "SELECT id_pasajero, modelo, asientos, soat FROM pasajero WHERE id_pasajero = ?";
		Pasajero updatedPasajero = jdbcTemplate.queryForObject(sql, Pasajero.class, pasajero.getIdPasajero());
						
		//Set pasajero id 
		return updatedPasajero;
	}

	@Override
	public void deletePasajero(Integer idPasajero) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM pasajero WHERE id_pasajero = ?";
		jdbcTemplate.update(sql, idPasajero);
	}

}

