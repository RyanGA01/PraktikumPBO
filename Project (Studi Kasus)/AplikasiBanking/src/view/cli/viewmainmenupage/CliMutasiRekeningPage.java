package view.cli.viewmainmenupage;


import entity.*;
import entity.abstraction.Transaksi;
import model.Modelling;
import utils.Keuangan;

import java.util.ArrayList;

public class CliMutasiRekeningPage {

    public CliMutasiRekeningPage(){
        mutasiRekening();
    }

    private void mutasiRekening(){
        System.out.println("------------- MUTASI REKENING ------------");

        User userMasuk = Modelling.getuserMasuk();

        ArrayList<Transaksi> mutasi = userMasuk.getRekening().getMutasi();

        for (Transaksi transaksi : mutasi){
            if (transaksi instanceof SetorTunai){
                SetorTunai setor = (SetorTunai) transaksi;
                System.out.println("Transaksi           : Penyetoran Tunai");
                System.out.println("Tanggal Setor Tunai : "+transaksi.getTanggalTransaksi());
                System.out.println("Nominal Setor Tunai : Rp. "+Keuangan.format(transaksi.getNilaiNominal()));
                System.out.println("rekening Asal       : "+setor.getUserAsal().getRekening().getNoRekening());
                System.out.println("Asal Atas Nama      : "+setor.getUserAsal().getFullname());
                System.out.println("Rekening Tujuan     : "+setor.getUserTujuan().getRekening().getNoRekening());
                System.out.println("Tujuan Atas Nama    : "+setor.getUserTujuan().getFullname());
            }
            else if (transaksi instanceof TarikTunai){
                TarikTunai tarik = (TarikTunai) transaksi;
                System.out.println("Transaksi           : Penarikan Tunai");
                System.out.println("Tanggal Tarik Tunai : "+transaksi.getTanggalTransaksi());
                System.out.println("Nominal Tarik Tunai : Rp. "+Keuangan.format(transaksi.getNilaiNominal()));
                System.out.println("rekening Asal       : "+tarik.getUserAsal().getRekening().getNoRekening());
                System.out.println("Asal Atas Nama      : "+tarik.getUserAsal().getFullname());
                System.out.println("Rekening Tujuan     : "+tarik.getUserTujuan().getRekening().getNoRekening());
                System.out.println("Tujuan Atas Nama    : "+tarik.getUserTujuan().getFullname());

            }
            else if (transaksi instanceof Transfer){
                Transfer transfer = (Transfer) transaksi;
                System.out.println("Transaksi           : Transfer Tunai");
                System.out.println("Tanggal Transfer    : "+transaksi.getTanggalTransaksi());
                System.out.println("Rekening Asal       : "+transfer.getUserAsal().getRekening().getNoRekening());
                System.out.println("Asal Atas Nama      : "+transfer.getUserAsal().getFullname());
                System.out.println("Rekening Tujuan     : "+transfer.getUserTujuan().getRekening().getNoRekening());
                System.out.println("Tujuan Atas Nama    : "+transfer.getUserTujuan().getFullname());
                System.out.println("Nominal Transfer    : Rp."+Keuangan.format(transaksi.getNilaiNominal()));
            }
            System.out.println("---------------------------------------");
        }
        System.out.println("---------------------------------------");
    }
}