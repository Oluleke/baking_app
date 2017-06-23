package rainmekka.andela.com.baking_app.data;

/**
 * Created by Oluleke on 6/20/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;


/**
 * Created by yemi on 15/04/2017.
 */

public class ReciepeClass implements Parcelable {
    public String id;
    public String name;
    public String servings;
    public String image;
    public ArrayList<RecipeIngredientClass> receipeIngredientList = new ArrayList<>();
    public ArrayList<ReciepeStepClass>  receipeStepList = new ArrayList<>();

   // final public static String reciepeURL = "http://go.udacity.com/android-baking-app-json";

    public ReciepeClass(){

    }

    protected ReciepeClass (Parcel in) {
        id = in.readString();
        name = in.readString();
        servings = in.readString();
        image = in.readString();
        receipeIngredientList = in.createTypedArrayList(RecipeIngredientClass.CREATOR);
        receipeStepList = in.createTypedArrayList(ReciepeStepClass.CREATOR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(servings);
        dest.writeString(image);
        dest.writeTypedList(receipeIngredientList);
        dest.writeTypedList(receipeStepList);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ReciepeClass> CREATOR;

    static {
        CREATOR = new Creator<ReciepeClass>() {
            @Override
            public ReciepeClass createFromParcel(Parcel in) {
                return new ReciepeClass(in);
            }

            @Override
            public ReciepeClass[] newArray(int size) {
                return new ReciepeClass[size];
            }
        };
    }

}

