package com.dionisio.dionisiofoodapi.service;

import com.dionisio.dionisiofoodapi.DionisioFoodAPI;
import com.dionisio.dionisiofoodapi.model.Cozinha;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class ConsultaCozinhaMain {

    public static void main(String[] args) {
        ApplicationContext appContext = new SpringApplicationBuilder(DionisioFoodAPI.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaService cozinhaService = appContext.getBean(CozinhaService.class);        
        for (Cozinha c : cozinhaService.listar()) {
            System.out.println("Nome: " + c.getNome());
        }
    }

}