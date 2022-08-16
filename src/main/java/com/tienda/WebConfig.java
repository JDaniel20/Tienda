package com.tienda;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/*
*Internationalization --- i18n --- 18 letras entre I y N
*Locale:Representa el lenguaje, la region geografica, variantes del dialecto/idioma, de un usuario
*SessionLocaleResolver: guardar el Locale seleccionado por usuario como atributo en el request HTTP
*LocaleChangeInterceptor: Detectar cualquier cambio de parte del usuario hacia lo que es Local
*/


@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Bean
    public SessionLocaleResolver localeResolver(){
        var slr=new SessionLocaleResolver();       //Es un metodo de configuracion 
        slr.setDefaultLocale(new Locale("es"));  //  En el objeto local podemos guardar informacion del lenguaje-region geografica-variantes del dialecto
        return slr;                              //La informacion se guarda en un metodo SessionLocaleResolver
    }
    
    @Bean 
    public LocaleChangeInterceptor localeChangeInterceptor (){   
        var lci =new LocaleChangeInterceptor();   //Intercepta los lang en los url y detecta si hay un cambio o no en el paramatro lang
        lci.setParamName("lang");                 //Lee el lang             
        return lci;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registro){   //Detecta los cambios en los urls 
        registro.addInterceptor(localeChangeInterceptor());
    }
    
    @Override
    public void addViewControllers (ViewControllerRegistry registro){
        registro.addViewController("/").setViewName("personas");
        registro.addViewController("/login");
        registro.addViewController("/errores/403").setViewName("/errores/403");
    }
}
