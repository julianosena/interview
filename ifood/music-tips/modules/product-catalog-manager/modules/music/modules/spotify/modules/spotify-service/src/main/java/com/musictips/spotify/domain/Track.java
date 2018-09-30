package com.musictips.spotify.domain;

import lombok.*;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter @Setter
public class Track implements Serializable {

    private static final long serialVersionUID = 8682367014586794357L;

    private String name;
}
