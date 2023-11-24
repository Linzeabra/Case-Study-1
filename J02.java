import java.util.ArrayList;
import java.util.List;
class LCD {
    private int size;
    private int cost;
    public LCD(int size) {
        this.size = size;
        if (size == 10) {
            this.cost = 2000;
        } else if (size == 15) {
            this.cost = 2500;
        } else if (size == 17) {
            this.cost = 3000;
        } else {
            this.cost = 0; 
        }
    }
    public int getCost() {
        return cost;
    }
}
class CPU {
    private double speed;
    private int cost;

    public CPU(double speed) {
        this.speed = speed;
        if (speed == 1.66) {
            this.cost = 6000;
        } else if (speed == 2.2) {
            this.cost = 8000;
        } else if (speed == 2.4) {
            this.cost = 11000;
        } else {
            this.cost = 0; 
        }
    }
    public int getCost() {
        return cost;
    }
}
class HD {
    private int cap;
    private int cost;

    public HD(int cap) {
        this.cap = cap;
        if (cap == 120) {
            this.cost = 2400;
        } else if (cap == 160) {
            this.cost = 2800;
        } else {
            this.cost = 0; 
        }
    }
    public int getCost() {
        return cost;
    }
}
class MiniNote {
    private LCD lcd;
    private CPU cpu;
    private HD hd;
    public MiniNote() {
        this.lcd = new LCD(10);
        this.cpu = new CPU(1.66);
        this.hd = new HD(120);
    }
    public int getCost() {
        return (lcd.getCost() + cpu.getCost() + hd.getCost()) * 2;
    }
    public double getPrice() {
        return (getCost() / 2) * 1.4;
    }
}
class Note15 {
    private LCD lcd;
    private CPU cpu;
    private HD hd;
    public Note15() {
        this.lcd = new LCD(15);
        this.cpu = new CPU(2.2);
        this.hd = new HD(160);
    }
    public int getCost() {
        return (lcd.getCost() + cpu.getCost() + hd.getCost()) * 2;
    }
    public double getPrice() {
        return (getCost() / 2) * 1.4;
    }
}
class PC {
    private CPU cpu;
    private HD hd;
    public PC() {
        this.cpu = new CPU(2.4);
        this.hd = new HD(160);
    }
    public int getCost() {
        return cpu.getCost() + hd.getCost() + 500;
    }
    public double getPrice() {
        return (getCost() - 500) * 1.8;
    }
}
class MultiPC {
    private List<CPU> cpus;
    private List<HD> hds;

    public MultiPC(int cpuCount, int hdCount) {
        this.cpus = new ArrayList<>();
        this.hds = new ArrayList<>();
        this.cpus.add(new CPU(2.4)); 
        this.hds.add(new HD(160)); 
        for (int i = 1; i < cpuCount; i++) {
            this.cpus.add(new CPU(2.4)); 
        }
        for (int i = 1; i < hdCount; i++) {
            this.hds.add(new HD(160)); 
        }
    }
    public int getCost() {
        int totalCost = 0;
        for (CPU cpu : cpus) {
            totalCost += cpu.getCost();
        }
        for (HD hd : hds) {
            totalCost += hd.getCost();
        }
        return (int) (totalCost * 1.2); 
    }
    public double getPrice() {
        return (getCost()/1.2) * 1.8; 
    }
}
public class J02 {
    public static void main(String[] args) {
        PC pc = new PC();
        MultiPC multiPC1 = new MultiPC(2, 4); 
        MultiPC multiPC2 = new MultiPC(4, 8); 
        System.out.println("PC cost:" + pc.getCost() + ", price: " + pc.getPrice());
        System.out.println("MultiPC: 2CPU, 4HD, cost" + multiPC1.getCost() + ", price: " + multiPC1.getPrice());
        System.out.println("MultiPC: 4CPU, 8HD, cost"  + multiPC2.getCost() + ", price: " + multiPC2.getPrice());
    }
}
