package lr7;

public class Example1 {
    public static void main(String[] args) {
        final var superClassObject = new SuperClassTest("передал в конструктор суперкласса");
        final var className = superClassObject.toString();
        System.out.println(className);
        final var subClassObject1 = new SubClassTest("передал в конструктор подкласса");
        final var subClassName = subClassObject1.toString();
        System.out.println(subClassName);
        final var subClassObject2 = new SubClassTest("передал в конструктор подкласса", "где два параметра");
        final var subClassName2 = subClassObject2.toString();
        System.out.println(subClassName2);
    }
}

class SuperClassTest {
    final private String str1;

    SuperClassTest(String strEx) {
        this.str1 = strEx;
    }

    SuperClassTest() {
        this.str1 = null;
    }

    @Override
    public String toString() {
        return "super" + "\n" +
            " Class name: " + this.getClass().getSimpleName() + "\n" +
            " str 1 = " + this.getStr1();
    }

    public String getStr1() {
        return str1;
    }
}

class SubClassTest extends SuperClassTest {
    final private String str2;
    final private String str3;

    SubClassTest(String strEx) {
        super(strEx);
        this.str2 = null;
        this.str3 = null;
    }

    SubClassTest(String strEx2, String strEx3) {
        this.str2 = strEx2;
        this.str3 = strEx3;
    }

    @Override
    public String toString() {
        return "sub" + "\n" +
            " Class name: " + this.getClass().getSimpleName() + "\n" +
            " str 1 = " + this.getStr1() + "\n" +
            " str 2 = " + this.getStr2() + "\n" +
            " str 3 = " + this.getStr3();
    }

    public String getStr3() {
        return str3;
    }

    public String getStr2() {
        return str2;
    }
}
