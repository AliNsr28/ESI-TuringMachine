package util;



/**
 * The `Observer` interface represents an object that observes changes in an observable subject.
 * Objects implementing this interface define an `update` method to react to changes notified by the subject.
 */
public interface Observer {

    /**
     * This method is called when the observable subject notifies changes. Implementing classes
     * should define the behavior or actions to be taken in response to the observed change.
     */
    void update();
}


