package com.ghostbuster.warsawApi.domain.external.warsaw

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.ghostbuster.warsawApi.utils.UpperCaseWithUnderscoresStrategy
import groovy.transform.CompileStatic

@CompileStatic
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(UpperCaseWithUnderscoresStrategy)
class Property {

    String RODZAJ
    String DZIELNICE
    String KONTAKT
    String LOKAL_NR
    String CENA_WYWOLAWCZA_PODSTAWOWA
    String ADRES
    String POW_PODSTAWOWA
    String POLOZENIA
    String OGLOSZENIE
    Integer ID_FORMA_WSTAPIENIA
    String USYTUOWANIA
    String PRZEZNACZENIE
    Integer ID_RODZAJ
    String POW_DODATKOWA
    String FORMA_WSTAPIENIA
    Integer ID_USYTUOWANIA
    String LOKAL_OPIS
    Integer ID
}
