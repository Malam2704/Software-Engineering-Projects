package kfp;

public class PandaFu {
    public static void main(String[] args) {
        // Fist f = new Fist();
        // Panda op = new Panda(f);
        // op.strike();

        Panda<Fist> pnd = new Panda<>(new Fist(), "Panda");
        Panda<Flowers> pnd2 = new Panda<>(new Flowers(), "Panda 2");
        Panda<Naginata> pnd3 = new Panda<>(new Naginata(100), "Panda 3");
        pnd3.strike();
        pnd.strike();
        pnd2.strike();
        
        String names = "Panda1 Panda2 Panda2 Panda3 Panda1 Panda4";
        System.out.println( Panda.unique(names.split(" ")) );  

    }
}
