package info.testing;

public class FehlerProgramm {
    int x;
    public static int[] arr = new int[10];

    public static void main(String[] args) {
        switch (random()) {
            case 1 :
                FehlerProgramm testobject = null;
                System.out.println(testobject.x);
                break;
            case 2 :
                arr[arr.length] = 7;
                break;
            case 3 :
                dumb(20);
        }

    }
    public static int random() {
        return (int) (Math.random() * 3 + 1);
    }
    public static int dumb(int n) {
        if (n == 2) {
            return 1;
        }
        return dumb(n++);
    }
}

