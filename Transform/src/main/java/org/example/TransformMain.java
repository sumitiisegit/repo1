package org.example;

import java.io.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class TransformMain {

    private Map<String, String> constructs = new HashMap<String,String>();

    public static void main(String args[]) {

    }

    public void initializeConstructsJava(){
        constructs.put("variable","variable");
        constructs.put("while","while::{condition}");
    }

    public void processJson(String inputJson){
        try {
            Object obj = new JSONParser().parse(inputJson);
            JSONObject jsonObject = (JSONObject) obj;
            //jsonObject.

        }catch (org.json.simple.parser.ParseException e){
            System.out.println("parse exception:"+e);

        }
    }

}
