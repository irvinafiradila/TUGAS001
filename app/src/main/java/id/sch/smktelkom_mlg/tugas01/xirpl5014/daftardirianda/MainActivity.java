package id.sch.smktelkom_mlg.tugas01.xirpl5014.daftardirianda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    EditText etAsalSekolah;
    Spinner spGolongan;
    RadioButton rbP, rbL;
    CheckBox cbPP, cbPK, cbCC, cbDD;
    Button bOk;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etAsalSekolah = (EditText) findViewById(R.id.editTextAsalSekolah);
        spGolongan = (Spinner) findViewById(R.id.spinnerGolongan);
        rbP = (RadioButton) findViewById(R.id.radioButtonP);
        rbL = (RadioButton) findViewById(R.id.radioButtonL);
        cbPP = (CheckBox) findViewById(R.id.checkBoxPP);
        cbPK = (CheckBox) findViewById(R.id.checkBoxPK);
        cbCC = (CheckBox) findViewById(R.id.checkBoxCC);
        cbDD = (CheckBox) findViewById(R.id.checkBoxDD);
        bOk = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isValid()) ;

                String nama = etNama.getText().toString();
                String asalsekolah = etAsalSekolah.getText().toString();

                String hasil1 = null;
                if (rbP.isChecked()) {
                    hasil1 = rbP.getText().toString();
                } else if (rbL.isChecked()) {
                    hasil1 = rbP.getText().toString();
                }

                String hasil2 = "\n\nKegiatan yang Ingin Diikuti:\n";
                int starlen = hasil2.length();
                if (cbPP.isChecked()) hasil2 += cbPP.getText() + "\n";
                if (cbPK.isChecked()) hasil2 += cbPK.getText() + "\n";
                if (cbCC.isChecked()) hasil2 += cbCC.getText() + "\n";
                if (cbDD.isChecked()) hasil2 += cbDD.getText() + "\n";

                if (hasil2.length() == starlen) hasil2 += "Belum pernah memilih";

                tvHasil.setText("Nama:\n" + nama + "\n\nAsal Sekolah: \n" + asalsekolah +
                        "\n\nGolongan: \n" + spGolongan.getSelectedItem() + "\n\nJenis Kelamin: \n" + hasil1 + hasil2);
            }
        });


    }

    private boolean isValid() {

        boolean valid = true;

        String nama = etNama.getText().toString();
        String asalsekolah = etAsalSekolah.getText().toString();

        if (nama.isEmpty()) {

            etNama.setError("Anda Belum Mengisi Nama");
        } else if (nama.length() < 8) {
            etNama.setError("Minimal 8 Karakter");
        } else {
            etNama.setError(null);
        }
        if (asalsekolah.isEmpty()) {
            etAsalSekolah.setError("Asal Sekolah Belum Diisi");
            valid = false;
        } else {
            etAsalSekolah.setError(null);
        }

        return valid;

    }
}
