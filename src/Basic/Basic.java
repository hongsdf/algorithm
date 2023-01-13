package Basic;

class Foo {

    private int value;

    public Foo(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

public class Basic {

    public static void main(String[] args) {
        Foo someFoo = new Foo(7);
        process(someFoo);
        System.out.println(someFoo.getValue());
    }

    public static void process(Foo foo) {
        // 주소 값을 통해 필드 값을 변경
        foo.setValue(10);
        System.out.println(foo.getValue());
        // 객체 자체를 변경하는 것은 영향 X
        foo = new Foo(15);
        System.out.println(foo.getValue());
    }

}
