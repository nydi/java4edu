/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */

package ch.nydi.j4edu.generics;

/**
 * Interface to define a simple generic registry.
 * 
 * @param <K>
 *            Type of key
 * @param <V>
 *            Type of value
 */
public interface Registry<K, V> {

    /**
     * Register the value associated with a key.
     * 
     * @param key
     *            key
     * @param value
     *            value
     * @throws KeyAlreadyExistsException
     *             if the key value pair already exists in the registry.
     */
    void add(K key, V value)
        throws KeyAlreadyExistsException;

    /**
     * Register or replace the value associated with a key.
     * 
     * @param key
     *            key
     * @param value
     *            value
     */
    void addOrReplace(K key, V value);

    /**
     * @param key
     *            key
     * @return the removed value, null if the key doesn't exists
     */
    V remove(K key);

    /**
     * @param key
     *            key
     * @return the value associated with the key, null if the key doesn't exists
     */
    V find(K key);
}
