package com.example.practicadialogostoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practicadialogostoast.Obj.data;

public class MainActivity extends AppCompatActivity {
    TextView txtName, txtOffice, txtRequest;
    Button btnSend, btnOffice, btnRequest;
    String selectedRequest;
    String selectedOffice;
    String selectedName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = findViewById(R.id.txtName);
        txtOffice = findViewById(R.id.txtOffice);
        txtRequest = findViewById(R.id.txtRequest);
        btnSend = findViewById(R.id.btnSend);
        btnOffice = findViewById(R.id.btnOffice);
        btnRequest = findViewById(R.id.btnRequest);

        btnOffice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showOfficeDialog();
            }
        });
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRequestDialog();
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSendDialog();
            }
        });
    }

    public void officeSelected(String item) {
        txtOffice.setText(item);
        selectedOffice = item;
    }

    void showOfficeDialog() {
        SucursalDialog dialog = new SucursalDialog();
        dialog.show(getFragmentManager(), "Office Dialog");
    }

    public void requestSelected(String item) {
        selectedRequest = item;

    }

    void showRequestDialog() {
        RequestDialog dialog = new RequestDialog();
        dialog.show(getFragmentManager(), "Request Dialog");
    }

    public void acceptRequest(){
        txtRequest.setText(selectedRequest);
    }

    void showSendDialog() {
        SendDataDialog dialog = new SendDataDialog();
        dialog.show(getFragmentManager(), "Send Data");
    }

    public void acceptSendData() {
        toastOnClick(true);
        sendData();
    }

    public void cancelSendData() {
        toastOnClick(false);
    }

    public void toastOnClick(boolean btn) {
        if (btn == true) {
            messageToast("Guardando");
        } else if (btn == false) {
            messageToast("Cancelando");
        }
    }

    public void messageToast(String toastMessage) {
        Toast message = new Toast(getApplicationContext());
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.lyToast));

        TextView txtMsg = (TextView) layout.findViewById(R.id.txtToast);
        txtMsg.setText(toastMessage);

        message.setDuration(Toast.LENGTH_SHORT);
        message.setView(layout);
        message.show();
    }

    void sendData(){
        selectedName = txtName.getText().toString();
        data dataValues = new data(selectedName, selectedRequest, selectedOffice);

        Intent i = new Intent(this, MainActivity2.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", dataValues);
        i.putExtras(bundle);
        startActivity(i);
    }
}