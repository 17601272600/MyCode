package com.qiantao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@SpringBootApplication
@SuppressWarnings("rawtypes")
public class PortalApp {

	public static void main(String[] arg0) {
		SpringApplication.run(PortalApp.class, arg0);
	}
	
	
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
   
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DruidDataSource druidDataSource(){
          return new DruidDataSource();
    }
    
    /**
     * 配置监控服务器
     * @return 返回监控注册的servlet对象
     * @author qiantao
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        @SuppressWarnings("unchecked")
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // 添加IP白名单
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        // 添加IP黑名单，当白名单和黑名单重复时，黑名单优先级更高
        servletRegistrationBean.addInitParameter("deny", "127.0.0.2");
        // 添加控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "123456");
        // 是否能够重置数据
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }
    
  
   
    
    @Bean
    public FilterRegistrationBean statFilter() {
		@SuppressWarnings("unchecked")
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        // 添加过滤规则
        filterRegistrationBean.addUrlPatterns("/*");
        // 忽略过滤格式
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*,");
        return filterRegistrationBean;
    }
    
    
    /**
     * redis连接
     * @return
     */
    @Bean
    public JedisPool redisPoolFactory(@Value("${spring.redis.host}")String host,
    		  						@Value("${spring.redis.port}")int port,
    		  						 @Value("${spring.redis.timeout}")int timeout,
    		  						@Value("${spring.redis.password}")String password) {	
    	JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(8);//连接池默认最大空闲连接为8
        jedisPoolConfig.setJmxEnabled(true);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password);
        return jedisPool;
    }

    
}
