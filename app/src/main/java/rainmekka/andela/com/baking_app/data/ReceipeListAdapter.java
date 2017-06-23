package rainmekka.andela.com.baking_app.data;

/**
 * Created by Oluleke on 6/20/2017.
 */


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import rainmekka.andela.com.baking_app.R;
import rainmekka.andela.com.baking_app.ui.MainActivity;
import rainmekka.andela.com.baking_app.ui.ReciepeDetailsActivity;


// Custom adapter class that displays a list of Android-Me images in a GridView
public class ReceipeListAdapter extends BaseAdapter {

    // Keeps track of the context and list of images to display
    private Context mContext;
    private ArrayList<ReciepeClass> mReciepeList;

    /**
     * Constructor method
     * @param ReciepeList The list of recipes to display
     */
    public ReceipeListAdapter(Context context, ArrayList<ReciepeClass> ReciepeList) {
        mContext = context;
        mReciepeList = ReciepeList;
    }

    /**
     * Returns the number of items the adapter will display
     */
    @Override
    public int getCount() {
        return mReciepeList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    /**
     * Creates a new ImageView for each item referenced by the adapter
     */
    public View getView(final int position, View convertView, ViewGroup parent) {
        Button btnRecipe;
        if (convertView == null) {
            // If the view is not recycled, this creates a new ImageView to hold an image
            btnRecipe = new Button(mContext);

            // Define the layout parameters
            btnRecipe.setWidth(parent.getWidth());
            btnRecipe.setHeight(300);
            btnRecipe.setTextSize(30);
            //btnRecipe.setTextAlignment();

            //Todo Redesign Button
        } else {
            btnRecipe = (Button) convertView;
        }

        ///final Button button = (Button) findViewById(R.id.button_id);
        btnRecipe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                //pass recipeClass to Reciepe Activity

                final Intent activityChangeIntent = new Intent(mContext, ReciepeDetailsActivity.class);

                activityChangeIntent.putExtra("reciepe_item",mReciepeList.get(position));
                //activityChangeIntent.putExtra("reciepe_context",mReciepeList.get(position));

                Toast.makeText(mContext, "Position clicked = " + position, Toast.LENGTH_SHORT).show();

                mContext.startActivity(activityChangeIntent);


            }
        });


        btnRecipe.setText(mReciepeList.get(position).name);

        return btnRecipe;
    }

}

