package org.dongchimi.eguncarlog.utility;

import java.util.Properties;

//@Configuration
//@EnableTransactionManagement
//@PropertySource({ "classpath:persistence-mysql.properties"})
//@ComponentScan({"org.dongchimi.eguncarlog"})
@Deprecated
public class PersistenceConfig {

//	@Autowired
//	private Environment env;
	
//	@Bean
//	public LocalSessionFactoryBean sessionFactory() {
//		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//		sessionFactory.setDataSource(restDataSource());
//		sessionFactory.setPackagesToScan(new String[] {"org.dongchimi.eguncarlog"});
//		sessionFactory.setHibernateProperties(hibernateProperties());
//		
//		return sessionFactory;
//	}
	
//	@Bean
//	public DataSource restDataSource() {
//		BasicDataSource dataSource = new BasicDataSource();
//		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
//		dataSource.setUrl(env.getProperty("jdbc.url"));
//		dataSource.setUsername(env.getProperty("jdbc.user"));
//		dataSource.setPassword(env.getProperty("jdbc.pass"));
//		
//		return dataSource;
//	}
	
//	@Bean
//	public HibernateTransactionManager transactionManager() {
//		HibernateTransactionManager txManager = new HibernateTransactionManager();
//		txManager.setSessionFactory(sessionFactory().getObject());
//		
//		return txManager;
//	}
	
//	@Bean
//	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//		return new PersistenceExceptionTranslationPostProcessor();
//	}
	
	Properties hibernateProperties() {
		return new Properties();
//		return new Properties() {
//			{
//				setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//				setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
//				setProperty("hibernate.globally_quoted_identifiers", "true");
//			}
//		};
	}
}
