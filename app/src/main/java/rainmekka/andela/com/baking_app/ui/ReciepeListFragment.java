package rainmekka.andela.com.baking_app.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


import java.util.ArrayList;
import rainmekka.andela.com.baking_app.R;
import rainmekka.andela.com.baking_app.data.ReceipeListAdapter;
import rainmekka.andela.com.baking_app.data.ReciepeClass;
import rainmekka.andela.com.baking_app.rest.FetchRecipes;


/**
 * Created by Oluleke on 6/20/2017.
 */

public class ReciepeListFragment extends Fragment {

    // Define a new interface OnButtonClickListener that triggers a callback in the host activity
//     mCallback;

    private ArrayList<ReciepeClass> mReciepeList;

    // Define a new interface OnImageClickListener that triggers a callback in the host activity
    OnButtonClickListener mCallback;

    // OnButtonClickListener interface, calls a method in the host activity named onImageSelected
    public interface OnButtonClickListener {
        void onButtonSelected(int position);
    }

    // Override onAttach to make sure that the container activity has implemented the callback
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//
//        // This makes sure that the host activity has implemented the callback interface
//        // If not, it throws an exception
//        try {
//            mCallback = (OnButtonClickListener) context;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(context.toString()
//                    + " must implement OnButtonClickListener");
//        }
//    }

    public ReciepeListFragment (){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_receipe_list, container, false);

        // Get a reference to the GridView in the fragment_master_list xml layout file
        GridView gridView = (GridView) rootView.findViewById(R.id.receipes_grid_view);

        // Create the adapter
        // This adapter takes in the context and an ArrayList of ALL the image resources to display
        ReceipeListAdapter mAdapter = new ReceipeListAdapter(getContext(), mReciepeList);

        // Set the adapter on the GridView
        gridView.setAdapter(mAdapter);

        //ToDo: setGridview to 3 cols if in tabletMode

        // Set a click listener on the gridView and trigger the callback onImageSelected when an item is clicked
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Trigger the callback method and pass in the position that was clicked
                mCallback.onButtonSelected(position);
            }
        });

        // Return the root view
        return rootView;
    }
    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //obtain data from API
        mReciepeList = new FetchRecipes().getReciepeList();

    }

    public void setReciepeList(ArrayList<ReciepeClass> reciepeList) {
        mReciepeList = reciepeList;
    }


    //ToDo: Convert to load all data once and store on phone to save network calls

}
