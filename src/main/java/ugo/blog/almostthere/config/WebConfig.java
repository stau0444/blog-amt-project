package ugo.blog.almostthere.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ugo.blog.almostthere.admin.IPInterceptor;


@Configuration
@RequiredArgsConstructor
public class WebConfig  implements WebMvcConfigurer {

    private final IPInterceptor ipInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ipInterceptor)
                .addPathPatterns("/api/**");
    }
}
