package concurrentcollection_task1;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    private static final int PAUSE_TIME = 4000;

    public static void main(String[] args) {
        Queue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
        Thread ats = new ATS(queue);
        ats.start();
        Thread specialist1 = new Specialist(queue, "Архипов А.С.");
        specialist1.start();
        Thread specialist2 = new Specialist(queue, "Уткин А.В.");
        specialist2.start();
        Thread specialist3 = new Specialist(queue, "Прохоров Д.А.");
        specialist3.start();
        Thread specialist4 = new Specialist(queue, "Харитонов А.Н.");
        specialist4.start();
        Thread specialist5 = new Specialist(queue, "Смирнов А.П.");
        specialist5.start();

        try {
            ats.join();
            while (queue.peek() != null) {
                Thread.sleep(PAUSE_TIME);
            }
            specialist1.interrupt();
            specialist2.interrupt();
            specialist3.interrupt();
            specialist4.interrupt();
            specialist5.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
