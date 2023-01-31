package run;

import material.CrispyFlour;
import material.Meat;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MaterialManager materialManager = new MaterialManager();
        Scanner input = new Scanner(System.in);
        int menu;
        do {
            System.out.println("Menu------------------------");
            System.out.println(
                    "1. hiển thị danh sách vật liệu\n" +
                            "2. Thêm vật liệu thịt\n" +
                            "3. Thêm vật liệu bột mỳ\n" +
                            "4. Sửa vật liệu thịt\n" +
                            "5. Sửa vật liệu bột mỳ\n" +
                            "6. Xóa vật liệu\n" +
                            "7. Giá gốc và giá sale thịt\n" +
                            "8. Giá gốc và gia sale bột\n"+
                            "0. Thoát khỏi chương trình\n");
            System.out.print("Mời bạn chọn: ");
            menu = input.nextInt();
            input.nextLine();
            switch (menu) {
                case 1 -> materialManager.print();
                case 2 -> {
                    System.out.print("Nhập id thịt: ");
                    String idMeat = input.nextLine();
                    System.out.print("Nhập tên thịt: ");
                    String nameMeat = input.nextLine();
                    LocalDate dayMeat = LocalDate.now();
                    System.out.print("Nhập giá thịt: ");
                    double priceMeat = Double.parseDouble(input.nextLine());
                    System.out.print("Nhập cân nặng thịt: ");
                    int weightMeat = Integer.parseInt(input.nextLine());
                    materialManager.addElement(new Meat(idMeat, nameMeat, dayMeat, (int) priceMeat, weightMeat));
                }
                case 3 -> {
                    System.out.print("Nhập id bột: ");
                    String id = input.nextLine();
                    System.out.print("Nhập tên bột: ");
                    String name = input.nextLine();
                    LocalDate day = LocalDate.now();
                    System.out.print("Nhập giá bột: ");
                    double price = Double.parseDouble(input.nextLine());
                    System.out.print("Nhập số lượng bột: ");
                    int quantity = Integer.parseInt(input.nextLine());
                    materialManager.addElement(new CrispyFlour(id, name, day, (int) price, quantity));
                }
                case 4 -> {
                    System.out.print("Nhập id thịt mới: ");
                    String newIdMeat = input.nextLine();
                    System.out.print("Nhập tên thịt mới: ");
                    String newNameMeat = input.nextLine();
                    LocalDate newDayMeat = LocalDate.now();
                    System.out.print("Nhập giá thịt mới: ");
                    double newPriceMeat = Double.parseDouble(input.nextLine());
                    System.out.print("Nhập cân nặng mới: ");
                    int newWeightMeat = Integer.parseInt(input.nextLine());
                    materialManager.editElement(new Meat(newIdMeat, newNameMeat, newDayMeat, (int) newPriceMeat, newWeightMeat));
                }
                case 5 -> {
                    System.out.print("Nhập id bột mới: ");
                    String newId = input.nextLine();
                    System.out.print("Nhập tên bột mới: ");
                    String newName = input.nextLine();
                    LocalDate newDay = LocalDate.now();
                    System.out.print("Nhập giá bột mới: ");
                    double newPrice = Double.parseDouble(input.nextLine());
                    System.out.print("Nhập số lượng bột mới: ");
                    int newQuantity = Integer.parseInt(input.nextLine());
                    materialManager.editElement(new CrispyFlour(newId, newName, newDay, (int) newPrice, newQuantity));
                }
                case 6 -> materialManager.deleteElement();
                case 7 -> materialManager.differenceMeat();
                case 8 -> materialManager.differenceCrispyFlour();
                case 0 -> System.exit(menu);
                default -> System.out.println("Vui lòng nhập lại!!!");
            }
        } while (true);
    }
}