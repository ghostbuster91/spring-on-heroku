package hello

import groovy.transform.Canonical
import groovy.transform.CompileStatic

@CompileStatic
@Canonical
class Greeting {

    final long id
    final String content
}
