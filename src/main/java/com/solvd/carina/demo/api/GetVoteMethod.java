package com.solvd.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import io.restassured.http.Header;

public class GetVoteMethod extends AbstractApiMethodV2 {

    public GetVoteMethod() {
        super(null, "api/users/_get/votes.json", "api/users/api.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        request.header(new Header("x-api-key", super.getProperties().getProperty("api_key")));
    }
}
