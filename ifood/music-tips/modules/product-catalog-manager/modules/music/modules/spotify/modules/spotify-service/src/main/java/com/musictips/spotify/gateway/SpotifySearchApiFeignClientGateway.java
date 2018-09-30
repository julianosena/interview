package com.musictips.spotify.gateway;

import com.musictips.spotify.config.feign.client.configuration.SpotifySearchClientConfiguration;
import com.musictips.spotify.gateway.feign.fallback.factory.SpotifySearchClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;

@FeignClient(name = "spotify-search-api",
    url = "https://api.spotify.com",
    configuration = SpotifySearchClientConfiguration.class,
    fallbackFactory = SpotifySearchClientFallbackFactory.class)
public interface SpotifySearchApiFeignClientGateway {

    @RequestMapping(method = RequestMethod.GET, value = "v1/search", consumes = "application/json")
    LinkedHashMap<Object, Object> search(@RequestParam("q") String query, @RequestParam("type") String type, @RequestParam("limit") Integer limit, @RequestParam("offset") Integer offset);

}
