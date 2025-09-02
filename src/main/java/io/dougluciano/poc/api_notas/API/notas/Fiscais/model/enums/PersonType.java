package io.dougluciano.poc.api_notas.API.notas.Fiscais.model.enums;

public enum PersonType {
    PF("Pessoa Física"),
    PJ("Pessoa Jurídica");

    private String value;

    PersonType(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
