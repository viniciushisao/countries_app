package br.com.hisao.countries.model;

/**
 * Created by vinicius on 23/11/17.
 */


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Translations implements Parcelable {

    @SerializedName("de")
    @Expose
    public String de;
    @SerializedName("es")
    @Expose
    public String es;
    @SerializedName("fr")
    @Expose
    public String fr;
    @SerializedName("ja")
    @Expose
    public String ja;
    @SerializedName("it")
    @Expose
    public String it;
    @SerializedName("br")
    @Expose
    public String br;
    @SerializedName("pt")
    @Expose
    public String pt;
    @SerializedName("nl")
    @Expose
    public String nl;
    @SerializedName("hr")
    @Expose
    public String hr;
    @SerializedName("fa")
    @Expose
    public String fa;
    public final static Parcelable.Creator<Translations> CREATOR = new Creator<Translations>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Translations createFromParcel(Parcel in) {
            return new Translations(in);
        }

        public Translations[] newArray(int size) {
            return (new Translations[size]);
        }

    };

    protected Translations(Parcel in) {
        this.de = ((String) in.readValue((String.class.getClassLoader())));
        this.es = ((String) in.readValue((String.class.getClassLoader())));
        this.fr = ((String) in.readValue((String.class.getClassLoader())));
        this.ja = ((String) in.readValue((String.class.getClassLoader())));
        this.it = ((String) in.readValue((String.class.getClassLoader())));
        this.br = ((String) in.readValue((String.class.getClassLoader())));
        this.pt = ((String) in.readValue((String.class.getClassLoader())));
        this.nl = ((String) in.readValue((String.class.getClassLoader())));
        this.hr = ((String) in.readValue((String.class.getClassLoader())));
        this.fa = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Translations() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(de);
        dest.writeValue(es);
        dest.writeValue(fr);
        dest.writeValue(ja);
        dest.writeValue(it);
        dest.writeValue(br);
        dest.writeValue(pt);
        dest.writeValue(nl);
        dest.writeValue(hr);
        dest.writeValue(fa);
    }

    public int describeContents() {
        return 0;
    }

}