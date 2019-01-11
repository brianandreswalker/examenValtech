package com.valtech.alquilauto.controllers;

import com.valtech.alquilauto.entities.Promocion;
import com.valtech.alquilauto.services.IPromocionService;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("promociones")
public class PromocionController {

    private static final Logger logger = LoggerFactory.getLogger(PromocionController.class);

    @Autowired
    IPromocionService promocionService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addOne(@RequestBody Promocion promocion){
        logger.info("POST / Creacion de la Promocion request: " + promocion);
        try {
            promocionService.addOne(promocion);
            return new ResponseEntity<Promocion>(promocion, HttpStatus.CREATED);
        } catch (Exception exception) {
            logger.info("Error en la busqueda: " + exception.getMessage());
            return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findOne(@PathVariable UUID id) throws NotFoundException {
        logger.info("GET / Promocion id: " + id);
        try {
            Promocion promocion = promocionService.findOne(id);
            if(promocion == null)
                throw new NotFoundException("La Promocion no existe");
            return new ResponseEntity<Promocion>(promocion, HttpStatus.OK);
        } catch (NotFoundException exc) {
            logger.info("Error en la busqueda. La Promocion no existe");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            logger.info("Error en la llamada al servicio: " + exception.getMessage());
            return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Promocion> findAll(){
        logger.info("GET / All Promociones");
        return promocionService.findAll();
    }

}
