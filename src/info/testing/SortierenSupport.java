package info.testing;

public class SortierenSupport {
    private int[] array;
    private int von;
    private int bis;

    //Constructor 1
    //ToDo Von Bis setzen
    public SortierenSupport(int[] array) {
        this.array = array;
    }

    //Constructor 2
    public SortierenSupport(int groesse, int von, int bis) {
        int[] array = new int[groesse];

        this.von = von;
        this.bis = bis;
        this.array = array;
        shuffleArray();

    }

    /**
     * @return Array mit 1000 Werten
     */
    //Get Methode
    public int[] getArray(){
        return array;
    }

    //Erneutes Shuffel
    public void shuffleArray(){
        for (int i =0; i < array.length ; i++) {
            array[i] = (int) (Math.random() * (bis - von)) + von;
        }
    }

    //Veränderung des Arrays
    public void shuffleArray(int /*@NotNull*/ [] array, int von, int bis){
        for (int element: array) {
            element = (int) (Math.random() * (bis - von)) + von;
        }
    }

}
