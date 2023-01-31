package run;

import material.CrispyFlour;
import material.Material;
import material.Meat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MaterialManager {
    public ArrayList<Material> materials;
    Scanner input = new Scanner(System.in);
    int index;

    public MaterialManager() {
        materials = new ArrayList<>();
        materials.add(new Meat("m1", "Thịt lợn 1", LocalDate.now().plusDays(1), 100, 1));
        materials.add(new Meat("m2", "Thịt lợn 2", LocalDate.now().plusDays(2), 100, 1));
        materials.add(new Meat("m3", "Thịt lợn 3", LocalDate.now().plusDays(3), 100, 1));
        materials.add(new Meat("m4", "Thịt lợn 4", LocalDate.now().plusDays(4), 100, 1));
        materials.add(new Meat("m5", "Thịt lợn 5", LocalDate.now().plusDays(5), 100, 1));
        materials.add(new CrispyFlour("f6", "Bột 1", LocalDate.now().plusDays(1), 100, 1));
        materials.add(new CrispyFlour("f7", "Bột 2", LocalDate.now().plusDays(2), 100, 1));
        materials.add(new CrispyFlour("f8", "Bột 3", LocalDate.now().plusDays(3), 100, 1));
        materials.add(new CrispyFlour("f9", "Bột 4", LocalDate.now().plusDays(4), 100, 1));
        materials.add(new CrispyFlour("f10", "Bột 5", LocalDate.now().plusDays(5), 100, 1));
    }

    public void print() {
        for (Material material : materials) {
            System.out.println(material);
            System.out.println("Hạn SD: " + material.getExpiryDate());
        }
    }

    public void differenceMeat() {
        double costMeat = 0;
        double saleMeat = 0;
        double differenceMeat;
        for (Material material : materials
        ) {
            if (material instanceof Meat) {
                costMeat += material.getAmount();
                saleMeat += material.getRealMoney();
            }
        }
        differenceMeat = costMeat - saleMeat;
        System.out.println("Giá gốc thịt: " + costMeat);
        System.out.println("Giá sale thịt: " + saleMeat);
        System.out.println("Giá chênh lệch thịt: " + differenceMeat);
        System.out.println(" ");
    }

    public void differenceCrispyFlour() {
        double costCrispyFlour = 0;
        double saleCrispyFlour = 0;
        double differenceCrispyFlour;
        for (Material material : materials
        ) {
            if (material instanceof CrispyFlour) {
                costCrispyFlour += material.getAmount();
                saleCrispyFlour += material.getRealMoney();
            }
        }
        differenceCrispyFlour = costCrispyFlour - saleCrispyFlour;
        System.out.println("Giá gốc bột: " + costCrispyFlour);
        System.out.println("Giá sale bột: " + saleCrispyFlour);
        System.out.println("Giá chênh lệch bột: " + differenceCrispyFlour);
    }


    //xóa đối tượng
    public void deleteElement() {
        System.out.print("Nhập vị trí muốn xóa: ");
        index = input.nextInt();
        for (int i = 0; i < materials.size(); i++) {
            if (i == index) {
                materials.remove(i);
            } else if (index >= materials.size()) {
                System.out.println("Không tìm thấy vị trí số " + index);
                break;
            }
        }
    }

    //thêm đối tượng
    public void addElement(Material material) {
        System.out.print("Nhập vị trí muốn thêm: ");
        index = input.nextInt();
        for (int i = 0; i < materials.size(); i++) {
            if (i == index) {
                materials.add(i, material);
            } else if (index >= materials.size()) {
                materials.add(material);
                System.out.println("Không thể thêm tại vị trí số " + index);
                break;
            }
        }
    }

    //Sửa đối tượng
    public void editElement(Material material) {
        System.out.print("Nhập vị trí muốn sửa: ");
        index = input.nextInt();
        for (int i = 0; i < materials.size(); i++) {
            if (i == index) {
                materials.set(i, material);
            } else if (index >= materials.size()) {
                System.out.println("Không thể sửa tại vị trí số " + index);
                break;
            }
        }
    }
}