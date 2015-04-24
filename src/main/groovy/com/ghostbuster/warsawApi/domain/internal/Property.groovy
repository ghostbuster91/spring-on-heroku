package com.ghostbuster.warsawApi.domain.internal

import com.ghostbuster.warsawApi.domain.common.Coordinate
import com.ghostbuster.warsawApi.domain.external.warsaw.KeyValue
import com.ghostbuster.warsawApi.domain.external.warsaw.ContainerEntity
import groovy.transform.Canonical
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode

@CompileStatic
@Canonical
@EqualsAndHashCode(excludes = "apiInfo")
class Property {

    final String id
    final List<Coordinate> coordinates
    final String name

    final WarsawApiInfo apiInfo = new WarsawApiInfo()

    public Property(){}

    public Property(ContainerEntity entity){
        coordinates = entity?.geometry?.coordinates
        id = entity.properties.find {KeyValue kv -> kv.key == 'ID' }?.value
        name = '?'
    }

}