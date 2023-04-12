package io.zipcoder;

public class MonkeyTypewriter {
    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.
        UnsafeCopier uc = new UnsafeCopier(introduction);
        Thread t1 = new Thread(uc); t1.start();
        Thread t2 = new Thread(uc); t2.start();
        Thread t3 = new Thread(uc); t3.start();
        Thread t4 = new Thread(uc); t4.start();
        Thread t5 = new Thread(uc); t5.start();

        SafeCopier sc = new SafeCopier(introduction);
        Thread t6 = new Thread(sc); t6.start();
        Thread t7 = new Thread(sc); t7.start();
        Thread t8 = new Thread(sc); t8.start();
        Thread t9 = new Thread(sc); t9.start();
        Thread t10 = new Thread(sc); t10.start();



        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.
        System.out.println(uc.copied);
        System.out.println("----------------------------------");
        System.out.println(sc.copied);
    }
}