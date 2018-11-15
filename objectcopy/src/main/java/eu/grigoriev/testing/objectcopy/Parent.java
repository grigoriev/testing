package eu.grigoriev.testing.objectcopy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parent implements Cloneable, Serializable {
    private Child1 child1;
    private Child2 child2;

    Parent(Parent parent) {
        if (parent != null) {
            child1 = parent.getChild1();
            child2 = parent.getChild2();
        }
    }

    @SuppressWarnings("CloneDoesntCallSuperClone")
    @Override
    protected Parent clone() {
        return new Parent(
                new Child1(getChild1().clone()),
                new Child2(getChild2())
        );
    }
}
