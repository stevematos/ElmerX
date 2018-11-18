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

import edu.stsm.entity.Usuario;
import edu.stsm.service.IUsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> getAllUsuarios() {
		logger.info("> getAllUsuarioes [Usuario]");

		List<Usuario> usuarioList = null;
		try {
			usuarioList = usuarioService.getAllUsuarios();
 
			if (usuarioList == null) {
				usuarioList = new ArrayList<Usuario>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Usuario>>(usuarioList, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllUsuarioes [Usuario]");
		return new ResponseEntity<List<Usuario>>(usuarioList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{idUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable("idUsuario") Integer idUsuario){
		logger.info("> getUsuarioById [Usuario]");
		
		Usuario usuario = null;
		try {
			usuario = usuarioService.getUsuarioById(idUsuario);
 
			if (usuario == null) {
				usuario = new Usuario();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Usuario>(usuario, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< getUsuarioById [Usuario]");
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario){
		logger.info("> addUsuario [Usuario]");
		
		Usuario addedUsuario = null;
		try {
			addedUsuario = usuarioService.addUsuario(usuario);
 
			if (addedUsuario == null) {
				addedUsuario = new Usuario();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Usuario>(addedUsuario, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< addUsuario [Usuario]");
		return new ResponseEntity<Usuario>(addedUsuario, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario){
		logger.info("> updateUsuario [Usuario]");
		
		Usuario updatedUsuario = null;
		try {
			updatedUsuario = usuarioService.updateUsuario(usuario);
 
			if (updatedUsuario == null) {
				updatedUsuario = new Usuario();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Usuario>(updatedUsuario, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< updateUsuario [Usuario]");
		return new ResponseEntity<Usuario>(updatedUsuario, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{idUsuario}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteUsuario(@PathVariable("idUsuario") Integer idUsuario){
		logger.info("> deleteUsuario [Usuario]");
		
		try {
			usuarioService.deleteUsuario(idUsuario);
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< deleteUsuario [Usuario]");
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}

