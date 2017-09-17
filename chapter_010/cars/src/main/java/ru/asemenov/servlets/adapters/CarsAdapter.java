package ru.asemenov.servlets.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import ru.asemenov.models.Car;

import java.lang.reflect.Type;

public class CarsAdapter implements JsonSerializer<Car> {

    @Override
    public JsonElement serialize(Car car, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", car.getId());
        jsonObject.addProperty("mark", car.getMark().getName());
        jsonObject.addProperty("model", car.getModel().getName());
        jsonObject.addProperty("body", car.getBody().getName());
        jsonObject.addProperty("year", car.getYear());
        jsonObject.addProperty("distance", car.getDistance());
        jsonObject.addProperty("transmission", car.getTransmission().getName());
        jsonObject.addProperty("engine", car.getEngine().getName());
        jsonObject.addProperty("capacity", car.getCapacity());
        jsonObject.addProperty("price", car.getPrice());
        jsonObject.addProperty("user", car.getUser().getId());
        jsonObject.addProperty("status", car.isStatus());
        return jsonObject;
    }
}
