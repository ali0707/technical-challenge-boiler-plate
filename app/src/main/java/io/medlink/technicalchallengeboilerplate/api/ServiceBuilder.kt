package io.medlink.technicalchallengeboilerplate.api



object ServiceBuilder {

//done
// TODO: Add the base URL
    private const val API_BASE_URL = "http://192.168.1.135:3000"
    const val API_SERVER_PORT = "/dev"
    const val API_SERVER_URL = "${API_BASE_URL}${API_SERVER_PORT}/"
    fun getServiceClass(java: Class<NumbersService>): NumbersService? {
        return RetrofitAPI.getRetrofit(API_SERVER_URL).create(NumbersService::class.java)
    }
}
