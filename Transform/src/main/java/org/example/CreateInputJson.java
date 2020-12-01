package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CreateInputJson {

    private Map<String, String> constructs = new HashMap<String,String>();

    public static void main(String args[]) {

        CreateInputJson createInputJson = new CreateInputJson();

        createInputJson.createJson();
    }

    public void createJson(){
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        jsonObject.put("language","java");

        jsonArray.add(jsonObject);

/*        Map map = new LinkedHashMap();
        map = new LinkedHashMap();

        map.put("name","var1");
        map.put("type","number");
        map.put("value","1");

        jsonObject = new JSONObject();
        jsonObject.put("variable",map);

        jsonArray.add(jsonObject);

        map = new LinkedHashMap();
        map.put("condition","var1>2");

        Map map1 = new LinkedHashMap();
        map1.put("statement","var1=2");

        jsonArray.add(map1);

        map.put("operation",jsonArray);

        jsonObject.put("while",map);*/

        System.out.println(jsonArray.toJSONString());


    }

}
