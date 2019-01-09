package com.valtech.alquilauto.controllers;

import com.valtech.alquilauto.AlquilautoApplication;
import com.valtech.alquilauto.entities.Automovil;
import com.valtech.alquilauto.entities.Cliente;
import com.valtech.alquilauto.entities.Solicitud;
import com.valtech.alquilauto.services.ISolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SolicitudController {

    @Autowired
    ISolicitudService solicitudService;

    @Autowired
    AlquilautoApplication main;

    @RequestMapping(value = "/solicitudes", method = RequestMethod.GET)
    public Iterable<Solicitud> findAll(){
        return solicitudService.findAll();
    }

    @RequestMapping(value = "/automoviles", method = RequestMethod.GET)
    public Iterable<Automovil> findAllAutomoviles(){
        return solicitudService.findAllAutomoviles();
    }
//
//    @RequestMapping(value = "/solicitudes/{id}", method = RequestMethod.GET)
//    public ResponseEntity<?> findOne(@PathVariable Integer id){
//        try {
//            return new ResponseEntity<Solicitud>(solicitudService.findOne(id), HttpStatus.OK);
//        } catch (Exception exception) {
//            return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
    @RequestMapping(value = "/solicitudes", method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody Cliente cliente){
        try {
            Solicitud solicitud = solicitudService.addOne(cliente);
            main.getArraySolicitudes().add(solicitud);
            return new ResponseEntity<Solicitud>(solicitud, HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//
//    @RequestMapping(value = "/solicitudes/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<?> update(@RequestBody Solicitud solicitud, @PathVariable Integer id){
//
//        if(solicitudService.findOne(id) == null){
//            return new ResponseEntity(solicitud, HttpStatus.NOT_FOUND);
//        }
//        try {
//            solicitudService.updateOne(solicitud);
//            return new ResponseEntity<Solicitud>(solicitud, HttpStatus.OK);
//        } catch (Exception exception) {
//            return new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
