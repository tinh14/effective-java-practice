package chapter9.item58;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;

public class DiceRolls {
    enum Face { ONE, TWO, THREE, FOR, FIVE, SIX }

    public static void main(String[] args) {
        Collection<Face> faces = EnumSet.allOf(Face.class);

        // The size of the outer collection is a multiple of the size of the inner one.
        // So the program still runs without throwing any exception.
        for (Iterator<Face> it1 = faces.iterator(); it1.hasNext(); )
            for (Iterator<Face> it2 = faces.iterator(); it2.hasNext(); )
                // Iterator it1 unintentionally gets advanced in lockstep
                System.out.println(it1.next() + " " + it2.next());

        System.out.println();

        for (Face face1 : faces)
            for (Face face2 : faces)
                System.out.println(face1 + " " + face2);
    }
}
