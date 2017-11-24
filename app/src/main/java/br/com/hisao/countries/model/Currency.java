package br.com.hisao.countries.model;

/**
 * Created by vinicius on 23/11/17.
 */



        import android.os.Parcel;
        import android.os.Parcelable;
        import android.os.Parcelable.Creator;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class Currency implements Parcelable
{

    @SerializedName("code")
    @Expose
    public String code;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("symbol")
    @Expose
    public String symbol;
    public final static Parcelable.Creator<Currency> CREATOR = new Creator<Currency>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Currency createFromParcel(Parcel in) {
            return new Currency(in);
        }

        public Currency[] newArray(int size) {
            return (new Currency[size]);
        }

    }
            ;

    protected Currency(Parcel in) {
        this.code = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.symbol = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Currency() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(code);
        dest.writeValue(name);
        dest.writeValue(symbol);
    }

    public int describeContents() {
        return 0;
    }

}