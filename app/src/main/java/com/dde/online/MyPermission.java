package com.dde.online;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.List;

public class MyPermission extends Activity {

    public MyPermission(Activity activity, String permission){
        Dexter.withContext(activity)
                .withPermission(permission)
                .withListener(new PermissionListener() {
                    @Override public void onPermissionGranted(PermissionGrantedResponse response) {

                    }
                    @Override public void onPermissionDenied(PermissionDeniedResponse response) {
                        Toast.makeText(activity,"please allow permission form setting ",Toast.LENGTH_SHORT).show();

                    }
                    @Override public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

                        token.continuePermissionRequest();
                    }
                }).check();
    }




}







//
//
//
//
//package com.dde.online;
//
//        import android.Manifest;
//        import android.app.Activity;
//        import android.content.Intent;
//        import android.net.Uri;
//        import android.provider.Settings;
//        import android.widget.Toast;
//
//        import androidx.appcompat.app.AppCompatActivity;
//
//        import com.karumi.dexter.Dexter;
//        import com.karumi.dexter.MultiplePermissionsReport;
//        import com.karumi.dexter.PermissionToken;
//        import com.karumi.dexter.listener.PermissionDeniedResponse;
//        import com.karumi.dexter.listener.PermissionGrantedResponse;
//        import com.karumi.dexter.listener.PermissionRequest;
//        import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
//        import com.karumi.dexter.listener.single.PermissionListener;
//
//        import java.util.List;
//        import java.util.Set;
//
//public class MyPermission extends Activity {
//
//    public MyPermission(Activity activity, String permission){
//        Dexter.withContext(activity)
//                .withPermission(permission)
//                .withListener(new PermissionListener() {
//                    @Override public void onPermissionGranted(PermissionGrantedResponse response) {
//                        Toast.makeText(activity,"Granted",Toast.LENGTH_SHORT).show();
//                    }
//                    @Override public void onPermissionDenied(PermissionDeniedResponse response) {
//                        Toast.makeText(activity,"rejected",Toast.LENGTH_SHORT).show();
//                        Intent intent=new Intent();
//                        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//                        Uri uri=Uri.fromParts("package",activity.getPackageName(),null);
//                        intent.setData(uri);
//                        startActivity(intent,110);
//
//                    }
//
//
//
//                    @Override public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
////
//                        token.continuePermissionRequest();
//                    }
//                }).check();
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//    }
//}
//
