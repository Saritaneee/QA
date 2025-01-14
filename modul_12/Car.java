public class Car {
    public static void main(String[] args){
        //Array declaration
        String[] myCar = {"Mitsubishi", "Tesla", "Honda", "Nissan", "Kia", "Hyundai"};

        //Print an array using loop
        for (String cars : myCar){
            System.out.println(cars);
        }

        //Another loop for print an array
        for (int i = 0; i < myCar.length; i++){
            System.out.println(myCar[i]);
        }
    }
}
