package com.arthurezeagbo.paymentprocessor.dto;


public class PaymentResponseDto {

    private boolean status;
    private String message;
    Data DataObject;

    public boolean getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Data getData() {
        return DataObject;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Data dataObject) {
        this.DataObject = dataObject;
    }
}

class Data {
    private String authorization_url;
    private String access_code;
    private String reference;

    public String getAuthorization_url() {
        return authorization_url;
    }

    public String getAccess_code() {
        return access_code;
    }

    public String getReference() {
        return reference;
    }

    public void setAuthorization_url(String authorization_url) {
        this.authorization_url = authorization_url;
    }

    public void setAccess_code(String access_code) {
        this.access_code = access_code;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
