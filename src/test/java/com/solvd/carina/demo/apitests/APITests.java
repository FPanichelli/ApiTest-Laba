package com.solvd.carina.demo.apitests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.api.*;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

import java.util.List;

public class APITests extends AbstractTest {

    private Long id;

    @Test(groups = "info")
    @MethodOwner(owner = "FacundoPanichelli")
    public void GetBreedData(){
        GetUserMethods getUserMethods = new GetUserMethods();
        getUserMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUserMethods.addParameter("q", "bengal");
        getUserMethods.replaceUrlPlaceholder("page", "/search");
        getUserMethods.callAPI();
        getUserMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test(groups = "info")
    @MethodOwner(owner = "FacundoPanichelli")
    public void getBreeds(){
        GetUserMethods getUserMethods = new GetUserMethods();
        getUserMethods.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUserMethods.replaceUrlPlaceholder("page", "");
        getUserMethods.addParameter("limit", "5");
        getUserMethods.setResponseTemplate("api/users/_get/rsbreeds.json");
        getUserMethods.callAPI();
        getUserMethods.validateResponse();
    }

    @Test(groups = "post", dependsOnGroups = "info")
    @MethodOwner(owner = "FacundoPanichelli")
    public void vote(){
        PostUserMethod postUserMethod = new PostUserMethod();
        postUserMethod.callAPI();
        postUserMethod.validateResponse(JSONCompareMode.STRICT_ORDER);
    }

    @Test(groups = "getID", dependsOnGroups = "post")
    @MethodOwner(owner = "FacundoPanichelli")
    public void getVote() throws JsonProcessingException {
        GetVoteMethod getVoteMethod = new GetVoteMethod();
        getVoteMethod.callAPI();
        getVoteMethod.validateResponse(JSONCompareMode.STRICT_ORDER);

        String rs = getVoteMethod.callAPI().asString();
        TypeReference<List<Vote>> tr = new TypeReference<List<Vote>>() {};
        ObjectMapper om = new ObjectMapper();
        List<Vote> votes = om.readValue(rs, tr);
        id = votes.stream().findFirst().get().getId();
    }

    @Test(groups = "delete", dependsOnGroups = "getID")
    @MethodOwner(owner = "FacundoPanichelli")
    public void delete(){
        DeleteUserMethod deleteUserMethod = new DeleteUserMethod();
        deleteUserMethod.replaceUrlPlaceholder("vote_id", String.valueOf(id));
        deleteUserMethod.callAPI();
        deleteUserMethod.validateResponse();
    }




}
