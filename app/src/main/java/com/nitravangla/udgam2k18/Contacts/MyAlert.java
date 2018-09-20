package com.nitravangla.udgam2k18.Contacts;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import static com.nitravangla.udgam_2k18.R.*;

public class MyAlert  extends DialogFragment {
    public  String title;
    public int img_id;
    public String number;
    public String rollNumber;

    public MyAlert(){}
    @SuppressLint("ValidFragment")
    public MyAlert(String title, int img_id, String number, String roll){
        this.title = title;
        this.img_id=img_id;
        this.number=number;
        this.rollNumber = roll;

    }

    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(layout.dialog_item,null);
        ImageView imageView = (ImageView)view.findViewById(id.imageView);
        imageView.setImageResource(img_id);

        builder.setView(view);
        builder.setTitle(""+title);

        builder.setNegativeButton("call", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });

        builder.setPositiveButton("mail", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                String[] mailTo = new String[]{rollNumber};
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL  , mailTo);
                try {
                    startActivity(Intent.createChooser(intent, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://gmail.com"));
                    startActivity(browserIntent);

                }
            }
        });


        Dialog dialog=builder.create();

        return dialog;
    }


}

