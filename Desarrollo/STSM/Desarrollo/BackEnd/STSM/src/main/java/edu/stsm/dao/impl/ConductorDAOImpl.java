package edu.stsm.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.stsm.dao.IConductorDAO;
import edu.stsm.entity.Conductor;
import edu.stsm.entity.rowmapper.ConductorRowMapper;

@Transactional
@Repository
public class ConductorDAOImpl implements IConductorDAO {
	
	@Autowired	
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Conductor> getAllConductores() {
		// TODO Auto-generated method stub
		String sql = "SELECT id_conductor, id_usuario, id_automovil, licencia FROM conductor";
        //RowMapper<Conductor> rowMapper = new BeanPropertyRowMapper<Conductor>(Conductor.class);
		RowMapper<Conductor> rowMapper = new ConductorRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Conductor getConductorById(Integer idConductor) {
		// TODO Auto-generated method stub
		String sql = "SELECT id_conductor, id_usuario, id_automovil, licencia FROM conductor WHERE id_conductor = ?";
		RowMapper<Conductor> rowMapper = new BeanPropertyRowMapper<Conductor>(Conductor.class);
		Conductor conductor = jdbcTemplate.queryForObject(sql, rowMapper, idConductor);
		return conductor;
	}

	@Override
	public Conductor addConductor(Conductor conductor) {
		// TODO Auto-generated method stub
		//Add conductor
		String sql = "INSERT INTO conductor (id_conductor, id_usuario, id_automovil, licencia) values (?, ?, ?, ?)";
		jdbcTemplate.update(sql, conductor.getIdConductor(), conductor.getIdUsuario(), conductor.getIdAutomovil(), conductor.getLicencia());
				
		//Fetch conductor id
		sql = "SELECT id_conductor, id_usuario, id_automovil, licencia FROM conductor WHERE id_conductor = ?";
		RowMapper<Conductor> rowMapper = new BeanPropertyRowMapper<Conductor>(Conductor.class);
		Conductor addedConductor = jdbcTemplate.queryForObject(sql, rowMapper, conductor.getIdConductor());
				
		//Set conductor id 
		return addedConductor;
	}

	@Override
	public Conductor updateConductor(Conductor conductor) {
		// TODO Auto-generated method stub
		String sql = "UPDATE conductor SET id_usuario = ?, id_automovil = ?, licencia = ? WHERE id_conductor = ?";
		jdbcTemplate.update(sql, conductor.getIdUsuario(), conductor.getIdAutomovil(), conductor.getLicencia(), conductor.getIdConductor());
		
		//Fetch conductor id
		sql = "SELECT id_conductor, id_usuario, id_automovil, licencia WHERE id_conductor = ?";
		RowMapper<Conductor> rowMapper = new BeanPropertyRowMapper<Conductor>(Conductor.class);
		Conductor updatedConductor = jdbcTemplate.queryForObject(sql, rowMapper, conductor.getIdConductor());
						
		//Set conductor id 
		return updatedConductor;
	}

	@Override
	public void deleteConductor(Integer idConductor) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM conductor WHERE id_conductor = ?";
		jdbcTemplate.update(sql, idConductor);
	}

}
