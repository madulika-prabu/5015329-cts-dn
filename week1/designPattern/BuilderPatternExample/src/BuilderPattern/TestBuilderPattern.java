package BuilderPattern;

public class TestBuilderPattern {
 public static void main(String[] args) {
     Computer gamingComputer = new Computer.Builder()
             .setCPU("Intel Core i9")
             .setRAM("32GB")
             .setStorage("1TB SSD")
             .setGPU("NVIDIA RTX 3080")
             .setPowerSupply("750W")
             .setMotherboard("ASUS ROG")
             .build();

     Computer officeComputer = new Computer.Builder()
             .setCPU("Intel Core i5")
             .setRAM("16GB")
             .setStorage("512GB SSD")
             .setGPU("Integrated Graphics")
             .setPowerSupply("500W")
             .setMotherboard("ASUS Prime")
             .build();

     System.out.println("Gaming Computer Configuration: " + gamingComputer);
     System.out.println("Office Computer Configuration: " + officeComputer);
 }
}

