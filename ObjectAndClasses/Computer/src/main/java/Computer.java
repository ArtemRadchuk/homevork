public class Computer {
    private final String vendor;
    private final String name;
    private Drive drive;
    private Monitor monitor;
    private Keyboard keyboard;
    private CPU cpu;
    private RAM ram;
    private int currentMass;

    public Computer(String vendor, String name, Drive drive, Monitor monitor, Keyboard keyboard, CPU cpu, RAM ram) {
        this.vendor = vendor;
        this.name = name;
        this.drive = drive;
        this.monitor = monitor;
        this.keyboard = keyboard;
        this.cpu = cpu;
        this.ram = ram;
    }

    public void CurrentMass() {
        int currentMass = cpu.getCpuWeight() + keyboard.getKWeight() + monitor.getMWeight() + ram.getRamWeight() + drive.getDWeight();
        this.currentMass = currentMass;
        return;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public String toString() {
        return "Производитель - " + vendor + ", модель - " + name + ", диск " + drive + ", монитор - " + monitor + ", клавиатура" + keyboard + ", процессор -" + cpu + ", оперативная память -" + ram + ", общей массой - " + currentMass;
    }
}
