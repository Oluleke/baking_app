package rainmekka.andela.com.baking_app.ui;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import java.util.ArrayList;

import rainmekka.andela.com.baking_app.R;
import rainmekka.andela.com.baking_app.data.ReciepeClass;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ReciepeClass> mReciepeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

//    @Override
//    public void onButtonSelected(int position) {
//
//        //Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show();
//
//        // Put this information in a Bundle and attach it to an Intent that will launch an AndroidMeActivity
////        Bundle b = new Bundle();
////        b.putInt("headIndex", headIndex);
////        b.putInt("bodyIndex", bodyIndex);
////        b.putInt("legIndex", legIndex);
////
////        // Attach the Bundle to an intent
////        final Intent intent = new Intent(this, AndroidMeActivity.class);
////        intent.putExtras(b);
////
////        // The "Next" button launches a new AndroidMeActivity
////        Button nextButton = (Button) findViewById(R.id.next_button);
////        nextButton.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                startActivity(intent);
////            }
////        });
//
//    }
}
