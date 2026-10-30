import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Rekening {

    private String nomor;
    private String pemilik;
    private int saldo;

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public String getNomor() {
        return nomor;
    }

    public String getPemilik() {
        return pemilik;
    }

    public int getSaldo() {
        return saldo;
    }

    public boolean setor(int jumlah) {
        if (jumlah <= 0) {
            return false;
        }

        saldo += jumlah;
        return true;
    }

    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || jumlah > saldo) {
            return false;
        }

        saldo -= jumlah;
        return true;
    }

    private String formatrupiah(int jumlah) {
        DecimalFormatSymbols simbol =
                new DecimalFormatSymbols(new Locale("id", "ID"));

        DecimalFormat format =
                new DecimalFormat("'Rp'#,##0", simbol);

        return format.format(jumlah);
    }

    public void cetakInfo() {
        System.out.println(
                nomor + " | " + pemilik + " | " + formatrupiah(saldo)
        );
    }
}