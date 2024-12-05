package com.es.segurosinseguros;

import com.es.segurosinseguros.security.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * The type Seguros inseguros application.
 */
@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class SegurosInsegurosApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(SegurosInsegurosApplication.class, args);
    }

}
