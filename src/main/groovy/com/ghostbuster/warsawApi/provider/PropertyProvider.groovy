package com.ghostbuster.warsawApi.provider

import com.ghostbuster.warsawApi.domain.Property

interface PropertyProvider {

    Property getById(Integer id)
}
