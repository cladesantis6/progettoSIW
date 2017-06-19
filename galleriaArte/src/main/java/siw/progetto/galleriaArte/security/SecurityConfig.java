package siw.progetto.galleriaArte.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.context.annotation.Bean;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Qualifier("dataSource")
	@Autowired
	private DataSource dataSource;	
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
    	auth.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery("SELECT username, password, 1 FROM utente WHERE username = ?")
		.authoritiesByUsernameQuery("SELECT username,ruolo FROM utente where username=?");
    	
				/*"select username, ruolo"+
									"from utente join ruolo on ruolo_id=id where username=?");
				/*"select username, ruolo "
								  + "from utente, ruolo "
								  + "where utente.id=utenti_id_utente and ruolo.id=ruoli_id");
    	
				/*"SELECT username,authority FROM authorities where username=?"
		
				"SELECT u.username, ruoli.ruolo authority " +
				"FROM utenti u JOIN ruoli_utente ruoli ON u.id = ruoli.utente_id WHERE u.username = ?" */
    }
    

 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.authorizeRequests()
        	//.anyRequest().authenticated()	   	
        		.antMatchers("/home/**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")    
        		.antMatchers("/admin/**").hasRole("ADMIN")   
        		.and()
        	.formLogin()
	          .loginPage("/login")
	          .defaultSuccessUrl("/home")
	          .failureUrl("/login-error")
	          .and()
	        .logout().logoutUrl("/logout").logoutSuccessUrl("/login");            
            
    }
}