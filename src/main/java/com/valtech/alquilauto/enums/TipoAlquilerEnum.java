package com.valtech.alquilauto.enums;

public enum TipoAlquilerEnum {

    POR_HORA(1L, "Alquiler por Hora"),
    POR_KMS(2L, "Alquiler por Kilómetros"),
    POR_SEMANA(3L, "Alquiler por Semana"),
    PROMOCIONAL(4L, "Alquiler Promocional");

    private TipoAlquilerEnum(Long id, String descripcion){
        this.id = id;
        this.descripcion = descripcion;
    }

    private Long id;
    private String descripcion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean existsTipoAlquiler(Long id){
        if (id.equals(POR_HORA.getId()) || id.equals(POR_KMS.getId()) || id.equals(POR_SEMANA.getId()) || id.equals(PROMOCIONAL.getId())){
            return true;
        } else {
            return false;
        }
    }

}
