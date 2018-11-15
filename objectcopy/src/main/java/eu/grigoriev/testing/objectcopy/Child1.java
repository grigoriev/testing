package eu.grigoriev.testing.objectcopy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Child1 implements Cloneable, Serializable {
    private SubChild1 subChild1;

    Child1(@NonNull Child1 child1) {
        this(child1.getSubChild1());
    }

    @SuppressWarnings("CloneDoesntCallSuperClone")
    @Override
    protected Child1 clone() {
        return new Child1(
                new SubChild1(getSubChild1())
        );
    }
}
