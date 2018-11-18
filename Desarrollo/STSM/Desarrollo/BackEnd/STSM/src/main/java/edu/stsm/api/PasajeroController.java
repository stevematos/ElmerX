package edu.stsm.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.stsm.entity.Pasajero;
import edu.stsm.service.IPasajeroService;

@RestController
@RequestMapping("/pasajero")
public class PasajeroController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IPasajeroService pasajeroService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pasajero>> getAllPasajeros() {
		logger.info("> getAllPasajeroes [Pasajero]");

		List<Pasajero> pasajeroList = null;
		try {
			pasajeroList = pasajeroService.getAllPasajeros();
 
			if (pasajeroList == null) {
				pasajeroList = new ArrayList<Pasajero>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Pasajero>>(pasajeroList, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllPasajeroes [Pasajero]");
		return new ResponseEntity<List<Pasajero>>(pasajeroList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{idPasajero}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pasajero> getPasajeroById(@PathVariable("idPasajero") Integer idPasajero){
		logger.info("> getPasajeroById [Pasajero]");
		
		Pasajero pasajero = null;
		try {
			pasajero = pasajeroService.getPasajeroById(idPasajero);
 
			if (pasajero == null) {
				pasajero = new Pasajero();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Pasajero>(pasajero, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< getPasajeroById [Pasajero]");
		return new ResponseEntity<Pasajero>(pasajero, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pasajero> addPasajero(@RequestBody Pasajero pasajero){
		logger.info("> addPasajero [Pasajero]");
		
		Pasajero addedPasajero = null;
		try {
			addedPasajero = pasajeroService.addPasajero(pasajero);
 
			if (addedPasajero == null) {
				addedPasajero = new Pasajero();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Pasajero>(addedPasajero, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< addPasajero [Pasajero]");
		return new ResponseEntity<Pasajero>(addedPasajero, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pasajero> updatePasajero(@RequestBody Pasajero pasajero){
		logger.info("> updatePasajero [Pasajero]");
		
		Pasajero updatedPasajero = null;
		try {
			updatedPasajero = pasajeroService.updatePasajero(pasajero);
 
			if (updatedPasajero == null) {
				updatedPasajero = new Pasajero();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Pasajero>(updatedPasajero, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< updatePasajero [Pasajero]");
		return new ResponseEntity<Pasajero>(updatedPasajero, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{idPasajero}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deletePasajero(@PathVariable("idPasajero") Integer idPasajero){
		logger.info("> deletePasajero [Pasajero]");
		
		try {
			pasajeroService.deletePasajero(idPasajero);
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< deletePasajero [Pasajero]");
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}


