/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.generics;

import java.util.HashMap;
import java.util.Map;

/**
 * Straight forward implementation of a registry.
 * 
 * @author Daniel Nydegger
 */
public class GenericRegistry<K, V>
    implements Registry<K, V> {

    private final Map<K, V> registry = new HashMap<K, V>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(K key, V value)
        throws KeyAlreadyExistsException {
        if (registry.containsKey(key)) {
            throw new KeyAlreadyExistsException(key.toString());
        }
        registry.put(key, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addOrReplace(K key, V value) {
        registry.put(key, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V remove(K key) {
        return registry.remove(key);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V find(K key) {
        return registry.get(key);
    }
}
