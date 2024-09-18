public class Tutor{
    Integer id;
    String name;
    String cel;
    String email;
    String endereco;
    Integer amountAnimal;

    public void fixId(Integer idFixed){
        this.id = idFixed;
    }

    public void changeName(String newName){
        this.name = newName;
    }

    public void changeCel(String newCel){
        this.name = newCel;
    }

    public void changeEmail(String newEmail){
        this.name = newEmail;
    }

    public void changeEndereco(String newEndereco){
        this.name = newEndereco;
    }

    public void addAmountAnimal(){
        this.amountAnimal = this.amountAnimal + 1;
    }

    public void createPet(Integer id, String name, Integer weight, String race){
        Pet pet = new Pet();
        addAmountAnimal();
        pet.fixId(id);
        pet.changeName(name);
        pet.addWeight(weight);
        pet.addRace(race);
        pet.addPetInTutor();
        pet.getIdTutor(this.id);
    }

    public void showTutor(){
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.name);
        System.out.println("Telefone: " + this.cel);
        System.out.println("Endereço: " + this.endereco);
        System.out.println("Quantidade de animais: " + this.amountAnimal);
    }
}