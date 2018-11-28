package config;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;

/**
 * swagger配置
 *
 * @author
 *
 */
@Configuration
@EnableWebMvc   //启用Spring MVC组件
@ComponentScan(/*basePackages = {"tesrcontroller"}*/)
@EnableSwagger
public class SwaggerConfig {

    @Resource
    private SpringSwaggerConfig springSwaggerConfig;


    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(apiInfo()).includePatterns(".*?");
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("My Apps API Title", "My Apps API Description", "My Apps API terms of service",
                "My Apps API Contact Email", "My Apps API Licence Type", "My Apps API License URL");
        return apiInfo;
    }

}