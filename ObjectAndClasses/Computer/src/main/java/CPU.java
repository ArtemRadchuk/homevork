public final class CPU {
    private final double frequency;
    private final int core;
    private final double efficiency;
    private final double cpuWeight;

    public CPU(int frequency, int core, int efficiency, int cpuWeight) {
        this.frequency = frequency;
        this.core = core;
        this.efficiency = efficiency;
        this.cpuWeight = cpuWeight;
    }

    public double getFrequency() {
        return frequency;
    }

    public int getCore() {
        return core;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public double getCpuWeight() {
        return cpuWeight;
    }

    @Override
    public String toString() {
        return
                "Частота процессора - " + frequency +
                ", ядер - " + core +
                ", производительность - " + efficiency +
                ",вес процессора - " + cpuWeight;}
    }

