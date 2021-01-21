package com.example.practicadialogostoast;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import java.nio.BufferUnderflowException;

public class RequestDialog extends DialogFragment {
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String[] requestItems = {"Permiso vacacional", "Ausencia", "Traslado domicilio"};
        return new AlertDialog.Builder(getActivity())
                .setTitle("Motivo de la solicitud")
                .setSingleChoiceItems(requestItems, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        String selectedItem = requestItems[item];
                        ((MainActivity) getActivity()).requestSelected(selectedItem);
                    }
                })
                .setPositiveButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ((MainActivity)getActivity()).acceptRequest();
                            }
                        })
                .create();
    }
}
