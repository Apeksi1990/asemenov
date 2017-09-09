package ru.asemenov.servlets.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import ru.asemenov.models.Mark;

import java.lang.reflect.Type;

public class MarkAdapter implements JsonSerializer<Mark> {
    @Override
    public JsonElement serialize(Mark mark, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", mark.getId());
        jsonObject.addProperty("name", mark.getName());
        jsonObject.add("models", jsonSerializationContext.serialize(mark.getModels()));
        return jsonObject;
    }
}
