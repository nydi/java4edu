/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.threading.workqueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple work queue who executes all loaded work elements.
 */
public class WorkQueue {

    private final List<Work> workList = new ArrayList<Work>();

    public synchronized void addWork(final Work work) {
        workList.add(work);
    }

    public synchronized void executeWorkers() {
        while (!workList.isEmpty()) {
            workList.remove(0).doWork();
        }
    }

    public synchronized void awaitQueueIsEmpty() {
        if (!workList.isEmpty()) {
            try {
                Thread.sleep(100);
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
