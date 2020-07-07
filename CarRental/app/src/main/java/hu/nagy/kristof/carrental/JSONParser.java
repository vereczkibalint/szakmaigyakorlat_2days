package hu.nagy.kristof.carrental;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class JSONParser {
    public static String readJSON(Context context) {
        String json = null;
        try {
            // Opening data.json file
            InputStream inputStream = context.getAssets().open("cars.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            // read values in the byte array
            inputStream.read(buffer);
            inputStream.close();
            // convert byte to string
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return json;
        }
        return json;
    }

    public static ArrayList<Car> fetchCars(Context context){
        ArrayList<Car> cars = new ArrayList<Car>();
        try{
            JSONObject object = new JSONObject(readJSON(context));
            JSONArray array = object.getJSONArray("cars");

            for(int i = 0; i < array.length(); i++){
                JSONObject jsonObject = array.getJSONObject(i);
                String brand = jsonObject.getString("brand");
                String model = jsonObject.getString("model");
                Integer year = Integer.parseInt(jsonObject.getString("year"));
                Integer pricePerDay = Integer.parseInt(jsonObject.getString("pricePerDay"));
                Boolean borrowable = Boolean.parseBoolean(jsonObject.getString("borrowable"));
                Car car = new Car(brand,model,year,pricePerDay,borrowable);
                cars.add(car);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return cars;
    }
}
