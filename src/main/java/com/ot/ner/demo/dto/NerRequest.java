package com.ot.ner.demo.dto;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class NerRequest {


    @NotNull
    @Valid
    public String data ;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


}
