package com.ghostbuster.springOnHeroku.model

import groovy.transform.Canonical
import groovy.transform.CompileStatic
import org.springframework.hateoas.ResourceSupport

@CompileStatic
@Canonical
class Greeting extends ResourceSupport {

    final String content
}
