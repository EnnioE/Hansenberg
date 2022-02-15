package info.sonstiges;

public class StoppUhr {
    private long startTime;
    private long endTime;


    public void start() {
        this.startTime = System.nanoTime();
    }

    public void stopp() {
        this.endTime = System.nanoTime();
    }

    public long diff() {
        return this.endTime - this.startTime;
    }

    public String getNanoseconds() {
        return this.diff() + " ns";
    }

    public String getSeconds() {
        return this.diff()/1000000000.0 + " s";
    }

    public void reset() {
        this.startTime = 0;
        this.endTime = 0;
    }
}
