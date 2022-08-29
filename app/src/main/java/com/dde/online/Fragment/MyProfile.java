package com.dde.online.Fragment;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.content.ClipData;
import android.content.ClipboardManager;
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
import android.widget.TextView;
import android.widget.Toast;
import com.dde.online.MyPermission;
import com.dde.online.R;
import com.google.android.material.snackbar.Snackbar;
import java.io.FileNotFoundException;
import java.io.InputStream;
public class MyProfile extends Fragment {
Spinner officerTypeSpinner;
ImageView userImagePriView;
    ViewParent parent_view;
    Uri selectedImageUri; // Global Variable
    String  selectedPath; //
    InputStream inputStream = null;
    Context applicationContext;
    TextView referLoad;
    Button shareReferBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);
        Button chooseFile=view.findViewById(R.id.chooseFile);
        chooseFile.setOnClickListener(chooseFileBtn -> {
            chooseFile();
        });
        new MyPermission(getActivity(), Manifest.permission.CAMERA);

//         parent_view = view.findViewById(android.R.id.content);
        userImagePriView=view.findViewById(R.id.userImagePriView);
        officerTypeSpinner=view.findViewById(R.id.officerTypeSpinner);
        officerTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Your code here
                switch (i){
                    case 0:
                        userImagePriView.setImageResource(R.drawable.navy_officer_women);

                        break;
                    case 1:
                        userImagePriView.setImageResource(R.drawable.navy_officer_men);

                        break;
                    case 2:
                        userImagePriView.setImageResource(R.drawable.indian_army_officer_men);

                        break;
                    case 3:
                        userImagePriView.setImageResource(R.drawable.indian_army_officer_women);

                        break; case 4:
                        userImagePriView.setImageResource(R.drawable.airforce_officer_men);

                        break;case 5:
                        userImagePriView.setImageResource(R.drawable.airforce_pilot_women);

                        break;
                }

            }

            public void onNothingSelected(AdapterView<?> adapterView) {

                return;
            }
        });

        referLoad=view.findViewById(R.id.referLoad);
        referLoad.setOnClickListener(view1 -> {
            if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
                android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                clipboard.setText(referLoad.getText().toString());
                Toast.makeText(getContext(),"text copy to clipboard",Toast.LENGTH_SHORT).show();
            } else {
                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", referLoad.getText().toString());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getContext(),"text copy to clipboard",Toast.LENGTH_SHORT).show();
            }

        });

shareReferBtn=view.findViewById(R.id.shareReferBtn);
shareReferBtn.setOnClickListener(view12 -> {
String text="Hello friend use my referral code and get discount buy course "+referLoad.getText().toString()+
  " \n https://qtcinfotech.in/ddeexams/index.php?referral="+referLoad.getText().toString();

    Intent i = new Intent(android.content.Intent.ACTION_SEND);
    i.setType("text/plain");
    i.putExtra(android.content.Intent.EXTRA_TEXT, text);
    startActivity(i);
});
         applicationContext = getContext();
        applicationContext.getContentResolver();

        return view;
    }



    private void chooseFile() {
      Intent  myFileIntent  =new Intent(Intent.ACTION_GET_CONTENT);
        myFileIntent.setType("image/*");
        startActivityForResult(myFileIntent,10);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {


                if (requestCode == 10)

                {

   InputStream inputStream = null;
   Intent OriginalBitmapIntent;
            OriginalBitmapIntent=data;
            Bitmap bitmap;
            try {
                inputStream = getActivity().getContentResolver().openInputStream(OriginalBitmapIntent.getData());

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
                    bitmap=BitmapFactory.decodeStream(inputStream);
                    userImagePriView.setImageBitmap(bitmap);

 }



            }else{
                Log.d("selectedPath1 : ","Came here its null !");
                Toast.makeText(getContext(), "failed to get Image!", Toast.LENGTH_SHORT).show();
            }



        }
}

