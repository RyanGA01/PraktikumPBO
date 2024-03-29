package view.cli.viewhomepage;

import controller.Authentication;
import view.cli.CliMainMenuPage;

import java.util.Scanner;
public class CliLoginPage {

    private Scanner input = new Scanner(System.in);

    public CliLoginPage(){
        login();
    }

    private void login(){
        while (true) {
            String username, kodeAkses;
            char pilihan;
                System.out.println("=========LOGIN=========");
                System.out.println("Sudah punya akun?");
                System.out.print("Y/y || N/n: ");
                pilihan = input.next().charAt(0);
                input.nextLine();
            if (pilihan == 'y' || pilihan == 'Y') {
                example();
                System.out.print("username: ");
                username = input.nextLine();
                System.out.print("Kode Akses: ");
                kodeAkses = input.nextLine();
                boolean status = new Authentication().login(username, kodeAkses);
                if (status) {
                    System.out.println("---------------");
                    System.out.println("Login Berhasil.");
                    System.out.println("---------------");
                    System.out.println();
                    new CliMainMenuPage();
                    break;
                }
                else{
                    loginGagal();
                    break;
                }
            }
            else if (pilihan == 'n' || pilihan == 'N'){
                new CliRegistrationPage();
                break;
            }
            else{
                new CliLoginPage();
                break;
            }
        }
    }

    private void loginGagal() {
        System.out.println("-------------------------------");
        System.out.println("----------LOGIN GAGAL----------");
        System.out.println("Username atau Kode Akses Salah!");
        System.out.println("-------------------------------");
    }

    private void example(){
        System.out.println("""
                Username: coba1
                Kode Akses: 0000
                =================================""");
    }
}