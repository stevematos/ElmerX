package edu.stsm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.stsm.dao.IAutomovilDAO;
import edu.stsm.entity.Automovil;
import edu.stsm.service.IAutomovilService;

@Service
public class AutomovilServiceImpl implements IAutomovilService{

	@Autowired
	private IAutomovilDAO automovilDAO;
	
	@Override
	public List<Automovil> getAllAutomovils() {
		// TODO Auto-generated method stub
		List<Automovil> automovilList = automovilDAO.getAllAutomovils();
		return automovilList;
	}

	@Override
	public Automovil getAutomovilById(Integer idAutomovil) {
		// TODO Auto-generated method stub
		Automovil automovil = automovilDAO.getAutomovilById(idAutomovil);
		return automovil;
	}

	@Override
	public Automovil addAutomovil(Automovil automovil) {
		// TODO Auto-generated method stub
		Automovil addedAutomovil = automovilDAO.addAutomovil(automovil);
		return addedAutomovil;
	}

	@Override
	public Automovil updateAutomovil(Automovil automovil) {
		// TODO Auto-generated method stub
		Automovil updatedAutomovil = automovilDAO.updateAutomovil(automovil);
		return updatedAutomovil;
	}

	@Override
	public void deleteAutomovil(Integer idAutomovil) {
		// TODO Auto-generated method stub
		automovilDAO.deleteAutomovil(idAutomovil);
	}

}
