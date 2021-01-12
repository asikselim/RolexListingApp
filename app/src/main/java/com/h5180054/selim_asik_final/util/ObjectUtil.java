package com.h5180054.selim_asik_final.util;

import com.google.gson.Gson;
import com.h5180054.selim_asik_final.model.SaatModel;


public class ObjectUtil {
    public  static String saatToJsonString(SaatModel saatModel)
    {
        Gson gson = new Gson();
        return   gson.toJson(saatModel);
    }
    public  static SaatModel jsonStringToSaat(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString,SaatModel.class);
    }
}