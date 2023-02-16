package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileActivity2 extends AppCompatActivity {

    // openFileInput ==> opens my file.
    // inputStream job ==> is to read the data from my file.
    TextView tv_name, tv_password;
    Button btn_file_back, btn_file_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file2);

        btn_file_back = findViewById(R.id.btn_file_back);
        btn_file_next = findViewById(R.id.btn_file_next);


        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_password = (TextView) findViewById(R.id.tv_password);

        btn_file_back.setOnClickListener(v -> {
            Intent intent = new Intent(FileActivity2.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
        btn_file_next.setOnClickListener(v -> {
            Intent intent = new Intent(FileActivity2.this, ControlsActivity.class);
            startActivity(intent);
            finish();
        });
    }

    public void open_ActivityA(View view) {
        Intent intent = new Intent(FileActivity2.this, FileActivity.class);
        startActivity(intent);
        finish();
    }

    public void loading_file_from_InternalStorage(View view) {
        loadData(null, "loading_file_from_default_InternalStorage");
    }

    public void loading_file_from_Directory_in_InternalStorage(View view) {
        String Folder_Name = "OmarAmeerDirectory";
        Context context = getApplicationContext();
        String Folder_Path = context.getFilesDir().getAbsolutePath() + File.separator + Folder_Name;
        File folderDir = new File(Folder_Path);
        if (!folderDir.exists()) {
            folderDir.mkdirs();
        }
        File file = new File(folderDir, "my_internal_file.txt");
        loadData(file, "loading_file_from_Directory_in_InternalStorage");
    }

    public void loading_file_from_Private_ExternalStorage(View view) {
        File folderDir = getExternalFilesDir("Private_External_OmarAmeer_Directory");
        File file = new File(folderDir, "my_private_external_file.txt");
        loadData(file, "loading_file_from_Private_ExternalStorage");
    }

    public void loading_file_from_Public_ExternalStorage(View view) {
        File folderDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(folderDir, "my_public_external_file.txt");
        loadData(file, "loading_file_from_Public_ExternalStorage");
    }

    public void loadData(File file, String status) {
        int read = -1;
        try {
            FileInputStream inputStream = null;
            if (status.equals("loading_file_from_default_InternalStorage")) {
                inputStream = openFileInput("default_internal.txt");
            } else {
                inputStream = new FileInputStream(file);
            }
            Toast.makeText(this, "File Status is: " + status, Toast.LENGTH_LONG).show();
            StringBuffer CharactersBuffer = new StringBuffer();
            StringBuffer BinaryBuffer = new StringBuffer();
            read = inputStream.read();
            if (read == -1) { // if read = -1 ==> the file is empty
                Toast.makeText(this, "File is Empty!", Toast.LENGTH_SHORT).show();
            } else {
                while (read != -1) { // loop for reading all the data in the file.
                    CharactersBuffer.append((char) read); // read function is reading byte-by-byte
                    BinaryBuffer.append(read).append("-");
                    read = inputStream.read();
                }
                inputStream.close();
                String allStringBufferContent = CharactersBuffer.toString();
                String allBinaryBufferContent = BinaryBuffer.toString();
                Toast.makeText(this, "Reading from the file is done successfully.", Toast.LENGTH_LONG).show();
                String[] cookies = allStringBufferContent.split("-");
                tv_name.setText(cookies[0]);
                tv_password.setText(cookies[1]);
                Toast.makeText(this, "Closing inputStream session is done successfully.", Toast.LENGTH_LONG).show();
            }
        } catch (FileNotFoundException e) {
            Toast.makeText(this, "File is not found!\nPlease create it first before reading from it.", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(this, "IO Exception :\n" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}