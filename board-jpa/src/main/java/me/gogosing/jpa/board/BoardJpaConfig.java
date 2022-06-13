package me.gogosing.jpa.board;

import me.gogosing.jpa.board.config.BoardJpaDataSourceConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration(exclude = {
	DataSourceAutoConfiguration.class,
	DataSourceTransactionManagerAutoConfiguration.class,
	HibernateJpaAutoConfiguration.class})
@ComponentScan(basePackages = {
	"me.gogosing.jpa.board",
	"me.gogosing.support"
})
@EntityScan(basePackages = {"me.gogosing.jpa.board"})
@Import({BoardJpaDataSourceConfig.class})
public class BoardJpaConfig {

}