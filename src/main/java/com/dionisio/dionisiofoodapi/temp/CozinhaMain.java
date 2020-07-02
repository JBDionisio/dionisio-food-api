package com.dionisio.dionisiofoodapi.temp;

import com.dionisio.dionisiofoodapi.DionisioFoodAPI;
import com.dionisio.dionisiofoodapi.domain.model.Cozinha;
import com.dionisio.dionisiofoodapi.domain.repository.CozinhaRepository;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class CozinhaMain {
    public static void main(String[] args) {
        ApplicationContext appContext = new SpringApplicationBuilder(DionisioFoodAPI.class)
        .web(WebApplicationType.NONE)
        .run(args);

        CozinhaRepository cozinhaService = appContext.getBean(CozinhaRepository.class);

        Cozinha c1 = new Cozinha();
        c1.setNome("Brasileira");

        Cozinha c2 = new Cozinha();
        c2.setNome("Japonesa");

        c1 = cozinhaService.salvar(c1);
        c2 = cozinhaService.salvar(c2);

        for (Cozinha c : cozinhaService.listar()) {
            System.out.println("Nome: " + c.getNome());
        }

        cozinhaService.remover(c2);

        for (Cozinha c : cozinhaService.listar()) {
            System.out.println("Nome: " + c.getNome());
        }
    }
}