package com.solvd.carina.demo.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vote {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("image_id")
    private String imageId;
    @JsonProperty("sub_id")
    private String subId;
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("value")
    private int value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
