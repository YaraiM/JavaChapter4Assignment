package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Promotion {
    public static void main(String[] args) {
        // 部署クラスのインスタンス化
        Department soumu = new Department(1, "総務部");
        Department kikaku = new Department(2, "企画部");
        Department eigyo = new Department(3, "営業部");
        Department gijutu = new Department(4, "技術部");

        // 資格クラスのインスタンス化
        Qualification level1 = new Qualification(1, "資格レベル１", 1);
        Qualification level2 = new Qualification(2, "資格レベル２", 5);
        Qualification level3 = new Qualification(3, "資格レベル３", 8);

        // 従業員リストの作成、従業員クラスのインスタンス化
        List<Employee> employeeList = new ArrayList<>();

        Employee soumuA = new Employee(1, "soumuA", 12, soumu, level3);
        Employee soumuB = new Employee(2, "soumuB", 8, soumu, level1);
        Employee soumuC = new Employee(3, "soumuC", 6, soumu, level2);
        Employee kikakuA = new Employee(4, "kikakuA", 8, kikaku, level1);
        Employee kikakuB = new Employee(5, "kikakuB", 7, kikaku, level2);
        Employee kikakuC = new Employee(6, "kikakuC", 1, kikaku, level2);
        Employee eigyoA = new Employee(7, "eigyoA", 10, eigyo, level3);
        Employee eigyoB = new Employee(8, "eigyoB", 8, eigyo, level2);
        Employee eigyoC = new Employee(9, "eigyoC", 3, eigyo, level1);
        Employee gijutuA = new Employee(10, "gijutuA", 15, gijutu, level2);
        Employee gijutuB = new Employee(11, "gijutuB", 12, gijutu, level2);
        Employee gijutuC = new Employee(12, "gijutuC", 12, gijutu, level3);
        Employee gijutuD = new Employee(13, "gijutuD", 15, gijutu, level2);
        Employee gijutuE = new Employee(14, "gijutuE", 8, gijutu, level3);

        employeeList.add(soumuA);
        employeeList.add(soumuB);
        employeeList.add(soumuC);
        employeeList.add(kikakuA);
        employeeList.add(kikakuB);
        employeeList.add(kikakuC);
        employeeList.add(eigyoA);
        employeeList.add(eigyoB);
        employeeList.add(eigyoC);
        employeeList.add(gijutuA);
        employeeList.add(gijutuB);
        employeeList.add(gijutuC);
        employeeList.add(gijutuD);
        employeeList.add(gijutuE);

        //Scannerクラスを使ってユーザーに部署コードを入力させ、入力結果に応じた出力を行う。
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("総務部：1、企画部：2、営業部：3、技術部：4");
                System.out.print("昇進者を抽出したい部署のコード（1~4）を入力してください：");

                //整数が入力されていない場合は即座にエラーを返す。整数が入力された場合は無視される。
                if (!scanner.hasNextInt()) {
                    throw new IllegalArgumentException("部署コード以外は入力できません!");
                }

                // 入力された整数をinputCodeに代入する。
                int inputCode = scanner.nextInt();
                scanner.nextLine(); //入力後の改行をクリア

                // inputCodeに1~4以外が入力された場合は、エラーを返し、1~4が入力された場合はその部署の昇進者を表示する。
                if (inputCode < 1 || inputCode > 4) {
                    throw new IllegalArgumentException("部署コード以外は入力できません!");
                } else {
                    List<Employee> promotingEmployees = employeeList.stream()
                            .filter(employee -> employee.getDepartment().getCode() == inputCode)
                            .sorted(Comparator.comparingInt(Employee::promotionScore) //昇進点を昇順に並び替える
                                    .thenComparingInt(Employee::getYearsOfExperience) //年齢を昇順に並び替える
                                    .thenComparingInt(Employee::qualificationPoint).reversed()) //資格点を昇順に並び替え、降順に入れ替える
                            .toList();

                    // promotionListの情報を表示
                    System.out.println("<" + promotionList.get(0).getDepartment().getDepartment() + ">");
                    for (Employee e : promotionList) {
                        System.out.println("氏名：" + i.getName() + "　経験年数：" + i.getYearsOfExperience() + "年" + "　資格点（資格名）：" + i.getQualification().getPoint() + "点（" + i.getQualification().getQualification() + "）" + "　昇進点：" + i.promotionScore() + "点");
                    }

                    while (true) {
                        try {
                            // ユーザーに次の処理に進むかどうかを聞く
                            System.out.print("昇進する人を表示する場合は1、表示しない場合は2を入力してください：");

                            //整数が入力されていない場合は即座にエラーを返す。整数が入力された場合は無視される。
                            if (!scanner.hasNextInt()) {
                                throw new IllegalArgumentException("1, 2以外は入力できません!");
                            }

                            int inputYesNo = scanner.nextInt();
                            scanner.nextLine(); //入力後の改行をクリア

                            if (inputYesNo == 1) {
                                System.out.println("昇進する従業員は、" + promotionList.get(0).getName() + "です。");
                                System.out.println("※昇進点（経験年数＋資格点）が最も高い人を昇進させます。");
                                System.out.println("※昇進点が同点の場合は、経験年数が長い人を昇進させます。経験年数も同じであれば、資格点が高い人を昇進させます");
                                break;
                            } else if (inputYesNo == 2) {
                                System.out.println("処理を終了します。リストを参照して、昇進する従業員を判断してください。");
                                break;
                            } else {
                                throw new IllegalArgumentException("1, 2以外は入力できません!");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            scanner.nextLine();
                        }
                    }
                break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                // nextIntで不正な値（文字列や1~4以外の整数など）を入力した後、Enter（改行）で実行するが、その時の改行は削除されずに残る。
                // scanner.nextLine()を配置することで、不正な値を入力した後のEnter（改行）を読み取って次の行に進むことができる。
                // もしscanner.nextLine()がないと、tryに戻った後のscanner.nextInt()で残った改行が不正な値として読み取られてしまい、無限ループが発生する。
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
