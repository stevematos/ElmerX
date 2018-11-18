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

import edu.stsm.entity.Automovil;
import edu.stsm.service.IAutomovilService;

@RestController
@RequestMapping("/automovil")
public class AutomovilController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IAutomovilService automovilService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Automovil>> getAllAutomoviles() {
		logger.info("> getAllAutomoviles [Automovil]");

		List<Automovil> automovilList = null;
		try {
			automovilList = automovilService.getAllAutomoviles();
 
			if (automovilList == null) {
				automovilList = new ArrayList<Automovil>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Automovil>>(automovilList, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllAutomoviles [Automovil]");
		return new ResponseEntity<List<Automovil>>(automovilList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{idAutomovil}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Automovil> getAutomovilById(@PathVariable("idAutomovil") Integer idAutomovil){
		logger.info("> getAutomovilById [Automovil]");
		
		Automovil automovil = null;
		try {
			automovil = automovilService.getAutomovilById(idAutomovil);
 
			if (automovil == null) {
				automovil = new Automovil();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Automovil>(automovil, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< getAutomovilById [Automovil]");
		return new ResponseEntity<Automovil>(automovil, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Automovil> addAutomovil(@RequestBody Automovil automovil){
		logger.info("> addAutomovil [Automovil]");
		
		Automovil addedAutomovil = null;
		try {
			addedAutomovil = automovilService.addAutomovil(automovil);
 
			if (addedAutomovil == null) {
				addedAutomovil = new Automovil();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Automovil>(addedAutomovil, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< addAutomovil [Automovil]");
		return new ResponseEntity<Automovil>(addedAutomovil, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Automovil> updateAutomovil(@RequestBody Automovil automovil){
		logger.info("> updateAutomovil [Automovil]");
		
		Automovil updatedAutomovil = null;
		try {
			updatedAutomovil = automovilService.updateAutomovil(automovil);
 
			if (updatedAutomovil == null) {
				updatedAutomovil = new Automovil();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Automovil>(updatedAutomovil, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< updateAutomovil [Automovil]");
		return new ResponseEntity<Automovil>(updatedAutomovil, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{idAutomovil}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteAutomovil(@PathVariable("idAutomovil") Integer idAutomovil){
		logger.info("> deleteAutomovil [Automovil]");
		
		try {
			automovilService.deleteAutomovil(idAutomovil);
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< deleteAutomovil [Automovil]");
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
