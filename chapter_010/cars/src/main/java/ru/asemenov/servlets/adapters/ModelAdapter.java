package ru.asemenov.servlets.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import ru.asemenov.models.Model;

import java.lang.reflect.Type;

public class ModelAdapter implements JsonSerializer<Model> {
    @Override
    public JsonElement serialize(Model model, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", model.getId());
        jsonObject.addProperty("name", model.getName());
        jsonObject.addProperty("mark", model.getMark().getName());
        return jsonObject;
    }
}
