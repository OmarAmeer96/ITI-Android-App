package com.example.myproject;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends AppCompatActivity {

    // outputStream job ==> is to write in any file with Bytes (is the pen).
    // after writing I should close the session.

    // first way ==> is to throw the file in the phone  files.
    // second way ==> is to make folder in the phone files and put the file I written in in this folder.
    // third way ==> Private storage (Memory Card) throw the file in it.
    // forth way ==> Public Storage: throw the file in any folder from the device folders, such as Documents, Downloads ...

    EditText et_name;
    EditText et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        et_name = (EditText) findViewById(R.id.et_name);
        et_password = (EditText) findViewById(R.id.et_password);
    }

    public void open_ActivityB(View view) {
        Intent intent = new Intent(FileActivity.this, FileActivity2.class);
        startActivity(intent);
        finish();
    }

    public void saving_file_in_InternalStorage(View view) {
        storeData(null, "saving_file_in_default_internalStorage");
    }

    public void saving_file_in_Directory_in_InternalStorage(View view) {
        String Folder_Name = "OmarAmeerDirectory";
        Context context = getApplicationContext();
        String Folder_Path = context.getFilesDir().getAbsolutePath() + File.separator + Folder_Name; // Full directory path
        File folderDir = new File(Folder_Path);
        if (!folderDir.exists()) {
            folderDir.mkdirs();
            Toast.makeText(this, "Directory has created for the first time", Toast.LENGTH_SHORT).show();
        }
        File file = new File(folderDir, "my_internal_file.txt");
        storeData(file, "saving_file_in_Directory_in_InternalStorage");
    }

    public void saving_file_in_Private_ExternalStorage(View view) {
        File folderDir = getExternalFilesDir("Private_External_OmarAmeer_Directory");
        File file = new File(folderDir, "my_private_external_file.txt");
        storeData(file, "saving_file_in_Private_ExternalStorage");
    }

    public void saving_file_in_Public_ExternalStorage(View view) {
        File folderDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        if (!folderDir.exists()) {
            folderDir.mkdirs();
            Toast.makeText(this, "Directory is created for the first time ", Toast.LENGTH_SHORT).show();
        }
        File file = new File(folderDir, "my_public_external_file.txt");
        storeData(file, "saving_file_in_Public_ExternalStorage");
    }

    public void storeData(File file, String status) {
        String Name = et_name.getText().toString();
        String Password = et_password.getText().toString();
        if (Name.isEmpty() || Password.isEmpty()) {
            Toast.makeText(this, "EditText Fields are Empty!", Toast.LENGTH_SHORT).show();
        } else {
            FileOutputStream outputStream = null;
            try {
                if (status.equals("saving_file_in_default_internalStorage")) {
                    outputStream = openFileOutput("default_internal.txt", Context.MODE_PRIVATE); // MODE_APPEND ==> used to add to the old data in the file not to delete it.
                    Toast.makeText(this, "File Path : " + getFilesDir().getAbsolutePath() + File.separator + "default_internal.txt", Toast.LENGTH_LONG).show();
                } else {
                    outputStream = new FileOutputStream(file); // is the pen I use to write the data.
                    Toast.makeText(this, "File Path : " + file.getAbsolutePath(), Toast.LENGTH_LONG).show();
                }
                Toast.makeText(this, "File Status is : " + status, Toast.LENGTH_LONG).show();
                byte[] nameInByte = Name.concat("-").getBytes();
                byte[] passwordInByte = Password.concat("-").getBytes();
                outputStream.write(nameInByte);
                outputStream.write(passwordInByte);
                outputStream.close(); // Closing the session
                Toast.makeText(this, "Writing to the file is done.", Toast.LENGTH_LONG).show();
                Toast.makeText(this, "Closing the outputStream session is done Successfully.", Toast.LENGTH_LONG).show();
            } catch (FileNotFoundException e) {
                Toast.makeText(this, "File is not found!\nPlease create it first", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                Toast.makeText(this, "IO Exception \n" + e.toString(), Toast.LENGTH_LONG).show();
            }

        }

    }
}