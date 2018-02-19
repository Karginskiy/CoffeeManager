package nkargin.ru.coffeemanager.main.tabs;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.time.LocalDate;

import nkargin.ru.coffeemanager.R;

public class StatsFragment extends Fragment {
    private DatePickerDialog datePickerDialog;
    private EditText editText;
    private EditText editText2;
    private static StatsFragment INSTANCE;

    public StatsFragment() {}

    public static StatsFragment newInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StatsFragment();
        }
        return INSTANCE;
    }

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_stats, container, false);

        editText2 = view.findViewById(R.id.stats1);
        editText = view.findViewById(R.id.stats);

        editText2.setText(LocalDate.now().toString());
        editText.setText(LocalDate.now().toString());


        datePickerDialog = new DatePickerDialog(view.getContext());

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
                datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        editText.setText(i + " " + i1 + " " + i2);
                    }
                });
            }
        });

        editText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
                datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        editText2.setText(i + " " + i1 + " " + i2);
                    }
                });
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            datePickerDialog = new DatePickerDialog(view.getContext());
            datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    editText.setText(String.format("%d, %d %d", i, i1, i2));
                }
            });
        }

        LocalDate now = LocalDate.now();

        editText.setText(now.toString());

        return view;
    }
}
