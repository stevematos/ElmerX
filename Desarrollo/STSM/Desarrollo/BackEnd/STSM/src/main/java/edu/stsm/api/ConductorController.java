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

import edu.stsm.entity.Conductor;
import edu.stsm.service.IConductorService;

@RestController
@RequestMapping("/conductor")
public class ConductorController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IConductorService conductorService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Conductor>> getAllConductores() {
		logger.info("> getAllConductores [Conductor]");

		List<Conductor> conductorList = null;
		try {
			conductorList = conductorService.getAllConductores();
 
			if (conductorList == null) {
				conductorList = new ArrayList<Conductor>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Conductor>>(conductorList, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllConductores [Conductor]");
		return new ResponseEntity<List<Conductor>>(conductorList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{idConductor}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Conductor> getConductorById(@PathVariable("idConductor") Integer idConductor){
		logger.info("> getConductorById [Conductor]");
		
		Conductor conductor = null;
		try {
			conductor = conductorService.getConductorById(idConductor);
 
			if (conductor == null) {
				conductor = new Conductor();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Conductor>(conductor, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< getConductorById [Conductor]");
		return new ResponseEntity<Conductor>(conductor, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Conductor> addConductor(@RequestBody Conductor conductor){
		logger.info("> addConductor [Conductor]");
		
		Conductor addedConductor = null;
		try {
			addedConductor = conductorService.addConductor(conductor);
 
			if (addedConductor == null) {
				addedConductor = new Conductor();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Conductor>(addedConductor, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< addConductor [Conductor]");
		return new ResponseEntity<Conductor>(addedConductor, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Conductor> updateConductor(@RequestBody Conductor conductor){
		logger.info("> updateConductor [Conductor]");
		
		Conductor updatedConductor = null;
		try {
			updatedConductor = conductorService.updateConductor(conductor);
 
			if (updatedConductor == null) {
				updatedConductor = new Conductor();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Conductor>(updatedConductor, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< updateConductor [Conductor]");
		return new ResponseEntity<Conductor>(updatedConductor, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{idConductor}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteConductor(@PathVariable("idConductor") Integer idConductor){
		logger.info("> deleteConductor [Conductor]");
		
		try {
			conductorService.deleteConductor(idConductor);
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< deleteConductor [Conductor]");
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
