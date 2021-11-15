package spring6;

import java.io.File;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"spring6"})
@PropertySource(value = {"classpath:config.properties"})
public class ContextConfig implements Serializable{
}
