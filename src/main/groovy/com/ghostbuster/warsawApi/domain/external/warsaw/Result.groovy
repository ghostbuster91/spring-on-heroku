package com.ghostbuster.warsawApi.domain.external.warsaw

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.ghostbuster.warsawApi.domain.common.Coordinate
import groovy.transform.CompileStatic

@CompileStatic
@JsonIgnoreProperties(ignoreUnknown = true)
class Result {
    List<ContainerEntity> featureMemberList
    List<Coordinate> featureMemberCoordinates
}
