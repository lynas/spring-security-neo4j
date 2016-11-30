package com.lynas.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

/**
 * Created by LynAs on 23-Jan-16
 */
@Configuration
@ComponentScan("com.lynas")
@PropertySource("classpath:application.properties")
open class RootConfig
