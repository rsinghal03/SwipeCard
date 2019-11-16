package com.example.swipecard.networking

import okhttp3.*

class DataResponseInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        val body = response.body()?.string()
        val standardJsonResponse = body?.drop(1)
        return Response.Builder()
            .addHeader("Content-Type", "application/json")
            .protocol(Protocol.HTTP_2)
            .body(ResponseBody.create(MediaType.parse("application/json"), standardJsonResponse))
            .request(request)
            .code(response.code())
            .message(response.message())
            .build()
    }
}