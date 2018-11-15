package eu.grigoriev.testing.objectcopy;

import org.apache.commons.lang3.SerializationUtils;

public class ObjectCopy {

    public Parent deepCopy(Parent parent) throws CloneNotSupportedException {
        return parent.clone();
    }

    public Parent deepCopyWithSerializationUtils(Parent parent) {
        return SerializationUtils.clone(parent);
    }

    public Parent shallowCopy(Parent parent) {
        return new Parent(parent);
    }
}
