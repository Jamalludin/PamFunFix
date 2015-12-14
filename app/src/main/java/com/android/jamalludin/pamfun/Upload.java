package com.android.jamalludin.pamfun;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.net.URI;


/**
 * A simple {@link Fragment} subclass.
 */
public class Upload extends Fragment implements View.OnClickListener {
    private static final int RESULT_LOAD_IMAGE = 1;


    public Upload() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_upload,
                container, false);
        Button button = (Button) view.findViewById(R.id.upload);
        ImageView imageView = (ImageView) view.findViewById(R.id.imgview);
        EditText editText = (EditText) view.findViewById(R.id.edittext1);

        imageView.setOnClickListener(this);
        button.setOnClickListener(this);
        editText.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgview :
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
                break;
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && data !=null){
            Uri selectedimage = data.getData();

        }
    }
}