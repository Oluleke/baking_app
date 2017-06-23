package rainmekka.andela.com.baking_app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

import rainmekka.andela.com.baking_app.R;
import rainmekka.andela.com.baking_app.data.IngredientListAdapter;
import rainmekka.andela.com.baking_app.data.ReciepeStepClass;
import rainmekka.andela.com.baking_app.data.RecipeIngredientClass;

/**
 * Created by Oluleke on 6/20/2017.
 */

public class StepDetailsActivity extends AppCompatActivity {

    ReciepeStepClass mRecipeStep = new ReciepeStepClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_details);

        Intent intent = getIntent();
        mRecipeStep = intent.getParcelableExtra("reciepe_steps");

        TextView txtStepDetails = (TextView)findViewById(R.id.txt_step_details) ;

        txtStepDetails.setText(mRecipeStep.description);

        //ToDo: load video into mediacontroller

    }
}
