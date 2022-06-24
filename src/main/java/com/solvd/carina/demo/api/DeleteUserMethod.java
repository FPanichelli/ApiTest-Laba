package com.solvd.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import io.restassured.http.Header;

public class DeleteUserMethod extends AbstractApiMethodV2 {

    public DeleteUserMethod() {
        super("api/users/_delete/rq.json", "api/users/_delete/rs.json", "api/users/api.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        request.header(new Header("x-api-key", super.getProperties().getProperty("api_key")));
    }
}
