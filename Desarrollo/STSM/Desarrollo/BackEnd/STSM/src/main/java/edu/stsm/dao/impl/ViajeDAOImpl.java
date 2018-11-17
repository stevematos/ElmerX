package edu.stsm.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.stsm.dao.IViajeDAO;
import edu.stsm.entity.Viaje;
import edu.stsm.entity.rowmapper.ViajeRowMapper;

@Transactional
@Repository
public class ViajeDAOImpl implements IViajeDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Viaje> getAllViajes() {
		// TODO Auto-generated method stub
		String sql = "SELECT id_viaje, inicio, fin, cupos, cupos_disponibles, en_curso, id_conductor, hora_partida FROM viaje";
        //RowMapper<Viaje> rowMapper = new BeanPropertyRowMapper<Viaje>(Viaje.class);
		RowMapper<Viaje> rowMapper = new ViajeRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Viaje getViajeById(Integer idViaje) {
		// TODO Auto-generated method stub
		String sql = "SELECT id_viaje, inicio, fin, cupos, cupos_disponibles, en_curso, id_conductor, hora_partida FROM viaje WHERE id_viaje = ?";
		RowMapper<Viaje> rowMapper = new BeanPropertyRowMapper<Viaje>(Viaje.class);
		Viaje viaje = jdbcTemplate.queryForObject(sql, rowMapper, idViaje);
		return viaje;
	}

	@Override
	public Viaje addViaje(Viaje viaje) {
		// TODO Auto-generated method stub
		//Add viaje
		String sql = "INSERT INTO viaje (id_viaje, inicio, fin, cupos, cupos_disponibles, en_curso, id_conductor, hora_partida) values (?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, viaje.getIdViaje(), viaje.getInicio(), viaje.getFin(), viaje.getCupos(), viaje.getCuposDisponibles(), viaje.getEnCurso(), viaje.getIdConductor(), viaje.getHoraPartida());
				
		//Fetch viaje id
		sql = "SELECT id_viaje, inicio, fin, cupos, cupos_disponibles, en_curso, id_conductor, hora_partida FROM viaje WHERE id_viaje = ?";
		Viaje addedViaje = jdbcTemplate.queryForObject(sql, Viaje.class, viaje.getIdViaje());
				
		//Set viaje id 
		return addedViaje;
	}

	@Override
	public Viaje updateViaje(Viaje viaje) {
		// TODO Auto-generated method stub
		String sql = "UPDATE viaje SET inicio = ?, fin = ?, cupos = ?, cupos_disponibles = ?, en_curso = ?, id_conductor = ?, hora_partida = ? WHERE id_viaje = ?";
		jdbcTemplate.update(sql, viaje.getInicio(), viaje.getFin(), viaje.getCupos(), viaje.getCuposDisponibles(), viaje.getEnCurso(), viaje.getIdConductor(), viaje.getHoraPartida(), viaje.getIdViaje());
		
		//Fetch viaje id
		sql = "SELECT id_viaje, modelo, asientos, soat FROM viaje WHERE id_viaje = ?";
		Viaje updatedViaje = jdbcTemplate.queryForObject(sql, Viaje.class, viaje.getIdViaje());
						
		//Set viaje id 
		return updatedViaje;
	}

	@Override
	public void deleteViaje(Integer idViaje) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM viaje WHERE id_viaje = ?";
		jdbcTemplate.update(sql, idViaje);
	}

}

