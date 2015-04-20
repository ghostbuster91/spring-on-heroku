package com.ghostbuster.warsawApi.consumer.warsaw

class WarsawApiRequestBuilder {

    private final static String API_KEY = 'f466c384-f5cc-4787-af44-1468697daf47'
    private final static String PROPERTY_RENT = '45ba10ab-6562-49ce-b572-6c9b999464d6'
    private final static String PROPERTY_PURCHASE = 'baa1d9c9-4a90-401d-b215-57b1ed09e694'

    private final StringBuilder url = new StringBuilder("https://api.um.warszawa.pl/api/action/wfsstore_get/?id=") //${PROPERTY_RENT}&limit=5&apikey=${API_KEY}")

    private WarsawApiRequestBuilder(String apiId){
        url.append(apiId).append("&apikey=${API_KEY}")
    }


    static WarsawApiRequestBuilder forPropertyRent(){
        return new WarsawApiRequestBuilder(PROPERTY_RENT)
    }

    static WarsawApiRequestBuilder forPropertyPurchase(){
        return new WarsawApiRequestBuilder(PROPERTY_PURCHASE)
    }

    WarsawApiRequestBuilder limitResults(Integer limit){
        url.append("&limit=${limit}")
        return this
    }

    String built(){
        return url.toString()
    }
}
