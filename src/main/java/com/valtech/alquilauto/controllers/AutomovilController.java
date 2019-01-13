package com.valtech.alquilauto.controllers;

import com.valtech.alquilauto.entities.Automovil;
import com.valtech.alquilauto.entities.Automovil;
import com.valtech.alquilauto.services.IAutomovilService;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.MissingResourceException;
import java.util.UUID;

@RestController
@RequestMapping("automoviles")
public class AutomovilController {

    private static final Logger logger = LoggerFactory.getLogger(AutomovilController.class);

    @Autowired
    IAutomovilService automovilService;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findOne(@PathVariable UUID id) throws NotFoundException {
        logger.info("GET / Automovil id: " + id);
        try {
            Automovil automovil = automovilService.findOne(id);
            if(automovil == null){
                throw new NotFoundException("El Automovil no existe");
            }
            return new ResponseEntity<Automovil>(automovil, HttpStatus.OK);
        } catch (NotFoundException exc) {
            logger.info("Error en la busqueda. El Automovil no existe");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            logger.info("Error en la llamada al servicio : " + exception.getMessage());
            return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Automovil> findAll(){
        logger.info("GET / All Automoviles");
        return automovilService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addOne(@RequestBody Automovil automovil) throws EntityExistsException {
        logger.info("POST / Creacion de Automovil request: " + automovil.toString());
        try {
            Automovil auto = automovilService.findOneByPatente(automovil.getPatente());
            if(auto != null)
                throw new EntityExistsException("El automovil ya existe en la base de datos");
            return new ResponseEntity<Automovil>(automovilService.addOne(automovil), HttpStatus.CREATED);
        } catch (EntityExistsException exception) {
            logger.info(exception.getMessage());
            return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (MissingResourceException exception) {
            logger.info(exception.getMessage());
            return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            logger.info("Error en la llamada al servicio: " + exception.getMessage());
            return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
