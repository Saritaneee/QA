public class Iteration {
    public static void main(String[] args) {
        String[] warna = {"hitam", "biru", "putih", "merah", "kuning"};

        //for each loop
        for (String color : warna){
            System.out.println("Warnanya adalah: " + color);
        }

        //except putih
        for (String color : warna){
            if (color == "putih") continue;
            System.out.println("Warna: " + color);
        }
    }
}
