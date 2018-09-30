package com.musictips.spotify.gateway;

import com.musictips.spotify.config.feign.client.configuration.SpotifyAuthorizeClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedHashMap;

@FeignClient(name = "spotify-account-api", url = "https://accounts.spotify.com", configuration = SpotifyAuthorizeClientConfiguration.class)
public interface SpotifyAccountApiFeignClientGateway {

    @RequestMapping(method = RequestMethod.POST, value = "api/token")
    LinkedHashMap<String, String> token(@RequestBody String grantType);

}