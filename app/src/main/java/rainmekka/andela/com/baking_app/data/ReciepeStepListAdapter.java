package rainmekka.andela.com.baking_app.data;

/**
 * Created by Oluleke on 6/20/2017.
 */


import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import rainmekka.andela.com.baking_app.ui.IngredientsActivity;
import rainmekka.andela.com.baking_app.ui.StepDetailsActivity;

import static java.security.AccessController.getContext;


// Custom adapter class that displays a list of Android-Me images in a GridView
public class ReciepeStepListAdapter extends BaseAdapter {

    // Keeps track of the context and list of images to display
    private Context mContext;
    private ArrayList<ReciepeStepClass> mReciepeStepList;

    /**
     * Constructor method
     * @param reciepeStepList The list of steps to display
     */
    public ReciepeStepListAdapter(Context context, ArrayList<ReciepeStepClass> reciepeStepList) {
        mContext = context;
        mReciepeStepList = reciepeStepList;
    }

    /**
     * Returns the number of items the adapter will display
     */
    @Override
    public int getCount() {
        return mReciepeStepList.size();
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
            btnRecipe.setText(mReciepeStepList.get(position).shortDescription);
            //btnRecipe.setTextAlignment();

            //Todo Redesign Button
        } else {
            btnRecipe = (Button) convertView;
        }

        btnRecipe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               Toast.makeText(mContext, "Position clicked = " + mReciepeStepList.get(position).
                       shortDescription, Toast.LENGTH_SHORT).show();

                //Load Detailed Steps Activity
                Intent stepDetails = new Intent(mContext, StepDetailsActivity.class);
                stepDetails.putExtra("reciepe_steps",mReciepeStepList.get(position));

                mContext.startActivity(stepDetails);
            }
        });
        return btnRecipe;
    }

}

