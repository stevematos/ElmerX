package edu.stsm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.stsm.dao.IPasajeroDAO;
import edu.stsm.entity.Pasajero;
import edu.stsm.service.IPasajeroService;

@Service
public class PasajeroServiceImpl implements IPasajeroService{

	@Autowired
	private IPasajeroDAO pasajeroDAO;
	
	@Override
	public List<Pasajero> getAllPasajeros() {
		// TODO Auto-generated method stub
		List<Pasajero> pasajeroList = pasajeroDAO.getAllPasajeros();
		return pasajeroList;
	}

	@Override
	public Pasajero getPasajeroById(Integer idPasajero) {
		// TODO Auto-generated method stub
		Pasajero pasajero = pasajeroDAO.getPasajeroById(idPasajero);
		return pasajero;
	}

	@Override
	public Pasajero addPasajero(Pasajero pasajero) {
		// TODO Auto-generated method stub
		Pasajero addedPasajero = pasajeroDAO.addPasajero(pasajero);
		return addedPasajero;
	}

	@Override
	public Pasajero updatePasajero(Pasajero pasajero) {
		// TODO Auto-generated method stub
		Pasajero updatedPasajero = pasajeroDAO.updatePasajero(pasajero);
		return updatedPasajero;
	}

	@Override
	public void deletePasajero(Integer idPasajero) {
		// TODO Auto-generated method stub
		pasajeroDAO.deletePasajero(idPasajero);
	}

}
