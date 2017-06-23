package rainmekka.andela.com.baking_app.ui;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

import rainmekka.andela.com.baking_app.R;
import rainmekka.andela.com.baking_app.data.IngredientListAdapter;
import rainmekka.andela.com.baking_app.data.RecipeIngredientClass;

/**
 * Created by Oluleke on 6/20/2017.
 */

public class IngredientsFragment extends Fragment {

    ArrayList<RecipeIngredientClass> mRecipeIngredientClass = new ArrayList<>();

    public IngredientsFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);

        final View rootView = inflater.inflate(R.layout.fragment_ingredients, container, false);

        GridView ingredientsView = (GridView)rootView.findViewById(R.id.frag_ingredient_details_grid);
        ingredientsView.setNumColumns(1);

        IngredientListAdapter mAdapter = new IngredientListAdapter(getContext(), mRecipeIngredientClass);

        // Set the adapter on the GridView
        ingredientsView.setAdapter(mAdapter);

        return rootView;

    }
    public void setReciepeIngredientList(ArrayList<RecipeIngredientClass> RecipeIngredientClass) {
        mRecipeIngredientClass = RecipeIngredientClass;
    }
}
