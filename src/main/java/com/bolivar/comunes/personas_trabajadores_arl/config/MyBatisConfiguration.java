package com.bolivar.comunes.personas_trabajadores_arl.config;

import javax.inject.Named;
import javax.sql.DataSource;

import com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.repository.PrcProcConsultaTrabajadoresOrdnRepository;
import com.bolivar.comunes.personas_trabajadores_arl.consultartrabajadores.repository.PrcProcContarTrabajadoresRepository;
import com.bolivar.comunes.personas_trabajadores_arl.crearafiliaciontrabajadores.repository.PrcProcAfiliarRepository;
import com.bolivar.comunes.personas_trabajadores_arl.consultarafiliaciontrabajador.repository.PrcProcConsultarRepository;
import com.bolivar.comunes.personas_trabajadores_arl.consultarcargotrabajador.repository.PrcProcListaCargoRepository;
import com.bolivar.comunes.personas_trabajadores_arl.crearcargotrabajador.repository.PrcCreaCargoRepository;
import com.bolivar.comunes.personas_trabajadores_arl.historialnovedadestrabajadores.repository.PrcConsultaNovedadesTrbjdrRepository;
import com.bolivar.comunes.personas_trabajadores_arl.retirartrabajadordependiente.repository.PrcProcExcluirRepository;
import com.bolivar.comunes.personas_trabajadores_arl.retirartrabajadorindependiente.repository.PrcExcluirTrabIndRepository;
import com.bolivar.comunes.personas_trabajadores_arl.consultarguardiantrabajador.repository.PrcTrabajadoresArlGuardianRepository;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisConfiguration {
	private static final String TRONADOR_SESSION_FACTORY = "tronadorSessionFactory";

	@Bean(name = TRONADOR_SESSION_FACTORY, destroyMethod = "")
	public SqlSessionFactoryBean crvSqlSessionFactory(
			@Named(DatabaseConfiguration.TRONADOR_DATASOURCE) final DataSource anotherDataSource) {
		final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(anotherDataSource);
		return sqlSessionFactoryBean;
	}

	@Bean
	public MapperFactoryBean<PrcProcExcluirRepository> prcProcExcluirRepository(
			@Qualifier(TRONADOR_SESSION_FACTORY) final SqlSessionFactory sqlSessionFactory) {
		MapperFactoryBean<PrcProcExcluirRepository> factoryBean = new MapperFactoryBean<>(
				PrcProcExcluirRepository.class);
		factoryBean.setSqlSessionFactory(sqlSessionFactory);
		return factoryBean;
	}

	@Bean
	public MapperFactoryBean<PrcProcConsultarRepository> prcProcConsultarRepository(
			@Qualifier(TRONADOR_SESSION_FACTORY) final SqlSessionFactory sqlSessionFactory) {
		MapperFactoryBean<PrcProcConsultarRepository> factoryBean = new MapperFactoryBean<>(
				PrcProcConsultarRepository.class);
		factoryBean.setSqlSessionFactory(sqlSessionFactory);
		return factoryBean;
	}

	@Bean
	public MapperFactoryBean<PrcExcluirTrabIndRepository> prcExcluirTrabIndRepository(
			@Qualifier(TRONADOR_SESSION_FACTORY) final SqlSessionFactory sqlSessionFactory) {
		MapperFactoryBean<PrcExcluirTrabIndRepository> factoryBean = new MapperFactoryBean<>(
				PrcExcluirTrabIndRepository.class);
		factoryBean.setSqlSessionFactory(sqlSessionFactory);
		return factoryBean;
	}

	@Bean
	public MapperFactoryBean<PrcProcListaCargoRepository> prcProcListaCargoRepository(
			@Qualifier(TRONADOR_SESSION_FACTORY) final SqlSessionFactory sqlSessionFactory) {
		MapperFactoryBean<PrcProcListaCargoRepository> factoryBean = new MapperFactoryBean<>(
				PrcProcListaCargoRepository.class);
		factoryBean.setSqlSessionFactory(sqlSessionFactory);
		return factoryBean;
	}
	
	@Bean
	public MapperFactoryBean<PrcProcAfiliarRepository> prcProcAfiliarRepository(
			@Qualifier(TRONADOR_SESSION_FACTORY) final SqlSessionFactory sqlSessionFactory) {
		MapperFactoryBean<PrcProcAfiliarRepository> factoryBean = new MapperFactoryBean<>(
				PrcProcAfiliarRepository.class);
		factoryBean.setSqlSessionFactory(sqlSessionFactory);
		return factoryBean;
	}

	@Bean
	public MapperFactoryBean<PrcCreaCargoRepository> prcCreaCargoRepository(
			@Qualifier(TRONADOR_SESSION_FACTORY) final SqlSessionFactory sqlSessionFactory) {
		MapperFactoryBean<PrcCreaCargoRepository> factoryBean = new MapperFactoryBean<>(
				PrcCreaCargoRepository.class);
		factoryBean.setSqlSessionFactory(sqlSessionFactory);
		return factoryBean;
	}

	@Bean
	MapperFactoryBean<PrcProcConsultaTrabajadoresOrdnRepository> prcProcConsultaTrabajadoresPagRepository(
			@Qualifier(TRONADOR_SESSION_FACTORY) final SqlSessionFactory sqlSessionFactory) {
		MapperFactoryBean<PrcProcConsultaTrabajadoresOrdnRepository> factoryBean = new MapperFactoryBean<>(
				PrcProcConsultaTrabajadoresOrdnRepository.class);
		factoryBean.setSqlSessionFactory(sqlSessionFactory);
		return factoryBean;
	}

	@Bean
	MapperFactoryBean<PrcProcContarTrabajadoresRepository> prcProcContarTrabajadoresRepository(
			@Qualifier(TRONADOR_SESSION_FACTORY) final SqlSessionFactory sqlSessionFactory) {
		MapperFactoryBean<PrcProcContarTrabajadoresRepository> factoryBean = new MapperFactoryBean<>(
				PrcProcContarTrabajadoresRepository.class);
		factoryBean.setSqlSessionFactory(sqlSessionFactory);
		return factoryBean;
	}

	@Bean
	MapperFactoryBean<PrcConsultaNovedadesTrbjdrRepository> prcHistorialNovedadesRepository(
			@Qualifier(TRONADOR_SESSION_FACTORY) final SqlSessionFactory sqlSessionFactory) {
		MapperFactoryBean<PrcConsultaNovedadesTrbjdrRepository> factoryBean = new MapperFactoryBean<>(
				PrcConsultaNovedadesTrbjdrRepository.class);
		factoryBean.setSqlSessionFactory(sqlSessionFactory);
		return factoryBean;
	}

	@Bean
	public MapperFactoryBean<PrcTrabajadoresArlGuardianRepository> procConsultasTrabajador(
			@Qualifier(TRONADOR_SESSION_FACTORY) final SqlSessionFactory saludSqlSessionFactory) {
		MapperFactoryBean<PrcTrabajadoresArlGuardianRepository> factoryBean = new MapperFactoryBean<>(
				PrcTrabajadoresArlGuardianRepository.class);
		factoryBean.setSqlSessionFactory(saludSqlSessionFactory);
		return factoryBean;
	}
}
