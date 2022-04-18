#配置文件到底能写什么 ---联系--- spring.factories
- 1：spring.factories中的每一个xxxAutoConfiguration是容器中的一个组件，最后它都有可能加入到容器中来并做一些配置。

```java
//表示这是一个配置类，配上它之后表示它会被spring接管配置
@Configuration(
    proxyBeanMethods = false
)
//自动配置属性，可以指定我们要配置哪一个类class。
@EnableConfigurationProperties({ServerProperties.class})
//下面的@Conditionalxxx表示Spring的底层注解：根据不同的条件来判断当前配置或者类是否生效！
//这个@ConditionalOnWebApplication来判断这个应用是否是web应用
@ConditionalOnWebApplication(
    type = Type.SERVLET
)
//@ConditionalOnClass表示是否经过过滤器
@ConditionalOnClass({CharacterEncodingFilter.class})
//@ConditionalOnProperty来判断是否有server.servlet.encoding这个配置
//如果没有的话就走默认配置
@ConditionalOnProperty(
    prefix = "server.servlet.encoding",
    value = {"enabled"},
    matchIfMissing = true
)
public class HttpEncodingAutoConfiguration {
    private final Encoding properties;
    
        public HttpEncodingAutoConfiguration(ServerProperties properties) {
            this.properties = properties.getServlet().getEncoding();
        }
    
        @Bean
        @ConditionalOnMissingBean
        //接下来这些就是关于字符编码的过滤
        public CharacterEncodingFilter characterEncodingFilter() {
            CharacterEncodingFilter filter = new OrderedCharacterEncodingFilter();
            filter.set Encoding(this.properties.getCharset().name());
            filter.setForceRequestEncoding(this.properties.shouldForce(org.springframework.boot.web.servlet.server.Encoding.Type.REQUEST));
            filter.setForceResponseEncoding(this.properties.shouldForce(org.springframework.boot.web.servlet.server.Encoding.Type.RESPONSE));
            return filter;
        }
    
        @Bean
        public HttpEncodingAutoConfiguration.LocaleCharsetMappingsCustomizer localeCharsetMappingsCustomizer() {
            return new HttpEncodingAutoConfiguration.LocaleCharsetMappingsCustomizer(this.properties);
        }
    
        static class LocaleCharsetMappingsCustomizer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>, Ordered {
            private final Encoding properties;
    
            LocaleCharsetMappingsCustomizer(Encoding properties) {
                this.properties = properties;
            }
    
            public void customize(ConfigurableServletWebServerFactory factory) {
                if (this.properties.getMapping() != null) {
                    factory.setLocaleCharsetMappings(this.properties.getMapping());
                }
    
            }
    
            public int getOrder() {
                return 0;
            }
        }
}
```