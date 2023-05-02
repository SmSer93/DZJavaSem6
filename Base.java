public class Base {
    String brand;
    String model;
    int ram;
    int hardDisk;
    String opSystem;
    String color;


    public Base(String brand, String model, int ram, int hardDisk, String opSystem, String color) {
        this.brand = brand.toUpperCase();
        this.model = model.toUpperCase();
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.opSystem = opSystem.toLowerCase();
        this.color = color.toLowerCase();
    }


    public int getRam() {
        return ram;
    }

    public int getHardDisk() {
        return hardDisk;
    }

    public String getOpSystem() {
        return opSystem;
    }

    public String getColor() {
        return color;
    }


    public void showInfo() {
        System.out.printf("Производитель: %s\nМодель: %s\nОЗУ: %d Гб\nЖесткий диск: %d Гб\nОС: %s\nЦвет: %s\n%n",
                this.brand, this.model, this.ram, this.hardDisk, this.opSystem, this.color);
    }


}

