package com.musictips.spotify.config;

import com.musictips.spotify.usecase.AuthenticateApplicationSpotifyUseCase;
import feign.Response;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Aspect
@Configuration
public class ReAuthorizeApplicationOnSpotifyApi {

    @Autowired
    private AuthenticateApplicationSpotifyUseCase authenticateApplicationSpotifyUseCase;


    @Before("execution(* com.musictips.spotify.config.feign.client.configuration.SpotifyClientConfiguration.SpotifyErrorDecoder.decode(..))")
    public void authenticate(JoinPoint joinPoint){
        Response response = (Response) joinPoint.getArgs()[1];
        if(response.status() == HttpStatus.UNAUTHORIZED.value())
            authenticateApplicationSpotifyUseCase.execute("client_credentials");
    }

}
