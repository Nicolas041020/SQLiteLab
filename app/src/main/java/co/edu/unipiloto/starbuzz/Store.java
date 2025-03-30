package co.edu.unipiloto.starbuzz;

public class Store {

    private String name;
    private String description;
    private int imageResourceId;

    public static final Store[] stores = {
            new Store("Principal Location","Near to the center of the city",R.drawable.principallocation),
            new Store("Cold Location","Located in the coldest city of the world",R.drawable.coldlocation),
            new Store("Mountain Location","Near to the top of the montain of the city",R.drawable.highlocation),
    };

    public Store(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    @Override
    public String toString() {
        return name;
    }
}
