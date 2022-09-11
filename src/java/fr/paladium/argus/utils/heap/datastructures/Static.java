package fr.paladium.argus.utils.heap.datastructures;

import fr.paladium.argus.utils.heap.datastructures.Value;

public class Static {
    public long staticFieldNameStringId;
    public Value<?> value;

    public Static(long staticFieldNameStringId, Value<?> value) {
        this.staticFieldNameStringId = staticFieldNameStringId;
        this.value = value;
    }
}
