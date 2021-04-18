package ley.modding.alchemycraft.alchemy.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ley.modding.alchemycraft.alchemy.Element;

import java.io.Reader;
import java.util.List;
import java.util.Map;

public class ElementJson {

    static Gson gson = new GsonBuilder().create();

    public static ElementJson fromJSON(Reader json) {
        return gson.fromJson(json, ElementJson.class);
    }

    public List<Element> elements;
    public Map<String, List<CombinationResult>> combinations;

    public static class CombinationResult {

        public double chance;
        public int[] results;

    }

}
