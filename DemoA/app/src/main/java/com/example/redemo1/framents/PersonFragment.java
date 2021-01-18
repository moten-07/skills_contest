package com.example.redemo1.framents;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.redemo1.MainActivity;
import com.example.redemo1.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PersonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PersonFragment extends Fragment implements View.OnClickListener{
   ImageView user_icon;
   TextView user_name,user_id;
   Button user_out;
   LinearLayout user_info_list,user_order_list,update_pass,feed;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PersonFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PersonFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PersonFragment newInstance(String param1, String param2) {
        PersonFragment fragment = new PersonFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_person, container, false);
        init(view);
        return view;
    }

    private void init(View view){
        user_icon = view.findViewById(R.id.user_icon);
        user_id = view.findViewById(R.id.user_id);
        user_name = view.findViewById(R.id.user_name);
        user_info_list = view.findViewById(R.id.user_info_list);
        user_order_list = view.findViewById(R.id.user_order_list);
        user_out = view.findViewById(R.id.user_out);

        user_info_list.setOnClickListener(this::onClick);
        user_order_list.setOnClickListener(this::onClick);
        user_out.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.user_info_list:
                intent = new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("type","user_info");
                startActivity(intent);
                break;
            case R.id.user_order_list:
                intent = new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("type","user_order");
                startActivity(intent);
                break;
            case R.id.user_out:
                Toast.makeText(v.getContext(),"退出",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}