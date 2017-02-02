# spring-data-mybatis-testing

Sample repo for bugs demos 
 
    git clone git@github.com:kopax/spring-data-mybatis-testing.git
    
## @OneToMany doesn't select join column because of missing join statement

__spring-data-mybatis : 3b6fba0__ 

PR https://github.com/hatunet/spring-data-mybatis/pull/98

    git checkout onetomany
    ./gradlew build --info && java -jar build/libs/spring-data-mybatis-testing-0.1.0.war
    
### Test

    curl http://localhost:8080/siteServices
    
### Expected

HTTP 200
    
### Result

    Thu Feb 02 19:14:48 ICT 2017
    There was an unexpected error (type=Internal Server Error, status=500).
    ### Error querying database. Cause: org.h2.jdbc.JdbcSQLException: Column "SITE_FUNCTION.SITE_FUNCTION_ID" not found; SQL statement: select "siteService".id as "id","siteService".NAME as "name","siteService.siteFunctionList".id as "siteFunctionList.id","siteService.siteFunctionList".NAME as "siteFunctionList.name","siteService.siteFunctionList".SITE_SERVICE_ID as "siteFunctionList.siteService.id" from SITE_SERVICE "siteService" left outer join SITE_FUNCTION on SITE_FUNCTION.SITE_SERVICE_id="siteService".id left outer join SITE_FUNCTION "siteService.siteFunctionList" on SITE_FUNCTION.SITE_FUNCTION_id="siteService.siteFunctionList".id [42122-193] ### The error may exist in org.springframework.data.mybatis.samples.security.SiteService_auto_generate.xml ### The error may involve org.springframework.data.mybatis.samples.security.SiteService._findAll ### The error occurred while executing a query ### SQL: select "siteService".id as "id","siteService".NAME as "name","siteService.siteFunctionList".id as "siteFunctionList.id","siteService.siteFunctionList".NAME as "siteFunctionList.name","siteService.siteFunctionList".SITE_SERVICE_ID as "siteFunctionList.siteService.id" from SITE_SERVICE "siteService" left outer join SITE_FUNCTION on SITE_FUNCTION.SITE_SERVICE_id="siteService".id left outer join SITE_FUNCTION "siteService.siteFunctionList" on SITE_FUNCTION.SITE_FUNCTION_id="siteService.siteFunctionList".id ### Cause: org.h2.jdbc.JdbcSQLException: Column "SITE_FUNCTION.SITE_FUNCTION_ID" not found; SQL statement: select "siteService".id as "id","siteService".NAME as "name","siteService.siteFunctionList".id as "siteFunctionList.id","siteService.siteFunctionList".NAME as "siteFunctionList.name","siteService.siteFunctionList".SITE_SERVICE_ID as "siteFunctionList.siteService.id" from SITE_SERVICE "siteService" left outer join SITE_FUNCTION on SITE_FUNCTION.SITE_SERVICE_id="siteService".id left outer join SITE_FUNCTION "siteService.siteFunctionList" on SITE_FUNCTION.SITE_FUNCTION_id="siteService.siteFunctionList".id [42122-193] ; bad SQL grammar []; nested exception is org.h2.jdbc.JdbcSQLException: Column "SITE_FUNCTION.SITE_FUNCTION_ID" not found; SQL statement: select "siteService".id as "id","siteService".NAME as "name","siteService.siteFunctionList".id as "siteFunctionList.id","siteService.siteFunctionList".NAME as "siteFunctionList.name","siteService.siteFunctionList".SITE_SERVICE_ID as "siteFunctionList.siteService.id" from SITE_SERVICE "siteService" left outer join SITE_FUNCTION on SITE_FUNCTION.SITE_SERVICE_id="siteService".id left outer join SITE_FUNCTION "siteService.siteFunctionList" on SITE_FUNCTION.SITE_FUNCTION_id="siteService.siteFunctionList".id [42122-193]
    
## How to extend xml with custom mappers

__spring-data-mybatis : f22774e__ (approx 1.0.8.SNAPSHOT, after this commit spring-data-mybatis is corrupt)

Ticket https://github.com/hatunet/spring-data-mybatis/issues/88

    git checkout extendxml
    ./gradlew build --info && java -jar build/libs/spring-data-mybatis-testing-0.1.0.war
    
### Test

    java -jar build/libs/spring-data-mybatis-testing-0.1.0.war
    
### Expected

start the server and create the getAll method for the SiteServiceRepository using the custom method in SiteServiceMapper.xml

