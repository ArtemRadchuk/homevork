public final class CPU {
    private final int frequency;
    private final int core;
    private final int efficiency;
    private final int cpuWeight;

    public CPU(int frequency, int core, int efficiency, int cpuWeight) {
        this.frequency = frequency;
        this.core = core;
        this.efficiency = efficiency;
        this.cpuWeight = cpuWeight;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getCore() {
        return core;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public int getCpuWeight() {
        return cpuWeight;
    }
}
