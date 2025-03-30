package co.edu.unipiloto.starbuzz;

public class Adulto {
    private String name;
    private String description;

    private int imageResourceId;

    public static final Adulto[] ADULTOS ={
      new Adulto("Agility Gold Adulto","Comida calidad premium para tu amigo canino \n 1.5 - 3.5 kg  35 - 50g \n " +
              "3.5 - 5.5 kg  50 - 90g \n" +
              "5.5 - 9 kg  90 - 112g \n" +
              "9 - 12 kg  112 - 120g \n" +
              "12 - 18 kg  120 - 150g \n" +
              "18 - 23 kg  150 - 165g \n" +
              "23 - 34 kg  165 - 275g \n" +
              "34 - 45 kg  275 - 400g \n" +
              "+ 45 kg  400 - 495g ",R.drawable.agilityadulto),
            new Adulto("Chunky Adulto","Comida calidad premium para tu amigo canino \n 1.5 - 3.5 kg  35 - 50g \n " +
                    "3.5 - 5.5 kg  50 - 90g \n" +
                    "5.5 - 9 kg  90 - 112g \n" +
                    "9 - 12 kg  112 - 120g \n" +
                    "12 - 18 kg  120 - 150g \n" +
                    "18 - 23 kg  150 - 165g \n" +
                    "23 - 34 kg  165 - 275g \n" +
                    "34 - 45 kg  275 - 400g \n" +
                    "+ 45 kg  400 - 495g ",R.drawable.chunkyadulto)
    };

    public Adulto(String name, String description, int imageResourceId) {
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
