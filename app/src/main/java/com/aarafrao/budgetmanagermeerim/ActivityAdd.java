package com.aarafrao.budgetmanagermeerim;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.aarafrao.budgetmanagermeerim.database.DatabaseHelper;
import com.aarafrao.budgetmanagermeerim.databinding.ActivityAddBinding;
import com.aarafrao.budgetmanagermeerim.models.IncomeModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.slider.Slider;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ActivityAdd extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ActivityAddBinding binding;
    private ArrayList<String> paths;
    private int selectedIndex = 0;
    private BottomSheetBehavior bottomSheetBehavior;
    private MaterialCheckBox checkDIgits, checkAlpha, checkSymbol;
    private DatabaseReference mDatabase;
    private TextView txtMain;
    private String generatedPassword = "";
    private Slider seekbar;
    private MaterialButton btnUsePassword;
    private String ALLOWED_CHARACTERS = "{}[]%^;':,.?/0123456789qwertyuiopasdfghjklzxcvbnm";


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddBinding.inflate(getLayoutInflater());
//        binding2 = BottomSheetLayoutBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        paths = new ArrayList<>();
        paths.add("Default");

//        mDatabase = FirebaseDatabase.getInstance().getReference();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(ActivityAdd.this, android.R.layout.simple_spinner_item, paths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerDropdown.setAdapter(adapter);
        binding.spinnerDropdown.setOnItemSelectedListener(this);

        String v1 = getRandomString((int) 10);
//        txtMain.setText(v1);

//        btnUsePassword.setOnClickListener(v -> binding.edPassword.setText(generatedPassword));

//        seekbar.addOnChangeListener((slider, value, fromUser) -> {
//            txtMain.setText(getRandomString((int) value));
//        });

//        checkDIgits.setChecked(true);
//        checkAlpha.setChecked(true);
//        checkSymbol.setChecked(true);
        binding.imgClose.setOnClickListener(v -> finish());

        binding.btnSave.setOnClickListener(v2 -> {

            if (!binding.edAmount.getText().toString().equals("")) {

                if (!binding.edName.getText().toString().equals("")) {

                    if (!binding.edDate.getText().toString().equals("")) {

                        saveData();
                        Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();


                    } else binding.edDate.setError("Enter ");
                } else binding.edLoginLayout.setError("Enter MAIL");
            } else {
                binding.edNameLayout.setError("Enter Name");
            }
        });

    }

    private void saveData() {
        DatabaseHelper databaseHelper = DatabaseHelper.getDB(getApplicationContext());
        databaseHelper.notificationDAO().addAppointment(
                new IncomeModel(
                        binding.edName.getText().toString(),
                        binding.edDate.getText().toString(),
                        Integer.valueOf(binding.edAmount.getText().toString())
                )
        );

        List<IncomeModel> models = databaseHelper.notificationDAO().getAllAppointments();
        for (int i = 0; i < models.size(); i++) {
            Log.d(TAG, "saveData: " + models.get(i));
        }

        startActivity(new Intent(getApplicationContext(), IncomeModel.class));
        finish();
    }

    private String getRandomString(final int sizeOfRandomString) {
        final Random random = new Random();
        final StringBuilder sb = new StringBuilder(sizeOfRandomString);
        for (int i = 0; i < sizeOfRandomString; ++i)
            sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
        generatedPassword = sb.toString();
        return sb.toString();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        selectedIndex = i;
        if (paths.get(i).equals("+Add")) {
            showAddCategoryDialogue();
        }
    }

    private void showAddCategoryDialogue() {

        AlertDialog.Builder builder1 = new AlertDialog.Builder(ActivityAdd.this);
        builder1.setTitle("Add Category");
        final EditText input = new EditText(ActivityAdd.this);

        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder1.setView(input);
        builder1.setPositiveButton("OK", (dialog, which) -> {
            String text = input.getText().toString();
            paths.add(0, text);
            selectedIndex = 0;
            binding.spinnerDropdown.setSelection(0);

            //make list on firebase
            dialog.dismiss();
            // Handle the OK button press
        });

        builder1.setNegativeButton("Cancel", (dialog, which) -> {
            dialog.dismiss();

            // Handle the Cancel button press
        });
        builder1.show();


    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}