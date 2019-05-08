package br.usjt.ciclodevidagpsemapas.forecast;

import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("description")
    private String description;

    @SerializedName("icon")
    private String iconURL;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconURL() {
        return "http://openweathermap.org/img/w/" + iconURL + ".png";
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }
}
