package com.xxxxxxxx.comunes.personas_trabajadores_arl.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.segurosbolivar.utils.parameterstore.ParameterStoreSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.util.Locale;

@Configuration
public class DatabaseConfiguration {
	private ParameterStoreSource parameterStoreSource = new ParameterStoreSource();

	public static final String TRONADOR_DATASOURCE = "TronadorDS";

	@Value("${app.db_params.ip}")
	private String ipTronDb;
	@Value("${app.db_params.service}")
	private String serviceTronDb;
	@Value("${app.db_params.username}")
	private String usernameTronDb;
	@Value("${app.db_params.password}")
	private String passwordTronDb;
	@Value("${app.db_params.port_db}")
	private String PortDb;
	@Value("${app.db_params.driver_db}")
	private String driverDb;
	@Value("${app.aws.prefix}")
	private String awsParamStorePrefix;
	@Value("${app.aws.env_prefix}")
	private String awsParamStoreEnvPrefix;

	@Bean(name = TRONADOR_DATASOURCE, destroyMethod = "")
	public DataSource dataSourceTronador() {
		String ipDatabase = getParameterStore(ipTronDb);
		String serviceTronadorDB = getParameterStore(serviceTronDb);
		String usernameTronadorDB = getParameterStore(usernameTronDb);
		String passwordTronadorDB = getParameterStore(passwordTronDb);
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:oracle:thin:@//" + ipDatabase + ":" + PortDb + "/" + serviceTronadorDB);
		config.setUsername(usernameTronadorDB);
		config.setPassword(passwordTronadorDB);
		config.setDriverClassName(driverDb);
		return new HikariDataSource(config);
	}

	private String getParameterStore(String key) {
		String prefix = awsParamStorePrefix + awsParamStoreEnvPrefix + "/";
		return (String) parameterStoreSource.getProperty(prefix + key);
	}
}
