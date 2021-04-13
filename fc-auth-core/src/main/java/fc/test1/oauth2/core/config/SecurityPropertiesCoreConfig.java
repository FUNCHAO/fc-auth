package fc.test1.oauth2.core.config;

import fc.test1.oauth2.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityPropertiesCoreConfig {
}
