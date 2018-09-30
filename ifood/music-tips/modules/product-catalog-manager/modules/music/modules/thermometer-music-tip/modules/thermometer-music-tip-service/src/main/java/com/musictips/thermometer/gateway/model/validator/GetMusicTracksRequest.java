package com.musictips.thermometer.gateway.model.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = GetMusicTracksRequestModelValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.TYPE })
public @interface GetMusicTracksRequest {

    String message() default "Search by city name or lat and long";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}