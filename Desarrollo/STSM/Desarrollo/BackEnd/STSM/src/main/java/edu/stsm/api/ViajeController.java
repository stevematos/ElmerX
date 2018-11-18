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

import edu.stsm.entity.Viaje;
import edu.stsm.service.IViajeService;

@RestController
@RequestMapping("/viaje")
public class ViajeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IViajeService viajeService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Viaje>> getAllViajes() {
		logger.info("> getAllViajees [Viaje]");

		List<Viaje> viajeList = null;
		try {
			viajeList = viajeService.getAllViajes();
 
			if (viajeList == null) {
				viajeList = new ArrayList<Viaje>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Viaje>>(viajeList, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllViajees [Viaje]");
		return new ResponseEntity<List<Viaje>>(viajeList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{idViaje}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Viaje> getViajeById(@PathVariable("idViaje") Integer idViaje){
		logger.info("> getViajeById [Viaje]");
		
		Viaje viaje = null;
		try {
			viaje = viajeService.getViajeById(idViaje);
 
			if (viaje == null) {
				viaje = new Viaje();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Viaje>(viaje, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< getViajeById [Viaje]");
		return new ResponseEntity<Viaje>(viaje, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Viaje> addViaje(@RequestBody Viaje viaje){
		logger.info("> addViaje [Viaje]");
		
		Viaje addedViaje = null;
		try {
			addedViaje = viajeService.addViaje(viaje);
 
			if (addedViaje == null) {
				addedViaje = new Viaje();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Viaje>(addedViaje, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< addViaje [Viaje]");
		return new ResponseEntity<Viaje>(addedViaje, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Viaje> updateViaje(@RequestBody Viaje viaje){
		logger.info("> updateViaje [Viaje]");
		
		Viaje updatedViaje = null;
		try {
			updatedViaje = viajeService.updateViaje(viaje);
 
			if (updatedViaje == null) {
				updatedViaje = new Viaje();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Viaje>(updatedViaje, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< updateViaje [Viaje]");
		return new ResponseEntity<Viaje>(updatedViaje, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{idViaje}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteViaje(@PathVariable("idViaje") Integer idViaje){
		logger.info("> deleteViaje [Viaje]");
		
		try {
			viajeService.deleteViaje(idViaje);
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< deleteViaje [Viaje]");
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}