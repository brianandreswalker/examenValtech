package com.valtech.alquilauto.controllers;

import com.valtech.alquilauto.entities.Cliente;
import com.valtech.alquilauto.entities.Promocion;
import com.valtech.alquilauto.services.IClienteService;
import com.valtech.alquilauto.services.IPromocionService;
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
@RequestMapping("clientes")
public class ClienteController {

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    IClienteService clienteService;

    @Autowired
    IPromocionService promocionService;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findOne(@PathVariable UUID id){
        logger.info("GET / cliente id: " + id);
        try {
            Cliente cliente = clienteService.findOne(id);
            if(cliente == null)
                throw new NotFoundException("El cliente no existe");
            return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
        } catch (NotFoundException exc) {
            logger.info("Error en la busqueda. El cliente no existe");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addOne(@RequestBody Cliente cliente) throws EntityExistsException {
        logger.info("POST / Creacion de Cliente request: " + cliente.toString());
        try {
            Cliente cli = clienteService.findOneByDni(cliente.getDniCliente());
            if(cli != null)
                throw new EntityExistsException("El cliente ya existe en la base de datos");
            return new ResponseEntity<Cliente>(clienteService.addOne(cliente), HttpStatus.CREATED);
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

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Cliente> findAll(){
        logger.info("GET / All Automoviles");
        return clienteService.findAll();
    }

    @RequestMapping(value = "/{id}/promociones", method = RequestMethod.GET)
    public ResponseEntity<?> findPromociones(@PathVariable String id) throws NotFoundException{
        logger.info("GET / promociones del Cliente id: " + id);
        try {
            Cliente cliente = clienteService.findOne(UUID.fromString(id));
            if(cliente == null)
                throw new NotFoundException("El Cliente no existe");
            return new ResponseEntity<>(cliente.getPromociones(), HttpStatus.OK);
        } catch (NotFoundException exc) {
            logger.info("Error en la busqueda. El Cliente no existe");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }catch (Exception exception) {
            logger.info("Error en la llamada al servicio: " + exception.getMessage());
            return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}/solicitudes", method = RequestMethod.GET)
    public ResponseEntity<?> findSolicitudes(@PathVariable String id) throws NotFoundException{
        logger.info("GET / solicitudes del Cliente id: " + id);
        try {
            Cliente cliente = clienteService.findOne(UUID.fromString(id));
            if(cliente == null)
                throw new NotFoundException("El Cliente no existe");
            return new ResponseEntity<>(cliente.getSolicitudes(), HttpStatus.OK);
        } catch (NotFoundException exc) {
            logger.info("Error en la busqueda. El Cliente no existe");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            logger.info("Error en la llamada al servicio: " + exception.getMessage());
            return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}/promociones/{idPromo}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable String id, @PathVariable String idPromo) throws NotFoundException, EntityExistsException {
        logger.info("PUT / asignacion de la promocion id: " + idPromo +  " al cliente id: " + id);
            try {
                Promocion promo = promocionService.findOne(UUID.fromString(idPromo));
                Cliente cliente = clienteService.findOne(UUID.fromString(id));
                if(promo == null || cliente == null)
                    throw new NotFoundException("El Cliente o la Promocion no existen");
                return new ResponseEntity<>(promocionService.addPromoToCliente(promo, cliente), HttpStatus.OK);
            } catch (NotFoundException exc) {
                logger.info("Error en la busqueda. El Cliente o la Promocion no existen");
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            } catch (EntityExistsException exception) {
                logger.info(exception.getMessage());
                return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            } catch (MissingResourceException exception) {
                logger.info(exception.getMessage());
                return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
            }  catch (Exception exception) {
                logger.info("Error en la llamada al servicio: " + exception.getMessage());
                return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

}
