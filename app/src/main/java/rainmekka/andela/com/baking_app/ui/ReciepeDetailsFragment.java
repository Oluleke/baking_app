package rainmekka.andela.com.baking_app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

import rainmekka.andela.com.baking_app.R;
import rainmekka.andela.com.baking_app.data.ReciepeClass;
import rainmekka.andela.com.baking_app.data.ReciepeStepListAdapter;


/**
 * Created by Oluleke on 6/20/2017.
 */

public class ReciepeDetailsFragment extends Fragment {

    public ReciepeClass mReciepeClass = new ReciepeClass();

    public ReciepeDetailsFragment(){}


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.fragment_recipe_details, container, false);

        GridView ingredientsView = (GridView)rootView.findViewById(R.id.receipes_steps_gridview);
        ingredientsView.setNumColumns(1);

        ReciepeStepListAdapter mAdapter = new ReciepeStepListAdapter(getContext(), mReciepeClass.receipeStepList);

        ingredientsView.setAdapter(mAdapter);

        return rootView;
    }

    public void setRecipeClassObject(ReciepeClass reciepeClass) {
        mReciepeClass = reciepeClass;
    }


    //public void onClick(View v)
    public void showIngredients(View v){
        //display ingredients activity

        /** ToDO: Check if in two pane mode or one.
         * if two pane. Use fragments instead....
         */

        Intent ingredientDetails = new Intent(getContext(), IngredientsActivity.class);

        ingredientDetails.putParcelableArrayListExtra("reciepe_ingredients",
                mReciepeClass.receipeIngredientList);
        getContext().startActivity(ingredientDetails);
    }
}
