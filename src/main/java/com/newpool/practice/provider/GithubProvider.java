package com.newpool.practice.provider;

import com.alibaba.fastjson.JSON;
import com.newpool.practice.dto.AccessTokenDTO;
import com.newpool.practice.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * @program: practice
 * @description:
 * @author: zp
 * @create: 2020-09-03 15:42
 **/
@Component
public class GithubProvider {
        public String getAccessToken(AccessTokenDTO accessTokenDTO){
            MediaType mediaType = MediaType.get("application/json; charset=utf-8");
            OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(mediaType , JSON.toJSONString(accessTokenDTO) );
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String string =response.body().string();
                String access_token = string.split("&")[0].split("=")[1];
                return access_token;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public GithubUser getUser(String accessToken){
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.github.com/user?access_token=" + accessToken)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                String string =response.body().string();
                GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
                return  githubUser;
            } catch (IOException e) {
            }
            return null;
        }
}
