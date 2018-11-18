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

import edu.stsm.entity.Facultad;
import edu.stsm.service.IFacultadService;

@RestController
@RequestMapping("/facultad")
public class FacultadController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IFacultadService facultadService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Facultad>> getAllFacultades() {
		logger.info("> getAllFacultades [Facultad]");

		List<Facultad> facultadList = null;
		try {
			facultadList = facultadService.getAllFacultades();
 
			if (facultadList == null) {
				facultadList = new ArrayList<Facultad>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Facultad>>(facultadList, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllFacultades [Facultad]");
		return new ResponseEntity<List<Facultad>>(facultadList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{idFacultad}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Facultad> getFacultadById(@PathVariable("idFacultad") Integer idFacultad){
		logger.info("> getFacultadById [Facultad]");
		
		Facultad facultad = null;
		try {
			facultad = facultadService.getFacultadById(idFacultad);
 
			if (facultad == null) {
				facultad = new Facultad();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Facultad>(facultad, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< getFacultadById [Facultad]");
		return new ResponseEntity<Facultad>(facultad, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Facultad> addFacultad(@RequestBody Facultad facultad){
		logger.info("> addFacultad [Facultad]");
		
		Facultad addedFacultad = null;
		try {
			addedFacultad = facultadService.addFacultad(facultad);
 
			if (addedFacultad == null) {
				addedFacultad = new Facultad();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Facultad>(addedFacultad, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< addFacultad [Facultad]");
		return new ResponseEntity<Facultad>(addedFacultad, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Facultad> updateFacultad(@RequestBody Facultad facultad){
		logger.info("> updateFacultad [Facultad]");
		
		Facultad updatedFacultad = null;
		try {
			updatedFacultad = facultadService.updateFacultad(facultad);
 
			if (updatedFacultad == null) {
				updatedFacultad = new Facultad();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Facultad>(updatedFacultad, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< updateFacultad [Facultad]");
		return new ResponseEntity<Facultad>(updatedFacultad, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{idFacultad}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteFacultad(@PathVariable("idFacultad") Integer idFacultad){
		logger.info("> deleteFacultad [Facultad]");
		
		try {
			facultadService.deleteFacultad(idFacultad);
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< deleteFacultad [Facultad]");
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}