### Result

    2017-02-02 17:54:38.089 ERROR 18063 --- [           main] o.s.boot.SpringApplication               : Application startup failed

    org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'databaseLoader' defined in file [/workspace/github.com/hatunet/spring-data-mybatis-samples/build/classes/main/org/springframework/data/mybatis/samples/config/DatabaseLoader.class]: Unsatisfied dependency expressed through constructor parameter 1; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'siteServiceRepository': Invocation of init method failed; nested exception is org.springframework.data.mapping.PropertyReferenceException: No property getAll found for type SiteService!
	at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:749) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	at org.springframework.beans.factory.support.ConstructorResolver.autowireConstructor(ConstructorResolver.java:189) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireConstructor(AbstractAutowireCapableBeanFactory.java:1193) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1095) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:513) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:483) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:197) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:761) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:866) ~[spring-context-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:542) ~[spring-context-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.refresh(EmbeddedWebApplicationContext.java:122) ~[spring-boot-1.4.4.RELEASE.jar:1.4.4.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:762) [spring-boot-1.4.4.RELEASE.jar:1.4.4.RELEASE]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:372) [spring-boot-1.4.4.RELEASE.jar:1.4.4.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:316) [spring-boot-1.4.4.RELEASE.jar:1.4.4.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1187) [spring-boot-1.4.4.RELEASE.jar:1.4.4.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1176) [spring-boot-1.4.4.RELEASE.jar:1.4.4.RELEASE]
	at org.springframework.data.mybatis.samples.Application.main(Application.java:35) [main/:na]
    Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'siteServiceRepository': Invocation of init method failed; nested exception is org.springframework.data.mapping.PropertyReferenceException: No property getAll found for type SiteService!
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1628) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:555) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:483) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:208) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1138) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1066) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	at org.springframework.beans.factory.support.ConstructorResolver.resolveAutowiredArgument(ConstructorResolver.java:835) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:741) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	... 19 common frames omitted
    Caused by: org.springframework.data.mapping.PropertyReferenceException: No property getAll found for type SiteService!
	at org.springframework.data.mapping.PropertyPath.<init>(PropertyPath.java:77) ~[spring-data-commons-1.12.7.RELEASE.jar:na]
	at org.springframework.data.mapping.PropertyPath.create(PropertyPath.java:329) ~[spring-data-commons-1.12.7.RELEASE.jar:na]
	at org.springframework.data.mapping.PropertyPath.create(PropertyPath.java:309) ~[spring-data-commons-1.12.7.RELEASE.jar:na]
	at org.springframework.data.mapping.PropertyPath.from(PropertyPath.java:272) ~[spring-data-commons-1.12.7.RELEASE.jar:na]
	at org.springframework.data.mapping.PropertyPath.from(PropertyPath.java:243) ~[spring-data-commons-1.12.7.RELEASE.jar:na]
	at org.springframework.data.repository.query.parser.Part.<init>(Part.java:76) ~[spring-data-commons-1.12.7.RELEASE.jar:na]
	at org.springframework.data.repository.query.parser.PartTree$OrPart.<init>(PartTree.java:235) ~[spring-data-commons-1.12.7.RELEASE.jar:na]
	at org.springframework.data.repository.query.parser.PartTree$Predicate.buildTree(PartTree.java:373) ~[spring-data-commons-1.12.7.RELEASE.jar:na]
	at org.springframework.data.repository.query.parser.PartTree$Predicate.<init>(PartTree.java:353) ~[spring-data-commons-1.12.7.RELEASE.jar:na]
	at org.springframework.data.repository.query.parser.PartTree.<init>(PartTree.java:84) ~[spring-data-commons-1.12.7.RELEASE.jar:na]
	at org.springframework.data.mybatis.repository.query.PartTreeMybatisQuery.<init>(PartTreeMybatisQuery.java:79) ~[spring-data-mybatis-1.0.8.BUILD-SNAPSHOT.jar:na]
	at org.springframework.data.mybatis.repository.query.MybatisQueryLookupStrategy$CreateQueryLookupStrategy.resolveQuery(MybatisQueryLookupStrategy.java:71) ~[spring-data-mybatis-1.0.8.BUILD-SNAPSHOT.jar:na]
	at org.springframework.data.mybatis.repository.query.MybatisQueryLookupStrategy$CreateIfNotFoundQueryLookupStrategy.resolveQuery(MybatisQueryLookupStrategy.java:120) ~[spring-data-mybatis-1.0.8.BUILD-SNAPSHOT.jar:na]
	at org.springframework.data.mybatis.repository.query.MybatisQueryLookupStrategy$AbstractQueryLookupStrategy.resolveQuery(MybatisQueryLookupStrategy.java:50) ~[spring-data-mybatis-1.0.8.BUILD-SNAPSHOT.jar:na]
	at org.springframework.data.repository.core.support.RepositoryFactorySupport$QueryExecutorMethodInterceptor.<init>(RepositoryFactorySupport.java:435) ~[spring-data-commons-1.12.7.RELEASE.jar:na]
	at org.springframework.data.repository.core.support.RepositoryFactorySupport.getRepository(RepositoryFactorySupport.java:220) ~[spring-data-commons-1.12.7.RELEASE.jar:na]
	at org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport.initAndReturn(RepositoryFactoryBeanSupport.java:280) ~[spring-data-commons-1.12.7.RELEASE.jar:na]
	at org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport.afterPropertiesSet(RepositoryFactoryBeanSupport.java:266) ~[spring-data-commons-1.12.7.RELEASE.jar:na]
	at org.springframework.data.mybatis.repository.support.MybatisRepositoryFactoryBean.afterPropertiesSet(MybatisRepositoryFactoryBean.java:55) ~[spring-data-mybatis-1.0.8.BUILD-SNAPSHOT.jar:na]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1687) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1624) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
	... 30 common frames omitted


    
