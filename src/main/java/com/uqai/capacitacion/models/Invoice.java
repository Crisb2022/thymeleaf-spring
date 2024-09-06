package com.uqai.capacitacion.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

/**
 * contextos:
 *
 * singleton -> el uso es compartido entre sesiones de usuario (carrito de compras y como se comparte con los usuarios que usan)
 * prototype -> Un bean con alcance de prototipo devolverá una instancia diferente cada vez que se solicite desde el contenedor.
 *              No es 100% gestionado por el contenedor --
 * request -> dura solo la peticion almacena estado, y elimina el componente
 * session -> es unico para cada sesion de los usuarios (carrito de compras unico para cada usuario), dura hasta que se invalide la sesion
 * application -> es un contexto similar al singleton compartido por los usuarios, Singleton es una sola instancia-aplicacion,
 *                application es a nivel de servidor (varias aplicaciones corriendo dentro del servidor)
 * websocket
 */

@Data
@Slf4j
@Component // por defecto tiene un estado Singleton]
@RequestScope
@JsonIgnoreProperties({"targetSource", "advisors"})
public class Invoice {

    @Autowired
    private Client client;
    @Value("${app.client.description}")
    private String description;

    @Autowired
    @Qualifier("default")
    private List<Item> items;

    /**
     * jakarta es la evolucion de java ee
     * PostConstruct
     * Se ejecuta despues que se haya instanciado y despues de que se haya instanciado todos los valores de la clase
     */
    @PostConstruct
    public void init() {
        log.info("asmdmlkdmakmkdlsmaklmdk");
        client.setName("PostConstruct".concat(client.getName()));
    }

    /**
     * Hacer una tarea antes de destruir
     * PreDestroy
     * cuando se desotruye el contexto singleton se realiza una tarea.
     */
    @PreDestroy
    public void destroy() {
        log.info("Destruyendo el componente");
    }

    public double getTotal() {
        return items.stream()
                .map(Item::getImporte)
                .reduce((double) 0, Double::sum);
    }
}
