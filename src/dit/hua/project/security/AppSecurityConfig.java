//package dit.hua.project.security;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
//public class AppSecurityConfig extends WebSecurityConfigurerAdapter { // this class configures spring security
//
//	//(&#39;admin&#39;,&#39;$2y$12$fsKDQpQgBwlJFgGByGqwSOlNHrgi7xNR0.aasinBNzxFJi/E2ojyS&#39;,&#39;off&#39;);
//	@Autowired
//	DataSource dataSource;
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) {  //mechanism of authentication
////		try {
////
////			auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder()) // spring will find bean
////																								// type of datasource,
////																								// to
////																								// dhlwsa sto web xml
////					.usersByUsernameQuery("select username, password, enabled from users where username=?") // username
////																											// apo
////																											// login
////																											// form
////					.authoritiesByUsernameQuery("select username, authority from authorities where username=?");
////		} catch (Exception e) {
////			e.getStackTrace();
////		}
//
//    }
//		
//
//
//	@Override
//	protected void configure(HttpSecurity http) {
////		
////		
////		try {
////			http.authorizeRequests()
////			//.antMatchers("/").permitAll()                          //anyone can see it 
////			//.antMatchers("/employee-login").permitAll()              //anyone can see it 
////			.antMatchers("/employee-menu/**").hasAnyRole("administrator", "student", "employee", "supervisor")   //access after they have logged in successfully and have one of the following roles: admin, student, employee, supervisor
////            .and()
////				.formLogin().loginPage("/employee-login")   //declare th log in page 
////				.loginProcessingUrl("/employee-menu")
////				.defaultSuccessUrl("/employee-menu")
////				.failureUrl("/just-logged-out")
////			.and()
////				.logout().logoutSuccessUrl("/just-logged-out");
////	         //   .permitAll()
////	           // .and()
////	           // .exceptionHandling().accessDeniedPage("/403");;
////	
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} 
//
//		// ++ for student, supervisor 
//
//	}
//
//	// to allow resources (css,js,images,...) to be προσπελάσιμα for all we need to
//	// override the method configure(WebSecurity web) from
//	// WebSecurityConfigurerAdapter
//	@Override
//	public void configure(WebSecurity web) {
//		try {
//			//web.ignoring().antMatchers("/"); 
//			//web.ignoring().antMatchers("/employee-login"); 
//			web.ignoring().antMatchers("/resources/**");
//			System.out.println(web.ignoring().antMatchers("/resources/**").toString());
//		} catch (Exception e) {
//			e.getStackTrace();
//		}
//
//	}
//
//
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		PasswordEncoder encoder = new BCryptPasswordEncoder();
//		System.out.println(encoder.toString());
//		return encoder;
//	
//	}
//
////to password poy 8a pairnei apo thn forma that to kanei encrypt k meta sygkrish me ayto poy einai apouhkeymeno sthn database
//}
