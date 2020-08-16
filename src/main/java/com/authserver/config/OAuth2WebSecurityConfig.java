package com.authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.token.*;

@Configuration
@EnableWebSecurity
public class OAuth2WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public ResourceServerTokenServices tokenServices(){
        RemoteTokenServices tokenServices = new RemoteTokenServices();
        tokenServices.setClientId("trusted-app");
        tokenServices.setClientSecret("123456");
        tokenServices.setCheckTokenEndpointUrl("http://127.0.0.1:8762/oauth//check_token");
        tokenServices.setAccessTokenConverter(getAccessTokenConverter());
        return tokenServices;
    }

    private AccessTokenConverter getAccessTokenConverter() {
        DefaultAccessTokenConverter defaultAccessTokenConverter = new DefaultAccessTokenConverter();
        DefaultUserAuthenticationConverter defaultUserAuthenticationConverter = new DefaultUserAuthenticationConverter();
        defaultUserAuthenticationConverter.setUserDetailsService(userDetailsService);
        defaultAccessTokenConverter.setUserTokenConverter(defaultUserAuthenticationConverter);
        return defaultAccessTokenConverter;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        OAuth2AuthenticationManager auth2AuthenticationManager = new OAuth2AuthenticationManager();
        auth2AuthenticationManager.setTokenServices(tokenServices());
        return auth2AuthenticationManager;
    }




}
