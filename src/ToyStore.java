import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ToyStore {
    private ArrayList<Toy> toys;
    private ArrayList<Toy> winning;
    private String winningToyFilePath;

    public ToyStore(){
        toys = new ArrayList<Toy>();
        winning = new ArrayList<Toy>();
        winningToyFilePath = "winning_toys.txt";
    }
    public void addToy (Toy toy){
        toys.add(toy);
    }
    public void changeToyFrequency(int toyId, double newFrequency){
        for (Toy toy: toys){
            if (toy.getID() == toyId){
                toy.setFrequency(newFrequency);
            }
        }
    }
    public void startRaffle(){
        winning.clear();
        for (Toy toy: toys){
            double random = Math.random()*100;
            if (random < toy.getFrequency()){
                winning.add(toy);
            }
        }
    }
    public Toy getPrizeToy(){
        if (!winning.isEmpty()){
            Toy winToy = winning.remove(0);
            winToy.setQuantity(winToy.getQuantity() - 1);

            try {
                FileWriter writer = new FileWriter(winningToyFilePath);
                writer.write(winToy.getName()+'\n');
                writer.close();
            } catch (IOException e) {
                System.out.println("Ошибка записи в файл призов");
            }
            return winToy;
        }
        else {
            System.out.println("В розыгрыше закончились игрушки");
            return null;
        }
    }
}