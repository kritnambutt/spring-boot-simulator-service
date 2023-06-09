/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.2.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.aiaplushk.server.api.User;

import com.aiaplushk.server.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-03-02T15:20:36.062710+07:00[Asia/Bangkok]")
@Validated
@Api(value = "users", description = "the users API")
public interface UsersApi {

    default UsersApiDelegate getDelegate() {
        return new UsersApiDelegate() {};
    }

    /**
     * GET /users : Get All Users
     * Get All Users
     *
     * @return OK (status code 200)
     */
    @ApiOperation(value = "Get All Users", nickname = "getAllUsers", notes = "Get All Users", response = User.class, responseContainer = "List", tags={ "example-tag", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = User.class, responseContainer = "List") })
    @GetMapping(
        value = "/users",
        produces = { "application/json" }
    )
    default ResponseEntity<String> getAllUsers() {
        return getDelegate().getAllUsers();
    }

}
