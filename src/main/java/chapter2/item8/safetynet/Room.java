package chapter2.item8.safetynet;

import java.lang.ref.Cleaner;

public class Room implements AutoCloseable{

    private static final Cleaner cleaner = Cleaner.create();
    private final Cleaner.Cleanable cleanable;
    private final RoomContext context;

    private static class RoomContext implements Runnable {
        private int numJunkPiles;

        RoomContext(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        @Override
        public void run() {
            numJunkPiles = 0;
            System.out.println("Room cleaned");
        }
    }

    public Room(int numJunkPiles) {
        this.context = new RoomContext(numJunkPiles);
        this.cleanable = cleaner.register(this, context);
    }

    @Override
    public void close() throws Exception {
        cleanable.clean();
    }
}
