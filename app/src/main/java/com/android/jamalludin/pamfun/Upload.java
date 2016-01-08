package com.android.jamalludin.pamfun;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class Upload extends Fragment implements View.OnClickListener {

    public static final String UPLOAD_URL = "http://simplifiedcoding.16mb.com/PhotoUpload/upload.php";
    public static final String UPLOAD_KEY = "image";
    private static final int RESULT_LOAD_IMAGE = 1;

    Button uploadbtn;
    ImageView imageupload, imangedownload;
    EditText textupload, textdownload;

    private ImageView imageView;
    private Bitmap bitmap;
    private Uri filePath;


    public Upload() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_upload,container, false);

        uploadbtn = (Button) view.findViewById(R.id.upload);
        imageupload = (ImageView) view.findViewById(R.id.imgview);
        textupload = (EditText) view.findViewById(R.id.editText);

        imageupload.setOnClickListener(this);
        uploadbtn.setOnClickListener(this);
        textupload.setOnClickListener(this);

        return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && data !=null) {
            Uri selectdimage = data.getData();
            imageupload.setImageURI(selectdimage);
        }
    }

    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    private void uploadImage(){
        class UploadImage extends AsyncTask<Bitmap,Void,String> {

            ProgressDialog loading;
            //RequestHandler rh = new RequestHandler();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                //loading = ProgressDialog.show(MainActivity.this, "Uploading...", null,true,true);
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getContext(),"Upload", Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Bitmap... params) {
                Bitmap bitmap = params[0];
                String uploadImage = getStringImage(bitmap);

                HashMap<String,String> data = new HashMap<>();

                data.put(UPLOAD_KEY, uploadImage);
                //String result = rh.sendPostRequest(UPLOAD_URL, data);

                return null;
            }
        }

        UploadImage ui = new UploadImage();
        ui.execute(bitmap);
    }


            @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgview :
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
                break;

            case R.id.upload :
                uploadImage();
                break;
        }

    }

}