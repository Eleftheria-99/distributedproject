package dit.hua.project.security;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter { // this class configures spring security
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) {  //mechanism of authentication
		try {

			auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder()) 
			// spring will find bean type of datasource, declared in the web xml																					
					.usersByUsernameQuery("select username, password, enabled from USERS where username=?")
					.authoritiesByUsernameQuery("select username, authority from AUTHORITIES where username=?");
		} catch (Exception e) {
			e.getStackTrace();
		}
    }

	@Override
	protected void configure(HttpSecurity http) {
		try {

		http.authorizeRequests()
			//.anyRequest().authenticated()
			.antMatchers("/").permitAll()                          //anyone can see it, no authentication needed
			.antMatchers("/login").permitAll()                     //anyone can see it, no authentication needed
//			.antMatchers("/login/main-menu-for-all/**").authenticated()
			.antMatchers("/login/main-menu-for-all/*").hasRole("student")
			.antMatchers("/login/main-menu-for-all/*").hasRole("employee")
	    	.antMatchers("/login/main-menu-for-all/*").hasRole("supervisor")
		//	.antMatchers("/login/**").hasRole("administrator")
			.and()
				.formLogin().loginPage("/login")   //declare the log in page 
				.loginProcessingUrl("/login/main-menu-for-all")
				.defaultSuccessUrl("/login/main-menu-for-all")
				.permitAll()
			 .and()
				.logout()
				//.logoutSuccessUrl("/just-logged-out")
				//.logoutSuccessUrl("/login")
	            .permitAll()
	            .and()
	            .exceptionHandling().accessDeniedPage("/403");
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	// to allow resources (css,js,images,...) to be προσπελάσιμα for all we need to
	// override the method configure(WebSecurity web) from
	// WebSecurityConfigurerAdapter
	@Override
	public void configure(WebSecurity web) {
		try {
			web.ignoring().antMatchers("/resources/**");
			System.out.println(web.ignoring().antMatchers("/resources/**").toString());
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.toString());
		return encoder;
	
	}
}
