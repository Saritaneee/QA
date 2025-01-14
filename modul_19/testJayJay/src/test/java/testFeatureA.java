import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testFeatureA {

    public static int tambah(int a, int b){
        return a + b;
    }

    @Test
    public void testPenjumlahan(){
        testFeatureA hasil = new testFeatureA();
        System.out.println("Hasil penjumlahan: " + hasil.tambah(3, 4));
        Assertions.assertEquals(7, hasil.tambah(4, 3));
    }

    @Test
    public void testPemjumlahanNegatif(){
        testFeatureA hasil = new testFeatureA();
        System.out.println("Hasil penjumlahan: " + hasil.tambah(-4, -7));
        Assertions.assertEquals(-11, hasil.tambah(-4, -7));
    }

    //kak makasih atas feedback sebelumnya untuk modul 14, saya lupa sama java operatornya :D
}
