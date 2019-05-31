package com.wd.http.okhttp;

import okhttp3.*;
import sun.rmi.runtime.Log;

import java.io.IOException;

public class Test {

    public static void main(String[] arg0){
        String url = "http://wwww.baidu.com";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("onFailure: " + e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("OnResponse: " + response.body().toString());
                System.out.println(response.body().source().readUtf8());
            }
        });
    }
}
