package com.valtech.alquilauto.services.impl;

import com.valtech.alquilauto.daos.ClienteDAO;
import com.valtech.alquilauto.daos.PromocionDAO;
import com.valtech.alquilauto.entities.Alquiler;
import com.valtech.alquilauto.entities.Cliente;
import com.valtech.alquilauto.entities.Promocion;
import com.valtech.alquilauto.entities.Solicitud;
import com.valtech.alquilauto.services.IClienteService;
import com.valtech.alquilauto.services.IPromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Qualifier("promocionService")
public class PromocionServiceImpl implements IPromocionService {

    @Autowired
    PromocionDAO promocionDAO;

    @Autowired
    IClienteService clienteService;

    @Override
    public void calcularPromo(Solicitud solicitud) {

        Alquiler alquiler = solicitud.getAlquiler();
        Double costoFinal = alquiler.getCostoFinal();

        if(alquiler.isAplicarPromo()){
            List<Promocion> promos = solicitud.getCliente().getPromociones();
            Double mejorPromo = costoFinal;
            Promocion promoAplicada = null;

            if(promos != null) {
                for (Promocion promo : promos) {
                    if(promo.aplicarPromo(costoFinal) < mejorPromo){
                        mejorPromo = promo.aplicarPromo(costoFinal);
                        promoAplicada = promo;
                    }
                }
            }

            costoFinal = mejorPromo;
            alquiler.setCostoFinal(costoFinal);

            if(promoAplicada != null){
                promos.remove(promoAplicada);
            }
        }
    }

    @Override
    public Promocion addOne(Promocion promocion) {
        return promocionDAO.addOne(promocion);
    }

    @Override
    public List<Promocion> findAll() {
        return promocionDAO.findAll();
    }

    @Override
    public Promocion findOne(UUID promocionId) {
        return promocionDAO.findOne(promocionId);
    }

    @Override
    public List<Promocion> addPromoToCliente(Promocion promocion, Cliente cliente) {
        List<Promocion> promocionesCliente = cliente.getPromociones();

        if(cliente.getPromociones() != null){
            promocionesCliente.add(promocion);
        } else {
            cliente.setPromociones(new ArrayList<>());
            cliente.getPromociones().add(promocion);
        }

        return cliente.getPromociones();
    }
}
