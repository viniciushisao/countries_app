package br.com.hisao.countries.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Country implements Parcelable  {

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

    public Bitmap bmpFlag;
    public Bitmap bmpMap;
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

    };

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


    /**
     * This list was generated from https://restcountries.eu/rest/v2/all on 11/24/2017
     */
    public static String CountryNameList[] = new String[]{
            "Afghanistan", "Åland Islands", "Albania", "Algeria", "American Samoa", "Andorra", "Angola",
            "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba",
            "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados",
            "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan",
            "Bolivia (Plurinational State of)", "Bonaire, Sint Eustatius and Saba",
            "Bosnia and Herzegovina", "Botswana", "Bouvet Island", "Brazil",
            "British Indian Ocean Territory", "United States Minor Outlying Islands",
            "Virgin Islands (British)", "Virgin Islands (U.S.)", "Brunei Darussalam",
            "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cabo Verde",
            "Cayman Islands", "Central African Republic", "Chad", "Chile", "China",
            "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo",
            "Congo (Democratic Republic of the)", "Cook Islands", "Costa Rica", "Croatia",
            "Cuba", "Curaçao", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica",
            "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea",
            "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland",
            "France", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon",
            "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada",
            "Guadeloupe", "Guam", "Guatemala", "Guernsey", "Guinea", "Guinea-Bissau", "Guyana",
            "Haiti", "Heard Island and McDonald Islands", "Holy See", "Honduras", "Hong Kong",
            "Hungary", "Iceland", "India", "Indonesia", "Côte d'Ivoire", "Iran (Islamic Republic of)",
            "Iraq", "Ireland", "Isle of Man", "Israel", "Italy", "Jamaica", "Japan", "Jersey",
            "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kuwait", "Kyrgyzstan",
            "Lao People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia",
            "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macao",
            "Macedonia (the former Yugoslav Republic of)", "Madagascar", "Malawi", "Malaysia",
            "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania",
            "Mauritius", "Mayotte", "Mexico", "Micronesia (Federated States of)",
            "Moldova (Republic of)", "Monaco", "Mongolia", "Montenegro", "Montserrat",
            "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands",
            "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue",
            "Norfolk Island", "Korea (Democratic People's Republic of)",
            "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau",
            "Palestine, State of", "Panama", "Papua New Guinea", "Paraguay", "Peru",
            "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar",
            "Republic of Kosovo", "Réunion", "Romania", "Russian Federation", "Rwanda",
            "Saint Barthélemy", "Saint Helena, Ascension and Tristan da Cunha",
            "Saint Kitts and Nevis", "Saint Lucia", "Saint Martin (French part)",
            "Saint Pierre and Miquelon", "Saint Vincent and the Grenadines", "Samoa",
            "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia",
            "Seychelles", "Sierra Leone", "Singapore", "Sint Maarten (Dutch part)",
            "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa",
            "South Georgia and the South Sandwich Islands", "Korea (Republic of)",
            "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Svalbard and Jan Mayen",
            "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan", "Tajikistan",
            "Tanzania, United Republic of", "Thailand", "Timor-Leste", "Togo", "Tokelau", "Tonga",
            "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands",
            "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates",
            "United Kingdom of Great Britain and Northern Ireland", "United States of America",
            "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela (Bolivarian Republicof)", "Viet Nam",
            "Wallis and Futuna", "Western Sahara", "Yemen", "Zambia", "Zimbabwe"


    };

}