package br.com.hisao.countries.model;

/**
 * Created by vinicius on 23/11/17.
 */


import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Language implements Parcelable
{

    @SerializedName("iso639_1")
    @Expose
    public String iso6391;
    @SerializedName("iso639_2")
    @Expose
    public String iso6392;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("nativeName")
    @Expose
    public String nativeName;
    public final static Parcelable.Creator<Language> CREATOR = new Creator<Language>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Language createFromParcel(Parcel in) {
            return new Language(in);
        }

        public Language[] newArray(int size) {
            return (new Language[size]);
        }

    }
            ;

    protected Language(Parcel in) {
        this.iso6391 = ((String) in.readValue((String.class.getClassLoader())));
        this.iso6392 = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.nativeName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Language() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(iso6391);
        dest.writeValue(iso6392);
        dest.writeValue(name);
        dest.writeValue(nativeName);
    }

    public int describeContents() {
        return 0;
    }

}