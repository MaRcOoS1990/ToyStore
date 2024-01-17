public class Lottery {
    public static void main(String[] args){
        ToyStore store = new ToyStore();

        Toy toy_1 = new Toy(1, "Робот на пульте управления", 5, 10);
        Toy toy_2 = new Toy(2, "Спинер", 20, 40);
        Toy toy_3 = new Toy(3, "Мяч футбольный", 15, 30);
        Toy toy_4 = new Toy(4, "Вингс кукла", 11, 22);
        Toy toy_5 = new Toy(5, "Конструктор Лего", 8, 16);
        Toy toy_6 = new Toy(6, "Кукла колдуна", 30, 60);
        Toy toy_7 = new Toy(7, "Световой мяч", 17, 34);

        store.addToy(toy_1);
        store.addToy(toy_2);
        store.addToy(toy_3);
        store.addToy(toy_4);
        store.addToy(toy_5);
        store.addToy(toy_6);
        store.addToy(toy_7);

        store.changeToyFrequency(1,30);
        store.startRaffle();

        Toy winning = store.getPrizeToy();
        if (winning!=null){
            System.out.println("Вы выйграли: " + winning.getName());
        }

    }
}