package io.dougluciano.poc.api_notas.API.notas.Fiscais.model.enums;

public enum ProductCategory {
    SERVICES("Serviços"),
    CABLES("Cabeamento"),
    PLUGS("Tomadas"),
    TUBIES("Conduites");


    private String value;

    ProductCategory(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
