package rainmekka.andela.com.baking_app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import rainmekka.andela.com.baking_app.R;
import rainmekka.andela.com.baking_app.data.ReciepeClass;


/**
 * Created by Oluleke on 6/20/2017.
 */

public class ReciepeDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciepe_details);

        //get data reciepe from intent
        Intent intent = getIntent();
        ReciepeClass reciepeClass = intent.getParcelableExtra("reciepe_item");

        ReciepeDetailsFragment reciepeDetailsFragment = new ReciepeDetailsFragment();

        reciepeDetailsFragment.setRecipeClassObject(reciepeClass);

        FragmentManager fragmentManager = getSupportFragmentManager();

        //load reciepe details fragment
        fragmentManager.beginTransaction()
                .add(R.id.receipe_details, reciepeDetailsFragment)
                .commit();


    }


}
