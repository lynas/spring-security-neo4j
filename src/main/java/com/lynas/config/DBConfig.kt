package com.lynas.config

import org.neo4j.ogm.session.Session
import org.neo4j.ogm.session.SessionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.data.neo4j.config.Neo4jConfiguration
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement


@Configuration
@EnableNeo4jRepositories("com.lynas.repo")
@EnableTransactionManagement
open class DBConfig(environment: Environment) : Neo4jConfiguration() {
    val neo4jDB_URL: String = environment.getProperty("db.local.url")

    @Bean
    override fun getSessionFactory() = SessionFactory(getConfiguration(), "com.lynas.model")

    @Bean
    @Throws(Exception::class)
    override fun getSession(): Session = super.getSession()

    @Bean
    open fun getConfiguration() = org.neo4j.ogm.config.Configuration().apply {
        driverConfiguration()
                .setDriverClassName("org.neo4j.ogm.drivers.bolt.driver.BoltDriver")
                .setConnectionPoolSize(150)
                .uri = "bolt://neo4j:123456@localhost:7687"
    }


    /*   @Bean
       open fun getConfiguration(): org.neo4j.ogm.config.Configuration {
           return org.neo4j.ogm.config.Configuration().apply {
               driverConfiguration()
                   .setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver")
                   .setURI("http://neo4j:123456@localhost:7474")
           }
       }*/


}