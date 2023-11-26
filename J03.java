class Part {
	int cost;
	
	int getCost() {
		return cost;
	}
}

class LCD extends Part {
	LCD(int size) {
		if(size == 10)
			cost = 2000;
		else if(size == 15)
			cost = 2500;
		else if(size == 17)
			cost = 3000;
	}
}

class CPU extends Part {
	CPU(double speed) {
		if(speed == 1.66)
			cost = 6000;
		else if(speed == 2.2)
			cost = 8000;
		else if(speed == 2.4)
			cost = 11000;
	}
}

class HD extends Part {
	HD(int size) {
		if(size == 120)
			cost = 2400;
		else if(size == 160)
			cost = 2800;
	}
}

abstract class AllPC {
	abstract double getCost();
	abstract double getPrice();
	
	boolean isExpensive(AllPC allpc) {
		return this.getPrice() > allpc.getPrice();
	}
}

class Note extends AllPC {
	LCD lcd;
	CPU cpu;
	HD hd;
	
	Note(LCD lcd, CPU cpu, HD hd) {
		this.lcd = lcd;
		this.cpu = cpu;
		this.hd = hd;
	}
	
	int getPartCost() {
		return lcd.getCost() + cpu.getCost() + hd.getCost();
	}
	
	double getCost() {
		return getPartCost() * 1.4;
	}
	
	double getPrice() {
		return getPartCost() * 2;
	}
}

class MiniNote extends Note {
	MiniNote() {
		super(new LCD(10), new CPU(1.66), new HD(120));
	}
}

class Note15 extends Note {
	Note15() {
		super(new LCD(15), new CPU(2.2), new HD(160));
	}
}

abstract class PCandMultiPC extends AllPC {
	CPU cpu;
	HD hd;
	int cpuQuantity;	
	int hdQuantity;		
	
	PCandMultiPC(CPU cpu, HD hd, int cpuQuantity, int hdQuantity) {
		this.cpu = cpu;
		this.hd = hd;
		this.cpuQuantity = cpuQuantity;
		this.hdQuantity = hdQuantity;
	}
	
	int getPartCost() {		
		return cpu.getCost() * cpuQuantity + hd.getCost() * hdQuantity;
	}
	
	abstract double getCost();
	
	double getPrice() {
		return getPartCost() * 1.8;
	}
}

class PC extends PCandMultiPC {
	PC() {
		super(new CPU(2.4), new HD(160), 1, 1);
	}
	
	double getCost() {
		return getPartCost() + 500;
	}
}

class MultiPC extends PCandMultiPC {
	MultiPC(int cpuQuantity, int hdQuantity) {
		super(new CPU(2.4), new HD(160), cpuQuantity, hdQuantity);
	}
	
	double getCost() {
		return getPartCost() * 1.2;
	}
}

public class Main {
    public static void main(String args[]) {
		PC pc = new PC();
		Note15 note15 = new Note15();
		if(note15.isExpensive(pc))
		    System.out.println("Note15 is more expensive than PC");
		else
		    System.out.println("PC is more expensive than Note15");
	}
}
