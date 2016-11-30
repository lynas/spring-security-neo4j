package com.lynas.service

import com.lynas.model.AppUser
import com.lynas.repo.AppUserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by sazzad on 7/19/16
 */

@Service
open class AppUserService(val appUserRepository: AppUserRepository) {

    @Transactional
    open fun save(appUser: AppUser): AppUser? = appUserRepository.save(appUser)

    @Transactional
    open fun findByUserName(username: String): AppUser? = appUserRepository.findByUsername(username)

    @Transactional
    open fun loadUserByUsername(username: String): AppUser? = appUserRepository.findByUsername(username)

    @Transactional
    open fun findById(id:Long): AppUser? = appUserRepository.findOne(id)

}