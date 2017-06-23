package rainmekka.andela.com.baking_app.rest;

import android.support.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import rainmekka.andela.com.baking_app.data.ReciepeClass;
import rainmekka.andela.com.baking_app.data.ReciepeStepClass;
import rainmekka.andela.com.baking_app.data.RecipeIngredientClass;

/**
 * Created by Oluleke on 6/20/2017.
 */

public class FetchRecipes {

    private ArrayList<ReciepeClass> mReciepeList = new ArrayList<>();
    final public static String reciepeURL = "http://go.udacity.com/android-baking-app-json";
    //get data

    public FetchRecipes (){

        NetworkOkHttpUtil getReviewData = new NetworkOkHttpUtil();

        try {
            JSONArray reciepeArray = getReviewData.execute(reciepeURL).get();

            for (int i = 0; i < reciepeArray.length(); i++) {
                JSONObject json_reciepe_data = reciepeArray.getJSONObject(i);
                ReciepeClass reciepeClass = new ReciepeClass();

                //Add MovieData to Reciepe List
                reciepeClass.id = json_reciepe_data.getString("id");
                reciepeClass.name = "Reciepe for : " + json_reciepe_data.getString("name");
                reciepeClass.servings = json_reciepe_data.getString("servings");
                reciepeClass.image = json_reciepe_data.getString("image");

                //ToDo Use GSon?
                //Get Ingredients Array

                JSONArray ingJSONArray = json_reciepe_data.getJSONArray("ingredients");

                ArrayList<RecipeIngredientClass> ingredientClasses =
                        new ArrayList<>();

                for (int j = 0; j < ingJSONArray.length(); j++){
                    JSONObject json_ingredients_data = ingJSONArray.getJSONObject(j);
                    RecipeIngredientClass ingClass = new RecipeIngredientClass();

                    ingClass.ingredient = json_ingredients_data.getString("ingredient");
                    ingClass.measure = json_ingredients_data.getString("measure");
                    ingClass.quantity = json_ingredients_data.getString("quantity");
                    //ingredientClasses.add(ingClass);

                    reciepeClass.receipeIngredientList.add(ingClass);
                }

                //Get Instructions  Array
                JSONArray stepsJSONArray = json_reciepe_data.getJSONArray("steps");

                ArrayList<ReciepeStepClass> stepsClasses =  new ArrayList<>();

                for (int k = 0; k < stepsJSONArray.length(); k++){
                    JSONObject json_steps_data = stepsJSONArray.getJSONObject(k);
                    ReciepeStepClass stepClass = new ReciepeStepClass();

                    stepClass.id = json_steps_data.getString("id");
                    stepClass.shortDescription = json_steps_data.getString("shortDescription");
                    stepClass.description = json_steps_data.getString("description");
                    stepClass.videoURL = json_steps_data.getString("videoURL");
                    stepClass.thumbnailURL = json_steps_data.getString("thumbnailURL");

                    //stepsClasses.add(stepClass);
                    reciepeClass.receipeStepList.add(stepClass);
                }

                mReciepeList.add(reciepeClass);
            }
        }catch(@NonNull JSONException | InterruptedException | ExecutionException e){
            e.printStackTrace();
        }


    }


    public ArrayList<ReciepeClass> getReciepeList(){

        return mReciepeList;
    }

}
