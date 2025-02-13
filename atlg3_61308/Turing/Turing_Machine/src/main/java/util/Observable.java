package util;

/**
 * The `Observable` interface represents an object that can be observed by registered observers.
 * Objects implementing this interface maintain a list of observers and notify them when the object's
 * state changes.
 */
public interface Observable {
    /**
     * Adds an observer to the list of registered observers. When the subject's state changes,
     * it will notify all registered observers by calling their `update` methods.
     *
     * @param observer The observer to be added to the list.
     */
    void addObserver(Observer observer);
    /**
     * Removes an observer from the list of registered observers. If an observer is no longer
     * interested in receiving updates from the subject, it can be removed from the list.
     *
     * @param observer The observer to be removed from the list.
     */
    void removeObserver(Observer observer);

    boolean register(Observer obs);

    boolean unregister(Observer obs);

    /**
     * Notifies all registered observers when the subject's state changes. This method is called
     * to trigger the `update` method in each registered observer, allowing them to react to the change.
     */
    void notifyObservers();
}
