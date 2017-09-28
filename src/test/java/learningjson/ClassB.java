package learningjson;

/**
 * Created by acedric on 13/06/2017.
 */
public class ClassB extends ClassA {

    private ClassA a;

    public ClassB(ClassA a) {
        this.a = a;
    }

    public String setA(){

       return a.name = "call";
    }

    public void addToListInClassB(){

        a.list.add("Arnaud");
        System.out.println(a.list.get(0));

    }

}
