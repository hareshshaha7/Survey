/**
 * 
 */
package com.haresh.usersurvey.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.haresh.usersurvey.dao.UserDao;
import com.haresh.usersurvey.dao.UserDaoImplementation;
import com.haresh.usersurvey.service.UserService;
import com.haresh.usersurvey.service.UserServiceImplementation;

/**
 * @author Haresh.Shaha
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.haresh.usersurvey")
@PropertySource(value = { "classpath:application.properties" })
public class ApplicationContextConfig {
	
	@Autowired
    private Environment env;
 
	@Bean(name="viewResolver")
	public InternalResourceViewResolver getViewResolver()
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
    @Bean(name="sqlDataSource")
    public DataSource getSQLdataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
        return dataSource;
    }
 
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        return jdbcTemplate;
    }
    
    @Bean
    public UserDao UserDao(){
    	return new UserDaoImplementation();
    }
    
    @Bean
    public UserService UserService(){
    	return new UserServiceImplementation();
    }
}
