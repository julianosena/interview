package com.musictips.open.weather.map.usecase;

import com.musictips.open.weather.map.gateway.OpenWeatherMapApiFeignClientGateway;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
public class GetTemperatureByLatitudeAndLongitudeUseCase {

    private OpenWeatherMapApiFeignClientGateway openWeatherMapApiFeignClientGateway;

    public GetTemperatureByLatitudeAndLongitudeUseCase(OpenWeatherMapApiFeignClientGateway openWeatherMapApiFeignClientGateway){
        this.openWeatherMapApiFeignClientGateway = openWeatherMapApiFeignClientGateway;
    }

    /**
     * Call Open Weather Map Api and gets a region of geolocation weather temperature
     * @param latitude
     * @param longitude
     * @return Double
     */
    public Double execute(String latitude, String longitude) {
        LinkedHashMap<Object, Object> searchWeatherApiResponseModel = openWeatherMapApiFeignClientGateway.searchByLatitudeAndLongitude(latitude.trim(), longitude.trim());

        LinkedHashMap<String, Object> main = (LinkedHashMap<String, Object>) searchWeatherApiResponseModel.get("main");
        if (main.get("temp") instanceof Integer) return Double.valueOf((Integer) main.get("temp"));
        else return (Double) main.get("temp");
    }

}
