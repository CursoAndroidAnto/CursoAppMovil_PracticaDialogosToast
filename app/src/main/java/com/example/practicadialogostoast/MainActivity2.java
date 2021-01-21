package com.example.practicadialogostoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.practicadialogostoast.Obj.data;

public class MainActivity2 extends AppCompatActivity {
    TextView txtName, txtOffice, txtRequest;
    Button btnSend, btnClose;
    data dataVal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtName = findViewById(R.id.txtNameFix);
        txtRequest = findViewById(R.id.txtRequestFix);
        txtOffice = findViewById(R.id.txtOfficeFix);
        btnSend = findViewById(R.id.btnSend);
        btnClose = findViewById(R.id.btnClose);

        Intent i = getIntent();
        data dataValues = (data) i.getSerializableExtra("data");
        dataVal = dataValues;
        txtName.setText(dataValues.getName());
        txtRequest.setText(dataValues.getSelectedRequest());
        txtOffice.setText(dataValues.getSelectedOffice());
    }

    public void closeWindow(View view) {
        finish();
    }

    public void sendMailDialog(View view) {
        String txtMailTo = "";
        String txtSubject = "";
        String txtMessage = Html.fromHtml( "Nombre: "+ dataVal .getName() + "<br>"
                + "Sucursal: " +  dataVal.getSelectedOffice() + "<br>"
                + "Solicitud: " + dataVal.getSelectedRequest()).toString();

        sendMail(txtMailTo, txtSubject, txtMessage);
    }
    void sendMail (String txtMailTo, String txtSubject, String txtMessage){
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{txtMailTo});
        email.putExtra(Intent.EXTRA_SUBJECT, txtSubject);
        email.putExtra(Intent.EXTRA_TEXT, txtMessage);

        startActivity(Intent.createChooser(email, "Mail"));
    }
}