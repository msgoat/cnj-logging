package group.msg.at.cloud.cloudtrain.adapter.rest;

import group.msg.at.cloud.common.test.JsonpAssertions;
import group.msg.at.cloud.common.test.adapter.rest.RestAssuredSystemTestFixture;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

/**
 * System test that verifies that the REST endpoint works as expected.
 * <p>
 * Assumes that a remote server hosting the REST endpoint is up and running.
 * </p>
 */
public class GrantedPermissionsEndpointSystemTest {

    private static final RestAssuredSystemTestFixture fixture = new RestAssuredSystemTestFixture();

    private final List<String> trashBin = new ArrayList<>();

    @BeforeAll
    public static void onBeforeClass() {
        fixture.onBefore();
    }

    @AfterAll
    public static void onAfterClass() {
        fixture.onAfter();
    }

    @AfterEach
    public void onAfter() {
    }

    @Test
    public void getWithProjectNameReturnsExpectedPermissions() {
        ExtractableResponse response = given().log().body(true).auth().oauth2(fixture.getAccessToken())
                .accept(ContentType.JSON)
                .get("api/v1/grantedPermissions")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract();
        JsonArray permissions = asJsonArray(response);
        assertFalse(permissions.isEmpty(), "permissions must not be empty!");
    }

    private JsonArray asJsonArray(ExtractableResponse response) {
        JsonArray result = null;
        try (InputStream in = response.body().asInputStream()) {
            result = Json.createReader(in).readArray();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return result;
    }

}
