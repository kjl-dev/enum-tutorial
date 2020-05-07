package d.customfieldswithspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Main {


    private Converter<String, OrderStatus> orderStatusConverter() {
        return new Converter<String, OrderStatus>() {
            @Override
            public OrderStatus convert(String value) {
                return OrderStatus.fromValue(value);
            }
        };
    }

    @Bean
    public Object WebMvcConfigurer() {
        return new WebMvcConfigurer() {
          @Override
          public void addFormatters(FormatterRegistry registry){
              registry.addConverter(orderStatusConverter());
          }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
