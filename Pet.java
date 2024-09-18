public class Pet {
    Integer id;
    String name;
    Integer weight;
    String race;
    Tutor tutor;
    Integer idTutor;
    Integer idCategory;

    public void fixId(Integer id){
        this.id = id;
    }

    public void changeName(String newName){
        this.name = newName;
    }

    public void addWeight(Integer newWeight){
        this.weight = newWeight;
    }

    public void addRace(String newRace){
        this.race = newRace;
    }

    public void addPetInTutor(){
        tutor.amountAnimal = tutor.amountAnimal + 1;
    }

    public void getIdTutor(Integer id){
        this.idTutor = id;
    }

    public void getCategory(Integer id){
        this.idCategory = id;
    }
}