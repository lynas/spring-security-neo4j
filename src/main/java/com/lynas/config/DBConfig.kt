package com.lynas.config

import org.neo4j.ogm.session.Session
import org.neo4j.ogm.session.SessionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.core.env.Environment
import org.springframework.data.neo4j.config.Neo4jConfiguration
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

/**
 * Created by LynAs on 7/16/2016
 */

@Configuration
@EnableNeo4jRepositories(basePackages = arrayOf("com.lynas.repo"))
@EnableTransactionManagement
open class DBConfig(environment: Environment) : Neo4jConfiguration() {

    val neo4jDB_URL: String = environment.getProperty("db.local.url")

    @Bean
    override fun getSessionFactory() = SessionFactory(getConfiguration(), "com.lynas.model")


    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    @Throws(Exception::class)
    override fun getSession(): Session = super.getSession()


    @Bean
    open fun getConfiguration() = org.neo4j.ogm.config.Configuration().apply {
        driverConfiguration()
                .setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver")
                .uri = neo4jDB_URL
    }

}