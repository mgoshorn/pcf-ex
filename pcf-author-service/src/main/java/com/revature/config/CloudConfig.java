package com.revature.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.service.PooledServiceConnectorConfig.PoolConfig;
import org.springframework.cloud.service.relational.DataSourceConfig;
import org.springframework.cloud.service.relational.DataSourceConfig.ConnectionConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudConfig extends AbstractCloudConfig {

	@Value("VCAP_SERVICES.elephantsql[0].instance_name")
	public String pgInstanceName;
	
	@Bean
	public DataSource postgresDataSource() {
		PoolConfig poolConfig = new PoolConfig(1, 1000);
		ConnectionConfig connectionConfig = new ConnectionConfig(pgInstanceName);
		DataSourceConfig dataSourceConfig = new DataSourceConfig(poolConfig, connectionConfig);
		return connectionFactory().dataSource(dataSourceConfig);		
	}
}