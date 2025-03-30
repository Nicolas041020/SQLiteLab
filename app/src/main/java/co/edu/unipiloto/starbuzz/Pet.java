package co.edu.unipiloto.starbuzz;

public class Pet {
    private int id;
    private String name;
    private String description;
    private String owner;

    public Pet(int id, String name, String description, String owner) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.owner = owner;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getOwner() { return owner; }
}
