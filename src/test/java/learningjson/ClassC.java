package learningjson;

/**
 * Created by acedric on 13/06/2017.
 */
public class ClassC extends ClassA {

    private ClassA a;

    public ClassC(ClassA a) {
        this.a = a;
    }

    public void addToListInClassC(){
        a.list.add("cedric");
        System.out.println(a.list.get(1));
    }
}
