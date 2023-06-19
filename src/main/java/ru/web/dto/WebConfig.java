package ru.web.dto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"ru"})
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/")
                .setCachePeriod(31556926);
    }
    @Bean
    ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("WEB-INF/il8n/messages", "WEB-INF/il8n/application");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setFallbackToSystemLocale(false);
        return messageSource;

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean
    LocaleChangeInterceptor localeChangeInterceptor(){
    return new LocaleChangeInterceptor();
    }

    @Bean
    InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/singers/");
        resolver.setSuffix(".jspx");
//        resolver.setRequestContextAttribute("requestContext");
        return resolver;
    }

    @Bean
    CookieLocaleResolver localeResolver(){
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
        cookieLocaleResolver.setCookieMaxAge(3600);
        cookieLocaleResolver.setCookieName("locale");
        return cookieLocaleResolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("list");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }
}
