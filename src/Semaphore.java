public class Semaphore {
    private int count;

    Semaphore(int init) {
        count = init;
    }

    public synchronized void aquire() {
        if (--count < 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void release() {
        if (++count <= 0) {
            notify();
        }
    }

    public int getCount() {
        return count;
    }
}