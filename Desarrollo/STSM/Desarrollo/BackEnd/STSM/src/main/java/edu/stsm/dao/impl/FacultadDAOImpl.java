package edu.stsm.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.stsm.dao.IFacultadDAO;
import edu.stsm.entity.Facultad;
import edu.stsm.entity.rowmapper.FacultadRowMapper;

@Transactional
@Repository
public class FacultadDAOImpl implements IFacultadDAO {
	
	@Autowired	
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Facultad> getAllFacultads() {
		// TODO Auto-generated method stub
		String sql = "SELECT id_facultad, nombre FROM facultad";
        //RowMapper<Facultad> rowMapper = new BeanPropertyRowMapper<Facultad>(Facultad.class);
		RowMapper<Facultad> rowMapper = new FacultadRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Facultad getFacultadById(Integer idFacultad) {
		// TODO Auto-generated method stub
		String sql = "SELECT id_facultad, nombre FROM facultad WHERE id_facultad = ?";
		RowMapper<Facultad> rowMapper = new BeanPropertyRowMapper<Facultad>(Facultad.class);
		Facultad facultad = jdbcTemplate.queryForObject(sql, rowMapper, idFacultad);
		return facultad;
	}

	@Override
	public Facultad addFacultad(Facultad facultad) {
		// TODO Auto-generated method stub
		//Add facultad
		String sql = "INSERT INTO facultad (id_facultad, nombre) values (?, ?)";
		jdbcTemplate.update(sql, facultad.getIdFacultad(), facultad.getNombre());
				
		//Fetch facultad id
		sql = "SELECT id_facultad, nombre FROM facultad WHERE id_facultad = ?";
		Facultad addedFacultad = jdbcTemplate.queryForObject(sql, Facultad.class, facultad.getIdFacultad());
				
		//Set facultad id 
		return addedFacultad;
	}

	@Override
	public Facultad updateFacultad(Facultad facultad) {
		// TODO Auto-generated method stub
		String sql = "UPDATE facultad SET nombre = ? WHERE id_facultad = ?";
		jdbcTemplate.update(sql, facultad.getNombre(), facultad.getIdFacultad());
		
		//Fetch facultad id
		sql = "SELECT id_facultad, modelo, asientos, soat FROM facultad WHERE id_facultad = ?";
		Facultad updatedFacultad = jdbcTemplate.queryForObject(sql, Facultad.class, facultad.getIdFacultad());
						
		//Set facultad id 
		return updatedFacultad;
	}

	@Override
	public void deleteFacultad(Integer idFacultad) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM facultad WHERE id_facultad = ?";
		jdbcTemplate.update(sql, idFacultad);
	}

}

