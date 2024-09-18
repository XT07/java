public class Category {
    Integer id;
    String name;
    Integer amountAnimals = 0;

    public void fixId(Integer id){
        this.id = id;
    }

    public void changeName(String name){
        this.name = name;
    }
}
