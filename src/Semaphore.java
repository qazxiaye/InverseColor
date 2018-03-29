public class Semaphore {
    private int count;

    Semaphore(int init) {
        count = init;
    }

    public synchronized void Require() {
        if (--count < 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void Release() {
        if (++count <= 0) {
            notify();
        }
    }

    public int getCount() {
        return count;
    }
}