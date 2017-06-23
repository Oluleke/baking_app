package rainmekka.andela.com.baking_app.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Oluleke on 6/20/2017.
 */

public class RecipeIngredientClass implements Parcelable {
    public String quantity;
    public String measure;
    public String ingredient;


    public RecipeIngredientClass (){}

    protected RecipeIngredientClass(Parcel in) {
        quantity = in.readString();
        measure = in.readString();
        ingredient = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(quantity);
        dest.writeString(measure);
        dest.writeString(ingredient);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RecipeIngredientClass> CREATOR = new Creator<RecipeIngredientClass>() {
        @Override
        public RecipeIngredientClass createFromParcel(Parcel in) {
            return new RecipeIngredientClass(in);
        }

        @Override
        public RecipeIngredientClass[] newArray(int size) {
            return new RecipeIngredientClass[size];
        }
    };
}
