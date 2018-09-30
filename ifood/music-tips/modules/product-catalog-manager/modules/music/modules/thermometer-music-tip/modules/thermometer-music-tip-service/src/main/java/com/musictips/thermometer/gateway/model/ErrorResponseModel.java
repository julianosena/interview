package com.musictips.thermometer.gateway.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Builder
@Getter @Setter
public class ErrorResponseModel implements Serializable {

    private static final long serialVersionUID = -4273965205952861400L;

    private final Map<String, String> messages = new HashMap<>();
}