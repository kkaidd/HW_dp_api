package ru.dp.api.steps;

import io.restassured.response.ValidatableResponse;
import ru.dp.api.models.Pet;
import ru.dp.api.models.PetStatus;
import ru.dp.api.spec.Specs;

import static io.restassured.RestAssured.given;

public class PetSteps {
    public static ValidatableResponse findByStatus(PetStatus status) {
        return given(Specs.PETSTORE_REQUEST_SPEC)
                .when()
                .params("status", status.getCode())
                .get("/pet/findByStatus")
                .then()
                .spec(Specs.OK);
    }

    public static Integer createPet(Pet pet) {
        return given(Specs.PETSTORE_REQUEST_SPEC)
                .body(pet)
                .when()
                .post("/pet")
                .then()
                .spec(Specs.OK)
                .extract().path("id");
    }
}