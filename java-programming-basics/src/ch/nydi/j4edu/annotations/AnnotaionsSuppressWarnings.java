/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.annotations;

import java.util.ArrayList;
import java.util.List;

/**
 * Shows how you can suppress compiler warnings and use deprecation annotation. Note: Generally, suppress compiler
 * warnings it's not the way to go, use that only if you exactly know why.
 * 
 * @author Daniel Nydegger
 */
public class AnnotaionsSuppressWarnings {

    @SuppressWarnings("unused")
    @Deprecated
    private String oldVariable;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List getList() {
        final List l = new ArrayList();
        l.add(1); // The TypeSafty Warning in this List is supressed.
        l.add(2); // The TypeSafty Warning in this List is supressed.
        return l;
    }
}
