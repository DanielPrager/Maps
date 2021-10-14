package at.ac.tgm.dprager.list_view;

public class Cocktail {


    private String cocktail_image;

    private String cocktail_name;
    private int aufwand;

    public Cocktail(String cocktail_image, String cocktail_name, int aufwand) {
        this.cocktail_image = cocktail_image;
        this.cocktail_name = cocktail_name;
        this.aufwand = aufwand;
    }

    public int getAufwand() {
        return this.aufwand;
    }

    public void setAufwand(int aufwand) {
        this.aufwand = aufwand;
    }

    public String getCocktailName() {
        return this.cocktail_name;
    }

    public void setCocktail_name(String cocktail_name) {
        this.cocktail_name = cocktail_name;

    }

    public String getCocktail_image() {
        return cocktail_image;
    }

    public void setCocktail_image(String cocktail_image) {
        this.cocktail_image = cocktail_image;
    }

    @Override
    public String toString() {
        return this.cocktail_name+" (Dauer: "+ this.aufwand+")";
    }


}
