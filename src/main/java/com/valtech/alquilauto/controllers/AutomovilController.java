package com.valtech.alquilauto.controllers;

import com.valtech.alquilauto.entities.Automovil;
import com.valtech.alquilauto.responses.BaseResponse;
import com.valtech.alquilauto.services.IAutomovilService;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("automoviles")
public class AutomovilController {

    private static final Logger logger = LoggerFactory.getLogger(AutomovilController.class);

    @Autowired
    IAutomovilService automovilService;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findOne(@PathVariable Long id) throws NotFoundException {
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


}
