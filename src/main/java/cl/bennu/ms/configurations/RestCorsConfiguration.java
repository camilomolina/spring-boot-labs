package cl.bennu.ms.configurations;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@Configuration
public class RestCorsConfiguration {


    @Bean
    public FilterRegistrationBean config() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
//        corsConfiguration.addAllowedMethod("GET");

        corsConfiguration.addAllowedMethod(RequestMethod.GET.name());
        corsConfiguration.addAllowedMethod(RequestMethod.POST.name());
        corsConfiguration.addAllowedMethod(RequestMethod.DELETE.name());
        corsConfiguration.addAllowedMethod(RequestMethod.PUT.name());
        corsConfiguration.addAllowedMethod(RequestMethod.PATCH.name());

        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

        CorsFilter corsFilter = new CorsFilter(urlBasedCorsConfigurationSource);

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(corsFilter);
        filterRegistrationBean.setOrder(0);

        return filterRegistrationBean;
    }

}
