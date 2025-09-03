package io.dougluciano.poc.api_notas.API.notas.Fiscais.model.enums;

public enum InvoiceStatus {
    PENDING("Pendente"),
    PROCESSING("Em processamento"),
    DONE("Finalizada");

    private String value;

    InvoiceStatus(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
