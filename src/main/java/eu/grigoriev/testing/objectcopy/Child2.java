package eu.grigoriev.testing.objectcopy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Child2 implements Serializable {
    private int value;

    Child2(@NonNull Child2 child2) {
        this(child2.getValue());
    }
}
