package com.example.list_it;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private boolean[] switchHora;
    private boolean[] switchFecha;
    private boolean[] switchPresupuesto;


    public CreateListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreateList.
     */
    // TODO: Rename and change types and number of parameters
    public static CreateListFragment newInstance(String param1, String param2) {
        CreateListFragment fragment = new CreateListFragment();
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
        return inflater.inflate(R.layout.fragment_create_list, container, false);
    }
    public void mostrarFecha(View view) {
        if (switchFecha[0]){view.setVisibility(View.INVISIBLE);
            switchFecha[0] = false;
        }
    }

    public void mostrarHora(View view) {
        if (switchHora[0]){view.setVisibility(View.INVISIBLE);
            switchHora[0] = false;
        }
    }

    public void mostrarPresupuesto(View view) {
        if (switchPresupuesto[0]){view.setVisibility(View.INVISIBLE);
            switchPresupuesto[0] = false;}
    }
}