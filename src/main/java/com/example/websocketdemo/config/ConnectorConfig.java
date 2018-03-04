package com.example.websocketdemo.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*http 重定向到 https*/
@Configuration
public class ConnectorConfig {
    static class MyTomcat extends TomcatEmbeddedServletContainerFactory {
        @Override
        protected void postProcessContext(Context context) {
            SecurityConstraint securityConstraint = new SecurityConstraint();
            securityConstraint.setUserConstraint("CONFIDENTIAL");
            SecurityCollection collection = new SecurityCollection();
            collection.addPattern("/*");
            securityConstraint.addCollection(collection);
            context.addConstraint(securityConstraint);
        }
    }
    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        MyTomcat tomcat = new MyTomcat();
        tomcat.addAdditionalTomcatConnectors(getHttpConnector());
        System.out.println("今天天气不错啊:" + tomcat.getAdditionalTomcatConnectors().size());
        return tomcat;
    }
    private Connector getHttpConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(8080);
        connector.setSecure(false);
        connector.setRedirectPort(9000);
        return connector;
    }
}
