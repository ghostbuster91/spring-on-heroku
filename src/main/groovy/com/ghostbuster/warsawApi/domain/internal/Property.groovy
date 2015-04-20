package com.ghostbuster.warsawApi.domain.internal

import groovy.transform.Canonical
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode

@CompileStatic
@Canonical
@EqualsAndHashCode(excludes = "apiInfo")
class Property {

    final String id
    final String latitude
    final String longitude
    final String name

    final WarsawApiInfo apiInfo = new WarsawApiInfo()
}