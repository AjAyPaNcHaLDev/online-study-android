package com.dde.online.Fragment;

import static android.app.Activity.RESULT_OK;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.dde.online.R;
import com.google.android.material.snackbar.Snackbar;

import java.io.InputStream;


public class MyProfile extends Fragment {
Spinner officerTypeSpinner;
ImageView userImagePriView;
    ViewParent parent_view;
    Uri selectedImageUri; // Global Variable
    String  selectedPath; //
    InputStream inputStream = null;
    Context applicationContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);
        Button chooseFile=view.findViewById(R.id.chooseFile);
        chooseFile.setOnClickListener(chooseFileBtn -> {
            chooseFile();
        });
//         parent_view = view.findViewById(android.R.id.content);
        userImagePriView=view.findViewById(R.id.userImagePriView);
        officerTypeSpinner=view.findViewById(R.id.officerTypeSpinner);
        officerTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Your code here
                switch (i){
                    case 1:
                        userImagePriView.setImageResource(R.drawable.navy_officer_women);
                        break;
                    case 2:
                        userImagePriView.setImageResource(R.drawable.navy_officer_men);
                        break;
                    case 3:
                        userImagePriView.setImageResource(R.drawable.indian_army_officer_men);
                        break; case 4:
                        userImagePriView.setImageResource(R.drawable.indian_army_officer_women);
                        break;case 5:
                        userImagePriView.setImageResource(R.drawable.airforce_officer_men);
                        break; case 6:
                        userImagePriView.setImageResource(R.drawable.airforce_pilot_women);
                        break;
                }

            }

            public void onNothingSelected(AdapterView<?> adapterView) {

                return;
            }
        });


         applicationContext = getContext();
        applicationContext.getContentResolver();
        return view;
    }



    private void chooseFile() {
        Log.e("AJAY","hiii error");
      Intent  myFileIntent  =new Intent(Intent.ACTION_GET_CONTENT);
        myFileIntent.setType("image/*");
        startActivityForResult(myFileIntent,10);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap=null;
Intent bitmapIntent = null;
        if (resultCode == RESULT_OK) {


                if (requestCode == 10)

                {
                    Bundle extras = data.getExtras();
                    Bitmap imageBitmap = (Bitmap) extras.get("data");
                    userImagePriView.setImageBitmap(imageBitmap);
                    Log.d("selectedPath1 : " ,selectedPath);
                }



            }else{
                Log.d("selectedPath1 : ","Came here its null !");
                Toast.makeText(getContext(), "failed to get Image!", Toast.LENGTH_SHORT).show();
            }



        }
}

