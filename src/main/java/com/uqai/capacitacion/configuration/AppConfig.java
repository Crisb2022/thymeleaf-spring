package com.uqai.capacitacion.configuration;

import com.uqai.capacitacion.models.Item;
import com.uqai.capacitacion.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("classpath:data.yml")
public class AppConfig {

    /**
     * Bean ("default") -> toma el bean con un alias por defecto para usar por el @Qualifier
     * Primary -> Toma al bean como primaria cuando se esta registrando mas de un bean dentro del contenedor
     * Qualifier -> llama al metodo del bean que se esta registrando para ser llamado por los metodos del Autowired
     */

    @Bean("default")
    List<Item> itemInvoice() {
        Product product = Product.builder().id(1).name("Papitas 1").price(250L).build();
        Product product2 = Product.builder().id(1).name("Papitas 2").price(250L).build();
        Product product3 = Product.builder().id(1).name("Papitas 3").price(250L).build();
        return Arrays.asList(
                Item.builder().product(product).quantity(2).build(),
                Item.builder().product(product2).quantity(1).build(),
                Item.builder().product(product3).quantity(3).build()
        );
    }

//    @Primary
    @Bean
    List<Item> itemInvoiceChocolate() {
        Product product = Product.builder().id(1).name("Chocolate 1").price(12L).build();
        Product product2 = Product.builder().id(1).name("Chocolate 2").price(2L).build();
        Product product3 = Product.builder().id(1).name("Chocolate 3").price(25L).build();
        Product product4 = Product.builder().id(1).name("Chocolate 4").price(25L).build();
        Product product5 = Product.builder().id(1).name("Chocolate 5").price(25L).build();
        return Arrays.asList(
                Item.builder().product(product).quantity(2).build(),
                Item.builder().product(product2).quantity(1).build(),
                Item.builder().product(product3).quantity(3).build(),
                Item.builder().product(product4).quantity(4).build(),
                Item.builder().product(product5).quantity(5).build()
        );
    }

}
