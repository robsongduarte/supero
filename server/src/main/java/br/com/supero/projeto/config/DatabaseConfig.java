package br.com.supero.projeto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Classe de configuração.

 * @author Robson Duarte
 * 

*/
@Configuration
@EnableJpaRepositories(basePackages = "br.com.supero.projeto.repository")
public class DatabaseConfig {

}
