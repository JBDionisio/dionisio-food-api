package com.dionisio.dionisiofoodapi.temp;

import java.math.BigDecimal;

import com.dionisio.dionisiofoodapi.DionisioFoodAPI;
import com.dionisio.dionisiofoodapi.domain.model.Restaurante;
import com.dionisio.dionisiofoodapi.domain.repository.RestauranteRepository;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class RestauranteMain {
    public static void main(String[] args) {
        ApplicationContext appContext = new SpringApplicationBuilder(DionisioFoodAPI.class).web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository rService = appContext.getBean(RestauranteRepository.class);

        /* 
        Restaurante r1 = new Restaurante();
        r1.setNome("Habbibs");
        r1.setTaxaFrete(new BigDecimal(8.69));

        Restaurante r2 = new Restaurante();
        r2.setNome("Podrão");
        r2.setTaxaFrete(new BigDecimal(0.40));

        r1 = rService.salvar(r1);
        r2 = rService.salvar(r2);

        for (Restaurante c : rService.listar()) {
            System.out.println(c.getNome() + " : " + c.getTaxaFrete());
        }

        rService.remover(r2); 
        */

        for (Restaurante c : rService.listar()) {
            System.out.printf("%s - %.2f: %s\n", c.getNome(), c.getTaxaFrete(), c.getCozinha().getNome());
        }
    }
}