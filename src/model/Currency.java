package model;

import com.google.gson.annotations.SerializedName;

public class Currency {

    @SerializedName("currencyName")
    private final String name;
    @SerializedName("id")
    private final String code;

    public Currency(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return name;
    }

}
