package rainmekka.andela.com.baking_app.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Oluleke on 6/20/2017.
 */

public class ReciepeStepClass implements Parcelable {
    public String id;
    public String shortDescription;
    public String description;
    public String videoURL;
    public String thumbnailURL;

    public ReciepeStepClass (){}

    protected ReciepeStepClass(Parcel in) {
        id = in.readString();
        shortDescription = in.readString();
        description = in.readString();
        videoURL = in.readString();
        thumbnailURL = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(shortDescription);
        dest.writeString(description);
        dest.writeString(videoURL);
        dest.writeString(thumbnailURL);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ReciepeStepClass> CREATOR = new Creator<ReciepeStepClass>() {
        @Override
        public ReciepeStepClass createFromParcel(Parcel in) {
            return new ReciepeStepClass(in);
        }

        @Override
        public ReciepeStepClass[] newArray(int size) {
            return new ReciepeStepClass[size];
        }
    };
}
