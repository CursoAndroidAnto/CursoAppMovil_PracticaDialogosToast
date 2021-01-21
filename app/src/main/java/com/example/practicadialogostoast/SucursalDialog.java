package com.example.practicadialogostoast;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class SucursalDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String[] offices = {"Madrid", "Barcelona"};
        return new AlertDialog.Builder(getActivity())
                .setTitle("Sucursal")
                .setItems(offices, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        String selectedItem = offices[item];
                        ((MainActivity) getActivity()).officeSelected(selectedItem);
                    }
                })

                .create();
    }
}