## findByModel doesn't work as expected 

Ticket https://github.com/hatunet/spring-data-mybatis/issues/87

    git checkout projection
    ./gradlew build --info && java -jar build/libs/spring-data-mybatis-testing-0.1.0.war
    
### Test

    ./gradlew build --info && java -jar build/libs/spring-data-mybatis-testing-0.1.0.war
    
### Expected

    To start
    
### Result

    2017-02-02 17:28:04.318 ERROR 16922 --- [           main] o.s.boot.SpringApplication               : Application startup failed
    
    org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'databaseLoader' defined in file [/workspace/github.com/hatunet/spring-data-mybatis-samples/build/classes/main/org/springframework/data/mybatis/samples/config/DatabaseLoader.class]: Unsatisfied dependency expressed through constructor parameter 2; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'siteFunctionRepository': Invocation of init method failed; nested exception is org.springframework.data.mybatis.repository.support.MybatisQueryException: can not find property: siteService from entity: org.springframework.data.mybatis.samples.security.SiteService
    	at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:749) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	at org.springframework.beans.factory.support.ConstructorResolver.autowireConstructor(ConstructorResolver.java:189) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireConstructor(AbstractAutowireCapableBeanFactory.java:1193) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1095) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:513) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:483) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:197) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:761) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:866) ~[spring-context-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:542) ~[spring-context-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.refresh(EmbeddedWebApplicationContext.java:122) ~[spring-boot-1.4.4.RELEASE.jar:1.4.4.RELEASE]
    	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:762) [spring-boot-1.4.4.RELEASE.jar:1.4.4.RELEASE]
    	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:372) [spring-boot-1.4.4.RELEASE.jar:1.4.4.RELEASE]
    	at org.springframework.boot.SpringApplication.run(SpringApplication.java:316) [spring-boot-1.4.4.RELEASE.jar:1.4.4.RELEASE]
    	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1187) [spring-boot-1.4.4.RELEASE.jar:1.4.4.RELEASE]
    	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1176) [spring-boot-1.4.4.RELEASE.jar:1.4.4.RELEASE]
    	at org.springframework.data.mybatis.samples.Application.main(Application.java:35) [main/:na]
    Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'siteFunctionRepository': Invocation of init method failed; nested exception is org.springframework.data.mybatis.repository.support.MybatisQueryException: can not find property: siteService from entity: org.springframework.data.mybatis.samples.security.SiteService
    	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1628) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:555) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:483) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:208) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1138) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1066) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	at org.springframework.beans.factory.support.ConstructorResolver.resolveAutowiredArgument(ConstructorResolver.java:835) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:741) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	... 19 common frames omitted
    Caused by: org.springframework.data.mybatis.repository.support.MybatisQueryException: can not find property: siteService from entity: org.springframework.data.mybatis.samples.security.SiteService
    	at org.springframework.data.mybatis.repository.query.PartTreeMybatisQuery.buildQueryCondition(PartTreeMybatisQuery.java:131) ~[spring-data-mybatis-1.0.8.BUILD-SNAPSHOT.jar:na]
    	at org.springframework.data.mybatis.repository.query.PartTreeMybatisQuery.doCreateSelectQueryStatement(PartTreeMybatisQuery.java:234) ~[spring-data-mybatis-1.0.8.BUILD-SNAPSHOT.jar:na]
    	at org.springframework.data.mybatis.repository.query.PartTreeMybatisQuery.doCreateCollectionQueryStatement(PartTreeMybatisQuery.java:249) ~[spring-data-mybatis-1.0.8.BUILD-SNAPSHOT.jar:na]
    	at org.springframework.data.mybatis.repository.query.PartTreeMybatisQuery.doCreateQueryStatement(PartTreeMybatisQuery.java:268) ~[spring-data-mybatis-1.0.8.BUILD-SNAPSHOT.jar:na]
    	at org.springframework.data.mybatis.repository.query.PartTreeMybatisQuery.<init>(PartTreeMybatisQuery.java:85) ~[spring-data-mybatis-1.0.8.BUILD-SNAPSHOT.jar:na]
    	at org.springframework.data.mybatis.repository.query.MybatisQueryLookupStrategy$CreateQueryLookupStrategy.resolveQuery(MybatisQueryLookupStrategy.java:71) ~[spring-data-mybatis-1.0.8.BUILD-SNAPSHOT.jar:na]
    	at org.springframework.data.mybatis.repository.query.MybatisQueryLookupStrategy$CreateIfNotFoundQueryLookupStrategy.resolveQuery(MybatisQueryLookupStrategy.java:120) ~[spring-data-mybatis-1.0.8.BUILD-SNAPSHOT.jar:na]
    	at org.springframework.data.mybatis.repository.query.MybatisQueryLookupStrategy$AbstractQueryLookupStrategy.resolveQuery(MybatisQueryLookupStrategy.java:50) ~[spring-data-mybatis-1.0.8.BUILD-SNAPSHOT.jar:na]
    	at org.springframework.data.repository.core.support.RepositoryFactorySupport$QueryExecutorMethodInterceptor.<init>(RepositoryFactorySupport.java:435) ~[spring-data-commons-1.12.7.RELEASE.jar:na]
    	at org.springframework.data.repository.core.support.RepositoryFactorySupport.getRepository(RepositoryFactorySupport.java:220) ~[spring-data-commons-1.12.7.RELEASE.jar:na]
    	at org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport.initAndReturn(RepositoryFactoryBeanSupport.java:280) ~[spring-data-commons-1.12.7.RELEASE.jar:na]
    	at org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport.afterPropertiesSet(RepositoryFactoryBeanSupport.java:266) ~[spring-data-commons-1.12.7.RELEASE.jar:na]
    	at org.springframework.data.mybatis.repository.support.MybatisRepositoryFactoryBean.afterPropertiesSet(MybatisRepositoryFactoryBean.java:55) ~[spring-data-mybatis-1.0.8.BUILD-SNAPSHOT.jar:na]
    	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1687) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1624) ~[spring-beans-4.3.6.RELEASE.jar:4.3.6.RELEASE]
    	... 30 common frames omitted
    

    
