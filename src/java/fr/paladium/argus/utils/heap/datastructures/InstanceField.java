package fr.paladium.argus.utils.heap.datastructures;

import fr.paladium.argus.utils.heap.datastructures.Type;

public class InstanceField {
    public long fieldNameStringId;
    public Type type;

    public InstanceField(long fieldNameStringId, Type type) {
        this.fieldNameStringId = fieldNameStringId;
        this.type = type;
    }
}
