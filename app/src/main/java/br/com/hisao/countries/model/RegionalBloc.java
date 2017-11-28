package br.com.hisao.countries.model;

/**
 * Created by vinicius on 23/11/17.
 */


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RegionalBloc implements Parcelable {

    @SerializedName("acronym")
    @Expose
    public String acronym;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("otherAcronyms")
    @Expose
    public List<String> otherAcronyms = null;
    @SerializedName("otherNames")
    @Expose
    public List<String> otherNames = null;
    public final static Parcelable.Creator<RegionalBloc> CREATOR = new Creator<RegionalBloc>() {


        @SuppressWarnings({
                "unchecked"
        })
        public RegionalBloc createFromParcel(Parcel in) {
            return new RegionalBloc(in);
        }

        public RegionalBloc[] newArray(int size) {
            return (new RegionalBloc[size]);
        }

    };

    protected RegionalBloc(Parcel in) {
        this.acronym = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.otherAcronyms, (java.lang.String.class.getClassLoader()));
        in.readList(this.otherNames, (java.lang.String.class.getClassLoader()));
    }

    public RegionalBloc() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(acronym);
        dest.writeValue(name);
        dest.writeList(otherAcronyms);
        dest.writeList(otherNames);
    }

    public int describeContents() {
        return 0;
    }
}
