package com.musictips.open.weather.map.usecase;

import com.musictips.open.weather.map.gateway.OpenWeatherMapApiFeignClientGateway;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
public class GetTemperatureByCityNameUseCase {

    private OpenWeatherMapApiFeignClientGateway openWeatherMapApiFeignClientGateway;

    public GetTemperatureByCityNameUseCase(OpenWeatherMapApiFeignClientGateway openWeatherMapApiFeignClientGateway){
        this.openWeatherMapApiFeignClientGateway = openWeatherMapApiFeignClientGateway;
    }

    /**
     * Call Open Weather Map Api and gets a city weather temperature
     * @param cityName
     * @return Double
     */
    public Double execute(String cityName) {
        try {
            LinkedHashMap<Object, Object> searchWeatherApiResponseModel = openWeatherMapApiFeignClientGateway.searchByQuery(cityName);

            LinkedHashMap<String, Object> main = (LinkedHashMap<String, Object>) searchWeatherApiResponseModel.get("main");
            if (main.get("temp") instanceof Integer) return Double.valueOf((Integer) main.get("temp"));
            else return (Double) main.get("temp");
        } catch (Exception e){
            //TODO Adicionar no Hystrix
            //Fallback
            return 15.0;
        }
    }

}
