package edu.stsm.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.stsm.dao.IAutomovilDAO;
import edu.stsm.entity.Automovil;
import edu.stsm.entity.rowmapper.AutomovilRowMapper;

@Transactional
@Repository
public class AutomovilDAOImpl implements IAutomovilDAO {
	
	@Autowired
	
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Automovil> getAllAutomovils() {
		// TODO Auto-generated method stub
		String sql = "SELECT id_automovil, modelo, asientos, soat FROM automovil";
        //RowMapper<Automovil> rowMapper = new BeanPropertyRowMapper<Automovil>(Automovil.class);
		RowMapper<Automovil> rowMapper = new AutomovilRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Automovil getAutomovilById(Integer idAutomovil) {
		// TODO Auto-generated method stub
		String sql = "SELECT id_automovil, modelo, asientos, soat FROM automovil WHERE id_automovil = ?";
		RowMapper<Automovil> rowMapper = new BeanPropertyRowMapper<Automovil>(Automovil.class);
		Automovil automovil = jdbcTemplate.queryForObject(sql, rowMapper, idAutomovil);
		return automovil;
	}

	@Override
	public Automovil addAutomovil(Automovil automovil) {
		// TODO Auto-generated method stub
		//Add automovil
		String sql = "INSERT INTO automovil (id_automovil, modelo, asientos, soat) values (?, ?, ?, ?)";
		jdbcTemplate.update(sql, automovil.getIdAutomovil(), automovil.getModelo(), automovil.getAsientos(), automovil.getSoat());
				
		//Fetch automovil id
		sql = "SELECT id_automovil, modelo, asientos, soat FROM automovil WHERE id_automovil = ?";
		Automovil addedAutomovil = jdbcTemplate.queryForObject(sql, Automovil.class, automovil.getIdAutomovil());
				
		//Set automovil id 
		return addedAutomovil;
	}

	@Override
	public Automovil updateAutomovil(Automovil automovil) {
		// TODO Auto-generated method stub
		String sql = "UPDATE automovil SET modelo = ?, asientos = ?, soat = ? WHERE id_automovil = ?";
		jdbcTemplate.update(sql, automovil.getModelo(), automovil.getAsientos(), automovil.getSoat(), automovil.getIdAutomovil());
		
		//Fetch automovil id
		sql = "SELECT id_automovil, modelo, asientos, soat FROM automovil WHERE id_automovil = ?";
		Automovil updatedAutomovil = jdbcTemplate.queryForObject(sql, Automovil.class, automovil.getIdAutomovil());
						
		//Set automovil id 
		return updatedAutomovil;
	}

	@Override
	public void deleteAutomovil(Integer idAutomovil) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM automovil WHERE id_automovil = ?";
		jdbcTemplate.update(sql, idAutomovil);
	}

}

