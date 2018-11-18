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

import edu.stsm.entity.Asiento;
import edu.stsm.service.IAsientoService;

@RestController
@RequestMapping("/asiento")
public class AsientoController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IAsientoService asientoService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Asiento>> getAllAsientos() {
		logger.info("> getAllAsientoes [Asiento]");

		List<Asiento> asientoList = null;
		try {
			asientoList = asientoService.getAllAsientos();
 
			if (asientoList == null) {
				asientoList = new ArrayList<Asiento>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Asiento>>(asientoList, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllAsientoes [Asiento]");
		return new ResponseEntity<List<Asiento>>(asientoList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{idViaje}/{idPasajero}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Asiento> getAsientoById(@PathVariable("idViaje") Integer idViaje, @PathVariable("idPasajero") Integer idPasajero){
		logger.info("> getAsientoById [Asiento]");
		
		Asiento asiento = null;
		try {
			asiento = asientoService.getAsientoById(idViaje, idPasajero);
 
			if (asiento == null) {
				asiento = new Asiento();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Asiento>(asiento, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< getAsientoById [Asiento]");
		return new ResponseEntity<Asiento>(asiento, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Asiento> addAsiento(@RequestBody Asiento asiento){
		logger.info("> addAsiento [Asiento]");
		
		Asiento addedAsiento = null;
		try {
			addedAsiento = asientoService.addAsiento(asiento);
 
			if (addedAsiento == null) {
				addedAsiento = new Asiento();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Asiento>(addedAsiento, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< addAsiento [Asiento]");
		return new ResponseEntity<Asiento>(addedAsiento, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Asiento> updateAsiento(@RequestBody Asiento asiento){
		logger.info("> updateAsiento [Asiento]");
		
		Asiento updatedAsiento = null;
		try {
			updatedAsiento = asientoService.updateAsiento(asiento);
 
			if (updatedAsiento == null) {
				updatedAsiento = new Asiento();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Asiento>(updatedAsiento, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< updateAsiento [Asiento]");
		return new ResponseEntity<Asiento>(updatedAsiento, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{idViaje}/{idPasajero}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteAsiento(@PathVariable("idViaje") Integer idViaje, @PathVariable("idPasajero") Integer idPasajero){
		logger.info("> deleteAsiento [Asiento]");
		
		try {
			asientoService.deleteAsiento(idViaje, idPasajero);
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< deleteAsiento [Asiento]");
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
