package rainmekka.andela.com.baking_app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

import rainmekka.andela.com.baking_app.R;
import rainmekka.andela.com.baking_app.data.IngredientListAdapter;
import rainmekka.andela.com.baking_app.data.RecipeIngredientClass;

/**
 * Created by Oluleke on 6/20/2017.
 */

public class IngredientsActivity extends AppCompatActivity {

    ArrayList<RecipeIngredientClass> mRecipeIngredientClass = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);

        GridView ingredientsView = (GridView)findViewById(R.id.ingredient_details_grid);
        ingredientsView.setNumColumns(1);

        Intent intent = getIntent();
        mRecipeIngredientClass = intent.getParcelableArrayListExtra("reciepe_ingredients");

        IngredientListAdapter mAdapter = new IngredientListAdapter(this, mRecipeIngredientClass);

        // Set the adapter on the GridView
        ingredientsView.setAdapter(mAdapter);

    }
}
