package com.lynas.service

import com.lynas.config.SpringSecurityUser
import com.lynas.model.AppUser
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

/**
 * Created by lynas on 9/9/2016
 */
@Service
open class UserDetailService(var appUserService: AppUserService) : UserDetailsService {


    override fun loadUserByUsername(userName: String): UserDetails {
        // todo need to fix to get in from db
        val appUser: AppUser? = appUserService.loadUserByUsername(userName)

        /*val appUser: AppUser? = AppUser().apply {
            username = userName
            password = "$2a$10$3mUSOw6gya8AeNnzL7qiaO2p9qeko.rWVpRpRdZQ4SoICglyGQVHa"
            authorities = "ROLE_USER, ROLE_ADMIN"
        }*/

        if (null == appUser) {
            throw UsernameNotFoundException(String.format("No user found with username '%s'" + userName))
        } else {
            return SpringSecurityUser(
                    appUser.id,
                    appUser.username,
                    appUser.password,
                    null,
                    null,
                    AuthorityUtils.commaSeparatedStringToAuthorityList(appUser.authorities)
            )
        }

    }
}