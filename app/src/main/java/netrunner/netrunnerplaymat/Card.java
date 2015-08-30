package netrunner.netrunnerplaymat;

public class Card extends CardPile {
    public String name;
    private int imageResource = R.drawable.runner_back;

    public Card(String name) {
        this.name = name;
    }

    public int getResource() {
        return imageResource;
    }
}
