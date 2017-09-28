package learningjson;

/**
 * Created by acedric on 13/06/2017.
 */
public class ClassDTest {

    public static void main(String[] args) {
        ClassA a = new ClassA();

        ClassB b = new ClassB(a);
        ClassC c = new ClassC(a);

        System.out.println(b.setA());
        b.addToListInClassB();
        c.addToListInClassC();

    }
}
