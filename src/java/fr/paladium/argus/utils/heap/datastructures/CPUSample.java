package fr.paladium.argus.utils.heap.datastructures;

public class CPUSample {
    public int numSamples;
    public int stackTraceSerialNum;

    public CPUSample(int numSamples, int stackTraceSerialNum) {
        this.numSamples = numSamples;
        this.stackTraceSerialNum = stackTraceSerialNum;
    }
}
