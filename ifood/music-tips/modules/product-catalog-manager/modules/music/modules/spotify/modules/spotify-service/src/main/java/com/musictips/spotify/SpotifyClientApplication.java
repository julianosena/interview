package com.musictips.spotify;

import com.musictips.spotify.usecase.AuthenticateApplicationSpotifyUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.annotation.PostConstruct;

@Configuration
@EnableFeignClients(basePackages = "com.musictips.spotify.gateway")
@EnableAspectJAutoProxy
public class SpotifyClientApplication {

    @Autowired
    AuthenticateApplicationSpotifyUseCase authenticateApplicationSpotifyUseCase;

    @PostConstruct
    public void initialization(){
        this.authenticateApplicationSpotifyUseCase.execute("client_credentials");
    }

}
