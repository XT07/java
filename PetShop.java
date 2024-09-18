import java.util.ArrayList;
import java.util.Scanner;

public class PetShop {
    ArrayList<Pet> pets = new ArrayList<>();
    ArrayList<Tutor> tutors = new ArrayList<>();
    ArrayList<Category> categorys = new ArrayList<>();

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opt = 0;
        int idTutor = 1;
        int idPet = 1;
        int idCategory = 1;

        do {
            System.out.println("Sistema do pet shop, selecione algo para acessar");
            System.out.println("Cadastrar categoria [1]");
            System.out.println("Cadastrar tutor [2]");
            System.out.println("Cadastrar animal [3]");
            System.out.println("Listar categoria [4]");
            System.out.println("Listar tutor [5]");
            System.out.println("Listar animal [6]");
            System.out.println("Escolha um: ");
            opt = scanner.nextInt();

            switch (opt) {
                case 1: {
                    System.out.println("Escreva o nome da categoria:");
                    String name = scanner.next();
                    Category category = new Category();
                    category.changeName(name);

                    category.fixId(idCategory);
                    categorys.add(category);
                    System.out.println("Id da categoria: " + category.id);
                    idCategory++;

                    System.out.println("Voltar ao menu [1]");
                    opt = scanner.nextInt();
                    break;
                }

                case 2: {
                    System.out.println("Escreva o nome do tutor:");
                    String name = scanner.next();
                    Tutor tutor = new Tutor();
                    tutor.changeName(name);

                    System.out.println("Escreva o telefone do tutor:");
                    String cel = scanner.next();
                    tutor.changeCel(cel);

                    System.out.println("Escreva o e-mail do tutor:");
                    String email = scanner.next();
                    tutor.changeEmail(email);

                    System.out.println("Escreva o endereço do tutor:");
                    String endereco = scanner.next();
                    tutor.changeEndereco(endereco);

                    tutor.fixId(idTutor);
                    tutors.add(tutor);
                    System.out.println("Id do tutor: " + tutor.id);
                    idTutor++;

                    System.out.println("Voltar ao menu [1]");
                    opt = scanner.nextInt();
                    break;
                }

                case 3: {
                    System.out.println("Escreva o nome do animal:");
                    String name = scanner.next();
                    Pet pet = new Pet();
                    pet.changeName(name);

                    System.out.println("Escreva o peso do animal:");
                    int weight = scanner.nextInt();
                    pet.addWeight(weight);

                    System.out.println("Escreva a raça do animal:");
                    String race = scanner.next();
                    pet.addRace(race);

                    System.out.println("Qual o id do tutor?");
                    int idTutorInput = scanner.nextInt();
                    Tutor tutor = getTutorById(idTutorInput);
                    if (tutor != null) {
                        pet.tutor = tutor;
                        tutor.addAmountAnimal();
                    }

                    System.out.println("Qual o id da categoria?");
                    int idCategoryInput = scanner.nextInt();
                    Category category = getCategoryById(idCategoryInput);
                    if (category != null) {
                        pet.getCategory(category.id);
                        category.amountAnimals++;
                    }

                    pet.fixId(idPet);
                    pets.add(pet);
                    idPet++;

                    System.out.println("Voltar ao menu [1]");
                    opt = scanner.nextInt();
                    break;
                }

                case 4: {
                    for (Category category : categorys) {
                        System.out.println("Id da categoria: " + category.id);
                        System.out.println("Nome da categoria: " + category.name);
                        System.out.println("Quantidade de animais: " + category.amountAnimals);
                    }
                    System.out.println("Voltar ao menu [1]");
                    opt = scanner.nextInt();
                    break;
                }

                case 5: {
                    for (Tutor tutorListed : tutors) {
                        tutorListed.showTutor();
                    }
                    System.out.println("Voltar ao menu [1]");
                    opt = scanner.nextInt();
                    break;
                }

                case 6: {
                    for (Pet petListed : pets) {
                        System.out.println("Id do animal: " + petListed.id);
                        System.out.println("Nome do animal: " + petListed.name);
                        System.out.println("Peso do animal: " + petListed.weight);
                        System.out.println("Raça do animal: " + petListed.race);
                        System.out.println("Nome do tutor: " + (petListed.tutor != null ? petListed.tutor.name : "Tutor não encontrado"));
                        System.out.println("Id da categoria do animal: " + petListed.idCategory);
                    }
                    System.out.println("Voltar ao menu [1]");
                    opt = scanner.nextInt();
                    break;
                }

                default: {
                    System.out.println("Opção inválida. Escolha uma opção válida.");
                }
            }
        } while (opt != 0);

        scanner.close();
    }

    public Tutor getTutorById(int id) {
        for (Tutor tutor : tutors) {
            if (tutor.id.equals(id)) {
                return tutor;
            }
        }
        System.out.println("Tutor não encontrado.");
        return null;
    }

    public Category getCategoryById(int id) {
        for (Category category : categorys) {
            if (category.id.equals(id)) {
                return category;
            }
        }
        System.out.println("Categoria não encontrada.");
        return null;
    }

    public static void main(String[] args) {
        PetShop petShop = new PetShop();

        try {
            petShop.menu();
        } catch (Exception e) {
            System.out.println("Erro | " + e);
        }
    }
}