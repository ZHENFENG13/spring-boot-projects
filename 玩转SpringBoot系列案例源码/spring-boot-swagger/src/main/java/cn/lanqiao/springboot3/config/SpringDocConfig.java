package cn.lanqiao.springboot3.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    // 扫描路径
    private static final String basePackage = "cn.lanqiao.springboot3.controller";
    // 请求头名称
    private static final String headerName = "token";

    @Bean
    public GroupedOpenApi group01() {
        return GroupedOpenApi.builder()
                .group("group01")
                .addOperationCustomizer((operation, handlerMethod) -> {
                    operation.addSecurityItem(new SecurityRequirement().addList(headerName));
                    return operation;
                })
                .packagesToScan(basePackage)
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        Components components = new Components();
        //添加右上角的统一安全认证
        components.addSecuritySchemes(headerName,
                new SecurityScheme()
                        .type(SecurityScheme.Type.APIKEY)
                        .scheme("basic")
                        .name(headerName)
                        .in(SecurityScheme.In.HEADER)
                        .description("请求头")
        );
        return new OpenAPI()
                .components(components)
                .info(apiInfo());
    }

    private Info apiInfo() {
        Contact contact = new Contact();
        contact.setEmail("2449207463@qq.com");
        contact.setName("程序员十三");
        contact.setUrl("https://juejin.cn/user/3808363978174302");
        return new Info()
                .title("Swagger文档")
                .version("1.0")
                .contact(contact)
                .license(new License().name("Apache 2.0").url("http://springdoc.org"));
    }
}
