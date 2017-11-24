package br.com.hisao.countries.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country implements Parcelable
{

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("topLevelDomain")
    @Expose
    public List<String> topLevelDomain = null;
    @SerializedName("alpha2Code")
    @Expose
    public String alpha2Code;
    @SerializedName("alpha3Code")
    @Expose
    public String alpha3Code;
    @SerializedName("callingCodes")
    @Expose
    public List<String> callingCodes = null;
    @SerializedName("capital")
    @Expose
    public String capital;
    @SerializedName("altSpellings")
    @Expose
    public List<String> altSpellings = null;
    @SerializedName("region")
    @Expose
    public String region;
    @SerializedName("subregion")
    @Expose
    public String subregion;
    @SerializedName("population")
    @Expose
    public Integer population;
    @SerializedName("latlng")
    @Expose
    public List<Double> latlng = null;
    @SerializedName("demonym")
    @Expose
    public String demonym;
    @SerializedName("area")
    @Expose
    public Double area;
    @SerializedName("gini")
    @Expose
    public Double gini;
    @SerializedName("timezones")
    @Expose
    public List<String> timezones = null;
    @SerializedName("borders")
    @Expose
    public List<String> borders = null;
    @SerializedName("nativeName")
    @Expose
    public String nativeName;
    @SerializedName("numericCode")
    @Expose
    public String numericCode;
    @SerializedName("currencies")
    @Expose
    public List<Currency> currencies = null;
    @SerializedName("languages")
    @Expose
    public List<Language> languages = null;
    @SerializedName("translations")
    @Expose
    public Translations translations;
    @SerializedName("flag")
    @Expose
    public String flag;
    @SerializedName("regionalBlocs")
    @Expose
    public List<RegionalBloc> regionalBlocs = null;
    @SerializedName("cioc")
    @Expose
    public String cioc;
    public final static Parcelable.Creator<Country> CREATOR = new Creator<Country>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        public Country[] newArray(int size) {
            return (new Country[size]);
        }

    }
            ;

    protected Country(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.topLevelDomain, (java.lang.String.class.getClassLoader()));
        this.alpha2Code = ((String) in.readValue((String.class.getClassLoader())));
        this.alpha3Code = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.callingCodes, (java.lang.String.class.getClassLoader()));
        this.capital = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.altSpellings, (java.lang.String.class.getClassLoader()));
        this.region = ((String) in.readValue((String.class.getClassLoader())));
        this.subregion = ((String) in.readValue((String.class.getClassLoader())));
        this.population = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.latlng, (java.lang.Double.class.getClassLoader()));
        this.demonym = ((String) in.readValue((String.class.getClassLoader())));
        this.area = ((Double) in.readValue((Double.class.getClassLoader())));
        this.gini = ((Double) in.readValue((Double.class.getClassLoader())));
        in.readList(this.timezones, (java.lang.String.class.getClassLoader()));
        in.readList(this.borders, (java.lang.String.class.getClassLoader()));
        this.nativeName = ((String) in.readValue((String.class.getClassLoader())));
        this.numericCode = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.currencies, (br.com.hisao.countries.model.Currency.class.getClassLoader()));
        in.readList(this.languages, (br.com.hisao.countries.model.Language.class.getClassLoader()));
        this.translations = ((Translations) in.readValue((Translations.class.getClassLoader())));
        this.flag = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.regionalBlocs, (br.com.hisao.countries.model.RegionalBloc.class.getClassLoader()));
        this.cioc = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Country() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeList(topLevelDomain);
        dest.writeValue(alpha2Code);
        dest.writeValue(alpha3Code);
        dest.writeList(callingCodes);
        dest.writeValue(capital);
        dest.writeList(altSpellings);
        dest.writeValue(region);
        dest.writeValue(subregion);
        dest.writeValue(population);
        dest.writeList(latlng);
        dest.writeValue(demonym);
        dest.writeValue(area);
        dest.writeValue(gini);
        dest.writeList(timezones);
        dest.writeList(borders);
        dest.writeValue(nativeName);
        dest.writeValue(numericCode);
        dest.writeList(currencies);
        dest.writeList(languages);
        dest.writeValue(translations);
        dest.writeValue(flag);
        dest.writeList(regionalBlocs);
        dest.writeValue(cioc);
    }

    public int describeContents() {
        return 0;
    }

}