## Projection type must be an interface 

__spring-data-mybatis : f22774e__ (approx 1.0.8.SNAPSHOT, after this commit spring-data-mybatis is corrupt)

Ticket https://github.com/hatunet/spring-data-mybatis/issues/85

    git checkout projection
    ./gradlew build --info && java -jar build/libs/spring-data-mybatis-testing-0.1.0.war
    
### Test

    curl http://localhost:8080/siteContents
    
### Expected

HTTP 200
    
### Result

    {"timestamp":1486030282864,"status":500,"error":"Internal Server Error","exception":"org.springframework.http.converter.HttpMessageNotWritableException","message":"Could not write content: Projection type must be an interface! (through reference chain: org.springframework.hateoas.Resources[\"_embedded\"]->java.util.Collections$UnmodifiableMap[\"siteContents\"]->java.util.ArrayList[0]->org.springframework.data.rest.webmvc.json.PersistentEntityJackson2Module$ProjectionResource[\"content\"]->com.sun.proxy.$Proxy118[\"siteFunction\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: Projection type must be an interface! (through reference chain: org.springframework.hateoas.Resources[\"_embedded\"]->java.util.Collections$UnmodifiableMap[\"siteContents\"]->java.util.ArrayList[0]->org.springframework.data.rest.webmvc.json.PersistentEntityJackson2Module$ProjectionResource[\"content\"]->com.sun.proxy.$Proxy118[\"siteFunction\"])","path":"/siteContents"}
    


    

        
