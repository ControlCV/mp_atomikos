package com.zhjw.common.db;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @ClassName MasterDataSourceConfig
 * @Author LENOVO
 * @Date 2021/10/19 10:18
 * @Description
 * @Version 1.0
 */
@Configuration
@MapperScan(basePackages = "com.zhjw.mapper.master", sqlSessionTemplateRef = "masterSqlSessionTemplate")
public class MasterDataSourceConfig {
    @Value("${spring.datasource.dynamic.datasource.master.url}")
    private String url;

    @Value("${spring.datasource.dynamic.datasource.master.username}")
    private String username;

    @Value("${spring.datasource.dynamic.datasource.master.password}")
    private String password;

    @Value("${spring.datasource.dynamic.datasource.master.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.type}")
    private String dataSourceClassName;

    @Value("${spring.datasource.dynamic.datasource.validation-query}")
    private String testQuery;

    @Bean(name = "masterDataSource")
    public DataSource masterDataSource() {
        AtomikosDataSourceBean sourceBean = new AtomikosDataSourceBean();
        sourceBean.setUniqueResourceName("masterDataSource");
        sourceBean.setXaDataSourceClassName(dataSourceClassName);
        sourceBean.setTestQuery("select 1");
        sourceBean.setBorrowConnectionTimeout(3);
        MysqlXADataSource dataSource = new MysqlXADataSource();
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        sourceBean.setXaDataSource(dataSource);
        return sourceBean;
    }

    @Bean(name = "masterSqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/master/*Mapper.xml"));
        //打印日志到控制台
        MybatisConfiguration mybatisConfiguration = new MybatisConfiguration();
        mybatisConfiguration.setLogImpl(StdOutImpl.class);
        sqlSessionFactoryBean.setConfiguration(mybatisConfiguration);
        //手动设置session工厂时，需要手动添加分页插件
//            Interceptor[] plugins = new Interceptor[1];
//            plugins[0] = new PaginationInterceptor();
//            sqlSessionFactoryBean.setPlugins(plugins);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "masterSqlSessionTemplate")
    public SqlSessionTemplate masterSqlSessionTemplate(@Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}