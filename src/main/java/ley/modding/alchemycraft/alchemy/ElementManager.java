package ley.modding.alchemycraft.alchemy;

import ley.modding.alchemycraft.alchemy.json.ElementJson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementManager {

    public static List<Element> elements;
    static Map<Integer, Element> signatures;
    static Map<Integer, IResult> combinationResults;


    public static void loadElements() {
        elements = new ArrayList<Element>();
        signatures = new HashMap<Integer, Element>();
        combinationResults = new HashMap<Integer, IResult>();

        InputStreamReader reader = new InputStreamReader(ElementManager.class.getClassLoader().getResourceAsStream("assets/alchemycraft/elements.json"));

        ElementJson json = ElementJson.fromJSON(reader);
        for (Element e : json.elements) {
            elements.add(e.num, e);
            signatures.put(e.signature, e);
        }

        for (String s : json.combinations.keySet()) {
            List<ElementJson.CombinationResult> res = json.combinations.get(s);
            combinationResults.put(Integer.valueOf(s), new DefaultResult(res.get(0).results)); //TODO Chances
        }
    }

    public static List<Element> combine(Element e1, Element e2) {
        List<Element> result = new ArrayList<Element>();
        int signature = 0;
        if (e1.signature != e2.signature)
            signature = e1.signature ^ e2.signature;
        else
            signature = e1.signature;
        if (combinationResults.containsKey(signature)) {
            int[] res = combinationResults.get(signature).getResult();
            for (int i : res) {
                result.add(signatures.get(i));
            }
        } else {
            result.add(e1);
            result.add(e2);
        }
        return result;
    }

}
