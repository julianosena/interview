package com.musictips.thermometer.gateway.model.validator;

import com.musictips.thermometer.gateway.model.GetMusicTracksRequestModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static org.springframework.util.StringUtils.isEmpty;

public class GetMusicTracksRequestModelValidator implements ConstraintValidator<GetMusicTracksRequest, GetMusicTracksRequestModel> {

    /**
     * Implements the validation logic.
     * The state of {@code value} must not be altered.
     * <p>
     * This method can be accessed concurrently, thread-safety must be ensured
     * by the implementation.
     *
     * @param model   object to validate
     * @param context context in which the constraint is evaluated
     * @return {@code false} if {@code value} does not pass the constraint
     */
    @Override
    public boolean isValid(GetMusicTracksRequestModel model, ConstraintValidatorContext context) {
        String cityName = model.getCityName();
        String lat = model.getLat();
        String lon = model.getLon();

        if(!isEmpty(cityName)){
            if(!isEmpty(lat) || !isEmpty(lon)){
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("If you are searching by City name, don't send lat and lon parameters").addConstraintViolation();
                return false;
            } else if ((lat != null && lat.isEmpty()) || (lon != null && lon.isEmpty())){
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("If you are searching by City name, don't send lat and lon parameters").addConstraintViolation();
                return false;
            }
        }

        else if(!isEmpty(lat) && !isEmpty(lat)){
            if(!isEmpty(cityName)){
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("If you are searching by lat and lon, don't send cityName parameter").addConstraintViolation();
                return false;
            } else if (cityName != null && cityName.isEmpty()){
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("If you are searching by lat and lon, don't send cityName parameter").addConstraintViolation();
                return false;
            }

            try {
                Double.valueOf(model.getLat());
                Double.valueOf(model.getLon());
            } catch (NumberFormatException e){
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Lat and Lon should be numbers").addConstraintViolation();
                return false;
            }

        } else {
            return false;
        }

        return true;
    }
}
