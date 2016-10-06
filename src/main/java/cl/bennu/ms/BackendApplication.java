package cl.bennu.ms;

import cl.bennu.ms.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@SpringBootApplication
public class BackendApplication {

    //@Bean
    public FilterRegistrationBean filter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new TokenFilter());
        //filterRegistrationBean.addUrlPatterns("/**");
        //filterRegistrationBean.addUrlPatterns("/users");

        return filterRegistrationBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
}
