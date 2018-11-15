package eu.grigoriev.testing.objectcopy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class SubChild1 implements Serializable {
    private int value;

    SubChild1(@NonNull SubChild1 subChild1) {
        this(subChild1.getValue());
    }
}
